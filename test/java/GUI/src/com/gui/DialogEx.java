package com.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class DialogEx extends JFrame {
	JPanel p=new JPanel();
public DialogEx() {
	setTitle("다이얼로그~~");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,200);
	JButton inputBtn = new JButton("Input Name");
	JButton confirmBtn = new JButton("Confirm");
	JButton messageBtn = new JButton("Message");
	
	JTextField tf = new JTextField(10);
	
	p.add(inputBtn);
	p.add(confirmBtn);
	p.add(messageBtn);
	p.add(tf);
	
	inputBtn.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			String name=JOptionPane.showInputDialog("이름??");
			if(name != null)
				tf.setText(name);
		}
		
	});
	
	confirmBtn.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int re=JOptionPane.showConfirmDialog(null, "할거임??","물어봄", JOptionPane.YES_NO_OPTION);
			if(re==JOptionPane.YES_OPTION){
				tf.setText("Yes");
			}else if(re==JOptionPane.NO_OPTION)
			{
				tf.setText("No");
			}
		}
		
	});
	
	
	messageBtn.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			JOptionPane.showMessageDialog(null,"조심하삼","경고", JOptionPane.ERROR_MESSAGE);
		}
		
	});
	add(p,BorderLayout.NORTH);
	
	
	setVisible(true);
}
	
	public static void main(String[] args) {
		new DialogEx();

	}

}
