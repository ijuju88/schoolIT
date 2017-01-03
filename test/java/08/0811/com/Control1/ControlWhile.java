package com.Control1;

import java.util.Scanner;

public class ControlWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int i=1, s=0;
		
		while(i<=10)
		{
			s+=i;
			i++;
		}
		
		System.out.println(s);*/
		
		/*Scanner in=new Scanner(System.in);
		
		String str="";
		while(!str.equals("q")){
			str=in.next();
			char ch=str.charAt(0);
			
			if(ch>='a' && ch<='z'){
				ch=(char)(ch-32);
				System.out.println("대문자로 변환 : "+ch);
			}
			
		}
		*/
		
		/*int i=11, s=0;
		 do{
			 	s+=i;
			 	i++;
		 }
			while(i<=10);
				System.out.println(s);
			*/
	
			/*Scanner in=new Scanner(System.in);
			String ap="";
			do{	
				System.out.println("--대<->소문자 변환기--");
				System.out.println("영어알파벳1개입력 : ");
				ap=in.nextLine();
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
					System.out.println("...");	
			
			}while(!ap.equals("qq"));*/
			
			
			/*int i=1, s=0;
		
			while(i<=100)
			{
				if(s>2000)break;
				
				s+=i;
				System.out.println(i+", "+s);
				i++;
			}
			System.out.println(s);*/
		
			int sum=0;
		
			for (int i = 0; i <=100 ; i++) {
				if(i%3==0)continue;
				sum+=i;
				System.out.println(i+", "+sum);
				
			}System.out.println(sum);
	}

}
