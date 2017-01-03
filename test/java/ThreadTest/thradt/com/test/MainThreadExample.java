package com.test;

public class MainThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator ca=new Calculator();
		
		User1 user1=new User1();
		user1.setCalculator(ca);
		user1.start();
		
		User2 user2=new User2();
		user2.setCalculator(ca);
		user2.start();
	}

}
