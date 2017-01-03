package com.Inheritance;

public class Person{
	protected String name; protected int age;
	
	//상속시 반드시 default 생성자를 해야함
	public Person(){}
	public Person(String name, int age)
	{this.name=name; this.age=age;}
	
	void display(){
		System.out.print(name+"\t");
		System.out.println(age);
	}
	
}