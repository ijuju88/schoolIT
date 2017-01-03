package com.finaltest;

import java.util.Scanner;

public class MainStu {
	public static Scanner in = new Scanner(System.in);
 public static void main(String[] args) {
	 
     boolean run = true;
     Scrlnh sl=new Scrlnh();
     
     while(run){
         System.out.println("────────────────────────────────────────────");
         System.out.println("1. 학생생성 | 2. 성적입력 | 3. 학생목록 출력 | 4. 종료");
         System.out.println("────────────────────────────────────────────");
         System.out.print("선택>> ");
         int selectNo = in.nextInt();
         
         switch(selectNo){
         case 1:
        	 sl.CreatStu();
            
             break;
         case 2:
        	 sl.ScoreStu();
         
             break;

         case 3:
        	 sl.ListStu(); 
        	
             break;
             
         case 4:
             run = false;
             break;
         default:
             System.out.println("번호를 잘못 입력하였습니다.");
             break;
         }
     }
     System.out.println("프로그램 종료");
 }

}


