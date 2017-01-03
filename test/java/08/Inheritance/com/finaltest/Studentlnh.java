package com.finaltest;

import java.util.Scanner;

/*
필드 : 학번, 학과, 성적(score 배열로 작성)
생성자 : Student(){}
    Student(String name, int age, int sno, String major){...}
메소드 : setScore(){...} // 정적을 입력받과 학생별 총점과 평균 구함.
   display() // 학번, 이름, 나이, 학과, 성적1-3, 총점 평균, 등수를 출력

기타 :학생 전체의 등수와 과목별 최고점, 최저점수를 구하라. 
*/

public class Studentlnh extends Personlnh {
	public int sno=0;
    public String major;
    public int[] score = new int[6];
    public int sum = 0;
    
  
	public Studentlnh(){}
    
    public Studentlnh(int sno, String name, int age, String major){
        super(name, age);
        this.sno = sno;
        this.major = major;
    }


	public void setScore(int score1, int score2, int score3){
        this.score[0] = score1;
        this.score[1] = score2;
        this.score[2] = score3;
        for(int scores : score){
            sum += scores;
            score[3]=sum;
        }
        score[4]=sum/3;
        
        
        
        System.out.println("결과 : "+sno+" "+name+" "+age+" "+major+" "+score[0]+" "+score[1]+" "+score[2]+" "+score[3]+" "+score[4]);
    }
    
    public void display(){
     System.out.print(sno+"\t"+name+"\t"+age+"\t"+major+"\t");
     for (int i : score) {
    	 System.out.print(i);
    	 System.out.print("\t");
	}
    }
	
}

