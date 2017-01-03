package com.test;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyKeyEventTest extends JFrame {
	JLabel la;
	Container c;
	public MyKeyEventTest() {
		super("키이벤트 처리");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		la = new JLabel("Enter 키로 배경색 바꾸기");
		c=this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(la);
		c.addKeyListener(new MyKeyLister());
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyLister extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyChar()) {
			case '\n':
				int r=(int)(Math.random()*256);
				int g=(int)(Math.random()*256);
				int b=(int)(Math.random()*256);
				la.setText("r=" + r + ", g=" + g + ", b=" + b);
				c.setBackground(new Color(r, g, b));

				break;
			case 'q':
				System.exit(0);

			default:
				break;
			}
		}

	}

	public static void main(String[] args) {
		new MyKeyEventTest();
	}

}
