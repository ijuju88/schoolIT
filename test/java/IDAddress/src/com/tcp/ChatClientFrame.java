package com.tcp;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class ChatClientFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = -8684664474278194455L;
	
	JTextField jtfAddress, jtfName, jtfInput, jtfProt;
	JTextArea jta;
	JButton btnConn, btnSend;
	
	Socket socket=new Socket();
	Thread senderThread=null;
	Thread receiverThread=null;
	PrintWriter writer=null;
	
	@SuppressWarnings("deprecation")
	public ChatClientFrame() {
		setTitle("채팅방★_★");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel p1=new JPanel();
		p1.setBounds(0, 0, 584, 38);
		JPanel p2=new JPanel();
		p2.setBounds(0, 338, 584, 23);
		setSize(600, 400);
		
		jtfAddress=new JTextField("127.0.0.1");
		jtfAddress.setBounds(114, 9, 80, 21);
		jtfName=new JTextField();
		jtfName.setBounds(251, 9, 80, 21);
		jtfInput=new JTextField();
		jtfProt=new JTextField("9002");
		jtfProt.setSize(50, 21);
		jtfProt.setLocation(380, 9);
		jta=new JTextArea();
		jta.setBounds(0, 38, 584, 300);
		btnConn=new JButton("접속");
		btnConn.setBounds(467, 8, 80, 23);
		btnSend=new JButton("전송");
		p1.setLayout(null);
		
		JLabel label = new JLabel("서버아이디");
		label.setFont(new Font("굴림", Font.PLAIN, 12));
		label.setBounds(30, 12, 72, 15);
		p1.add(label);
		p1.add(jtfAddress);
		
		JLabel label2 = new JLabel("포트");
		label2.setSize(40, 15);
		label2.setLocation(343, 12);
		label2.setFont(new Font("굴림", Font.PLAIN, 12));
		p1.add(label2);
		p1.add(jtfProt);
		
		JLabel label3 = new JLabel("이름");
		label3.setFont(new Font("굴림", Font.PLAIN, 12));
		label3.setBounds(206, 12, 40, 15);
		
		p1.add(label3);
		p1.add(jtfName);
		p1.add(btnConn);
		
		p2.setLayout(new BorderLayout());
		p2.add(jtfInput);
		p2.add(btnSend, BorderLayout.EAST);
		getContentPane().setLayout(null);
		
		getContentPane().add(p1);
		getContentPane().add(jta);
		jta.disable();
		getContentPane().add(p2);
		setVisible(true);
		
		btnConn.addActionListener(this);
		btnSend.addActionListener(this);
		jtfInput.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=jtfName.getText();
		String ip=jtfAddress.getText();
		int port=Integer.parseInt(jtfProt.getText());
		if(e.getSource() ==jtfInput ){
			jtfInput.setText("");
			
		}
			else if(e.getSource()==btnConn || e.getSource()==btnSend){
			try {
				socket=new Socket(ip, port);
				writer=new PrintWriter(socket.getOutputStream());
				writer.println(name);
				
				Thread senderThread=new SenderThead(socket, name);
				Thread receiverThread=new ReceiverThread(socket, this);
				
				senderThread.start();
				receiverThread.start();

			} catch (Exception e1) {
				e1.getStackTrace();
			}
			
		}/*else if(e.getSource()==btnSend){
			try {
				writer=new PrintWriter(socket.getOutputStream());
				writer.println(name);
				
				Thread senderThread=new SenderThead(socket, name);
				Thread receiverThread=new ReceiverThread(socket, this);
				
				senderThread.start();
				receiverThread.start();

			} catch (Exception e1) {
				e1.getStackTrace();
			}
		}*/
		
	}
	
	public static void main(String[] args) {
		new ChatClientFrame();
		
	}

	
	
}
