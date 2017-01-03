package com.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame{
	JTextField jtf=new JTextField(20);
	JTextArea jta=new JTextArea(7,20);
	public TextFieldEx() {
		super("텍스트필드 만들기 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("이름"));
		c.add(jtf);
		c.add(new JScrollPane(jta));
		
		jta.setBackground(Color.BLUE);
		
		jtf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.append(jtf.getText()+"\n");
				jtf.setText("");
			}
		});
		
		
		setSize(300, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new TextFieldEx();
	}
}
