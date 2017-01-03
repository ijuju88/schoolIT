package com.test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Member extends JFrame {
	String[] str = { "이름", "나이", "성별" };
	JPanel jp[] = new JPanel[4];
	JLabel jl[] = new JLabel[3];
	JTextField jt[] = new JTextField[3];
	JButton jbent, jbcel, jbget, jbupdata, jbdel;
	DBConPro DB = new DBConPro();
	Memberber memberber=new Memberber();
	public Member() {
		super("JDBC 테스트");
		setSize(350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridLayout(4, 1));

		for (int i = 0; i < jl.length; i++) {
			jp[i] = new JPanel();
			jl[i] = new JLabel(str[i]);
			jt[i] = new JTextField(10);
			jp[i].add(jl[i]);
			jp[i].add(jt[i]);
			add(jp[i]);

		}

		jp[3] = new JPanel();
		jbent = new JButton("저장");
		jbcel = new JButton("취소");
		jbget = new JButton("출력");
		jbupdata = new JButton("수정");
		jbdel = new JButton("삭제");
		jp[3].add(jbent);
		jp[3].add(jbcel);
		jp[3].add(jbget);
		jp[3].add(jbupdata);
		jp[3].add(jbdel);
		add(jp[3]);

		jbent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memberber.setName(jt[0].getText());
				memberber.setAge(Integer.parseInt(jt[1].getText()));
				memberber.setGender(jt[2].getText());
				DB = DBConPro.getInstance();
	
				try {
					DB.inputDB(memberber);

					for (int j = 0; j < jt.length; j++) {
						jt[j].setText("");
					}

				} catch (SQLException e1) {
					System.err.println(e1.getMessage());
				}
			}
		});

		jbget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memberber.setName(jt[0].getText());
				DB = DBConPro.getInstance();
				ArrayList<Memberber> memberbers=DB.SetTableDB(memberber);

				new MemberTable(memberbers);
			}
		});

		jbupdata.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memberber.setName(jt[0].getText());
				memberber.setAge(Integer.parseInt(jt[1].getText()));
				memberber.setGender(jt[2].getText());
				DB = DBConPro.getInstance();
				DB.upDB(memberber);
				for (int j = 0; j < jt.length; j++) {
					jt[j].setText("");
				}
			}
		});

		jbdel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memberber.setName(jt[0].getText());
				DB = DBConPro.getInstance();
				DB.delectDb(memberber);
				for (int j = 0; j < jt.length; j++) {
					jt[j].setText("");
				}
			}
		});

		jbcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int j = 0; j < jt.length; j++) {
					jt[j].setText("");
				}
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new Member();
	}

}
