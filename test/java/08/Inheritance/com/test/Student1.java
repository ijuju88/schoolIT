package com.test;

import java.util.Scanner;

public class Student1 extends Person1 {
	String sh,depa;
	int dept;
	Scanner sc=new Scanner(System.in);
	float[] score=new float[8]; 
	
	public Student1
	(String name, int age, String iv,String sh,String depa,int dept)
	{super(name, age, iv); this.sh=sh; this.depa=depa; this.dept=dept;}
	
	public void average(){
		System.out.println("─────────────────────────────");
		System.out.println("8학기 학점을 순서대로 입력하세요");
		float sum=0, avg=0;
		for (int i = 0; i < 8; i++) {
			System.out.print((i+1)+"학기 학점 -> ");
			score[i]=sc.nextFloat();
			sum+=score[i];
			
		}	
		avg=sum/score.length;
		System.out.println("─────────────────────────────");
		System.out.println("8학기 총 평균 평점은 "+avg+"점 입니다.");
	}
	
	public void Studisplay(){
		super.display();
		System.out.println("학교 : "+sh);
		System.out.println("학과 : "+depa);
		System.out.println("학번 : "+dept);
	}


}
