package com.test;

public class YieldText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA1 ta1=new ThreadA1();
		ThreadB1 tb1=new ThreadB1();
		ta1.start();
		tb1.start();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		
		ta1.work=false;
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		
		ta1.stop=false;
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		ta1.stop=true;
		tb1.stop=true;
		
	}

}

class ThreadA1 extends Thread{
	public boolean stop=false;
	public boolean work=true;
	
	@Override
	public void run(){
		while (!stop) {
			if(work){System.out.println("ThreadA1~~");}
			else{Thread.yield();}
		}System.out.println("ThreadA1끝~");
	}
}


class ThreadB1 extends Thread{
	public boolean stop=false;
	public boolean work=true;
	
	@Override
	public void run(){
		while (!stop) {
			if(work){System.out.println("ThreadB1~~");}
			else{Thread.yield();}
		}System.out.println("ThreadB1끝~");
	}
}