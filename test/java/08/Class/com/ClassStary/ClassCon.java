package com.ClassStary;
	class Car
	{
		int year; String color;
		
		Car(){System.out.println("default");}//안에 아무것도 없어도 됨
		
		Car(int y){year=y;}
		
		Car(int y, String c){year=y; color=c;}
	
	void display(){
		System.out.println(year);
		System.out.println(color);
	}
	}
public class ClassCon {
	
	public static void main(String[] args){
		Car car1=new Car();
		car1.year=2014;
		car1.color="yello";
		
		car1.display();
		
		
		Car car2=new Car(2015);
		car2.color="red";
		car2.display();
		
		Car car3=new Car(2016,"black");
		car3.display();
	}
}
