package com.io1;

import java.io.*;

public class IOtextStream{
	public static void main(String[] args) {
		 Reader ir=null;
		 Writer ow= null;
		int readByteNo=0;
		try {
			
			ir= new FileReader("D:/ijuju/test/java/schooljava/IOStreamtest/img/text.txt");
			ow=new FileWriter("D:/ijuju/test/java/schooljava/IOStreamtest/img/text_1.txt");

			
			while ((readByteNo=ir.read())!= -1) {
				ow.write(readByteNo);
			}
			
			ow.flush();
			ow.close();
			ir.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
