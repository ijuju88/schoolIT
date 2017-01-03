package com.ClassTest;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal=new Calculator();
		
		
		/*System.out.println(cal.sum(10)); 
		//int num1=cal.su.(10);
		//System.out.println(num1);
		
		System.out.println(cal.sum(10+20));
		System.out.println(cal.sum(10+20+30));*/
		
		int[] num= new int[]{10};
		System.out.println(cal.sum(num)); 
		int[] num2= {1,2,3};
		System.out.println(cal.sum(num2));
 
		int[] num3= {1,2,3,4};
		System.out.println(cal.sum1(num3));
		System.out.println(cal.sum1(10,20));
		
	}

}
