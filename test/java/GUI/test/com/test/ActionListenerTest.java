package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ActionListenerTest extends JFrame {
	private JButton jb = new JButton("빨강");
	private JButton jb1 = new JButton("노랑");
	private JButton jb2 = new JButton("파랑");
	private Container c = this.getContentPane();

	public ActionListenerTest() {
		setTitle("Action 이벤트 리스너 예제");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jb) {
					c.setBackground(Color.RED);
				} else if (e.getSource() == jb1) {
					c.setBackground(Color.yellow);
				} else if (e.getSource() == jb2) {
					c.setBackground(Color.BLUE);
				}
			}
		});
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jb) {
					c.setBackground(Color.RED);
				} else if (e.getSource() == jb1) {
					c.setBackground(Color.yellow);
				} else if (e.getSource() == jb2) {
					c.setBackground(Color.BLUE);
				}
			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jb) {
					c.setBackground(Color.RED);
				} else if (e.getSource() == jb1) {
					c.setBackground(Color.yellow);
				} else if (e.getSource() == jb2) {
					c.setBackground(Color.BLUE);
				}
			}
		});

		add(jb);
		add(jb1);
		add(jb2);

		setSize(250, 150);
		setVisible(true);
	}

	// private class MyActionListener implements ActionListener{
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// if(e.getSource()==jb)
	// {c.setBackground(Color.RED);}
	// else if(e.getSource()==jb1)
	// {c.setBackground(Color.yellow);}
	// else if(e.getSource()==jb2)
	// {c.setBackground(Color.BLUE);}
	// }
	//
	// }

	public static void main(String[] args) {
		new ActionListenerTest();
	}

}
