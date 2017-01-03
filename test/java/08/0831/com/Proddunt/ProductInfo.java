package com.Proddunt;

import java.util.Scanner;

public class ProductInfo {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		PrList pl=new PrList();
	     while(run){
	         System.out.println("────────────────────────────────────────────");
	         System.out.println("1 상품추가 | 2 상품조회 | 3 모든 상품조회 | 4 끝내기");
	         System.out.println("────────────────────────────────────────────");
	         System.out.print("선택>> ");
	         int selectNo = sc.nextInt();  
	         
	         switch(selectNo){
	         case 1:
	         Book bo=new Book();
	         CompackDisc cd=new CompackDisc();
	         ConversationNBook cb=new ConversationNBook();
	        	 System.out.print("상품의 종류선택 : 1 책 | 2 앨범 | 3 회화책 >>");
	        	 int PrNo=sc.nextInt();
	        	 if(PrNo==1){bo.Scr();}
	        	 if(PrNo==2){cd.Scr();}	
	        	 if(PrNo==3){cb.Scr();}
	             break;
	         case 2:
	        	 
	         
	             break;

	         case 3:
	        	 pl.AllList();
	         
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


class PrList{
	Proddunt[] Pr = new Proddunt[10];
	
	void AllList(){
		for (int i = 0; i < Pr.length; i++) {
	           Pr[i].display();
	           System.out.println("");
	          }
	}
}


