package com.tcp;

import java.io.*;
import java.net.*;

public class SenderThead extends Thread {
	Socket s; 
	String name;
	
	public SenderThead(Socket s, String name) {
		this.s=s;
		this.name=name;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// 서버에 전송하는 객체 생성
			PrintWriter writer = new PrintWriter(s.getOutputStream());
			writer.println(name); //사용자명 전송
			writer.flush();
			while(true){
			String str = reader.readLine(); //라인단위로 읽어오기
			if(str.equals("bye"))
			break;
			writer.println(str); //입력한 메시지 서버에 전송
			writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		
	}

}
