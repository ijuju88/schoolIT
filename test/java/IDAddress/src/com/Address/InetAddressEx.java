package com.Address;

import java.net.InetAddress;

public class InetAddressEx {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress() : " + ip.getHostAddress());
			System.out.println("toString() : " + ip.toString());

			System.out.println("----도메인명(host)에 지정된 모든 호스트의 IP 주소를 배열----");
			
			InetAddress[] addresses = InetAddress.getAllByName("www.daum.net");
			for (int i = 0; i < addresses.length; i++) {
				System.out.println("addresses["+i+"]"+addresses[i]);
			}
			
			System.out.println("--------지역호스트의 IP주소--------");
			ip = InetAddress.getLocalHost( );
			System.out.println(ip);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
