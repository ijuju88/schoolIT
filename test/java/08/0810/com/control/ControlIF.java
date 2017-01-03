package com.control;

import java.util.Scanner;

public class ControlIF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner in= new Scanner(System.in);
		
		System.out.print("숫자적으삼 : ");
		int num=in.nextInt();
		
		if(num>0)
			System.out.println(num+"양수임여~~");
		else 
			System.out.println(num+"음수임여~");
		
	}

}
