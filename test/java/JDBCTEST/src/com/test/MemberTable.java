package com.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MemberTable extends JFrame {
	private static final long serialVersionUID = 1L;
	DBConPro dbConn=DBConPro.getInstance();
	JTable table;
	JButton jb;
	String[] names={"이름", "나이", "성별"};
	public MemberTable(ArrayList<Memberber>members ) {
		
		super("조회");
		setSize(400, 300);
		dispose();
		
		DefaultTableModel model=new DefaultTableModel(names, 0);
		for (int i = 0; i < members.size(); i++) {
			Memberber member=members.get(i);
			System.out.println(member.getName());
			Object[] oMember=new Object[3];
			oMember[0]=member.getName();
			oMember[1]=member.getAge();
			oMember[2]=member.getGender();
			
			model.addRow(oMember);
		}
		table=new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		
		
		jb=new JButton("닫기");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(new JScrollPane(table));
		add(jb, BorderLayout.SOUTH);

		
		setVisible(true);
	}
	public MemberTable(String name) {
		// TODO Auto-generated constructor stub
	}

	

}
