package com.Threadtest;

public class Threadtest {
	public static void main(String[] args) {
		/*MyThread mythread = new MyThread();
		mythread.start();*/
		
		MyRunnable mr=new MyRunnable();
		Thread myrunnable = new Thread(mr);
		
		//Thread myrunnable= new Thread(new MyRunnable());
		myrunnable.start();
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		while (true) {
			System.out.println("i=" + i);
			i++;

			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			System.out.println("i=" + i);
			i++;
			if (i>=100) {break;}
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}