package com.lang;

public class Mathtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.abs(-10));
		System.out.println(Math.floor(3.2));
		System.out.println(Math.round(5.3)); //반올림
		System.out.println(Math.ceil(10.2)); //올림
		System.out.println(Math.max(3,2));
		System.out.println(Math.min(3,2));
		
		System.out.println(Math.random());//그냥하면 0~1사이실수가--;
		//그래서 +1을 합니다 밑에는 1~10
		System.out.println((int)(Math.random()*10)+1);
		
		System.out.println(Math.rint(10.2)); //가장가까운 정수
		
		System.out.printf("%.2f ",10.1); //소수점2자리까지 출력 - 10.10
		System.out.printf("%d ",10); //정수 - 10
		System.out.printf("%c ",65); //아스키코드 65=>A입니다 
		System.out.printf("%o ",65);//8진수
		System.out.printf("%h ",10);//16진수 
		System.out.printf("%s\n ","A123");//문자열(잘안쓰는방법입니다) 
		
		System.out.printf("%1$d,%1$d,%2$o",10,10,10);
	}

}
