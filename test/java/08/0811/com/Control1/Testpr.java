package com.Control1;

import java.util.Iterator;

public class Testpr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
		/*for (int i = 1; i <5; i++) {
			for(int j = 3; j>=i; j--)
				System.out.print(" ");
			for(int k = 1; k<=i*2-1; k++)
				System.out.print("*");
				System.out.println("");
	
		  }

		  for (int i = 5; i >=1; i--) {
				for(int j =4; j>=i-1; j--)
					System.out.print(" ");
				for(int k = 5; k<=i*2-1; k++)
					System.out.print("*");
					System.out.println("");
		
			  }*/
		int num=11, d=num/2+1;

		for (int i = 1; i <num+1; i++) {
			if(i>num/2+1){d++;}
			else {d--;}
			System.out.print(d);
			
		for(int k = 0; k<d; k++)
			System.out.print("@");
			for(int k = 0; k<num-d*2; k++)
			System.out.print("◆");
			for(int k = 0; k<d; k++)
				System.out.print("@");
			System.out.println();
		}
		
		
		//확인문제4 주사위수 합이 5면 끝
		/*while (true) {
		int a=(int)(1+Math.random()*6);
		int b=(int)(1+Math.random()*6);
	
			System.out.println(a+", "+b);
			if(a+b==5)
				break;		
		}*/
		

	}
}