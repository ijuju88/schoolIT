package com.test;

public class User1 extends Thread{
	private Calculator ca;
	
	public void setCalculator(Calculator ca)
	{
		this.setName("User1");
		this.ca=ca;
	}
	
	public void run(){
		ca.setMemory(100);
	}
}
