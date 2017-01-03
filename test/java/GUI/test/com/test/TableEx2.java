package com.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableEx2 extends JFrame implements ActionListener{
	JTextField tfName, tfAge, tfGender;
	DefaultTableModel model;
	JTable jt;
	String[] colName = { "이름", "나이", "성별" };
	public TableEx2() {
		super("테이블");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		JPanel jp4=new JPanel();
		jp1.add(new JLabel("이름"));
		jp2.add(new JLabel("나이"));
		jp3.add(new JLabel("성별"));
		
		tfName=new JTextField(8);
		tfAge=new JTextField(8);
		tfGender=new JTextField(8);
		jp1.add(tfName);
		jp2.add(tfAge);
		jp3.add(tfGender);
		
		JButton jbent=new JButton("추가");
		JButton jbcel=new JButton("삭제");
		jp4.add(jbent);
		jp4.add(jbcel);
		jbent.addActionListener(this);
		jbcel.addActionListener(this);
		
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		
		
		model= new DefaultTableModel(colName, 0);
		jt=new JTable(model);
		
		//테이블크기변경
		jt.setPreferredScrollableViewportSize(new Dimension(400,200));

		//테이블칼럼변경
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(1).setPreferredWidth(50);
		jt.getColumnModel().getColumn(2).setPreferredWidth(10);
		
		add(new JScrollPane(jt));
		setSize(450, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TableEx2();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str[]=new String[3];
		int row=0;
		String re=e.getActionCommand();
		if(re.equals("추가")){
			str[0]=tfName.getText();
			str[1]=tfAge.getText();
			str[2]=tfGender.getText();
			
			model.addRow(str);
		}else
		{
			row=jt.getSelectedRow();
			System.out.println(row);
			if(row==-1){
				return;
			}else{model.removeRow(row);}
		}
	}

}
