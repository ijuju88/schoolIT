package com.interfacetest;

public interface Score {
	
	public static final int MIN_VALE=0; 
	int MAX_VALE=0; //생략가능 
	public abstract void display();
	void setScore(int score);
	
	//jdk8에서 가능한 메소드
	public default void deMethod()
	{System.out.println("default Method!!");}
	
	public static void staticMethod()
	{System.out.println("static Method!");}
}

//추상클래스의 자식클래스에서는 오버라이딩을 해야함
class KorScore implements Score{
	int score;
	
	@Override
	public void display() 
	{System.out.println(score);}

	@Override
	public void setScore(int score) 
	{this.score=score;}
	
}