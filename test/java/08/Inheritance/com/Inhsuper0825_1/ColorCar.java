package com.Inhsuper0825_1;

public class ColorCar extends Car1{
	String color;
	
	public ColorCar()
	{	super(); //자식클래스에서 super - 부모생성자 호출
		System.out.println("ColorCar생성자");
		// super();부모클래스를 하고 호출해야하므로 뒤에가면 안됨
	}
	
	public ColorCar(String model, int year, String color)
	{ //this.model=model; this.year=year; 
		super(model, year);
		this.color=color;}
	
	public void dispaly(){
		System.out.print(model+"\t");
		System.out.print(year+"\t");
		System.out.println(color);
	}
}
