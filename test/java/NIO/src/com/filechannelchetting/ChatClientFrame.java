package com.filechannelchetting;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.*;

public class ChatClientFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1491801129249926001L;
	
	JTextField tfAddress, tfName, tfData;
	JButton btnConn, btnSend;
	JTextArea ta;
	ChattingClient cc;
	
	public ChatClientFrame() {
		super("채팅서버 ★∧★");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		
		tfAddress=new JTextField("127.0.0.1", 10);
		tfName=new JTextField(10);
		tfData=new JTextField();
		
		btnConn=new JButton("채팅참여하기");
		btnSend=new JButton("보내기");
		
		ta=new JTextArea();
		
		jp1.add(new JLabel("서버주소"));
		jp1.add(tfAddress);
		jp1.add(new JLabel("이름"));
		jp1.add(tfName);
		jp1.add(btnConn);
		
		add(jp1, BorderLayout.NORTH);
		add(new JScrollPane(ta));
		
		jp2.setLayout(new BorderLayout());
		jp2.add(tfData, BorderLayout.CENTER);
		jp2.add(btnSend, BorderLayout.EAST);
		
		add(jp2, BorderLayout.SOUTH);
		
		setVisible(true);
		
		btnSend.setEnabled(false);
		
		btnConn.addActionListener(this);
		btnSend.addActionListener(this);
		tfData.addActionListener(this);
		cc=new ChattingClient(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==btnConn){
				if(btnConn.getText().equals("채팅참여하기")){
					String address=tfAddress.getText();
					cc.startClient(address);
					System.out.println("참여중");
					}
				else{
					cc.stopClient();
				}
			}else{
				String name=tfName.getText();
				String data=tfData.getText();
				
				System.out.println("data : "+data);
				
				 cc.send(name+" ->"+data);
				tfData.setText("");
			}
		} catch (Exception e2) {
			e2.getStackTrace();
		}

	}

	public static void main(String[] args) {
		new ChatClientFrame();
	}
	
	void displayText(String str){
		
		ta.append(str+"\n");
	}
}
