package com.Arrage;

import java.util.Scanner;

public class ArrageMax {
	public static void main(String[] args) {
		
	int maxsub[]=new int[10];
	int max=0;
	
	for (int i = 0; i < 10; i++) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println((i+1)+"번째점수 : ");
		 maxsub[i]=sc.nextInt();
		 
		 if(maxsub[i]>max)
			max=maxsub[i];
		}
	System.out.println("가장큰수 : "+max);
		
	for (int i = 0; i < maxsub.length; i++) {
		int ra=1;
		for (int j = 0; j <maxsub.length ; j++) {
			if(maxsub[j]>maxsub[i])
				ra++;
			
		}System.out.print("rank : "+ra+"\t");
	}
	}
}


