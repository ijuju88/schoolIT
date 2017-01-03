package com.ClassTest;

public class Student {
	int grade;
	String name, dept;
	
	Student(String n){
		name=n;
	}
	
	void display(){
		System.out.println(name);
		System.out.println(grade);
		System.out.println(dept);
	}
}
