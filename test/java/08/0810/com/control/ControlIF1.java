package com.control;

import java.util.Scanner;

public class ControlIF1 {
	
	public static void main(String[] args){
		
		Scanner in= new Scanner(System.in);
		
		/*System.out.println("5의 배수인지 판별할까용?? 숫자를 적으세용 : ");
		int fi=in.nextInt();
		
		if(0==fi%5)
			System.out.println("5의 배수임");
		else
			System.out.println("....");*/
		
		
		System.out.println("점수1입력 : ");
		int n1=in.nextInt();
		
		System.out.println("점수2입력 : ");
		int n2=in.nextInt();
		
		/*
		 //두점수가 다 60점 이상일때
		 
		 if(n1<60 || n2<60)
			System.out.println(n1+", "+n2+"....");
		else
			System.out.println(n1+", "+n2+" - 결과 : 와잘했구만");
			
			//System.out.println(n1>=60 && n2>=60 ? "잘함" : "....");	
			 
		*/
		
		//학점 if ~ else if ~ else
		/*float avg= (float)n1+n2/2;
		
		System.out.println("점수1 : "+n1+", 점수2 : "+n2+"  평균 : "+avg);
		
		if(avg>=90)
			System.out.println("A");
		else if(avg>=80)
			System.out.println("B");
		else if(avg>=70)
			System.out.println("C");
		else
			System.out.println("F ㅜㅜ");*/
		
		//ㅋㅋ 중첩
		
		if(n1>=70){
				if(n1>=90)
					System.out.println("A");
				else if(n1>=80)
					System.out.println("B");
				else
					System.out.println("c");
		}
		else 
			System.out.println("F");
		
		/*//연산자
		
		System.out.println("두숫자로 연산을 합시당");
		System.out.println("숫자1 : ");
		int nu1=in.nextInt();
		
		System.out.println("숫자2 : ");
		int nu2=in.nextInt();
		
		System.out.println("연산자(+,-,/,*,%) : ");
		String op=in.next();

		System.out.print(nu1+op+nu2+"결과는 : ");
		
		if(op.equals("+"))
			System.out.println(nu1+nu2);
		else if(op.equals("-"))
			System.out.println(nu1-nu2);
		else if(op.equals("*"))
			System.out.println(nu1*nu2);
		else if(op.equals("/"))
			System.out.println((float)nu1/nu2);
		else if(op.equals("%"))
			System.out.println((float)nu1%nu2);
		else
			System.out.println("연산자가 아니잖아 ㅠㅠ");*/
		
	}
}
