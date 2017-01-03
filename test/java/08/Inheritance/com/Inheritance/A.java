package com.Inheritance;

public class A {
	public void methodA(){
		System.out.println("메소드A");
	}
	public void methodB(){} //오버라이딩 안넣으면 B클래스 못불려옴
}

class B extends A{
	public void methodB(){
		System.out.println("메소드B");
	}
}

