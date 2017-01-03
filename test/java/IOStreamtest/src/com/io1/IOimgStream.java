package com.io1;

import java.io.*;

public class IOimgStream{
	public static void main(String[] args) {
		InputStream is=null;
		OutputStream os= null;
		int readByteNo=0;
		try {
			
			is= new FileInputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/06.jpg");
			os=new FileOutputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/06_1.jpg");

			
			while ((readByteNo=is.read())!= -1) {
				os.write(readByteNo);
			}
			os.flush();
	        os.close();
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
