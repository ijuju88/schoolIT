package com.io1;

import java.io.*;

public class IOSysteminex {
	public static void main(String[] args) throws IOException {
		System.out.println("===메뉴===");
		System.out.println("1.예금조회");
		System.out.println("2.예금출금");
		System.out.println("3.예금입금");
		System.out.println("4.종료하기");
		System.out.print("선택하세요▶");

		InputStream is = System.in;
		char inputchar = (char) is.read();

		switch (inputchar) {
		case '1':
			System.out.println("=예금조회입니다=");
			break;
		case '2':
			System.out.println("=예금출금입니다=");
			break;
		case '3':
			System.out.println("=예금입금입니다=");
			break;
		case '4':
			System.out.println("=종료합니다!!=");
			break;

		default:
			break;
		}

	}
}
