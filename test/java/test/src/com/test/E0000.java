package com.test;

import java.io.*;
 
 
public class E0000 {
 
 
 public static boolean[] TFT(int p, int a){
  
  boolean list[]=new boolean[p];
  
  for(int i=0; i<a; i++){
   int co=(int)(Math.random()*p);
  
  while(list[co]==true){
   co=(int)(Math.random()*a);
  }
  list[co]=true;
 }
  return list;
 }
 
public static void main(String[] args) throws NumberFormatException, IOException {
 BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("==여기는 복불복 현장==");
 System.out.println("할사람의 개수를 입력하세요(최대10명) : ");
 int a1=Integer.parseInt(in.readLine());
 System.out.println("걸릴사람 개수를 입력하세요(사람수보다 작게) : ");
 int a2=Integer.parseInt(in.readLine());
 
 
 boolean list[]= TFT(a1,a2);
 for(int i=0; i<list.length; i++)
 {
  System.out.println((i+1)+"번째 : "+list[i]);
 }
 }
 
}
 