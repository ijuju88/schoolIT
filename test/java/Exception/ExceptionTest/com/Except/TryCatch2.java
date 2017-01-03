package com.Except;

class Test{
	void method1(){
		try {
			method2();
			method3();
		} catch (Exception e) {
			e.printStackTrace();}
}

	void method2() throws ArrayIndexOutOfBoundsException{
		int[] a=new int[3];
		a[3]=10;
	}
	
	void method3() throws NumberFormatException{
		String data="a123";
		int num1=Integer.parseInt(data);
	}	
}

public class TryCatch2 {

	public static void main(String[] args) {
		Test t=new Test();
		t.method1();
	}

}

