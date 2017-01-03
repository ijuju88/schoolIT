package com.test;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class NullNullContainerEx extends JFrame {

	public NullNullContainerEx()  {
		setTitle("배치관리자 없이 절대 위치에 배치하는 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		
		JLabel la=new JLabel("Hello, Press Buttons!");
		la.setLocation(130,50);
		la.setSize(200,20);
		add(la);
		
		
		for (int i = 1; i <=9; i++) {
			JButton b=new JButton(Integer.toString(i));
			b.setBounds(i*15, i*15, 50, 20);
			add(b);
		}
		
		setSize(300, 200);
		setVisible(true);
	}

	

	public static void main(String[] args) {
		new NullNullContainerEx();
	}

}
