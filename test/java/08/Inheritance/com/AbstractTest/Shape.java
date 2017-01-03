package com.AbstractTest;
/*
 	abstract - 추상클래스, 설계용(큰프로젝트~~)
 */
public abstract class Shape {
	int sArea;
	public void draw(){System.out.println("Shape draw!");}
	
	//추상메소드 - 재정의해야하는 메소드가 하나라도 있으면 클래스가 추상 클래스가 됨
	public abstract void area(int x, int y);

}

class Rect extends Shape{

	@Override
	public void area(int x, int y) {
		sArea=x*y;
	}
	
}


class Circle extends Shape{

	@Override
	public void area(int x, int y) {
		sArea=(int)(x*y*3.14);
	}
	
}