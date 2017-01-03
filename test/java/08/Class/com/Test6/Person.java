package com.Test6;

public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonClass[] per1=new PersonClass[3];
		per1[0]=new PersonClass("홍길동",20, "백수");
		per1[1]=new PersonClass("홍길자",30, "회사원");
		per1[2]=new PersonClass("홍길길",25, "교사");
		
		for (PersonClass p : per1) p.display();
		
	}

}

class PersonClass{
	private String name;
	private int age;
	private String job;
	
	PersonClass(){}

	public PersonClass(String name, int age, String job) {
		this.name= name;
		this.age = age;
		this.job= job;}
	
	public void display(){
			System.out.println
			("이름 : "+name+" 나이 : "+age+" 직업 : "+job);
		}
	}
