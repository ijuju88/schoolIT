package com.Arrage;

public class Arrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//배열 선언하고 저장값 설정
		int[] arrint; 
		arrint=new int[10]; 
		//=>int[] arrint= new int[10]; 
		
		arrint[0]=10; //인덱스0번값 넣기
		
		
		for(int i=0; i<10; i++)
		{
			arrint[i]=10+10*i;
			System.out.println(arrint[i]);

		}
		
		
		//배열 선언과동시 값설정
		int arr2[]={1,2,3,4,5}; 
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i]);
		
		
		//합체 
		int arr3[]=new int[]{1,2,3,4,5};
	
				
	}
}
