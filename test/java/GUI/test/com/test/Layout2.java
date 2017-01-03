package com.test;

import java.awt.*;

import javax.swing.*;

public class Layout2 extends JFrame{
	String[] str={"CE","←","%","/","7","8","9","*","4","5","6","-"
			,"1","2","3","+","+/-","0", ".","="};
	
	public Layout2(){
		setTitle("창"); //창타이틀
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
//		JPanel jp1=new JPanel();
//		JPanel jp2=new JPanel();
//		jp1.setLayout(new FlowLayout()); 
//		jp2.setLayout(new FlowLayout()); 
//		JLabel jl1=new JLabel("num1");
//		JLabel jl2=new JLabel("num2");
//		JTextField jt1=new JTextField(20);
//		JTextField jt2=new JTextField(20);
//		
//		jp1.add(jl1);
//		jp1.add(jt1);
//		jp2.add(jl2);
//		jp2.add(jt2);
//		
//		c.add(jp1);
//		c.add(jp2);

		JPanel jp1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jl1=new JLabel("0");
		Font f1=new Font("돋움", Font.BOLD, 30);
		jl1.setFont(f1);
		jp1.add(jl1);
		c.add(jp1, BorderLayout.NORTH);
		JPanel jp3=new JPanel();
		//JPanel jp4=new JPanel();
		
		jp3.setLayout(new GridLayout(5,4));
		for (String s : str) {
			JButton jb=new JButton(s);
			jp3.add(jb);
			c.add(jp3, BorderLayout.CENTER);
		}
		
//		for (int i = 0; i< str.length; i++) {
//			String text=Integer.toString(i);
//			JButton jb=new JButton(text);
//			jp3.add(jb);
//			c.add(jp3);
//
//		}
		
		
		setSize(300,300); //창크기
		setVisible(true); //창 출력여부
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Layout2();
	}

}
