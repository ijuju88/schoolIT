package com.test;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class MenuEx extends JFrame {
	ImageIcon ic;
	JLabel jl;
	public MenuEx() {
		setTitle("Menu 만들기");
		createMenu();

		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	void createMenu() {
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("기본");
		JMenuItem jmi1, jmi2, jmi3;

		jmi1 = new JMenuItem("열기");
		jmi2 = new JMenuItem("저장");
		jmi3 = new JMenuItem("종료");
		jm.add(jmi1);
		jm.add(jmi2);
		jm.addSeparator();
		jm.add(jmi3);
		jmb.add(jm);
		this.setJMenuBar(jmb);

		jl=new JLabel();
		add(jl);
		

		jmi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ic=new ImageIcon("D:/ijuju/test/java/schooljava/GUI/test/com/test/l1.png");
				//Image img=ic.getImage();
				//img=img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
				//ic=new ImageIcon(img);
				jl.setIcon(ic);
			}
		});

		jmi2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jl.setVisible(false);
			}
		});

		jmi3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});

	}

	public static void main(String[] args) {
		new MenuEx();
	}

}
