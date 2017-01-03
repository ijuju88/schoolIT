package com.Inhsuper0825_1;

public class Car1 {
	String model; int year;
	
	public Car1(){
		System.out.println("Car1생성자");}
	
	public Car1(String model, int year)
	{this.model=model; this.year=year;}
	
	public void display()
	{
		System.out.println(model);
		System.out.println(year);
	}
}
