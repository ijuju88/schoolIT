package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class  jumin{
 int year = 0, month = 0, day = 0, area = 0, sex = 0;
    String jumin = "";
    char[] ju = new char[12];
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
    public void Year() throws NumberFormatException, IOException{
     
     do {
          System.out.print("태어난 연도 = ");
          year = Integer.parseInt(in.readLine());
         }while(year < 1800 || year > 2099);
         do {
          System.out.print("태어난 월 = ");
          month = Integer.parseInt(in.readLine());
         }while(month < 1 || month > 12);
         do {
          System.out.print("태어난 일 = ");
          day = Integer.parseInt(in.readLine());
         }while(day < 1 || day > 31);//날짜는 정확히 비교 하지 않았음.
    }
    
    public void setHo() throws NumberFormatException, IOException{
     do {
          System.out.println("0:서울"); 
          System.out.println("1:경기, 인천");
          System.out.println("2:부산");
          System.out.println("3:강원도");
          System.out.println("4:충청도");
          System.out.println("5:전라도");
          System.out.println("6:대구, 광주");
          System.out.println("7:경북, 경남");
          System.out.println("8:경남");
          System.out.println("9:제주도");
          System.out.print("태어난 지역(0~9)=");
          area = Integer.parseInt(in.readLine());
         }while(area < 0 || area > 9);
    }
    
    public void setSex() throws NumberFormatException, IOException{
    do {
          System.out.print("성별(0:남성, 1:여성) = ");
          sex = Integer.parseInt(in.readLine());
         }while(sex != 0 && sex != 1);
      
         switch((int)(year / 100)) {
         case 18: jumin += sex == 0 ? "9" : "0"; break;
         case 19: jumin += sex == 0 ? "1" : "2"; break;
         case 20: jumin += sex == 0 ? "3" : "4"; 
         }
    }
    
    public void setpin(){
    jumin = "" + (year - (int)(year / 100) * 100);
         if(month < 10) jumin += "0";
         jumin += month;
         if(day < 10) jumin += "0";
         jumin += day;
         jumin += "-";
         
         jumin += area;
         jumin += "0000";
         
         for(int i = 0; i < ju.length; ++i) {
          ju[i] = jumin.charAt(i);
         }
         
         int hap = 0;
         float temp = 0.0f;
         float temp1 = 0.0f;
         int cre = 2;
         for(int i = 0; i < ju.length; ++i) {
          hap += ju[i] * cre++;
          if(cre == 10) cre = 2;
         }
         temp = (int)(hap / 10.0f) * 10.0f + 10.0f - hap;
         temp1 = temp - (int)(temp / 10.0f) * 10.0f;
         jumin += (int)temp1;
    }
    public void disp1(){
     System.out.println("===================");
     System.out.println("생성된 주민번호 = " + jumin);
     System.out.println("===================");
     }
    
}
 
 class Sunjl{
     int kor, eng, mat, tot, ha, ha1;
     float avg;
     
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  public void setin() throws NumberFormatException, IOException{
   System.out.print("국어 = ");
   kor = Integer.parseInt(in.readLine());
   System.out.print("영어 = ");
   eng = Integer.parseInt(in.readLine());
   System.out.print("수학 = ");
   mat = Integer.parseInt(in.readLine());
  }
  public void setSn(){
   tot = kor + eng + mat;
   avg = (tot / 3);
   ha1 = 1;
   int x = (int) (avg / 10);
   switch (x) {
   case 10:
   case 9:
      ha = 'A';
      break;
   case 8:
      ha = 'B';
      break;
   case 7:
      ha = 'C';
      break;
   case 6:
      ha = 'D';
      break;
   default:
      ha = 'F';
     }
    }
 
    public void disp2() {
     System.out.println("===================");
     System.out.println("총점 = " + tot+"점");
     System.out.println("평균 = " + avg+"점");
     System.out.println("학점 = " + ha + "학점");
     System.out.println("석차 = " + ha1 + "등");
     System.out.println("===================");
 } 
}
 class test1{
 
 public static void main(String[] args) throws NumberFormatException, IOException {
  jumin a=new jumin();
  a.Year();
  a.setHo();
  a.setSex();
  a.setpin();
  a.disp1();
  
  Sunjl b=new Sunjl();
  b.setin();
  b.setSn();
  b.disp2();
 
 }
 
}