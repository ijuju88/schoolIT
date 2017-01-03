package com.io1;

import java.io.*;

/*메모장파일을 불려봅시다*/
public class IOInputStreamex1 {
	public static void main(String[] args) {
		try {
			InputStream io=new FileInputStream("d:/text.txt");
		
			byte[] readBytes=new byte[100];
			int readByte=io.read(readBytes);
			
			System.out.println(new String(readBytes));
			System.out.println(readByte);
			
			io.close();
			
		} catch (Exception e) {
			System.err.println("문서불려오기 실패 ->"+e.getMessage());
		}
	}
}
