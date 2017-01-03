package com.filechannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClinetEx {
	public static void main(String[] args) {
		SocketChannel sc=null;
		
		try {
			sc=SocketChannel.open();
			sc.configureBlocking(true);
			
			System.out.println("[연결요청]");
			
			sc.connect(new InetSocketAddress("127.0.0.1", 5001));
			
			System.out.println("[연결완료]");
			
		
			ByteBuffer bytebuffer=null;
			Charset charset=Charset.forName("UTF-8");
			
			bytebuffer=charset.encode("hello Sever");
			sc.write(bytebuffer);
			System.out.println("[보개기성공]");
			
			bytebuffer=bytebuffer.allocate(100);
			int byteCount=sc.read(bytebuffer);
			bytebuffer.flip();
			String message=charset.decode(bytebuffer).toString();
			System.out.println("[받은데이터]"+message);
			
		
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		if(sc.isOpen()){
			try {
				sc.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
}
