package com.lang;

public class StringTest {

	public static void main(String[] args){
		String str1="abc";
		String str2="abc";
		String str3=new String("abc"); 
		String str4=new String("abc");	
	
		System.out.println(str1==str2);
		System.out.println(str3==str4);
		
		System.out.println("--------------------");
		
		System.out.println(str1.charAt(2));
		
		System.out.println("--------------------");
		
		System.out.println("abc".equals(str2));
		
		System.out.println("--------------------");
		
		System.out.println(str2.substring(1, 3));
		System.out.println("--------------------");
		
		byte[] bytes={72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		String str5=new String(bytes);
		System.out.println(str5);
		System.out.println(new String(bytes, 2, 5));
		
		System.out.println("--------------------");
		
		System.out.println(str5.replace("Java", "android"));
		System.out.println(str5.toUpperCase());
		
		char[] c1={'j','a','v','a'};
		String str6=new String(c1);
		System.out.println(str6);
		
		System.out.println("--------------------");
		
		byte[] bytes2=str6.getBytes();
		for (int i = 0; i < bytes2.length; i++) {
			System.out.print(bytes2[i]+"\t");	
		}System.out.println();
		
		System.out.println("--------------------");
		
		int index=str6.indexOf('a');
		System.out.println(index);
		
		System.out.println("--------------------");
		
		int le=str5.length();
		System.out.println(le);
		
	}
}
