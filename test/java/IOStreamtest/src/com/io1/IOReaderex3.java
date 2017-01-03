package com.io1;

import java.io.*;

public class IOReaderex3 {
	public static void main(String[] args) {
		try {
			Reader ir = new FileReader("d:/text1.txt");
			int readDate;
			while ((readDate=ir.read())!= -1) {
				System.out.println((char)readDate);
			}
			
			ir.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
