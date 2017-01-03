package com.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableModel;

public class TableEx extends JFrame {
	JTextArea ta;
	JTable jt;
	JLabel jl;
	JPanel jp=new JPanel();
	JButton jb = new JButton("출력");
	String[] colName = { "이름", "나이", "성별" };
	Object[][] data = { { "김철수", 20, "남" }, { "김순희", 18, "여" }, { "박휘순", 27, "남" } };

	public TableEx() {
		super("테이블");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jt = new JTable(data, colName);
		add(new JScrollPane(jt));
		jl = new JLabel("정보");
		ta=new JTextArea(4,10);
		add(jb, BorderLayout.NORTH);
		jp.add(jl, BorderLayout.SOUTH);
		jp.add(ta, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
		jb.addActionListener(new MyActionListener());

		setSize(250, 300);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = "";
			TableModel model = jt.getModel();
			int rownum = model.getRowCount();
			int colnum = model.getColumnCount();
			str += "\n행수" + rownum + "\n열수" + colnum + "";
			for (int i = 0; i < colName.length; i++) {
				String colName = model.getColumnName(i);
				str += colName + ", ";
			}
			str += "\n";
			for (int i = 0; i < colName.length; i++) {
				for (int j = 0; j < colName.length; j++) {
					str+=model.getValueAt(i, j)+"\t";
				}str += "\n";
			}
		
			ta.setText(str);
		}

	}

	public static void main(String[] args) {
		new TableEx();

	}

}
