package com.tcp;

import java.net.*;

public class chatServet {
	public static void main(String[] args) {
		ServerSocket ss=null;
		try {
			ss=new ServerSocket(9002);
			
			while (true) {
				Socket s=ss.accept();
				Thread thread=new PerClientThread(s);
				thread.start();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
