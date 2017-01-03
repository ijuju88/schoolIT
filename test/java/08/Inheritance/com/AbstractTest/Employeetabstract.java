package com.AbstractTest;

public abstract class Employeetabstract {
	int empno=0;
	String name, dept;
	int pay=0;

	
	public abstract void setPay();
	public void display(){
		System.out.println("---간단급여명세서---");
		System.out.println("사번 : "+empno);
		System.out.println("이름 : "+name);
		System.out.println("직급 : "+dept);
	}

}
