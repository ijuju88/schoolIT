package com.test;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class KeyListenerTest extends JFrame {
	JLabel lb;
	int x=50,y=50;
	Container c = getContentPane();
	public KeyListenerTest() {
		lb = new JLabel("Hello");
		setTitle("KeyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		c.addKeyListener(new MyKeyAdapter());
		lb.setBounds(x, y, 50, 20);
		c.add(lb);
		setSize(300, 200);
		setVisible(true);
		c.requestFocus();
		c.setFocusable(true);
		
	}

	
	class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				lb.setLocation(lb.getX(), lb.getY()-5);
				break;
			case KeyEvent.VK_DOWN:
				lb.setLocation(lb.getX(), lb.getY()+5);
				break;

			case KeyEvent.VK_LEFT:
				lb.setLocation(lb.getX()-5, lb.getY());
				break;
				
			case KeyEvent.VK_RIGHT:
				lb.setLocation(lb.getX()+5, lb.getY());
				break;

			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyListenerTest();
	}

}


