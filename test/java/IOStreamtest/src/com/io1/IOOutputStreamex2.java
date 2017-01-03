package com.io1;

import java.io.*;

public class IOOutputStreamex2 {
		public static void main(String[] args) {
			try {
				//주석처럼하면 파일이 존재하기 때문에 내용이 바뀝니다
				//OutputStream io=new FileOutputStream("d:/text.txt");
				
				OutputStream io=new FileOutputStream("d:/text1.txt");
				
				String str="-EFG아아";
				byte[] writeBytes=str.getBytes();
				
				io.write(writeBytes);
				/*for (int i = 0; i < writeBytes.length; i++) {
					io.write(writeBytes[i]);
				}*/
				
				io.close();
				//버퍼에 남은 출력스트림을 출력합니다 지금은 안해도 됩니다
				io.flush();
				
			} catch (Exception e) {
				System.err.println("문서출력실패 ->"+e.getMessage());
			}
		}
	}

