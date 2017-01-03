package com.interfacetest;

public interface Intertest {
	static final int a=123; //필드선언은 안됨
	
	/*
	 - 메소드가 가능한 범위- 
	타입 메소드명(매개변수, ...); //추상메소드
	default 타입 메소드명(매개변수, ...){...} 
	Static 타입 메소드명(매개변수, ...){...} 
*/
	
	public void display(); //
}
