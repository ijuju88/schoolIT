package com.Inhertest;

public class CastingClassA {
	public void methodA()
	{System.out.println("클래스A의 methodA");}
}


class ClassB extends CastingClassA{
	public void methodB()
	{System.out.println("클래스B의 methodB");}

}


class ClassC extends ClassB{
	public void methodC()
	{System.out.println("클래스C의 methodC");}
}
