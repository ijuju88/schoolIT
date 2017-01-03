package com.non.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;

import com.filechannelchetting.chatServerFrame;

public class NChattingServer {
	ChatServerFrame csf;
	Selector selector;
	ServerSocketChannel ssc;
	List<Client> list = new Vector<>();

	public NChattingServer(ChatServerFrame csf) {
		this.csf = csf;
	}

	public void startServer() {
		try {
			selector = Selector.open();
			ssc = ssc.open();

			// non플로킹을 위해 false를 합니다
			ssc.configureBlocking(false);

			ssc.bind(new InetSocketAddress(5001));

			// selector에게 accept 할 키등록을합니다
			ssc.register(selector, SelectionKey.OP_ACCEPT);

		} catch (Exception e) {
			if (ssc.isOpen()) {
				stopServer();
			}
			return; // 예외가 발생하면 리턴시킬겁니다
		}
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						int keyCount = selector.select();// key가 들어왔는지 감지

						if (keyCount == 0) {
							continue;
						} // keyCount값이 0이면 계속감지

						Set<SelectionKey> selectKeys = selector.selectedKeys();
						Iterator<SelectionKey> iterator = selectKeys.iterator();

						while (iterator.hasNext()) {
							SelectionKey selectionKey = iterator.next();

							if (selectionKey.isAcceptable()) {
								accept(selectionKey);
							} else if (selectionKey.isReadable()) {
								Client client = (Client) selectionKey.attachment();
								client.receive(selectionKey);
							} else if (selectionKey.isWritable()) {
								Client client = (Client) selectionKey.attachment();
								client.send(selectionKey);
							}

							iterator.remove();
						}

					} catch (Exception e) {
						if (ssc.isOpen()) {
							stopServer();
						}
						break; // 예외가 발생하면 나갈겁니다
					}
				}
			}

		};
		thread.start();
		csf.displayText("[서버시작]");
		csf.btnstartstop.setText("[stop]");
	}

	public void stopServer() {
		try {
			Iterator<Client> iterator=list.iterator();
			
			while (iterator.hasNext()) {
				Client client=iterator.next();
				client.socketchannel.close();
				iterator.remove();
			}
			if(ssc!=null && ssc.isOpen()){ssc.close();}
			if(selector!=null && selector.isOpen()){selector.close();}
			csf.displayText("[서버닫힘]");
			csf.btnstartstop.setText("시작");
			
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	void accept(SelectionKey selectionkey) {
		try {
			ServerSocketChannel serversocketshannel = (ServerSocketChannel) selectionkey.channel();
			SocketChannel socketchannel = serversocketshannel.accept();
			String message = 
			"[연결수락 :" + socketchannel.getRemoteAddress() + Thread.currentThread() + "]";
			csf.displayText(message);

			Client client = new Client(socketchannel);
			list.add(client);

			csf.displayText("[연결개수 : " + list.size() + "]");

		} catch (Exception e) {
			if (ssc.isOpen()) {
				stopServer();
			}
		}

	}

	class Client {
		SocketChannel socketchannel;
		String sendData;

		Client(SocketChannel socketchannel) throws IOException {
			this.socketchannel = socketchannel;
			socketchannel.configureBlocking(false);
			SelectionKey selectionkey = socketchannel.register(selector, SelectionKey.OP_READ);
			selectionkey.attach(this);
		}

		public void receive(SelectionKey selectionKey) {
			try {
				ByteBuffer bytebuffer = ByteBuffer.allocate(100);
				int byteCount = socketchannel.read(bytebuffer);

				if (byteCount == -1)
					throw new IOException();
				bytebuffer.flip();
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(bytebuffer).toString();

				String message = 
				"[연결수락 :" + socketchannel.getRemoteAddress() + Thread.currentThread() + "]";
				csf.displayText(message);

				for (Client client : list) {
					client.sendData = data;
					SelectionKey key = client.socketchannel.keyFor(selector);
					key.interestOps(selectionKey.OP_WRITE);
				}
				selector.wakeup();

			} catch (Exception e) {
				try {
					list.remove(this);
					String message=
					"[클라이언트 통신 안됨 : "+socketchannel.getRemoteAddress()+Thread.currentThread()+"]";
					socketchannel.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}

		public void send(SelectionKey selectionKey) {
			try {
				Charset charset=Charset.forName("UTF-8");
				ByteBuffer bytebuffer = charset.encode(sendData);
				socketchannel.write(bytebuffer);
				selectionKey.interestOps(SelectionKey.OP_READ);
			} catch (Exception e) {
				try {
					list.remove(this);
					String message=
					"[클라이언트 통신 안됨 : "+socketchannel.getRemoteAddress()+Thread.currentThread()+"]";
					socketchannel.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}

	}

}
