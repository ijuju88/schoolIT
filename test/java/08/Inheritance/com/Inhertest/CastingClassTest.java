package com.Inhertest;

public class CastingClassTest {
	public static void main(String[] args){
	CastingClassA a=new ClassB();
	a.methodA();
	
	ClassB b=(ClassB)a;
	b.methodA();
	b.methodB();
	
	//문법상은 맞지만 실행하면 오류남
	//ClassB B=(ClassB)(new CastingClassA()); 
	
	CastingClassA a1=new CastingClassA();
	//ClassB b1=(ClassB)a1;
	
	
	CastingClassA a2=new ClassC();
	a2.methodA();
	ClassC c=(ClassC)a2;
	c.methodC();
	
	//객체 타입 확인
	System.out.println(a1 instanceof ClassB);
	System.out.println(a instanceof CastingClassA);
	System.out.println(a2 instanceof CastingClassA);
	System.out.println(c instanceof CastingClassA);
	}
}
