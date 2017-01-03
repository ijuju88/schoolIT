package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Calendartest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Calendar ca=Calendar.getInstance();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year=ca.get(Calendar.YEAR);
		int month=ca.get((Calendar.MONTH)+1); //0부터이기때문에 +1을합니다
		//int day=ca.get(Calendar.DAY_OF_MONTH);
	
		int week=ca.get(Calendar.DAY_OF_WEEK);
		int lastday=ca.getActualMaximum(Calendar.DATE) ;
		
		System.out.print("년도?");
	    year=Integer.parseInt(br.readLine());
	    System.out.print("월?");
	    month=Integer.parseInt(br.readLine());
	    
	    ca.set(year, (month)-1, 1);
	    
	    for (int i = 1; i < week; i++) {
			System.out.print("\t");
		}
	    
	    for (int i = 1; i <= lastday; i++) {
	    	System.out.print(i+"\t");
	    	week++;
	    	
			if (week%7==1) {
				System.out.println();
			}
		}System.out.println();
	}

}
