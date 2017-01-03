package com.time;

import java.time.*;

public class timetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate now=LocalDate.now();
		LocalDate targetDate=LocalDate.of(2015, 12, 23);
		
		int year=now.getYear();
		int month=now.getMonthValue();
		int day=now.getDayOfMonth();
		int yday=now.getDayOfYear();
		
		System.out.println(year+"년"+month+"월"+day+"일"+yday+"일");
		System.out.println(now.getDayOfWeek()); //요일
		System.out.println(now.isLeapYear()); //윤년?
		
		//시간
		LocalTime time=LocalTime.now();
		LocalTime sargetTime=LocalTime.of(12, 50);
		
		System.out.print(time.getHour()+":");
		System.out.print(time.getMinute()+":");
		System.out.print(time.getSecond()+":");
		System.out.println(time.getNano());
	}

}
