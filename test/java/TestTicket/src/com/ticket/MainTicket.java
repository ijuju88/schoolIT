package com.ticket;

import java.util.Scanner;

//main 함수입니당 - 주메뉴만 구현하고 나머지는 다른클래스에 구현하였습니다.
public class MainTicket {
 private static TickMenu tm = new TickMenu();

 private static Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
  boolean run = true;
  while (run) {
   System.out.println("─────────────────────────────────");
   System.out.println("예약(1), 조회(2), 취소(3), 끝내기(4)");
   System.out.println("─────────────────────────────────");
   System.out.print("타입 선택>> ");
   int SNo = sc.nextInt();

   switch (SNo) {
   case 1:
    tm.ReTicket();
    break;
   case 2:
    tm.ListTicket();
    break;
   case 3:
    tm.delTicket();
    break;
   case 4:
    run = false;
    break;

   default:

    System.out.println("번호를 잘못 선택하였습니다.");

   }

  }

 }

}
