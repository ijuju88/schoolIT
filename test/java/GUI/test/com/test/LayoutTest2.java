package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutTest2 extends JFrame implements ActionListener{
	private JPanel jp1 = new JPanel();

	private Container c = this.getContentPane();
	private JTextField jt1;
	private JTextArea jta;

	public LayoutTest2() {
		setTitle("창");
		c.setLayout(new BorderLayout());

		jt1 = new JTextField(10);

		JButton jbenter = new JButton("입력");
		JButton jbdel = new JButton("취소");

		jta = new JTextArea();
		jta.setSize(300, 150);
		
		jp1.add(jbenter);
		jp1.add(jbdel);
		
		jbenter.addActionListener(this);
		jbdel.addActionListener(this);
		
		c.add(jt1, BorderLayout.NORTH);
		c.add(jta, BorderLayout.CENTER);
		c.add(jp1, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LayoutTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String result = "";
		if (e.getActionCommand().equals("입력")) {
			result += jt1.getText() + "\n";
			jta.append(result);
			jt1.setText("");

		} else {
			jt1.setText("");
		}
		
		
	}

}
