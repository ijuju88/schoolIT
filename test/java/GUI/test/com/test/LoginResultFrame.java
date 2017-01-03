package com.test;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;


public class LoginResultFrame extends JFrame{
	private LoginFrame lf=new LoginFrame();
	JLabel la;
	JButton jbenter;
	
	public LoginResultFrame(String id){		
		super("로그인결과");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(new FlowLayout());
		
		la=new JLabel(id+"님 로그인");
		add(la);
		
		jbenter=new JButton("돌아가기");
		jbenter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		add(jbenter);	
		
		setVisible(true);
	}

}
