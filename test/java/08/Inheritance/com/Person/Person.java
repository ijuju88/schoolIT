package com.Person;

public class Person {
	protected String name; 
	protected int age;
	
	public Person(){}
	public Person(String name, int age)
	{this.name=name; this.age=age;}
	
	public void display(){
		System.out.print(name+"\t");
		System.out.print(age+"\t");
	}
}
