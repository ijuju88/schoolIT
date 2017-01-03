package com.AbstractTest;

public abstract class Phone {
	public String owner;
	public Phone(String owner){this.owner=owner;}
	
	public void turnOn(){System.out.println("폰전원켬");}
	public void turnOff(){System.out.println("폰전원켬끔");}
}
