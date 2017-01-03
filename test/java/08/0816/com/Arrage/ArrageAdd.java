package com.Arrage;

import java.util.Scanner;

public class ArrageAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int[][]sub =new int[5][6];
	
	for (int i = 0; i < 5; i++) {
		Scanner sc= new Scanner(System.in);

	System.out.println((i+1)+"번째점수 : ");
	 sub[i][0]=i+1;
	 sub[i][1]=sc.nextInt();
	 sub[i][2]=sc.nextInt();
	 sub[i][3]=sc.nextInt();
	 
	for (int j = 1; j < 4; j++) {
		sub[i][4]+=sub[i][j];	
	}

	}	
	
	for (int i = 0; i < sub.length; i++) {
	
	int rank=1;
	for (int j = 0; j < sub.length; j++) {
	
		if(sub[j][4]>sub[i][4]){
		rank++;
		//System.out.print("rank : "+rank+" ");
	}sub[i][5]=rank;
	}
	}
	
	for (int i = 0; i < sub.length; i++) {
		for (int j = 0; j < 6; j++) {

			System.out.print(sub[i][j]+"\t");
		}System.out.println("");
	}
	
	}

}

