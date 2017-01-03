package com.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutTest extends JFrame {
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();

	private Container c = this.getContentPane();
	private JTextField jtfname;
	private JTextField jtfage;
	private JTextField jtftel;
	private JTextArea jta;
	private String result = "";

	public LayoutTest() {
		setTitle("창");
		c.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(4, 2));
		jp2.setLayout(new FlowLayout());

		JLabel jname = new JLabel("이름");
		JLabel jage = new JLabel("나이");
		JLabel jtel = new JLabel("연락");

		jtfname = new JTextField(10);
		jtfage = new JTextField(10);
		jtftel = new JTextField(10);

		JButton jbenter = new JButton("입력");
		JButton jbdel = new JButton("취소");

		jta = new JTextArea();
		jta.setSize(300, 150);
		// jbenter.addActionListener(new EnterActionListener(jtfname, jtfage,jtftel, jta));
		// jbdel.addActionListener(new EnterActionListener(jtfname, jtfage,jtftel, jta));

		// jbenter.addActionListener(new EnterActionListener());
		// jbdel.addActionListener(new EnterActionListener());

		jbenter.addActionListener(new EnterActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				result += jtfname.getText() + " ";
				result += jtfage.getText() + " ";
				result += jtftel.getText() + "\n";
				jta.append(result);
				jtfname.setText("");
				jtfage.setText("");
				jtftel.setText("");

			}

		});
		jbdel.addActionListener(new EnterActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				jtfname.setText("");
				jtfage.setText("");
				jtftel.setText("");

			}

		});

		jp1.add(jname);
		jp1.add(jtfname);

		jp1.add(jage);
		jp1.add(jtfage);

		jp1.add(jtel);
		jp1.add(jtftel);

		jp1.add(jbenter);
		jp1.add(jbdel);
		c.add(jp1, BorderLayout.NORTH);

		c.add(jta, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LayoutTest();
	}

	class EnterActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String result = "";
			if (e.getActionCommand().equals("입력")) {
				result += jtfname.getText() + " ";
				result += jtfage.getText() + " ";
				result += jtftel.getText() + "\n";
				jta.append(result);
				jtfname.setText("");
				jtfage.setText("");
				jtftel.setText("");

			} else {
				jtfname.setText("");
				jtfage.setText("");
				jtftel.setText("");
			}
		}

	}

}
