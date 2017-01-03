package com.AbstractTest;

public class Shapeex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Shape sh=new Shape();
		//추상클래스에서는 객체생성을 할 수 없음
		
		Shape sh1=new Rect();
		sh1.area(5, 4);
		System.out.println(sh1.sArea);
		
		Shape sh2=new Rect();
		sh2.area(5, 5);
		System.out.println(sh2.sArea);
	}

}
