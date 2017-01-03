package com.io1;

import java.io.*;

public class Consoleex {
	public static void main(String[] args) {
		Console con=System.console();
		
		System.out.print("아이디 ▶");
		String id=con.readLine();
		
		System.out.print("비 번  ▶");
		char[] charpw=con.readPassword();
		String pw=new String(charpw);
		
		System.out.println("==========");
		System.out.println(id);
		System.out.println(pw);
	}
}
