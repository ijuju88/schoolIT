package com.finaltest;

import java.util.Scanner;

public class Scrlnh {
	public static Scanner in = new Scanner(System.in);
	public static Studentlnh[] stu = new Studentlnh[100];
	public static int index = 0;
	
void CreatStu(){
	 System.out.print("학번>> ");
     int sno = in.nextInt();
     System.out.print("이름>> ");
     String name = in.next();
     System.out.print("나이>> ");
     int age = in.nextInt();
     System.out.print("전공>> ");
     String major = in.next();
     stu[index++] = new Studentlnh(sno, name, age, major);
     System.out.println("결과 : 학생이 생성되었습니다.");
     
}


void ListStu(){
	 int min[]={100,100,100};
	 int max[]={0,0,0};
     System.out.println("학번\t이름\t나이\t전공\t성적1\t성적2\t성적3\t총점\t평균\t등수");
     for (int i = 0; i < index; i++) {
    	 int rank=1;
		for (int j = 0; j < index; j++) {
			if(stu[i].score[3]<stu[j].score[3]){rank++;}
		}stu[i].score[5]=rank;
	}

     for (int i = 0; i < index; i++) {
		for (int j = 0; j < 3; j++) {
			if(min[j]>stu[i].score[j])
			{min[j]=stu[i].score[j];}
			if(stu[i].score[j]>max[j])
			{max[j]=stu[i].score[j];}
		}
	}
     
     
    for (int i = 0; i < index; i++) {
        		 stu[i].display();
        		 System.out.println("");
         	}
    
    System.out.println("최저점수");
    for (int i = 0; i < 3; i++) {
    	
    	System.out.print(min[i]+"\t");
	}
    System.out.println("");
    
    System.out.println("최고점수");
    for (int i = 0; i < 3; i++) {
    	System.out.print(max[i]+"\t");
	}
    System.out.println("");
    
}


void ScoreStu(){
    System.out.print("학번>> ");
    int SNo = in.nextInt();


    System.out.print("성적1>> ");
    int score1 = in.nextInt();
    System.out.print("성적2>> ");
    int score2 = in.nextInt();
    System.out.print("성적3>> ");
    int score3 = in.nextInt();
    for(Studentlnh s : stu){
       if(s.sno == SNo){
            s.setScore(score1, score2, score3);
            break;
        }
    }
}



}
