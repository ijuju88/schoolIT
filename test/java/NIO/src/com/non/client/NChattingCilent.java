package com.non.client;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;

public class NChattingCilent {
	ChatClientFrame ccf;
	Selector selector;
	SocketChannel sc;

	public NChattingCilent(ChatClientFrame ccf) {
		this.ccf = ccf;
	}

	public void startClient(String address) {
		try {
			selector = Selector.open();
			sc = SocketChannel.open();
			sc.configureBlocking(false);

			sc.register(selector, SelectionKey.OP_CONNECT);
			sc.connect(new InetSocketAddress(address, 5001));

		} catch (Exception e) {
			ccf.displayText("[서버통신안됨]");
			if (sc.isOpen()) {
				stopClient();
			}
			return;
		}

		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					try {
						int keyCount = selector.select();// key가 들어왔는지 감지

						if (keyCount == 0) {
							continue;
						}
						Set<SelectionKey> selectKeys = selector.selectedKeys();
						Iterator<SelectionKey> iterator = selectKeys.iterator();

						while (iterator.hasNext()) {
							SelectionKey selectionKey = iterator.next();

							if (selectionKey.isConnectable()) {
								Connect(selectionKey);
							} else if (selectionKey.isReadable()) {
								receive(selectionKey);
							} else if (selectionKey.isWritable()) {
								send(selectionKey);
							}

							iterator.remove();
						}

					} catch (Exception e) {
						ccf.displayText("[서버통신안됨]");
						if (sc.isOpen()) {
							stopClient();
						}
					}
				}
			}

		};
		new Thread(runnable).start();
	}

	private void Connect(SelectionKey selectionKey) {
		try {
			sc.finishConnect();
			ccf.displayText("[연결완료 : "+sc.getRemoteAddress()+"]");
			ccf.btnSend.setEnabled(true);
			ccf.btnConn.setText("stop");
			selectionKey.interestOps(SelectionKey.OP_READ);
		} catch (Exception e) {
			ccf.displayText("[서버통신안됨]");
			if (sc.isOpen()) {
				stopClient();
			}
		}
	}

	public void receive(SelectionKey selectionKey) {
		try {
			ByteBuffer bytebuffer = ByteBuffer.allocate(100);
			int byteCount =sc.read(bytebuffer);

			if (byteCount == -1)
				throw new IOException();
			bytebuffer.flip();
			Charset charset = Charset.forName("UTF-8");
			String data = charset.decode(bytebuffer).toString();
			ccf.displayText(data);
		} catch (Exception e) {
			ccf.displayText("[서버통신안됨]");
			stopClient();
		}

	}

	public void send(SelectionKey selectionKey) {
		try {
			ByteBuffer bytebuffer =(ByteBuffer)selectionKey.attachment();
			sc.write(bytebuffer);
			ccf.displayText("[보내기완료]");
			selectionKey.interestOps(SelectionKey.OP_READ);
		} catch (Exception e) {
			ccf.displayText("[서버통신안됨]");
			stopClient();
		}

	}

	public void stopClient() {
		try {
			ccf.displayText("[연결끊김]");
			ccf.btnConn.setText("start");
			
			if(sc != null && sc.isOpen()){sc.close();}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void send(String data) {
		Charset charset=Charset.forName("UTF-8");
		ByteBuffer bytebuffer=charset.encode(data);
		SelectionKey key=sc.keyFor(selector);
		key.attach(bytebuffer);
		key.interestOps(SelectionKey.OP_WRITE);
		selector.wakeup();
		
	}

}
