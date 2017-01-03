package com.ect;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Formattest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df=new DecimalFormat("#, ##0.0");
		String result=df.format(123456.894);
		
		System.out.println(result);
		
		String id="aaa", name="홍길동",num="111-1111";
		String message="ID: {0} \nNAME : {1} \nNUM : {2}";
		String result1=MessageFormat.format(message, id, name, num);
		System.out.println(result1);
		
		Object[] arguments={id,name,num};
		result1=MessageFormat.format(message, id, name, num);
		System.out.println(result1);
	}

}
