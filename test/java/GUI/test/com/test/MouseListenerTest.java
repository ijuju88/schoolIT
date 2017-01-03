package com.test;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MouseListenerTest extends JFrame {
	JLabel la = new JLabel("Hello");

	public MouseListenerTest() {
		setTitle("mouse 이벤트 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(null);

		la.setSize(50, 20);
		la.setLocation(30, 30);
		// la.setBounds(30, 30, 50, 20);

		add(la);
		//addMouseListener(new MymouseLiustener());
		addMouseListener(new MouseAdapter (){

			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX(); 
				int y = e.getY(); 
				la.setLocation(x - 5, y - 35);
			}
			
		});
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerTest();
	}

	/*class MymouseLiustener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); 
			int y = e.getY(); 
			la.setLocation(x - 5, y - 35);
		}

	}*/
}
