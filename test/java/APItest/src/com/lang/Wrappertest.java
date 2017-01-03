package com.lang;

public class Wrappertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Byte b=new Byte((byte)10);
		System.out.println(b);
		
		Integer i= new Integer(10);
		System.err.println(i);
		
		Float f= new Float(3.5f);
		System.out.println(f);
		
		Double d=new Double(3.6);
		System.out.println(d);
		
		System.out.println("-----------------");
		
		Byte b1=new Byte("10");
		System.out.println(b1);
		
		Integer i1= new Integer("10");
		System.err.println(i1);
		
		Float f1= new Float("3.5f");
		System.out.println(f1);
		
		Double d1=new Double("3.6");
		System.out.println(d1);
		
		System.out.println("-----------------");
		
		//자동박싱
		Integer i3=10;
		System.out.println(i3);
		
		int i4=i1.intValue();
		System.out.println(i4);
		
		
		//파싱
		int i5=Integer.parseInt("123");
		System.out.println(i5);
		String str="A123";
		int i6=Integer.parseInt(str.substring(1));
		
		System.out.println("-----------------");
		
		
		//비교
		System.out.println(i5==i6);
		System.out.println(i3==i1);
	}

}
