package com.control;

import java.util.Scanner;

public class ControlIF2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		Scanner in=new Scanner(System.in);
		System.out.println("숫자를 비교합니당");
		System.out.println("첫번째숫자 : ");
		int a1=in.nextInt();
		System.out.println("두번째숫자 : ");
		int a2=in.nextInt();
		System.out.println("세번째숫자 : ");
		int a3=in.nextInt();

		if(a1<a2 || a1<a3)
			if(a2<a3)
				System.out.println(a3+"큼");
			else
				System.out.println(a2+"큼");
		else 
			System.out.println(a1+"큼");
		
	/*	if(a1>a2){
			if(a1>a3)
				System.out.println(a1+"큼");
			else
				System.out.println(a3+"큼");
		}
			else{
				System.out.println(a2+"큼");
				if(a2<a3)
					System.out.println(a3+"큼");
			}*/
	}

}
