package com.io1;

import java.io.*;

public class OutputStreamWriterex {

	public static void main(String[] args) {
		// OutputStreamReader 선언
		OutputStreamWriter osw = null;

		try {
			osw = new OutputStreamWriter(new FileOutputStream("d:/text.txt"));
			String str = "ㅋㅋㅋ 조앙~~";
			byte[] writeBytes = str.getBytes();
			
			osw.write(new String(writeBytes));


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (osw != null)
				try {
					osw.close();
				} catch (IOException e) {
				}
		}
	}
}
