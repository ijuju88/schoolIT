package com.test;

import java.awt.*;
import javax.swing.*;

public class RadioButtonEx extends JFrame{
	public RadioButtonEx() {
		super("라디오 	버튼 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c=getContentPane();
			

		c.setLayout(new FlowLayout());
		ButtonGroup g=new ButtonGroup();
		
		JRadioButton apple=new JRadioButton("사과");
		JRadioButton pear=new JRadioButton("배", true);
		JRadioButton cherry=new JRadioButton("체리");
		JLabel jl=new JLabel("fdf");
	
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		c.add(jl);
		
		setSize(500,200);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new RadioButtonEx();
	}
}
