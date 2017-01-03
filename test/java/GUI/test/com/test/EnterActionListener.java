package com.test;

import java.awt.event.*;

import javax.swing.*;

public class EnterActionListener implements ActionListener {

	JTextField txtname, txtage, txttel;
	JTextArea txta;
	
	

	public EnterActionListener
	(JTextField txtname, JTextField txtage, JTextField txttel, JTextArea txta) 
	{
		this.txtname = txtname;
		this.txtage = txtage;
		this.txttel = txttel;
		this.txta = txta;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str=e.getActionCommand();
		String result="";
		if(str.equals("입력"))
		{
			result+=txtname.getText()+" ";
			result+=txtage.getText()+" ";
			result+=txttel.getText()+"\n";
			txta.append(result);
			txtname.setText("");
			txtage.setText("");
			txttel.setText("");
			
			
		}else{
			txtname.setText("");
			txtage.setText("");
			txttel.setText("");
		}
	}




}
