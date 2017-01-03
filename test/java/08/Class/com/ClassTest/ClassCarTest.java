package com.ClassTest;

public class ClassCarTest {
	public static void main(String[] args){
		ClassCar cart=new ClassCar();
		cart.setModel("아반테");
		cart.setColor("red");
		cart.setYear(2014);
		cart.setSpeed(50);
		cart.setMaxSpeed(200);

		
		System.out.print(cart.getModel()+" ");
		System.out.print(cart.getColor()+" ");
		System.out.print(cart.getYear()+" ");
		System.out.print(cart.getSpeed()+" ");
		System.out.println(cart.getMaxSpeed());
		
		
		/*ClassCar cart1=new ClassCar("큐브", "blue", 2016);
	
		cart1.setSpeed(80);
		cart1.setMaxSpeed(180);
		cart1.speedUp(40);
		cart1.display();
		cart1.speedDown(150);
		cart1.display();
	
		ClassCar cart2=new ClassCar("그랜져", "black", 2013, 100, 200);
		cart2.speedUp(200);
		cart2.display();
		cart2.speedDown(60);
		cart2.display(); */
	}
}
