package com.Test6;

public class Student {
	 
	 private int sno; //학번
	 private String name, dept; //이름과 학과
	 private int[] socres=new int[3]; //성적이 3개라서 배열크기를 3으로 설정
	 private double avg; //평균
	// private int rank; //등수(?)그런데 문제에서는 안쓰이는데 --;
	 private int sum=0; //합계
	 
	 Student(){} //default 생성자

	 //학번, 이름, 학과, 성적1~3(성적배열3개에 각각 설정) 생성자 
	 public Student(int sno, String name, String dept, int num1, int num2, int num3) 
	 {this.sno = sno;this.name = name;
	 this.dept = dept;
	 this.socres[0] = num1; 
	 this.socres[1] = num2;
	 this.socres[2] = num3;
	}
	 
	 //성적합계를 구하는 메소드
	 public int SumSocres() {
	  
	  for (int i = 0; i < socres.length; i++) {
	   sum+=socres[i];
	 }
	  return sum;

	 }
	 
	 //평균을 구하는 메소드
	 public double AvgSocres() {return avg=(double)sum/socres.length;}
	  

	 //출력 메소드
	 void display(){
	  
	  System.out.print(sno+"\t"+ name+"\t"+
	  dept);
	  for (int a = 0; a < socres.length; a++) {
	            System.out.print("\t " + socres[a]);
	        }
	  System.out.print("\t"+sum+"\t");
	  System.out.printf("%.2f",avg);
	  System.out.println("");
	    
	 }
	}
