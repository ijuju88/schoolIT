package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {
	JCheckBox[] fruits = new JCheckBox[3];
	String[] names = { "사과", "배", "체리" };
	JLabel sumLabel;

	CheckBoxEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		MYltemlistener listener = new MYltemlistener();
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);
		setSize(250, 200);
		setVisible(true);
	}

	class MYltemlistener implements ItemListener {
		int sum = 0; // 가격의 합

		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == fruits[0])
					sum += 1000;
				else if (e.getItem() == fruits[1])
					sum += 5000;
				else
					sum += 10000;
			} else {
				if (e.getItem() == fruits[0])
					sum -= 1000;
				else if (e.getItem() == fruits[1])
					sum -= 5000;
				else
					sum -= 10000;
			}
			sumLabel.setText("현재 " + sum + "원 입니다.");
		}
	}

	public static void main(String[] args) {
		new CheckBoxEx();
	}
}
