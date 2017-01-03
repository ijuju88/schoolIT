package com.interfacetest;

public class ShapeInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect r=new Rect(5, 6);
		r.display();
		
		Shape s=new Trangle(5, 6);
		s.display();
		
		Shape s1=new Shape(){
			int x=3,y=2;
			@Override
			public int area(int x, int y) 
			{return x*y;}

			@Override
			public void display() 
			{System.out.println(x+", "+y+", "+area(x, y));}
		};
	
		s1.display();
		
	}

}
