package com.gui;

import java.awt.*;
import java.time.*;

import javax.swing.*;
import javax.swing.border.*;

public class TestForm extends JFrame{
	public JTextField[] jt = new JTextField[5];
	
	public void TestForm() {
		setBounds(600, 300, 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("물류 관리");

		JPanel all = new JPanel(new BorderLayout());
		JPanel north = new JPanel(new GridLayout(1, 4, 10, 10));
		JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));

		north.setBorder(new EmptyBorder(10, 10, 10, 10));
		all.setBorder(new EmptyBorder(10, 10, 10, 10));

		add(all);
		all.add(north, BorderLayout.NORTH);
		all.add(center, BorderLayout.CENTER);

		String[] BtnName = { "물품 등록", "물품 조회", "물품 삭제", "종 료" };
		for (int i = 0; i < BtnName.length; i++) {
			JButton btn = new JButton(BtnName[i]);
			//btn.addActionListener(this);
			north.add(btn);
		}

		String[] LabelName = {"등록자", "물품명", "휴대전화", "주소", "날짜" };
		for (int i = 0; i < LabelName.length; i++) {
			JLabel jl = new JLabel(LabelName[i]);
			jl.setPreferredSize(new Dimension(70, 30));
			jl.setHorizontalAlignment(jl.LEFT);
			center.add(jl);

			jt[i] = new JTextField();
			jt[i].setPreferredSize(new Dimension(130, 30));
			jt[i].setHorizontalAlignment(jt[i].CENTER);
			center.add(jt[i]);
		}

		LocalDate now = LocalDate.now();

		jt[4].setText(now.toString());
		setVisible(true);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestForm t=new TestForm();
		t.TestForm();	
	}
}

