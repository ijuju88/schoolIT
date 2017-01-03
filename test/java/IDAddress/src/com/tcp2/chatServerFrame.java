package com.tcp2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class chatServerFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = -5961102443122185180L;
	
	JTextArea jta;
	JButton btnstartstop;
	
	ChattingServer cs=null;
	public chatServerFrame() {
		super("채팅서버");
		setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jta=new JTextArea();
		jta.setEditable(false);
		btnstartstop=new JButton("시작");
		btnstartstop.addActionListener(this);
		add(jta, BorderLayout.CENTER);
		add(btnstartstop, BorderLayout.SOUTH);
		setVisible(true);
		cs=new ChattingServer(this);
	}
	
	public static void main(String[] args) {
		new chatServerFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		if(btnstartstop.getText().equals("시작")){
			cs.startServer();
		}else
			cs.stopServer();
		
	}

	void displayText(String str){
		jta.append(str+"\n");
	}
}
