package com.EnumTest;

import java.util.Iterator;

//열거타입선언
enum Week{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY	
}


public class EnumA {
	
	public static void main(String[] args) {
		
		Week today;//열거타입 변수;
		/*today=Week.WEDNESDAY; //열거타입변수=열거타입.열거상수;
		
		System.out.println(today);
		System.out.println(today.ordinal());//순서(0~)
		
		String str=today.name();
		System.out.println(str);
		
		
		Week today1=Week.FRIDAY;
		
		System.out.println(today.compareTo(today1));//순서 비교
		
		Week today2=Week.valueOf("SUNDAY"); //문자열을 열거형으로
		
		Week[] today3=Week.values(); //문자열을 배열형으로
		for (Week day : today3) {
			System.out.println(day);
		}*/
		
		
		if(args.length==1){
			String strDay=args[0];
			Week weekDay=Week.valueOf(strDay); 
			if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) 
				{System.out.println("주말");}
			else
				{System.out.println("평일");}
		}
	}

}
