package com.Control1;

public class ControlFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int esum=0, osum=0;
		
		/*for(int i=1; i<=100; i++){
			if(i%2==0)
			{
				esum+=i;
				//System.out.println("숫자"+i+"합 : "+esum);				
			}else
			{
				osum+=i;
				//System.out.println("숫자"+i+"합 : "+osum);
			}
		}*/
	
		/*for(int i=1 ,j=2; i<=100; i+=2, j+=2){
		
				esum+=j;
				osum+=i;
				
		}
		
		System.out.println("짝수합 : "+esum);
		System.out.println("홀수합 : "+osum);*/
		
		/*
		for(int i=0, j=100; i<=50 && j>=50; i++, j--)
			System.out.println("i값 : "+i+"	j값 : "+j);
		*/
		
		//charAt()-문자열을 배열로, length()-문자열의 길이
		/*String str="java1234pro",s1="", s2="";
		
		for(int i=0; i<str.length(); i++)
		{
			char ch=str.charAt(i);
			
			if(ch>='a' && ch<='z' || ch>='A' && ch<='Z')
				s1+=ch;
				
			else
				s2+=ch;
		}
			System.out.println(s1+", "+s2);
			
			
			*/
			System.out.println("------------------");
		
			
		//float카운터변수
			/*for(float x=0.1f; x<=1.0f; x+=0.1f)
				System.out.println(x);*/
			
		//삼각형
			for(int a=0; a<10; a++)
			{
				for(int a1=0; a1<=a; a1++)
				{
					System.out.print("*");
				}	
				System.out.println("");
			}
			
			/*for(int a=10; a>=1; a--)
			{
				for(int a1=1; a1<=a; a1++)
				{
					System.out.print("*");
				}	
				System.out.println("");
			}*/
			
			for(int a=0; a<10; a++)
			{
				for(int a1=0; a1<=9-a; a1++)
				{
					System.out.print("*");
				}	
				System.out.println("");
			}
	}
}
