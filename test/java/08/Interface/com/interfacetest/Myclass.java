package com.interfacetest;

public class Myclass {
	PersonInterface pi;
	
	public Myclass(PersonInterface pi)
	{	this.pi=pi;
		this.pi.dispaly();
	}
	
	public void MethodA(PersonInterface pi)
	{	this.pi=pi;
		this.pi.defMethod();
		this.pi.dispaly();}
	
	public void MethodB()
	{pi=new Employee();
	((Employee)pi).setEmpno(1);
	pi.setName("박사장");
	pi.setAge(30);
	((Employee)pi).setDept("사장");
	((Employee)pi).setPay(500);
	
	this.pi.dispaly();}
}
