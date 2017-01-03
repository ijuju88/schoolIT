package com.udp1;

import java.net.*;

public class UDPReceiveEx {
	public static void main(String[] args) {
		try {
			//-DatagramSocket클래스(우편함과 같은 클래스)
			DatagramSocket ds = new DatagramSocket(5002);

			Thread thread = new Thread() {
				@Override
				public void run() {
					System.out.println("[수신시작]");
					byte[] bytes=new byte[100];

					try {
						while (true) {
							//-DatagramPacket 클래스 (소포와 같은 클래스)
							DatagramPacket dp=new DatagramPacket(bytes, bytes.length);
							ds.receive(dp); //수신데이터를 받습니다
							
							//데이터를 출력할 String타입의 data를 생성합니다.
							String data=new String(dp.getData(), 0, dp.getLength(), "UTF-8");
							
							System.out.println(" -> "+data);
						}
					} catch (Exception e) {
						System.out.println("[수신종료]");
					}
				}
			};
			
			thread.start();
			//thread.sleep(1000);
			//ds.close();
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}
