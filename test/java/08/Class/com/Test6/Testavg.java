package com.Test6;

public class Testavg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		double avg=0;
	
		int arr1[][]=
		{{78,48,78,98},{99,92},{29,64,83},{34,78,92,56}};
	
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print((i+1)+"번행"+ " "+(j+1)+"째점수 "+arr1[i][j]+" " );
				sum+=arr1[i][j];
				avg=(double)sum/arr1[i].length;
			}
			
			System.out.print(sum);
			System.out.printf(" %.2f", +avg);
			System.out.println("");
		}
	}

}

