package com.ControlTest;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//
		
	/*	int num=1, count=0;
		for(;num<=100;num++){
			if(num%2==0 || num%3==0 || num%5==0 || num%7==0)
			{
				continue;
			}
			else if(count==10){
				System.out.println("");
				count=0;
			}
			System.out.print(num+"\t");	
			count++;
		}*/
		
		//1~100 난수
	/*	int c=0;
		int s=0;
		
		
		for(;c<=10; c++){
			int n=(int)(Math.random()*100)+1;
			System.out.println(n);
			s+=n;
		}
		System.out.println(s);
		float avg=s/10f;
		
		System.out.printf("%.2f \n",avg);*/
		
		
		//3.자리수 반대
		/*int b=0, co=0;
		Scanner in=new Scanner(System.in);
		System.out.println("입력하삼 : ");
		int a=in.nextInt();
		
		do {
			b=a%10;
			System.out.printf("%d", b);
			a=a/10;
	
		} while (a!=0);
		System.out.println();
*/
		
		//1~10년까지 매년말마다 받을금액
		/*Scanner in=new Scanner(System.in);
		System.out.println("예치금 : ");
		
		int m=in.nextInt();
		int s=1;
		double sint=m*0.045f*1;
		double sm=m*(1+0.045f*s);
		
		for(s=1;s<=10; s++)
		{
			System.out.println(sint*s);
		}
		sm=m*(1+0.045f*s);
		System.out.println(sm);*/

	
	//1~n의 합중 5000안넘는 가장 큰합과 n의 값
	/*	Scanner in=new Scanner(System.in);
		System.out.println("숫자입력 : ");
		int num=in.nextInt();
		int sum = 1;
		
		
		for(int a=1; a<=num; a++)
		{
			if(sum<=5000)
				System.out.println(a+", "+sum);
			sum+=a;
				
		}
		*/
	
	//1~100 소수	
		/*boolean t = false;
		int cou=0;
		
		for(int a=2;a<=100; a++)
		{
			for(int c=2; c<a; c++){
			t=false;
			if(a%c==0){
				t=true;
				break;
			}
			}
			
			if(t==false){
			System.out.print(a+" ");
			cou++;
	
			if(cou==10){
				System.out.println();
				cou=0;
			}
			}
		}*/
		
	//역삼각형 
		
		/*Scanner in=new Scanner(System.in);
		System.out.println("입력(소문자) : ");
		String ap=in.nextLine();
		char c=ap.charAt(0); //문자열배열요소
		int num=0;*/
		
		/*if(c>='a' && c<='z'){
			num=(char)(c-96);
			//System.out.println(num);
			}
		
		for(int a=0; a<num; a++)
		{
			for(int a1=0; a1<num-a; a1++)
			{
				System.out.print((char)(a1+97));
			}	
			System.out.println("");
		}*/
		
		
		/*if(c>='a' && c<='z'){
			num=(char)(c-96);
			//System.out.println(num);
			}
		
		for(int a=num; a>=1; a--)
		{
			for(int a1=0; a1<a; a1++)
			{
				System.out.print((char)(a1+97));
			}	
			System.out.println("");
		}*/
		
		/*for(char ci='a'; ci<=c; ci++){
			for(char cj='a'; cj<=ci; cj++)
				System.out.print(cj);
			System.out.println("");
		}
		
		for(char ci=c; ci>='a'; ci--){
			for(char cj='a'; cj<=ci; cj++)
				System.out.print(cj);
			System.out.println("");
		}*/

		//삼각형만들기
/*
		for(int out1=1; out1<=7; out1++){
			for(int out2=-7; out2<=7; out2++)
		
				if(Math.abs(out2)>=out1)
				System.out.print(" ");
			else
				System.out.print(Math.abs(out2));
			System.out.println("");
		
		}	
		*/

		
	//최대공약수
		/*Scanner in=new Scanner(System.in);
		System.out.println("숫자입력1 : ");
		int num1=in.nextInt();
		System.out.println("숫자입력2 : ");
		int num2=in.nextInt();
		int pr=0;
		
		for(int i=1;i<=num1;i++)
		{
			if(num1%i==0 && num2%i==0)
			{
				System.out.print(i+" ");
				System.out.println();
				pr=i;
			}

		}
		System.out.print("최대공약수는 : "+pr);*/
		
			
		//난수+3,6,9  짝
		
		int count=0;
			
		for(int c=0;c<=99; c++){
			c=(int)(Math.random()*99)+1;
			//System.out.println(n);
		
			 
			 if(c/10 == 3 || c/10 == 6 || c/10 == 9) {
				 count++;
			 }
                 if(c%10 == 3 || c%10 == 6 || c%10 == 9){
		            count++;
		        }
		      
		      
			 if(count==2){
		        	System.out.println(c+"짝짝");
		        count=0;
		    }
		        else if(count==1)
		        {
		        	System.out.println(c+"짝");
		        	count=0;
		        }else
		        	System.out.println(c);
		}	
	}		

}


