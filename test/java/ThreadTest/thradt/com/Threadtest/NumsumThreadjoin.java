package com.Threadtest;

public class NumsumThreadjoin {
	public static void main(String[] args) {
		NumSum11 numsum=new NumSum11();
		Therad2 therad2=new Therad2(numsum);
		therad2.start();
		System.out.println(therad2.getName());
	}
}

class NumSum11{
	int sum;
	public void setSum(){
		for (int i = 0; i < 10; i++) {
			sum+=i;
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
	
	public int getSum(){return sum;}
}

class Therad1 extends Thread{
	NumSum11 ns11;
	
	public Therad1(NumSum11 ns11) {
		this.ns11=ns11;
	}
	
	public void run(){
		Thread therad1=new Therad1(ns11);
		
		System.out.println(ns11.getSum());
	}
}

class Therad2 extends Thread{
	NumSum11 ns11;
	
	public Therad2(NumSum11 ns11) {
		this.ns11=ns11;
	}
	
	public void run(){
		Thread therad2=new Therad2(ns11);
		therad2.start();
		
		System.out.println(ns11.getSum());
	}
}