package com.udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSendEx {
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();

			for (int i = 1; i <= 10; i++) {
				String data = "message" + i;
				byte[] byteArr = data.getBytes("UTF-8");

				DatagramPacket dp = new DatagramPacket(byteArr, byteArr.length,
						new InetSocketAddress("127.0.0.1", 5002));
				ds.send(dp);
				
				System.out.println("보낸바이트수 : "+byteArr.length+"bytes");
			}
			System.out.println("[발신종료]");
			ds.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
