package com.Threadtest;

import java.awt.*;

public class testPrintThread implements Runnable{
	
	public void run(){
		for (int j = 1; j <= 10; j++) {
			System.out.println(j+"");
			try {Thread.sleep(500);} 
			catch (Exception e) {e.printStackTrace();}
		}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Thread test1=new Thread(new testPrintThread());
		//test1.start();
		
		//for (int i = 1; i <= 5; i++) {
			//System.out.println("띵!");
			//try {Thread.sleep(1000);} 
			//catch (Exception e) {e.printStackTrace();}
		
		//Runnable익명객체를 사용합니다
		Thread test2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int j = 1; j <= 10; j++) {
					System.out.println(j+"");
					try {Thread.sleep(500);} 
					catch (Exception e) {e.printStackTrace();}
				}
			}
		});
		test2.start();
			
	}
}


