package com.test;

public class Person1 {
	
	private String name, iv; private int age;
	
	public Person1(){}
	public Person1(String name, int age, String iv)
	{this.name=name; this.age=age; this.iv=iv;}
	
	
	
	public void display(){
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("주소 : "+iv);
	}
	
}
