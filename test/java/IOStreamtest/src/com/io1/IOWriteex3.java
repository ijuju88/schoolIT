package com.io1;

import java.io.*;

public class IOWriteex3 {
	public static void main(String[] args) {
		try {
			Writer ow = new FileWriter("d:/text2.txt");
			String str="안녕하세요!!";
			char[] c=str.toCharArray();
			
			ow.write(c);
			/*for (int i = 0; i < c.length; i++) {
				ow.write(c[i]);
			}*/
			
			ow.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
