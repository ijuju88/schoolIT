package com.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListEx extends JFrame{

	private static final long serialVersionUID = 1L;
	String[] fruits1 = { "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry" };
	JList jl1, jl2;
	JComboBox jcb;
	JTextArea jta;
	public ListEx() {
		super("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLayout(new FlowLayout());
		
		jl1= new JList<>(fruits1);
		add(jl1);
		
		jl2=new JList<>(fruits1);
		add(jl2);
		add(new JScrollPane(jl2));
		
		jcb= new JComboBox<>(fruits1);
		add(jcb);
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox jcombobox=(JComboBox) e.getSource();
				int index=jcombobox.getSelectedIndex();
				jta.setText(fruits1[index]);
				
			}
		});
		
		jta=new JTextArea(7,10);
		add(jta);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListEx();
	}

}
