package com.Inher;

import com.Inheritance.Person;

public class Employee extends Person {
	public int empNo;
	public String job;
	
	public void empDisplay(){
		System.out.print(name);
		System.out.println(age);
		System.out.println(empNo);
		System.out.println(job);
	}
}
