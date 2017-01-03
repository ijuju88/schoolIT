package com.EnumTest;

import java.util.Scanner;

public class Test9 {

	@SuppressWarnings("null")
	public static void main(String[] args){
		boolean run=true;
		int stuvenNum=0; //학생수
		int[] scores=null;
		
		Scanner scanner= new Scanner(System.in);
		
		while(run){
			System.out.println("───────────────────────────────────────────");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4. 분석 | 5.종료");
			System.out.println("───────────────────────────────────────────");
			System.out.print("선택> ");
			
			int selectNo=scanner.nextInt();
			
			if(selectNo==1)
			{
				System.out.print("학생수>");
				stuvenNum=scanner.nextInt();
				scores=new int[stuvenNum];
				
				continue;
			}
			else if(selectNo==2)
			{
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores["+i+"]> ");
					scores[i]=scanner.nextInt();
					
				}
			}
			else if(selectNo==3)
			{
				for (int score : scores) {
					System.out.println(score);
				}
			}
			else if(selectNo==4)
			{
				int max=0, sum=0;
				float avg=0;
				for (int i = 0; i < scores.length; i++) {
					if (scores[i]>max) {
						max=scores[i];
					}
					sum+=scores[i];
					avg=(float)sum/scores.length;
				}
				System.out.println("최고점수 : "+max);
				System.out.println("평균점수 : "+avg);
			}
			else if(selectNo==5)
			{
				run=false;
			}
			
		}
		
		System.out.println("프로그램종료!");
		
		
	}
}
