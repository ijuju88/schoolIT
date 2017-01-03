package com.ClassTest;

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persont per1=new Persont("123456-987654","홍길동");
		Persont per2=new Persont("159951-753357","황길자");
		
		System.out.print(per1.nation+" ");
		System.out.print(per1.ssn+" ");
		System.out.println(per1.name);
		
		System.out.print(per2.nation+" ");
		System.out.print(per2.ssn+" ");
		System.out.println(per2.name);
		
		//p1.ssn="456789-951753";//한번쓰이면 더이상 만들어지지 않음
	}

}

class Persont{
	final String nation="korea";
	final String ssn; 
	String name;
	
	public Persont(String ssn, String name)
	{this.ssn=ssn; this.name=name;}
	
}