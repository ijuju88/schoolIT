package com.Threadtest;

public class InterruptThreadTest {

	public static void main(String[] args) {
		printThread pt = new printThread();
		pt.start();

		/*try {Thread.sleep(300);} 
		catch (Exception e) {}*/
		pt.interrupt();
	}

}

class printThread extends Thread {
	@Override
	public void run() {
		/*try {
			while (true) {
				System.out.println("실행중");
				sleep(100);
			}
		} catch (Exception e) {}*/
		boolean stop = false;
		while (!stop) {}
		System.out.println("종료");
	}

}