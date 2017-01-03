package com.test;

import java.awt.*;
import javax.swing.*;

public class test extends JFrame{
	public test() {
		setTitle("창"); //창타이틀
		
		
//		setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
//		Container c=getContentPane();
//		c.setBackground(Color.lightGray); //안바뀜 이거는 프레임색
//		add(new JButton("add"));
//		add(new JButton("sub"));
//		add(new JButton("mul"));
//		add(new JButton("div"));
//		add(new JButton("Calculate"));
		
//		setLayout(new BorderLayout(10,8));
//		Container c=getContentPane();
//		c.setBackground(Color.lightGray); //안바뀜 이거는 프레임색
//		add(new JButton("add"), BorderLayout.NORTH);
//		add(new JButton("sub"), BorderLayout.SOUTH);
//		add(new JButton("mul"), BorderLayout.WEST);
//		add(new JButton("div"), BorderLayout.EAST);
//		add(new JButton("Calculate")); //디폴드가 CENTER
		
//		JButton jb1=new JButton("1");
//		JButton jb2=new JButton("2");
//		JButton jb3=new JButton("3");
//		add(jb1);
//		add(jb2);
//		add(jb3);
		
		Container c=getContentPane();
		JPanel p = new JPanel();
		
		
		c.setLayout(new BorderLayout());
		p.setLayout(new FlowLayout());
		
		p.add(new JLabel("이름 : "));
		p.add(new JTextField(10));
		c.add(p, BorderLayout.NORTH);
		
		c.add(new JTextArea(), BorderLayout.CENTER);
	
		c.add(new JButton("출력"), BorderLayout.SOUTH);
		
		setSize(300,300); //창크기
		setVisible(true); //창 출력여부
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
	}

}
