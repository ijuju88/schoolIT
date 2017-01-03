package com.util;

import java.util.Arrays;
import java.util.Random;

public class Randomtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random num=new Random();
		int No[]=new int[6]; //임의번호
		
		System.out.print("생성번호 : ");
		for (int i = 0; i < No.length; i++) {
			No[i]=num.nextInt(45)+1;
			System.out.print(No[i]+"\t");
		}
		System.out.println();
		
		num=new Random(6);
		int PrintNo[]=new int[6]; //당첨번호
		
		System.out.print("당첨번호 : ");
		for (int i = 0; i < PrintNo.length; i++) {
			PrintNo[i]=(int)(Math.random()*45)+1;
			System.out.print(PrintNo[i]+"\t");
		}
		System.out.println();

		Arrays.sort(No);
		Arrays.sort(PrintNo);
		boolean result=Arrays.equals(No, PrintNo);
		
		if(result){System.out.println("당첨!!");}
		else{System.out.println("당첨안됨 ㅠㅠ");}
	}

}
