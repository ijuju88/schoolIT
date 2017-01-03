package com.test;

import java.io.*;

public class MoneyNum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		  BufferedReader in = new BufferedReader(new InputStreamReader(System.in ));
		  int []money={50000,10000,5000,1000,500,100,50,10,5,1};
		  int co=0;//금액 입력할곳
		  int num=0;//금액넣을곳
		  
		  System.out.println("금액을 입력하거라 돈나눠줄게!");
		  System.out.print("금액 : ");
		  co=Integer.parseInt(in.readLine());//금액입력
		    
		      for (int i = 0; i < money.length; i++)
		      {
		       
		       num=co/money[i];//입력한거에서 배열0번부터 한걸나눈거를 출력할 num에 넣음 
		       co = co-num*money[i]; //입력할금액을 출력할금액*배열각각 에 빼고 남은금액을 입력할금액에 넣기
		       System.out.println(money[i]+"원 : "+num+"개");//배열당 개수출력
		      }
		 
		 }
		}
