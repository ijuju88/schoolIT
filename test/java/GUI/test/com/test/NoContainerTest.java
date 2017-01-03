package com.test;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoContainerTest extends JFrame{
	public NoContainerTest() {
		setTitle("배치관리자 없는 컨테이너");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JButton jb1=new JButton("버튼1");
		jb1.setSize(100,50);
		jb1.setLocation(50,50);
		add(jb1);
		
		JButton jb2=new JButton("버튼2");
		jb2.setBounds(60,70,100,50);
		add(jb2);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NoContainerTest();
	}

}
