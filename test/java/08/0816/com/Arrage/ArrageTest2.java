package com.Arrage;

public class ArrageTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//행렬 M1의 크기는 dim(M1)=[axb] 이고, 행렬 M2의 크기는dim( M2)=[cxd] 라고 할 때, 
		//‘b’와 ‘c’는 반드시 일치해야 합니다.

		int s1[][]={{1,2,3,4},{5,6,7,8}};
		int s2[][]={{1,2,3,4,5},
		{6,7,8,9,10},{11,12,13,14,15}};
		
		//앞 행렬의 첫 번째 행과 뒷 행렬의 첫 번째 열에 있는 수들을 각각 곱하고 이들을 더합니다. 
		//이 값을 결과값인 행렬의 (0,0) 위치에 넣게 됩니다.

		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s1[i].length; j++) {
				//int sum=s1[i]*s2[j];
				//System.out.println(sum+" ");
			}
		}
		
	
		/*int[][] array={{95,86},{83,82,96},{78,83,93,87,88}};
		
		System.out.println(array.length);
		System.out.println(array[2].length);
		
		
		int sum=0;
		double avg=0.0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				
				sum+=array[i][j];
				avg=sum/array[i].length;
				System.out.println("sum : "+sum);
				System.out.println("avg : "+avg);
			}
		}
		System.out.println("-----------------------------------");
		
		int min=100;
		int[] ar={1,5,3,8,2};
		
		for (int i = 0; i < ar.length; i++) {	
			if(ar[i]<min)
				min=ar[i];
		}System.out.println("min : "+min);*/
	}

}
