package com.filechannelchetting;


import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;

public class ChattingServer {
	ExecutorService es;
	chatServerFrame csf;
	ServerSocketChannel ssc;
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
		ssc=ServerSocketChannel.open();
		ssc.configureBlocking(true);
		ssc.bind(new InetSocketAddress(5001));
		
	} catch (Exception e) {
		if(ssc.isOpen()){stopServer();}
		return;
	}
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				csf.displayText("[서버시작]");
				csf.btnstartstop.setText("stop");
				
				while (true) {
					try{
					SocketChannel sc=ssc.accept();
					String message="[연결수락:"+
					sc.getRemoteAddress()+Thread.currentThread()+"]";
					csf.displayText(message);
					
					Client client=new Client(sc);
					list.add(client);
					csf.displayText("[연결개수 : "+list.size()+"]");
					
					}catch (Exception e) {
						if(ssc.isOpen() ){stopServer();}
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
				client.sc.close();
				iterator.remove();
			}
			if(ssc!=null && ssc.isOpen())
			{
				ssc.close();
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
		SocketChannel sc;
		public Client(SocketChannel sc) {
			this.sc=sc;
			receive();
		}
		void receive() {
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					try {
						while (true) {
							ByteBuffer bytebuffer=ByteBuffer.allocateDirect(100);
							
							int readByte=sc.read(bytebuffer);
							
							if(readByte == -1){
								throw new IOException();
							}
							String message=
								"[요청처리:"+sc.getRemoteAddress()+Thread.currentThread()+"]";
							csf.displayText(message);
							bytebuffer.flip();
							Charset charset=Charset.forName("UTF-8");
							String data=charset.decode(bytebuffer).toString();
							
							System.out.println("csdata->"+data);
							for(Client client : list){
								client.send(data);
							}
						}
					} catch (Exception e) {
						try {
							list.remove(Client.this);
							String message=
								"[클라이언트 통신안됨 : +" + sc.getRemoteAddress()+Thread.currentThread()+"]";
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
						Charset charset=Charset.forName("UTF-8");
						ByteBuffer bytebuffer=charset.encode(data);
						sc.write(bytebuffer);
						
					} catch (Exception e) {
						try {
							list.remove(Client.this);
							String message=
								"[클라이언트 통신안됨 : +" + sc.getRemoteAddress()+Thread.currentThread()+"]";
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
