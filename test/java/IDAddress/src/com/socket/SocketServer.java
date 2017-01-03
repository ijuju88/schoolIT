package com.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		String message=null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

		try {
			ss = new ServerSocket();// ServerSocket인스턴스를 생성한다.
			ss.bind(new InetSocketAddress("localhost", 5001)); // ip주소와 port

			while (true) { // 클라이언트의 요청을 받아들여 데이터를 클라이언트에게 전송한다.
				System.out.println("연결기다리는 중 ....");
				Socket s = ss.accept(); // 서버는 이부분에서 멈춰서 클라이언트의 요청을 기다리다가, 요청이들어오면 클라이언트의 Socket객체를 생성 및 저장
				InetSocketAddress isa = (InetSocketAddress) ss.getLocalSocketAddress(); // Socket에  연결된 클라이언트의 주소

				System.out.println("연결완료 ->" + isa.getHostName());
				
				// 소켓의 입력스트림을 얻는다.
	            InputStream in = s.getInputStream();
	            DataInputStream dis = new DataInputStream(in);  // 기본형 단위로 처리하는 보조스트림
	             
	            // 소켓으로 부터 받은 데이터를 출력한다.
	            System.out.println("클라이언트로부터 받은 메세지 : " + dis.readUTF());
	            
	            
				 // 소켓의 출력스트림을 얻는다.
                OutputStream out = s.getOutputStream(); 
                DataOutputStream dos = new DataOutputStream(out); // 기본형 단위로 처리하는 보조스트림
                 
                // 원격 소켓(remote socket)에 데이터를 보낸다.
                System.out.println("message입력하세요~~");
                message=reader.readLine();
                dos.writeUTF(message);
                System.out.println(" 데이터를 전송했습니다.");
            
                //dis.close(); in.close();  dos.close(); out.close(); s.close(); ss.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!ss.isClosed()) {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
