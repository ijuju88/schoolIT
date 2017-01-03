package com.udp2;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class FileClient {
	public static void main(String[] args) {
		try {
			Socket s=new Socket("192.168.0.44", 5003);
			OutputStream os=s.getOutputStream();
			
			String filePath="d:/dir/text.txt";
			File file=new File(filePath);
			
			String fileName=file.getName();
			byte[] filebytes=fileName.getBytes("UTF-8");
			filebytes=Arrays.copyOf(filebytes, 100);
			os.write(filebytes);
			
			System.out.println("[파일보내기]"+fileName);
			
			FileInputStream fis=new FileInputStream(file);
			byte[] bytes=new byte[1000];
			int readByte=-1;
			
			while ((readByte=fis.read(bytes))!=-1) {
				os.write(bytes, readByte, readByte);
				System.out.println(readByte);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
