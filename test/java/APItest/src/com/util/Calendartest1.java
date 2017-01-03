package com.util;
import java.io.*; //java.io 하위클래스를 전부불려오게 하려고 *
import java.util.Calendar;
 
public class Calendartest1 {

    /*
BufferedReader와 System.in.read등의
입,출력에 관련해서는 IOException를 발생시킵니다
*/
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
       System.out.print("년도 : ");
        int year=Integer.parseInt(bf.readLine());
        System.out.print(" 월 : ");
        int month=Integer.parseInt(bf.readLine());
		/*
		 String year = "", month="";
		args[0]=year;
		args[1]=month;
        */
        
        Calendar ca=Calendar.getInstance(); //객체생성시 new를 사용하지 않습니다. 인스턴스로합니다.
    
       //Calendar에 년, 월, 일을 셋팅합니다
 ca.set(year, month, 1); //월을 입력한값에 -1을하여 month를 맞춥시다
        
        int day=ca.get(ca.DAY_OF_WEEK); //해당월 시작요일
        int lastday=ca.getActualMaximum(ca.DATE);  //해당월에 마지막날짜
        
        
        
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        
        //1일전을 공백으로
        for (int i = 1; i < day; i++) {
            System.out.print("\t");
        }
        
        for (int i = 1; i <= lastday; i++) {
            System.out.print(i+"\t");
            day++;
            
//토요일까지 가면 개행
            if (day%7==1) {System.out.println("");}
        }
	}

}
