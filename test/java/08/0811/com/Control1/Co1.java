package com.Control1;

import java.util.Scanner;

public class Co1 {
	public static void main(String args[]){
		
		Scanner in=new Scanner(System.in);	
		
		//1.평균점수
			
		/*
		System.out.println("점수1 : ");
		int num1=in.nextInt();
		
		System.out.println("점수2 : ");
		int num2=in.nextInt();
		
		int su=num1+num2;
		float av=num1+num2/2.0f;
		
		System.out.println("당신의 합계는"+su+"입니당 ><");
		System.out.println("당신의 평균은"+av+"입니당 ><");*/
			
		
		//2.kg(소수)->파운드 (0.453592)
		
		/*System.out.println("kg을 적으삼(소수입력해도됨) : ");*/
		
		//3.영문자입력(소<->대)
		
		/*System.out.println("--대<->소문자 변환기--");
		System.out.println("영어알파벳1개입력 : ");
		String ap=in.nextLine();
		char c=ap.charAt(0); //문자열배열요소
		
		if(c>='a' && c<='z'){
			c=(char)(c-32);
			System.out.println(c);
			}
		else if(c>='A' && c<='Z'){
			c=(char)(c+32);
			System.out.println(c);
			}
		else
			System.out.println("...");*/
		
		/*//4.윤년 (년도%4=0 and %400 100% 평년)
		
		System.out.println("윤년??(몇년도임?) : ");
		int un=in.nextInt();
		
		if(un%4==0 && un%100!=0 || un%400==0)
			System.out.println(un+"년 : 윤년");
		else
			System.out.println(un+"년 : 평년");*/
		
		//5.숫자를 단위(일십백천만 ㅋㅋ)
		
		/*System.out.println("얼마임?(천만이하숫자입력) : ");
		int mon=in.nextInt();
	
		System.out.print(mon/10000+"만");
		mon=mon%10000;
		if(mon/1000!=0){
			System.out.print(mon/1000+"천");
			mon%=1000;
		}
		else 
			System.out.print("");
		
		if(mon/100!=0){
		System.out.print(mon/100+"백");
		mon%=100;
		}
		else 
			System.out.print("");
		
		if(mon/10!=0){
		System.out.print(mon/10+"십");
		mon%=10;
		}
		else 
			System.out.print("");
		
		System.out.println(mon);*/

		
		//6.분기
		
		/*System.out.println("월을 입력하세용(몇분기일까용?숫자로입력) : ");
		int s=in.nextInt();
		
		if(s>=1 && s<=3)
		System.out.println("1분기");
		
		else if(s>=4 && s<=6)
			System.out.println("2분기");
		
		else if(s>=7 && s<=9)
			System.out.println("3분기");
		
		else if(s>=10&& s<=12)
			System.out.println("4분기");
		
		else
			System.out.println("......");
		*/
		
		//7.체중 비만도 ㅠㅠ
		
		/*System.out.println("키?? : ");
		int t=in.nextInt();
		
		System.out.println("몸무게 : ");
		float m=in.nextFloat();
		
		float p=(t-100)*0.9f;
		
		if(m<=p)
			System.out.println("정상");
		else
			System.out.println("비만");*/
		
		//8.화폐개수~~
		System.out.println("---------화폐개수---------");
		System.out.println("돈이 얼마있음 ㅠㅠ : ");
		int mo=in.nextInt();
	
		System.out.println("5만원권"+mo/50000+"개");
			mo=mo%50000;
		
		if(mo/10000!=0){
			System.out.println("1만원권"+mo/10000+"개");
			mo%=10000;
		}
		else 
			System.out.print("");
		
		
		if(mo/5000!=0){
			System.out.println("5천원권"+mo/5000+"개");
			mo%=5000;
		}
		else 
			System.out.print("");
		
		if(mo/1000!=0){
			System.out.println("1천원권"+mo/1000+"개");
			mo%=1000;
		}
		else  
			System.out.print("");
		
			System.out.println("나머지돈"+mo+"원");
		
	}
}
