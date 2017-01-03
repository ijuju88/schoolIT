package com.interfacetest;

public interface Shape {
	public static final double PI=3.14;
	public int area(int x, int y);
	public void display();
	
	default void defMethod(){
		System.err.println("default method!");
	}
	
	static void staticMethod(){
		System.out.println("static method!");
	}
}

class Rect implements Shape{
	int width, height;
	
	public Rect(int width, int height)
	{this.width=width; this.height=height;}
	
	@Override
	public int area(int x, int y) {
		return width*height;
	}

	@Override
	public void display() {
		System.out.println("폭 : "+width);
		System.out.println("높이 : "+height);
		System.out.println("넓이 : "+area(width, height));		
	}
}

class Trangle implements Shape{
int width, height;
	
	public Trangle(int width, int height)
	{this.width=width; this.height=height;}
	
	@Override
	public int area(int x, int y) {
		return width*height/2;
	}

	@Override
	public void display() {
		System.out.println("폭 : "+width);
		System.out.println("높이 : "+height);
		System.out.println("넓이 : "+area(width, height));		
	}
	
	
}
