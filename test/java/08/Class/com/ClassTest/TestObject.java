package com.ClassTest;

public class TestObject {
	
	//배열로 선언하기
	static int sum(int[] b){
		int result = 0;
		
		for (int bb : b) {
			result+=bb;
		}return result;
	}

	
	//배열로 안할시 선언하기
	static int sum2(int d1, int d2, int d3,int d4, int d5){
		int sum=0;
		sum=d1+d2+d3+d4+d5;
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		int[]a=new int[100];				 
		for (int i = 0; i < a.length; i++) {
			a[i]=i+1;
		}
		int result=sum(a);
		System.out.println(result);
		
		
		int c1=2, c2=2, c3=3, c4=4, c5=5;
		int result1=sum2(c1, c2, c3,c4,c5);
		System.out.println(result1);
	}
}



	
	