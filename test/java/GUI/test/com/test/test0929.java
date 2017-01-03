package com.test;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class test0929 extends JFrame{
	public test0929() {
		setTitle("창");
		//Container cp=getContentPane();
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		
		setLayout(new GridLayout(4, 1));
		jp1.setLayout(new FlowLayout());
		
		JLabel Jname=new JLabel("이름");
		JTextField Jtfname=new JTextField(10);
		JLabel Jage=new JLabel("나이");
		JTextField Jtfage=new JTextField(10);
		JLabel Jtel=new JLabel("연락");
		JTextField Jtftel=new JTextField(10);
		
		jp1.add(Jname);
		jp1.add(Jtfname);
		
		add(jp1);
		
		jp2.add(Jage);
		jp2.add(Jtfage);
		add(jp2);
		
		jp3.add(Jtel);
		jp3.add(Jtftel);
		add(jp3);
	
		JButton Jbset=new JButton("입력");
		JButton Jbdel=new JButton("취소");
		
		jp4.add(Jbset);
		jp4.add(Jbdel);
		add(jp4);
		
		setSize(300,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test0929();
	}

}
