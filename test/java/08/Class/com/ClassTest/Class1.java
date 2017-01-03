package com.ClassTest;

public class Class1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		car1.year=2016;
		car1.color="red";
		
		car1.display();

		Car car2=new Car();
		car2.year=2015;
		car2.color="black";
		car2.display();
	}

}


class Car{
	int year;
	String color;
	
	void display(){
		System.out.println(year);
		System.out.println(color);
	}
}