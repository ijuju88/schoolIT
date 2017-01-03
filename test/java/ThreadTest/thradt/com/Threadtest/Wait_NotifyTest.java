package com.Threadtest;

public class Wait_NotifyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkObjent workobject= new WorkObjent();
		ThreadA ta= new ThreadA(workobject);
		ThreadB tb= new ThreadB(workobject);
		ta.start();
		tb.start();
	}

}

class WorkObjent{
	public synchronized void methodA(){
		System.out.println("ThreadA");
		notify(); //일시정지상태의 다른스레드 대기상태 만들기
		try {
			wait(); //일시정지
		} catch (Exception e) {}
		
	}
	
	public synchronized void methodB(){
		System.out.println("ThreadB");
		notify(); //일시정지상태의 다른스레드 대기상태 만들기
		try {
			wait(); //일시정지
		} catch (Exception e) {}
		
	}
}

class ThreadA extends Thread{
	private WorkObjent wo;
	
	public ThreadA(WorkObjent wo) 
	{this.wo=wo;}
	
	public void run(){
		for (int i = 0; i <10; i++) {
			wo.methodA();
		}
	}
		
}


class ThreadB extends Thread{
	private WorkObjent wo;
	
	public ThreadB(WorkObjent wo) 
	{this.wo=wo;}
	
	public void run(){
		for (int i = 0; i <10; i++) {
			wo.methodB();
		}
	}
		
}