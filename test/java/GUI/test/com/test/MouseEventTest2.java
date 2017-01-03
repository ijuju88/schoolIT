package com.test;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventTest2 extends JFrame{
	JLabel la=new JLabel("Move Me");
	
	public MouseEventTest2() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=getContentPane();
		myMouseListenerevent listener=new myMouseListenerevent();
		
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.setLayout(null);
		
		la.setSize(80,20);
		la.setLocation(100,80);
		c.add(la);
		
		setSize(300, 200);
		setVisible(true);
	}
}
