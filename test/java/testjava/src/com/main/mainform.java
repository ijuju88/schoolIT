package com.main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import com.AR.Account_registration;
import com.CR.Company_registration;
import com.T.Tax;
import com.TB.Tax_Bill;
import com.list.Tax_Bill_List;
import com.list1.Tax_List;

@SuppressWarnings("serial")
public class mainform extends JFrame implements ActionListener {
	private Container contentPane;
	private ImageIcon im;
	private JLabel imgbox;
	private JButton jbRegisterBook, jbReceivablesPayables;
	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3, menu3_1;
	private JMenuItem menu1_Company, menu1_Deal, menu2_RegisterBook, menu2_ReceivablesPayables,
			menu3_1_1, menu3_1_2;

	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		new mainform();

	}

	public mainform() throws IOException {
		super("회계장부프로그램");
		setResizable(false);

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("SansSerif", Font.PLAIN, 20));
		setJMenuBar(menuBar);

		menu1 = new JMenu("사용자등록");
		menu1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menuBar.add(menu1);

		menu1_Company = new JMenuItem("회사정보등록");
		menu1_Company.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menu1_Company.addActionListener(this);
		menu1.add(menu1_Company);

		menu1_Deal = new JMenuItem("거래처 관리");
		menu1_Deal.setFont(new Font("SansSerif", Font.PLAIN, 15));
		menu1_Deal.addActionListener(this);
		menu1.add(menu1_Deal);

		menu2 = new JMenu("거래등록");
		menu2.setFont(new Font("Dialog", Font.PLAIN, 15));
		menuBar.add(menu2);

		menu2_RegisterBook = new JMenuItem("거래명세표등록");
		menu2_RegisterBook.setFont(new Font("Dialog", Font.PLAIN, 15));
		menu2_RegisterBook.addActionListener(this);
		menu2.add(menu2_RegisterBook);

		menu2_ReceivablesPayables = new JMenuItem("계산서등록");
		menu2_ReceivablesPayables.setFont(new Font("Dialog", Font.PLAIN, 15));
		menu2_ReceivablesPayables.addActionListener(this);
		menu2.add(menu2_ReceivablesPayables);

		menu3 = new JMenu("거래내역");
		menu3.setFont(new Font("Dialog", Font.PLAIN, 15));
		menuBar.add(menu3);

		menu3_1 = new JMenu("거래내역조회");
		menu3_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		menu3.add(menu3_1);

		menu3_1_1 = new JMenuItem("세금계산서조회");
		menu3_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		menu3_1_1.addActionListener(this);
		menu3_1.add(menu3_1_1);

		menu3_1_2 = new JMenuItem("계산서조회");
		menu3_1_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		menu3_1_2.addActionListener(this);
		menu3_1.add(menu3_1_2);


		// 메뉴끝---------------------------------------------

		// 콘텐츠 패널 초기 설정
		contentPane = getContentPane();
		contentPane.setLayout(null);

		// 배경넣기
		im = new ImageIcon("D:/ijuju/test/java/schooljava/testjava/light.jpg");

		JPanel panel_mainmenu1 = new JPanel();
		panel_mainmenu1.setBounds(50, 100, 300, 50);
		getContentPane().add(panel_mainmenu1);
		panel_mainmenu1.setLayout(new GridLayout(1, 1, 10, 10));

		jbRegisterBook = new JButton("세금명세서등록");
		jbRegisterBook.addActionListener(this);
		panel_mainmenu1.add(jbRegisterBook);

		JPanel panel_mainmenu2 = new JPanel();
		panel_mainmenu2.setBounds(50, 200, 300, 50);
		getContentPane().add(panel_mainmenu2);
		panel_mainmenu2.setLayout(new GridLayout(1, 1, 10, 10));

		jbReceivablesPayables = new JButton("명세서등록");
		jbReceivablesPayables.addActionListener(this);
		panel_mainmenu2.add(jbReceivablesPayables);
		imgbox = new JLabel(im);
		imgbox.setBounds(0, 0, 394, 440);
		contentPane.add(imgbox);

		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand());
		//System.out.println(e.getSource().toString());
		if (e.getSource().equals(jbRegisterBook) || e.getSource().equals(menu2_RegisterBook)) {
			Tax_Bill second = new Tax_Bill();
			second.eventProc();

		} else if (e.getSource().equals(menu1_Company)) {
			new Company_registration();
		} else if (e.getSource().equals(menu1_Deal)) {
			new Account_registration();
		} else if(e.getSource().equals(menu3_1_1)){
			new Tax_Bill_List();
		}else if(e.getSource().equals(menu2_ReceivablesPayables)|| e.getSource().equals(jbReceivablesPayables)){
			Tax second1 = new Tax();
			second1.eventProc();
		}else if(e.getSource().equals(menu3_1_2)){
			new Tax_List();
		}else {
			JOptionPane.showMessageDialog(this, "준비중");
		}

	}
}
