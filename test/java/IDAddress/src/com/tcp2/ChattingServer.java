package com.tcp2;


import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChattingServer {
	ExecutorService es;
	chatServerFrame csf;
	ServerSocket ss;
	List<Client> list=new Vector<>();
	
	public ChattingServer(chatServerFrame csf) {
		this.csf=csf;
	}
	
	//서버실행
	void startServer(){
		//현재실행시간에 남은 스레드 시간만큼 들어가게 됩니다.
		es=Executors.newFixedThreadPool
				(Runtime.getRuntime().availableProcessors());
	try {
		ss=new ServerSocket(5001);
	} catch (Exception e) {
		if(!ss.isClosed()){stopServer();}
		return;
	}
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				csf.displayText("[서버시작]");
				csf.btnstartstop.setText("stop");
				
				while (true) {
					try{
					Socket s=ss.accept();
					String message="[연결수락:"+
					s.getRemoteSocketAddress()+Thread.currentThread()+"]";
					csf.displayText(message);
					
					Client client=new Client(s);
					list.add(client);
					csf.displayText("[연결개수 : "+list.size()+"]");
					
					}catch (Exception e) {
						if(!ss.isClosed()){stopServer();}
						return;
					}
				}
			}
		};
		es.submit(runnable);
	
	}
	
	//서버끝내기
	void stopServer(){
		try {
			Iterator<Client> iterator=list.iterator();
			
			while (iterator.hasNext()) {
				Client client=iterator.next();
				client.s.close();
				iterator.remove();
			}
			if(ss!=null && !ss.isClosed())
			{
				ss.close();
			}
			if(es!=null && es.isShutdown())
			{
				es.shutdown();
			}
			csf.displayText("[서버닫힘]");
			csf.btnstartstop.setText("시작");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public class Client{
		Socket s;
		public Client(Socket s) {
			this.s=s;
			receive();
		}
		void receive() {
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					try {
						while (true) {
							byte[] bytearr=new byte[100];
							InputStream is=s.getInputStream();
							int readByte=is.read(bytearr);
							
							if(readByte == -1){
								throw new IOException();
							}
							String message=
								"[요청처리:"+s.getRemoteSocketAddress()+Thread.currentThread()+"]";
							csf.displayText(message);
							String data=new String(bytearr, 0, readByte, "UTF-8");
							
							System.out.println("csdata->"+data);
							for(Client client : list){
								client.send(data);
							}
						}
					} catch (Exception e) {
						try {
							list.remove(Client.this);
							String message=
								"[클라이언트 통신안됨 : +" + s.getRemoteSocketAddress()+Thread.currentThread()+"]";
						} catch (Exception e1) {
							e1.getStackTrace();
						}
					}
					
				}
			};
			es.submit(runnable);
			
		}
		
		
		void send(String data) {
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					try {
						byte[] bytearr=data.getBytes("UTF-8");
						OutputStream os=s.getOutputStream();
						os.write(bytearr);
						os.flush();
					} catch (Exception e) {
						try {
							list.remove(Client.this);
							String message=
								"[클라이언트 통신안됨 : +" + s.getRemoteSocketAddress()+Thread.currentThread()+"]";
						} catch (Exception e1) {
							e1.getStackTrace();
						}
					}
					
				}
			};
			es.submit(runnable);
		}
		
	}
}
