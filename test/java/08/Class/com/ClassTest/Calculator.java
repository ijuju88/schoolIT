package com.ClassTest;

public class Calculator {
	
	/*int sum(int num){return num+5;}
	int sum(int num1, int num2){return num1+num2;}
	int sum(int num1, int num2, int num3)
	{return num1+num2+num3;}*/
	
	int sum(int[] num)
	{
		int add=0;
		for (int i = 0; i < num.length; i++) 
			add+=num[i];
		
		return add;
	}
	
	int sum1(int...values)
	{
		int add=0;
		for (int i = 0; i < values.length; i++) {
			add+=values[i];
		}
		return add;
	}

}
