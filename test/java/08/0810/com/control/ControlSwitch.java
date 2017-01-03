package com.control;

import java.util.Scanner;

public class ControlSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		
		/*System.out.println("두숫자로 연산을 합시당");
		System.out.println("숫자1 : ");
		int nu1=in.nextInt();
		
		System.out.println("숫자2 : ");
		int nu2=in.nextInt();
		
		System.out.println("연산자(+,-,/,*,%) : ");
		String op=in.next();
		
		
		switch (op) {
		case "+":
			System.out.println(nu1+nu2);
			break;
			
		case "-":
			System.out.println(nu1-nu2);
			break;
			
		case "*":
			System.out.println((float)nu1*nu2);
			break;
			
		case "/":
			System.out.println((float)nu1/nu2);
			break;

		default:
			System.out.println("연산자가 아니잖아 ㅠㅠ");
		}*/
		

		System.out.println("국어점수 : ");
		int num1=in.nextInt();
		
		switch(num1/10){
			case 10:
			case 9:
				System.out.println("A");
			break;
			
			case 8:
				System.out.println("B");
			break;
			
			case 7:
				System.out.println("C");
			break;
			
		default:
				System.out.println("F");
		}
		
	}

}
