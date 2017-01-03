package com.ControlTest;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args){
		//스위치변수
		/*int sum=0, n=1, sw=1;
		
	
				for( ;n<100;n++){
					sw=-sw;
					sum=sum+sw*n;
					//System.out.println(sum);
				}
				System.out.println(sum);
				*/
				
		//1~100 자연수
	
/*
		    int sum=0;
		    int n=1;
		    do{
		        sum=sum+n;
		        n++;
		    }while(n<=100);
		    System.out.println(sum);
		
		 */
		//1~100사이의 4개의 자연수 입력
		Scanner in=new Scanner(System.in);
		
		int a=in.nextInt();
		int b=in.nextInt();
		
		
		System.out.print((a/b));
		System.out.print((a%b));
 	}	
}
