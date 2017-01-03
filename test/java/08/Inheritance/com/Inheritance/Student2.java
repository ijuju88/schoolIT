package com.Inheritance;

import java.util.Scanner;

public class Student2 {
	String name; int age; Score score[]=new Score[3];
	public Student2(String name, int age){this.name=name; this.age=age;}
	
	public void setScore(){
		Scanner in=new Scanner(System.in);
		
		for (int i = 0; i < score.length; i++) {
			System.out.print("과목명>>");
			String subject=in.next();
			System.out.print("점수>>");
			int point=in.nextInt();
			score[i]=new Score(subject, point);
		}
		
	}
	
	public void display(){
		System.out.println("이름 : "+name+"\t");
		System.out.println("나이 : "+age+"\t");
		for (int i = 0; i < score.length; i++) {
			score[i].display();
		}System.out.println(" ");
	}
	
}


class Score{
	String subject;
	int point;
	
	public Score(String subject, int point){this.subject=subject; this.point=point;}
	
	public void display(){
		System.out.print(subject+" : ");
		System.out.println(point+"\t");
	}
}