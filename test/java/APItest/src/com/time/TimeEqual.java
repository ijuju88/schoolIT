package com.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDateTime startDateTime=LocalDateTime.now();
		LocalDateTime lastDateTime=LocalDateTime.of(2016, 2, 22, 12, 40,40);
		
		//비교하기
		
		// startDateTime이 endDateTime 보다 이전 날짜 인지 비교
		boolean Dateequal=startDateTime.isBefore(lastDateTime);
		System.out.println(Dateequal);
		
		// startTime이 endTime 보다 이후 시간 인지 비교
		boolean Datetime=startDateTime.isAfter(lastDateTime);
		System.out.println(Datetime);
		
		
		//예제
		if(startDateTime.isBefore(lastDateTime))
		{System.out.println("진행중~~");}
		else if(startDateTime.isEqual(lastDateTime)|| startDateTime.isAfter(lastDateTime))
		{System.out.println("종료");}
		
		
		
		//차이 계산 - 날짜
		LocalDate Dateset=LocalDate.now();
		LocalDate targetDate=LocalDate.of(2018, 5, 5);
		
		Period per=Dateset.until(targetDate);
		per.getYears();// ~년차이
		per.getMonths();// ~개월차이
		per.getDays();// ~일 차이
		
		System.out.println(per.toString());
		
		Period per1=Period.between(Dateset, targetDate);
		per1.getYears();// ~년차이
		per1.getMonths();// ~개월차이
		per1.getDays();// ~일 차이
		
		System.out.println(per1.toString());
		
		
		//차이계산 - 시간
		LocalTime startTime =LocalTime.now();
		LocalTime endTime =LocalTime.of(11, 00, 00);
		long per2=startTime.until(endTime, ChronoUnit.MINUTES); 
		System.out.println(per2);
		
		Duration duration=Duration.between(startTime, endTime);
		System.out.println(duration.getSeconds());
		
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter formatterset=DateTimeFormatter.ofPattern("yyyy MM/dd");
		String nowStr=now.format(formatterset);			

		System.out.println(nowStr.toString());
	}

}
