package com.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class SocketClient {
	public static void main(String[] args) throws Exception{
		String message=null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		Socket c =new Socket("localhost", 5001); //Socket클래스의 인스턴스 생성
		System.out.println("연결요청중~~~");
		
		//c.connect(new InetSocketAddress("localhost", 5001)); // ip주소와 port

          // 소켓의 출력스트림을 얻는다.
          OutputStream out = c.getOutputStream(); 
          DataOutputStream dos = new DataOutputStream(out); // 기본형 단위로 처리하는 보조스트림
           
          // 원격 소켓(remote socket)에 데이터를 보낸다.
          System.out.println("message입력하세요~~");
          message=reader.readLine();	
          dos.writeUTF(message);
          
          // 소켓의 입력스트림을 얻는다.
          InputStream in = c.getInputStream();
          DataInputStream dis = new DataInputStream(in);  // 기본형 단위로 처리하는 보조스트림
           
          // 소켓으로 부터 받은 데이터를 출력한다.
          System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
          System.out.println("연결을 종료합니다.");
  
          //dis.close(); in.close(); dos.close(); out.close(); c.close();
        
		if (!c.isClosed()) {
			try {
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}
