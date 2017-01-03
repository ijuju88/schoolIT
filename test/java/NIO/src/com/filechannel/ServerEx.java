package com.filechannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerEx {
	public static void main(String[] args) {
		ServerSocketChannel ssc= null;
		try {
			ssc=ServerSocketChannel.open();
			ssc.configureBlocking(true);
			ssc.bind(new InetSocketAddress(5001));
			
			while (true) {
				System.out.println("[클라이언트 연결 요청 수락]");
				SocketChannel sc=ssc.accept();
				
				InetSocketAddress isa=(InetSocketAddress)sc.getRemoteAddress();
				System.out.println("[연결완료]"+isa.getHostName());
				
				ByteBuffer bytebuffer=ByteBuffer.allocate(100);
				Charset charset=Charset.forName("UTF-8");
				
				int byteCount=sc.read(bytebuffer);
				bytebuffer.flip();
				String message=charset.decode(bytebuffer).toString();
				System.out.println("[받은데이터]"+message);
				
				bytebuffer=charset.encode("hello Cilent");
				sc.write(bytebuffer);
				System.out.println("[보개기성공]");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		if(ssc.isOpen()){
			try {
				ssc.close();
			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}
	}
}
