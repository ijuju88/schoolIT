package com.ClassTest;

public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator2 mycal= new Calculator2();
		mycal.setcolor("red");
		
		System.out.println(mycal.sum(10, 20));
		System.out.println(mycal.mul(10, 20));
		
		double area=10*20*Calculator2.pi;
		int add=Calculator2.sum(10, 20);
		int nul=Calculator2.mul(10, 20);
		
		System.out.println(area);
		System.out.println(add);
		System.out.println(nul);
		
		
	}

}

class Calculator2{
	String color;
	
	void setcolor(String color){this.color=color;}
	
	
	static double pi=3.141592;
	
	static int sum(int x, int y){return x+y;}
	static int mul(int x, int y){return x*y;}
	
}