package com.test;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	private JLabel jid, jpw;
	private JTextField jtfid, jtfpw;
	private JButton jbset, jbcel;
	private JPanel jp[]=new JPanel[3];
	private String id, pw;
	public LoginFrame() {
		super("로그인~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(new FlowLayout());
		
		jid=new JLabel("아이디");
		jpw=new JLabel("비번");
		jtfid=new JTextField(20);
		jtfpw=new JTextField(20);
		jbset=new JButton("확인");
		jbcel=new JButton("취소");
		
		for (int i = 0; i < jp.length; i++) {
			jp[i]=new JPanel();
		}	
		jp[0].add(jid);
		jp[0].add(jtfid);
		jp[1].add(jpw);
		jp[1].add(jtfpw);
		
		jp[2].add(jbset);
		jp[2].add(jbcel);
		
		add(jp[0]);
		add(jp[1]);
		add(jp[2]);
		jbset.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LoginFrame();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		id=jtfid.getText();
		pw=jtfpw.getText();
		
		if(id.equals("abcd")&& pw.equals("1234"))
		{
			new LoginResultFrame(id);
		}
		
	}

}
