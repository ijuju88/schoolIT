package com.filechannelchetting;

import java.awt.ComponentOrientation;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import javax.sound.midi.Receiver;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class ChattingClient {
	SocketChannel sc;
	ChatClientFrame ccf;

	public ChattingClient(ChatClientFrame ccf) {
		this.ccf = ccf;
	}

	void startClient(String address) {
		Thread thread = new Thread() {

			@Override
			public void run() {

				try {
					sc = SocketChannel.open();
					sc.configureBlocking(true);
					sc.connect(new InetSocketAddress("127.0.0.1", 5001));
					ccf.displayText("[연결완료 :" + sc.getRemoteAddress() + "]");
					ccf.btnConn.setText("stop");
					ccf.btnSend.setEnabled(true);

				} catch (IOException e) {
					ccf.displayText("[연결안됨]");
					if (sc.isOpen()) {
						stopClient();
					}
					return;
				}
				receiver();
			}

		};

		thread.start();
	}

	void stopClient() {
		try {
			ccf.displayText("[연결끊김]");
			ccf.btnConn.setText("채팅참여하기");
			ccf.btnSend.setEnabled(false);

			if (sc != null && sc.isOpen()) {
				sc.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	void receiver() {
		while (true) {
			try {
				ByteBuffer bytebuffer = ByteBuffer.allocateDirect(100);
				int readByte = sc.read(bytebuffer);

				if (readByte == -1) {
					break;
				}

				bytebuffer.flip();
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(bytebuffer).toString();

				ccf.displayText(data);
				System.out.println("data ->" + data);

			} catch (Exception e) {
				ccf.displayText("[서버통신안됨]");
				stopClient();
				break;
			}
		}
	}

	void send(String data) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					Charset charset = Charset.forName("UTF-8");
					ByteBuffer bytebuffer = charset.encode(data);
					sc.write(bytebuffer);
					System.out.println("senddata ->" + data);
					
					bytebuffer.flip();
				} catch (Exception e) {
					ccf.displayText("[서버통신안됨]");
					stopClient();
				}
			}

		};
		thread.start();
	}

}
