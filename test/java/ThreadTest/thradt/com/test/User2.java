package com.test;

public class User2 extends Thread{
	private Calculator ca;
	
	public void setCalculator(Calculator ca)
	{
		this.setName("User2");
		this.ca=ca;
	}
	
	public void run(){
		ca.setMemory(50);
	}
}
