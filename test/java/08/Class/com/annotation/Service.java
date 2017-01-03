package com.annotation;

public class Service {
	@AnnotationTest
	public void method1(){System.out.println("실행1");}
	
	@AnnotationTest("*")
	public void method2(){System.out.println("실행2");}
	
	@AnnotationTest(value="#", number=20)
	public void method3(){System.out.println("실행3");}
}
