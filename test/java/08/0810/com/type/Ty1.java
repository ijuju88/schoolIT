package com.type;


public class Ty1 {
	
	public static void main(String[] args){
		
		byte b=-128; //byte 값범위 -128 ~ 127
		char ch='A'; //char은 2byte 한글자만 가능
		char ch1=65; //숫자입력가능함(아스키코드~~)
		char ch2='\t'; //줄바꿈같은건 두글자이지만 한글자로 됨~~ 예)\n, \\, \t, \b
		char ch3='\u0041'; //
		
		System.out.print(ch);
		System.out.print(ch2);
		System.out.print(ch1);
		System.out.println(ch3);
		
		
		System.out.print((int)ch);
		System.out.print(ch2);
		System.out.println((int)ch1);
		
	}
}
