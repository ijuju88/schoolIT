package com.tcp;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
	public static void main(String[] args) {
		//채팅때 쓸 이름을 적을겁니다
		Scanner sc=new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name=sc.nextLine();
		//System.out.println(name);
		Socket s=null;
		
		try {
			s=new Socket("192.168.0.44", 9002);
			//PrintWriter out=new PrintWriter(s.getOutputStream(), true);
			
			Thread senderThread=new SenderThead(s, name);
			Thread receiverThread=new ReceiverThread(s);
			
			senderThread.start();
			receiverThread.start();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
