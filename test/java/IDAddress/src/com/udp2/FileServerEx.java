package com.udp2;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.*;

public class FileServerEx {
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket();
			ss.bind(new InetSocketAddress("127.0.0.1", 5003));
			System.out.println("[서버시작]");
			
			while (true) {
				Socket s=ss.accept();
				InputStream is=s.getInputStream();
				
				byte[] bytes=new byte[1000];
				int readByte=-1;
				is.read(bytes, 0,100);
				String fileName=new String(bytes, 0, 100, "UTF-8");
				fileName=fileName.trim();
				
				System.out.println("[파일받기]"+fileName);
				
				FileOutputStream fos=new FileOutputStream("d:/");
				
				while ((readByte=is.read(bytes))!=-1) {
					fos.write(bytes,0,readByte);
				}
				
				fos.flush();
				fos.close();
				is.close();
				s.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
