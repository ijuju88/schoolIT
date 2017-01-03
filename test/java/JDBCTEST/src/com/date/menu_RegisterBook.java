package com.date;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class menu_RegisterBook extends JFrame {

	private Container contentPane;
	private JTextField jtfdate;
	private JTextField jtfmemo;
	private JTextField jtfTotPay;
	private JTextField jtfPay;
	private JTextField jtfTax;

	
	public static void main(String[] args) {
		new menu_RegisterBook();
				
	}

	
	public menu_RegisterBook() {
		super("거래등록");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 314, 415);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 3, 320, 28);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jlDivision = new JLabel("거래구분(해당 거래종류를 선택)");
		jlDivision.setBounds(6, 10, 282, 18);
		jlDivision.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(jlDivision);
		
		JButton jbEnter = new JButton("등록");
		jbEnter.setBounds(240, 5, 60, 25);
		panel_1.add(jbEnter);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 36, 320, 28);
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setLayout(null);

		
		JRadioButton jrSales = new JRadioButton("매출(수입)");
		jrSales.setBounds(30, 5, 84, 18);
		jrSales.setBackground(new Color(0, 0, 102));
		jrSales.setForeground(Color.WHITE);
		jrSales.setSelected(true);
		jrSales.setFont(new Font("굴림", Font.PLAIN, 12));
		panel_2.add(jrSales);
		
		JRadioButton jrPurchase = new JRadioButton("매입(비용)");
		jrPurchase.setBounds(126, 5, 84, 18);
		jrPurchase.setBackground(new Color(0, 0, 102));
		jrPurchase.setForeground(Color.WHITE);
		jrPurchase.setFont(new Font("굴림", Font.PLAIN, 12));
		panel_2.add(jrPurchase);
		
		JRadioButton jrAssets = new JRadioButton("자산");
		jrAssets.setBounds(222, 5, 58, 18);
		jrAssets.setBackground(new Color(0, 0, 102));
		jrAssets.setForeground(Color.WHITE);
		jrAssets.setFont(new Font("굴림", Font.PLAIN, 12));
		panel_2.add(jrAssets);
		
		ButtonGroup  group = new ButtonGroup();
		group.add(jrSales);  group.add(jrPurchase);  group.add(jrAssets);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 69, 320, 28);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
		JLabel jldatename = new JLabel("거래일자");
		jldatename.setBounds(6, 5, 56, 18);
		panel_3.add(jldatename);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd");
		Date today = new Date (); 
		String day = formatter.format ( today ); 
		
		jtfdate = new JTextField(day.toString());
		jtfdate.setBounds(62, 0, 160, 27);
		jtfdate.setEnabled(false);
		panel_3.add(jtfdate);
		jtfdate.setColumns(10);
		
		
		JButton jbdate = new JButton("선택");
		jbdate.setBounds(240, 0, 60, 24);
		
		jbdate.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				jtfdate.setText(new DatePicker(f).setPickedDate());
			}
		});
		
		panel_3.add(jbdate);
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 102, 320, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lbDeal = new JLabel("거래처");
		lbDeal.setBounds(6, 5, 56, 18);
		panel_4.add(lbDeal);
		
		JComboBox DealcomboBox = new JComboBox();
		DealcomboBox.setBounds(62, 0, 160, 27);
		DealcomboBox.setModel(new DefaultComboBoxModel(new String[] {"아아아아아아아", "아이", "오우"}));
		panel_4.add(DealcomboBox);
		
		JButton jbDeal = new JButton("추가");
		jbDeal.setBounds(240, 0, 60, 24);
		panel_4.add(jbDeal);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 135, 320, 28);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lbAccount = new JLabel("거래종류");
		lbAccount.setBounds(6, 5, 56, 18);
		panel_5.add(lbAccount);
		
		JComboBox AccountcomboBox = new JComboBox();
		AccountcomboBox.setBounds(62, 0, 160, 27);
		AccountcomboBox.setModel(new DefaultComboBoxModel(new String[] {"wn)11", "주)22", "주)33333333333"}));
		panel_5.add(AccountcomboBox);
		
		JButton jbAccount = new JButton("추가");
		jbAccount.setBounds(240, 0, 60, 24);
		panel_5.add(jbAccount);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 168, 320, 28);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lbPay = new JLabel("결제형태");
		lbPay.setBounds(6, 5, 56, 18);
		panel_6.add(lbPay);
		
		JRadioButton jrCash = new JRadioButton("현금");
		jrCash.setBounds(62, 5, 62, 18);
		jrCash.setSelected(true);
		jrCash.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_6.add(jrCash);
		
		JRadioButton jrCredit = new JRadioButton("외상");
		jrCredit.setBounds(140, 5, 70, 18);
		jrCredit.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_6.add(jrCredit);
		
		JRadioButton jrCard = new JRadioButton("카드");
		jrCard.setBounds(230, 5, 66, 18);
		jrCard.setFont(new Font("굴림", Font.PLAIN, 15));
		panel_6.add(jrCard);
		
		ButtonGroup  group2 = new ButtonGroup();
		group2.add(jrCash);  group2.add(jrCredit);  group2.add(jrCard);
  
  JPanel panel_7 = new JPanel();
  panel_7.setBounds(0, 201, 320, 28);
  panel.add(panel_7);
  panel_7.setLayout(null);
  
  JLabel jlEvidence = new JLabel("거래증빙");
  jlEvidence.setBounds(6, 5, 56, 18);
  panel_7.add(jlEvidence);
  
  
  String Evidencearr[]={"해당없음", "카드 영수증", "소득공제 현금영수증", "지출증빙용 현금영수증", "전자세금계산서", "일반세금계산서", "세금계산서면제"};
  JComboBox<String > EvidenceCcomboBox = new JComboBox<String>();
  EvidenceCcomboBox.setBounds(62, 0, 160, 26);
  EvidenceCcomboBox.setModel(new DefaultComboBoxModel<String>(Evidencearr));
  panel_7.add(EvidenceCcomboBox);
  
  JPanel panel_8 = new JPanel();
  panel_8.setBounds(0, 234, 320, 28);
  panel.add(panel_8);
  panel_8.setLayout(null);
  
  JLabel jlmemo = new JLabel("메모사항");
  jlmemo.setBounds(6, 5, 56, 18);
  panel_8.add(jlmemo);
  
  jtfmemo = new JTextField();
  jtfmemo.setBounds(62, 0, 245, 26);
  panel_8.add(jtfmemo);
  jtfmemo.setColumns(20);
  
  JPanel panel_9 = new JPanel();
  panel_9.setBounds(0, 267, 320, 28);
  panel.add(panel_9);
  panel_9.setLayout(null);
  
  JLabel jlTotPay = new JLabel("총금액");
  jlTotPay.setBounds(35, 5, 52, 22);
  jlTotPay.setFont(new Font("SansSerif", Font.PLAIN, 15));
  panel_9.add(jlTotPay);
  
  JLabel jlPay = new JLabel("공급가");
  jlPay.setBounds(130, 5, 52, 22);
  jlPay.setFont(new Font("SansSerif", Font.PLAIN, 15));
  panel_9.add(jlPay);
  
  JCheckBox jrTax = new JCheckBox("부가세");
  jrTax.setSelected(true);
  jrTax.setFont(new Font("SansSerif", Font.PLAIN, 15));
  jrTax.setBounds(220, 5, 88, 18);
  panel_9.add(jrTax);
  
  JPanel panel_10 = new JPanel();
  panel_10.setBounds(0, 300, 320, 28);
  panel.add(panel_10);
  panel_10.setLayout(null);
  
  jtfTotPay = new JTextField();
  jtfTotPay.setFont(new Font("SansSerif", Font.PLAIN, 15));
  jtfTotPay.setBounds(5, 0, 100, 26);
  panel_10.add(jtfTotPay);
  jtfTotPay.setColumns(8);
  
  jtfPay = new JTextField();
  jtfPay.setFont(new Font("SansSerif", Font.PLAIN, 15));
  jtfPay.setBounds(105, 0, 100, 26);
  panel_10.add(jtfPay);
  jtfPay.setColumns(8);
  
  jtfTax = new JTextField();
  jtfTax.setFont(new Font("SansSerif", Font.PLAIN, 15));
  jtfTax.setBounds(205, 0, 100, 26);
  panel_10.add(jtfTax);
  jtfTax.setColumns(8);
  
  JPanel panel_11 = new JPanel();
  panel_11.setBounds(0, 333, 314, 82);
  panel.add(panel_11);
  panel_11.setLayout(null);
  
  JTable jtablepay = new JTable();
  jtablepay.setLocation(6, 0);
  jtablepay.setSize(297, 75);
  panel_11.add(jtablepay);
  
		
		
		setSize(320, 450);
		setVisible(true);
	}
}
