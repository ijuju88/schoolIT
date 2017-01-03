package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now=new Date();
		System.out.println(now.toString());
		
		SimpleDateFormat sdf=
				new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(now));
	}

}
