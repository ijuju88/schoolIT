package com.interfacetest;

public class Student implements PersonInterface {
	String name, major; int age, score; 
	
	public Student(){}
	public Student(String name, int age, String major, int score)
	{this.name=name; this.age=age; this.major=major; this.score=score;}
	
	
	@Override
	public void setName(String name) 
	{this.name=name;}

	@Override
	public void setAge(int age) 
	{this.age=age;}

	public void setMajor(String major)
	{this.major=major;}
	
	public void setScore(int score)
	{this.score=score;}
	
	@Override
	public void dispaly() 
	{System.out.println(name+":"+age+":"+major+":"+score);}

	public void defMethod()
	{System.out.println("Student default Method!!");}
	@Override
	public boolean comperTo(PersonInterface per) {
		if(this.score>((Student)per).score)return true;
		else return false;
	}
}
