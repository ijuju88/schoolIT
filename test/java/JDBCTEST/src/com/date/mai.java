package com.date;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class mai extends JFrame implements ActionListener{
	private Container contentPane;
	private ImageIcon im;
	private JLabel imgbox;
	private JButton jbRegisterBook, jbReceivablesPayables;
	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3, menu3_1, menu3_2;
	private JMenuItem menu1_Company, menu1_Deal, menu1_Account, menu2_RegisterBook, menu2_ReceivablesPayables,
	menu3_1_1, menu3_1_2, menu3_1_3, menu3_1_4, menu3_2_1, menu3_2_2;
	
	public static void main(String[] args) throws IOException {
		new mai();

	}

	
	public mai() throws IOException {
		super("회계장부프로그램");
		setResizable(false);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menu1 = new JMenu("사용자등록");
		menuBar.add(menu1);

		menu1_Company = new JMenuItem("회사정보등록");
		menu1.add(menu1_Company);

		menu1_Deal = new JMenuItem("거래처 관리");
		menu1.add(menu1_Deal);

		menu1_Account = new JMenuItem("계정과목 관리");
		menu1.add(menu1_Account);

		menu2 = new JMenu("거래등록");
		menuBar.add(menu2);

		menu2_RegisterBook = new JMenuItem("거래내역등록");
		menu2_RegisterBook.addActionListener(this);
		menu2.add(menu2_RegisterBook);

		menu2_ReceivablesPayables = new JMenuItem("미수금/미지급금등록");
		menu2.add(menu2_ReceivablesPayables);

		menu3 = new JMenu("거래내역");
		menuBar.add(menu3);

		menu3_1 = new JMenu("거래내역조회");
		menu3.add(menu3_1);

		menu3_1_1 = new JMenuItem("오늘");
		menu3_1.add(menu3_1_1);

		menu3_1_2 = new JMenuItem("이번달");
		menu3_1.add(menu3_1_2);

		menu3_1_3 = new JMenuItem("이번년도");
		menu3_1.add(menu3_1_3);

		menu3_1_4 = new JMenuItem("상세검색");
		menu3_1.add(menu3_1_4);

		menu3_2 = new JMenu("통계보기");
		menuBar.add(menu3_2);

		menu3_2_1 = new JMenuItem("월별종합분석");
		menu3_2.add(menu3_2_1);

		menu3_2_2 = new JMenuItem("계정항목별분석");
		menu3_2.add(menu3_2_2);

		// 메뉴끝---------------------------------------------

		// 콘텐츠 패널 초기 설정
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		// 배경넣기
		im = new ImageIcon("E:/ijuju/java/test/DatePicker/com/date/img/mainBac.jpg");
		
		JPanel panel_mainmenu1 = new JPanel();
		panel_mainmenu1.setBounds(50, 100, 300, 50);
		getContentPane().add(panel_mainmenu1);
		panel_mainmenu1.setLayout(new GridLayout(1, 1, 10, 10));
		
		jbRegisterBook = new JButton("거래등록");
		jbRegisterBook.addActionListener(this);
		panel_mainmenu1.add(jbRegisterBook);
		
		JPanel panel_mainmenu2 = new JPanel();
		panel_mainmenu2.setBounds(50, 200, 300, 50);
		getContentPane().add(panel_mainmenu2);
		panel_mainmenu2.setLayout(new GridLayout(1,1,10,10));
		
		jbReceivablesPayables = new JButton("미수금/미지급금 관리");
		panel_mainmenu2.add(jbReceivablesPayables);
		imgbox = new JLabel(im);
		imgbox.setBounds(0, 0, 400, 400);
		contentPane.add(imgbox);

		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbRegisterBook)|| e.getSource().equals(menu2_RegisterBook))
		{
			JOptionPane.showMessageDialog(this, "거래등록하기");
			new menu_RegisterBook();
			
		}
		else
		{
			JOptionPane.showMessageDialog(this, "2번 버튼 눌렀네");
		}
		
	}
}
