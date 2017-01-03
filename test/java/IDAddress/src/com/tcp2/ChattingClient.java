package com.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

import javax.sound.midi.Receiver;


public class ChattingClient {
	Socket s;
	ChatClientFrame ccf;
	
	public ChattingClient(ChatClientFrame ccf) {
		this.ccf=ccf;
	}
	
	void startClient(String address){
		Thread thread=new Thread(){
			
			@Override
			public void run() {
				
				try {
					s=new Socket();
					s.connect(new InetSocketAddress(address, 5001));
					ccf.displayText("[연결완료 :"+s.getRemoteSocketAddress()+"]");
					ccf.btnConn.setText("stop");
					ccf.btnSend.setEnabled(true);
					
				} catch (IOException e) {
					ccf.displayText("[연결안됨]");
					if(!s.isClosed()){stopClient();}
					return;
				}
				receiver();
			}
			
		};
		
		thread.start();
	}
	
	
	void stopClient(){
		try {
			ccf.displayText("[연결끊김]");
			ccf.btnConn.setText("채팅참여하기");
			ccf.btnSend.setEnabled(false);
			
			if(s!=null && !s.isClosed()){s.close();}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
void receiver(){
		while (true) {
			try {
				byte[] bytearr=new byte[100];
				InputStream is=s.getInputStream();
				int readByte=is.read(bytearr);
				
				if(readByte == -1){
					break;
				}
			
				String data=new String(bytearr, 0, readByte, "UTF-8");
				ccf.displayText(data);
				System.out.println("data ->"+data);
				
			} catch (Exception e) {
				ccf.displayText("[서버통신안됨]");
				stopClient();
				break;
			}
		}
	}

	void send(String data){
		Thread thread=new Thread(){
			@Override
			public void run() {
				try {
					byte[] bytearr=data.getBytes("UTF-8");
					OutputStream os=s.getOutputStream();
					os.write(bytearr);
					System.out.println("senddata ->"+data);
					os.flush();
				} catch (Exception e) {
					ccf.displayText("[서버통신안됨]");
					stopClient();
				}
			}
			
		};
		thread.start();
	}
	
}
