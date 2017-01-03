package com.ClassTest;

public class StaticTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Tv.info);
		Tv.method();
		System.out.println(Tv.info);
	}

}


class Tv{
				
	int number;
	static String company="samsung", model="Led", info;
	
	static{info=company+"-"+model;
	Tv tv=new Tv();
	tv.number=1;} //자동실행
	
	static void method(){
	company="LG";
	model="G5";
	info=company+"-"+model;}

}