package com.test;

import java.util.Calendar;
import java.util.Scanner;
 
public class ECal {
 
 public static void main(String[] args) {
  cal Ca=new cal();
  Ca.disp();
 }} 
  
class cal{
 int year, month, week, laweek, i;
 
public cal(){  
  Calendar cal = Calendar.getInstance();//static메서드로 불러오기
  
  Scanner scan=new Scanner(System.in);//다른책에서 다른방법으로 치는게 나와서 그거해본거임
  
  System.out.println("년도를 치세요");
  year=scan.nextInt();
  System.out.println("몇월인가요?");
  month=scan.nextInt();
 
  cal.set(Calendar.YEAR, year);//년도
  cal.set(Calendar.MONTH,month-1);//월(근데 이거 왜 -1해야 나오는거지?)
  cal.set(Calendar.DAY_OF_MONTH , 1);
  /*DAY_OF_MONTH 
   공공 정적 최종 INT의 DAY_OF_MONTH 
   에 대한 필드 번호 get 및 set 달의 날을 나타냅니다.  
   이 동의어입니다 DATE.달의 첫째 날에는, 값 1이 사용됩니다. */
  
  week=cal.get(Calendar.DAY_OF_WEEK);//1:일요일~7:토요일
  laweek=cal.getActualMaximum(Calendar.DATE);//일수 최대수로 리턴
}
  public void disp(){
  i=0;
 System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦"+year+"년"+month+"월▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
  System.out.println("일\t월\t화\t수\t목\t금\t토");
  System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
  for(i=0; i<week-1; i++){//요일시작하는 곳 바로 전까지 탭으로 채우기
   System.out.print("\t");}
  for(int day=1; day<=laweek; day++, i++){//1일부터 일수까지 출력해보기
  {if(i%7==0)System.out.println("");}
  System.out.print(day+"\t");
  }}}