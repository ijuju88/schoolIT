package com.Threadtest;

public class ThreadNametest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread mainThread=Thread.currentThread();
		
		System.out.println("시작 스레드 : "+mainThread.getName());
		System.out.println(mainThread.getPriority());
		
		for (int i = 0; i < 10; i++) {
			System.out.println(mainThread.getName()+"출력");
			if(i!=10){mainThread.setPriority(Thread.MIN_PRIORITY);}
		}
		
		ThreadA1 threadA1=new ThreadA1();
		System.out.println(threadA1.getName());
		System.out.println(threadA1.getPriority());
		threadA1.start();
		
		ThreadB1 threadB1=new ThreadB1();
		System.out.println(threadB1.getName());
		System.out.println(threadB1.getPriority());
		threadB1.start();
	}

}


class ThreadA1 extends Thread{
	public ThreadA1(){setName("ThreadA");}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+"출력");
			
			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadB1 extends Thread{
	public ThreadB1(){setName("ThreadB");}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+"출력");
			
			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}