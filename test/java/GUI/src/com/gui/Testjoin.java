package com.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Testjoin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jl[] = new JLabel[5];
	private JTextField text[] = new JTextField[5];
	private String[] str = { "아이디", "비번", "이름", "성별", "취미" };
	private String[] jcstr = { "게임", "여행", "낚시", "음악감상" };
	private JButton jbset, jbcel;
	private JRadioButton jr[] = new JRadioButton[2];
	private JCheckBox jc[] = new JCheckBox[4];
	private JPanel jp[] = new JPanel[7];
	private ButtonGroup group = new ButtonGroup();
	private JTextArea jta;

	public Testjoin() {
		super("사용자 정보 입력");
		setSize(350, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		for (int i = 0; i < jp.length; i++) {
			jp[i] = new JPanel();
		}

		jl[0] = new JLabel(str[0]);
		text[0] = new JTextField(15);
		jp[0].add(jl[0]);
		jp[0].add(text[0]);
		add(jp[0]);

		jl[1] = new JLabel(str[1]);
		text[1] = new JTextField(15);
		jp[1].add(jl[1]);
		jp[1].add(text[1]);
		add(jp[1]);

		jl[2] = new JLabel(str[2]);
		text[2] = new JTextField(15);
		jp[2].add(jl[2]);
		jp[2].add(text[2]);
		add(jp[2]);

		jl[3] = new JLabel(str[3]);
		jr[0] = new JRadioButton("남");
		jr[1] = new JRadioButton("여");
		group.add(jr[0]);
		group.add(jr[1]);
		jp[3].add(jl[3]);
		jp[3].add(jr[0]);
		jp[3].add(jr[1]);
		add(jp[3]);

		jl[4] = new JLabel(str[4]);
		jp[4].add(jl[4]);
		for (int i = 0; i < jc.length; i++) {
			jc[i] = new JCheckBox(jcstr[i]);
			jp[4].add(jc[i]);
		}

		add(jp[4]);

		jbset = new JButton("입력");
		jbcel = new JButton("취소");

		jp[5].add(jbset);
		jp[5].add(jbcel);
		add(jp[5]);

		jta = new JTextArea(7, 25);
		jp[6].add(new JScrollPane(jta));
		add(jp[6]);

		jbset.addActionListener(new MyActionListener());

		jbcel.addActionListener(new MyActionListener());

		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		String str = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			String commandstr = e.getActionCommand();
			if (commandstr.equals("입력")) {

				str += text[0].getText() + " ";
				str += text[1].getText() + " ";
				str += text[2].getText() + " ";

				if (jr[0].isSelected()) {
					str += jr[0].getText();

				} else {
					str += jr[1].getText();
				}

				str += " ";

				for (int k = 0; k < jc.length; k++) {
					if (jc[k].isSelected()) {
						str += jc[k].getText();

					}
				}

				jta.append(str + "\n");

				for (int i = 0; i < text.length; i++) {
					text[0].setText("");
					text[1].setText("");
					text[2].setText("");
				}
				for (int i = 0; i < jr.length; i++) {
					jr[i].setSelected(false);
				}

				for (int i = 0; i < jc.length; i++) {
					jc[i].setSelected(false);
				}

				JOptionPane.showConfirmDialog(null, str, "결과", JOptionPane.OK_OPTION);

				str = "";

			} else if (commandstr.equals("취소")) {
				str = "";

				for (int i = 0; i < text.length; i++) {
					text[0].setText("");
					text[1].setText("");
					text[2].setText("");
				}
				for (int i = 0; i < jr.length; i++) {
					jr[i].setSelected(false);
				}

				for (int i = 0; i < jc.length; i++) {
					jc[i].setSelected(false);
				}
			}

		}

	}

	public static void main(String[] args) {
		new Testjoin();

	}

}
