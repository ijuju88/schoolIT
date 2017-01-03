package com.Test6;

public class TestStudent {
	 public static void main(String[] args){
	 
	  Student[] stuednts=new Student[3];
	  
	  System.out.println("학번\t이름\t학과\t성적1\t성적2\t성적3\t총점\t평균");
	  
	  stuednts[0]=new Student(1, "홍길동", "영문", 80, 70, 80);
	  stuednts[1]=new Student(2, "박경미", "컴공", 70, 80, 75);
	  stuednts[2]=new Student(3, "하성호", "전컴", 80, 85, 90);
	  
	  
	  for (int i = 0; i < stuednts.length; i++) {
		  stuednts[i].SumSocres();
		  stuednts[i].AvgSocres();
		  stuednts[i].display();
	}
	  


	  
	 }
	}

