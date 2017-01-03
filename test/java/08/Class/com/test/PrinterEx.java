package com.test;

class Printer{
	public static void println(int num){System.out.println(num);}
	public static void println(Boolean bo){System.out.println(bo);}
	public static void println(double d){System.out.println(d);}
	public static void println(String s){System.out.println(s);}
}

public class PrinterEx {
	public static void main(String[] args){
		//Printer p=new Printer();
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}
}
