package com.ClassTest;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CarT myCar=new CarT();
		myCar.display();
		
		//main안에 접근
		//System.out.println("제작회사 : "+myCar.company);
		//System.out.println("제작회사 : "+myCar.speed);
	
	}

}

class CarT{
	String company, model, color;
	int maxSpeed, speed;
	
	void display(){
		System.out.println(company); //클래스안에서 접근
	}
	
}