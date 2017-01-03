package com.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentTest extends JFrame {
	private boolean flag = false;
	public JComponentTest() {
		super("JComponent 공통 메소드 예제");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JButton b1=new JButton("Magenta/yellow Button");
		JButton b2=new JButton("Disabled Button");
		JButton b3=new JButton("getX(), getY()");

		b1.setBackground(Color.yellow);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		
		b2.setEnabled(false);
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				if(!flag){
					b2.setEnabled(true);
					flag=true;
					setTitle(b.getX()+", "+b.getY());
				}
				else{
					b2.setEnabled(false);
					flag=false;
					setTitle(b.getX()+", "+b.getY());
				}
					
			}
		});
		
		c.add(b1); c.add(b2);  c.add(b3);
		setSize(260,200); setVisible(true);
		
	}
	public static void main(String[] args) {
		new JComponentTest();
	}

}
