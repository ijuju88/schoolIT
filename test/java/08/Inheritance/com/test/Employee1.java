package com.test;

public class Employee1 extends Person1 {
	String company, dept;
	int pay;
	
	public Employee1(String name, int age, String iv, String company, String dept, int pay)
	{super(name, age, iv); this.company=company; this.dept=dept; this.pay=pay;}
	
	public void display()
	{
		super.display();
		System.out.println("회사 : "+company);
		System.out.println("부서 : "+dept);
		System.out.println("급여 : "+pay);
	}
}
