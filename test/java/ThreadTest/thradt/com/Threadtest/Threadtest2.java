package com.Threadtest;

public class Threadtest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ThreadC extends Thread{
	public ThreadC(int i){setName("Thread"+i);}
	
	public void run(){
		System.out.println(getName()+"내용");
	}
}