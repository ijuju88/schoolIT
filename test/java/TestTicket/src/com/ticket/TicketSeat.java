package com.ticket;

//좌석에 관한 클래스

//좌석설정 및 보여주기
public class TicketSeat {

 protected String SSeat[] = {"---", "---", "---",  "---",   "---", "---",  "---",  "---",  "---", "---"};
 protected  String ASeat[] = {"---", "---", "---",  "---",   "---", "---",  "---",  "---",  "---", "---"};
 protected  String BSeat[] = {"---", "---", "---",  "---",   "---", "---",  "---",  "---",  "---", "---"};


 protected void setTicketSSeat() {
   System.out.print("S>> ");

    for(String ss : SSeat){
     System.out.print(ss+" ");    
    }
    System.out.println("");

  }
  

 protected void setTicketASeat() {
   System.out.print("A>> ");

    for(String as : ASeat){
     System.out.print(as+" ");    
    }
    System.out.println("");
  
 }

 protected void setTicketBSeat() {
   System.out.print("b>> ");

    for(String bs : BSeat){
     System.out.print(bs+" ");    
    }
    System.out.println("");
 }
 
}
