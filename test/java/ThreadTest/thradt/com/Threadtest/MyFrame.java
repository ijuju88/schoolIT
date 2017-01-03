package com.Threadtest;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	JTextField tx1, tx2; 
	MyFrame(){
		setTitle("MyFrame"); 
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel p=new JPanel();
		tx1=new JTextField("0"); 
		tx2=new JTextField("1");
		p.add(tx1);
		p.add(tx2);
		add(p);
		
		setVisible(true);
		
		MyThread1 mt1= new MyThread1(tx1);
		mt1.start();
		Thread mt2=new Thread(new MyThread2(tx2));
		mt2.start();
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}


class MyThread1 extends Thread{
	JTextField t1;
	public MyThread1(JTextField tx) {this.t1=tx;}
	
	@Override
	public void run(){
		int i = 0;
		while (true) {
			t1.setText(i+"");
			i++;
			if (i>=100) {break;}
				
			try {sleep(500);} 
			catch (Exception e) {e.printStackTrace();}
		}
			
	}
}

class MyThread2 implements Runnable{
	JTextField t2;
	public MyThread2(JTextField tx) {this.t2=tx;}
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			t2.setText(i+"");
			i++;
			if (i>=100) {break;}
				
			try {Thread.sleep(1000);} 
			catch (Exception e) {e.printStackTrace();}
		}
	}
}
