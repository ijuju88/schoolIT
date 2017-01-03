package com.time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class TimePlusMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//날짜 시간+-
		LocalDateTime ldt=LocalDateTime.now();
		
		System.out.println(ldt.toString());//현재시간
		
		LocalDateTime target=ldt
				.plusDays(3) //3일 +
				.minusHours(5); //5시간-
		
		System.out.println(target.toString());
		
		//변경
		target=null;
		target=ldt
				.with(TemporalAdjusters.firstDayOfMonth()) //이번달1일
				.withMinute(50)
				.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));//지난주금요일
		System.out.println(target.toString());
		
		
	}

}
