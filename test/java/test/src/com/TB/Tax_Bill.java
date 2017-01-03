package com.TB;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tax_Bill extends JFrame implements ActionListener {

	private JTextField jtbooknum1, jtbooknum2, jtbooknum4;
	private JButton jbTax_Cel;
	private JTextField jtbooknum5;

	private JLabel jlCRno, jlCRname, jlCRboss, jlCRloc, jlCRcategory, jlCRevent, jlARno, jlARname, jlARboss, jlARloc,
			jlARcategory, jlARevent;
	private JTextField jtCRname, jtCRboss, jtCRloc, jtCRcategory, jtCRevent, jtARname, jtARboss, jtARloc, jtARcategory,
			jtARevent;

	JTable TaxTable;
	public JComboBox jbCRno, jbARno;
	private String selectRow1 = "";
	private String selectRow2 = "";
	private String selectRow3 = "";
	private float selectRow4 = 0.00f;
	private int selectRow5 = 0;
	private int selectRow6 = 0;
	private int selectRow7 = 0;
	private String selectRow8 = "";

	private JScrollPane jsp;

	private String tablestr[] = { "날짜", "품목", "규격", "수량", "단가", "공급가액", "비고" };
	private Object tablestr1[][] = new Object[4][7];

	private JLabel jlCR, jlAR, jldate, jltotal, jlcash, jlcheck, jlpromissory_note, jlcredit, jlpay;
	private JTextField jtdate, jtect, jttotal, jtcash, jtcheck, jtpromissory_note, jtcredit;

	private JComboBox<String> jcbpay;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData rsmd = null;
	private Vector crstr;
	private Vector<Vector<String>> crdata = new Vector<Vector<String>>();

	private Vector arstr;
	private Vector<Vector<String>> ardata = new Vector<Vector<String>>();
	private JLabel jllist;
	private JTextField jtlist;
	private JLabel jlect;
	private JLabel jlstandard;
	private JTextField jbstandard;
	private JLabel jlamount;
	private JTextField jbamount;
	private JLabel jlunit_price;
	private JTextField jbunit_price;
	private JTextField jbprovision;

	public Tax_Bill() throws SQLException {
		getContentPane().setLayout(null);
		setBounds(0, 0, 900, 500);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 882, 60);
		getContentPane().add(panel1);
		panel1.setLayout(null);

		JPanel panel1_1 = new JPanel();
		panel1_1.setBounds(0, 0, 238, 60);
		panel1.add(panel1_1);
		panel1_1.setLayout(null);

		// title부분
		JLabel jlTitleName = new JLabel("세금계산서");
		jlTitleName.setBounds(6, 6, 210, 47);
		jlTitleName.setHorizontalAlignment(SwingConstants.LEFT);
		jlTitleName.setForeground(Color.RED);
		jlTitleName.setFont(new Font("굴림", Font.BOLD, 34));
		panel1_1.add(jlTitleName);

		JPanel panel1_2 = new JPanel();
		panel1_2.setBounds(238, 0, 657, 60);
		panel1.add(panel1_2);
		panel1_2.setLayout(null);

		JPanel panel1_2_1 = new JPanel();
		panel1_2_1.setBounds(0, 0, 405, 60);
		panel1_2.add(panel1_2_1);
		panel1_2_1.setLayout(null);

		JButton jbTax_Ent = new JButton("저장");
		jbTax_Ent.setBounds(14, 5, 61, 43);
		panel1_2_1.add(jbTax_Ent);

		jbTax_Cel = new JButton("취소");
		jbTax_Cel.setBounds(80, 5, 61, 43);
		panel1_2_1.add(jbTax_Cel);

		JButton jbTax_Excel = new JButton("계산서엑셀");
		jbTax_Excel.setFont(new Font("굴림", Font.PLAIN, 12));
		jbTax_Excel.setBounds(146, 5, 117, 43);
		panel1_2_1.add(jbTax_Excel);

		JPanel panel1_2_2 = new JPanel();
		panel1_2_2.setBounds(405, 0, 236, 60);
		panel1_2.add(panel1_2_2);
		panel1_2_2.setLayout(null);

		JPanel panel1_2_1_1 = new JPanel();
		panel1_2_1_1.setBounds(0, 0, 236, 30);
		panel1_2_2.add(panel1_2_1_1);
		panel1_2_1_1.setLayout(null);

		JLabel jbbooknum1 = new JLabel("책번호");
		jbbooknum1.setBounds(10, 5, 42, 18);
		panel1_2_1_1.add(jbbooknum1);

		jtbooknum1 = new JTextField();
		jtbooknum1.setBounds(140, 2, 50, 24);
		panel1_2_1_1.add(jtbooknum1);
		jtbooknum1.setColumns(3);

		JLabel jbbooknum2 = new JLabel("권");
		jbbooknum2.setBounds(121, 5, 22, 18);
		panel1_2_1_1.add(jbbooknum2);

		jtbooknum2 = new JTextField();
		jtbooknum2.setBounds(70, 2, 50, 24);
		panel1_2_1_1.add(jtbooknum2);
		jtbooknum2.setColumns(3);

		JLabel jbbooknum3 = new JLabel("호");
		jbbooknum3.setBounds(197, 5, 22, 18);
		panel1_2_1_1.add(jbbooknum3);

		JPanel panel1_2_1_2 = new JPanel();
		panel1_2_1_2.setBounds(0, 30, 236, 30);
		panel1_2_2.add(panel1_2_1_2);
		panel1_2_1_2.setLayout(null);

		JLabel jbbooknum4 = new JLabel("일련번호");
		jbbooknum4.setBounds(10, 5, 64, 21);
		panel1_2_1_2.add(jbbooknum4);

		jtbooknum4 = new JTextField();
		jtbooknum4.setBounds(70, 2, 64, 24);
		panel1_2_1_2.add(jtbooknum4);
		jtbooknum4.setColumns(3);

		JLabel jbbooknum5 = new JLabel("-");
		jbbooknum5.setBounds(140, 5, 15, 21);
		panel1_2_1_2.add(jbbooknum5);

		jtbooknum5 = new JTextField();
		jtbooknum5.setColumns(3);
		jtbooknum5.setBounds(155, 3, 64, 24);
		panel1_2_1_2.add(jtbooknum5);

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 60, 882, 170);
		getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(1, 2));

		JPanel panel2_1 = new JPanel();
		panel2.add(panel2_1);
		panel2_1.setLayout(null);

		jlCR = new JLabel("     공급자");
		jlCR.setBounds(0, 0, 91, 170);
		panel2_1.add(jlCR);

		// 공급자부분
		jlCRno = new JLabel("등록번호");
		jlCRno.setBounds(105, 5, 74, 27);
		panel2_1.add(jlCRno);

		jbCRno = new JComboBox<>();
		jbCRno.setFont(new Font("굴림", Font.PLAIN, 12));
		jbCRno.setBounds(190, 2, 240, 27);
		panel2_1.add(jbCRno);
		jbCRno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object critem = jbCRno.getSelectedItem();
				jtCRname.setText((String) crstr.get(0));
				jtCRboss.setText((String) crstr.get(1));
				jtCRloc.setText((String) crstr.get(2));
				jtCRcategory.setText((String) crstr.get(3));
				jtCRevent.setText((String) crstr.get(4));

			}
		});

		jlCRname = new JLabel("상호");
		jlCRname.setBounds(105, 32, 74, 24);
		panel2_1.add(jlCRname);

		jtCRname = new JTextField();
		jtCRname.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRname.setBounds(190, 29, 240, 27);
		panel2_1.add(jtCRname);
		jtCRname.setColumns(10);

		jlCRboss = new JLabel("성명");
		jlCRboss.setBounds(105, 59, 74, 24);
		panel2_1.add(jlCRboss);

		jtCRboss = new JTextField();
		jtCRboss.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRboss.setBounds(190, 56, 240, 27);
		panel2_1.add(jtCRboss);
		jtCRboss.setColumns(10);

		jlCRloc = new JLabel("사업장주소");
		jlCRloc.setBounds(105, 86, 74, 24);
		panel2_1.add(jlCRloc);

		jtCRloc = new JTextField();
		jtCRloc.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRloc.setBounds(190, 83, 240, 27);
		panel2_1.add(jtCRloc);
		jtCRloc.setColumns(10);

		jlCRcategory = new JLabel("업태");
		jlCRcategory.setBounds(105, 113, 74, 24);
		panel2_1.add(jlCRcategory);

		jtCRcategory = new JTextField();
		jtCRcategory.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRcategory.setBounds(190, 110, 240, 27);
		panel2_1.add(jtCRcategory);
		jtCRcategory.setColumns(10);

		jlCRevent = new JLabel("종목");
		jlCRevent.setBounds(105, 140, 74, 24);
		panel2_1.add(jlCRevent);

		jtCRevent = new JTextField();
		jtCRevent.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRevent.setBounds(190, 137, 240, 27);
		panel2_1.add(jtCRevent);
		jtCRevent.setColumns(10);

		JPanel panel2_2 = new JPanel();
		panel2.add(panel2_2);
		panel2_2.setLayout(null);

		jlAR = new JLabel("  공급받는자");
		jlAR.setFont(new Font("굴림", Font.PLAIN, 15));
		jlAR.setBounds(0, 0, 91, 170);
		panel2_2.add(jlAR);

		// 공급받는자부분
		jlARno = new JLabel("등록번호");
		jlARno.setBounds(105, 2, 74, 27);
		panel2_2.add(jlARno);

		jbARno = new JComboBox<>();
		jbARno.setFont(new Font("굴림", Font.PLAIN, 12));
		jbARno.setBounds(190, 2, 240, 27);
		panel2_2.add(jbARno);
		jbARno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object aritem = jbARno.getSelectedItem();
				jtARname.setText((String) arstr.get(0));
				jtARboss.setText((String) arstr.get(1));
				jtARloc.setText((String) arstr.get(2));
				jtARcategory.setText((String) arstr.get(3));
				jtARevent.setText((String) arstr.get(4));

			}
		});

		jlARname = new JLabel("상호");
		jlARname.setBounds(105, 29, 74, 27);
		panel2_2.add(jlARname);

		jtARname = new JTextField();
		jtARname.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARname.setBounds(190, 29, 240, 27);
		panel2_2.add(jtARname);
		jtARname.setColumns(10);

		jlARboss = new JLabel("성명");
		jlARboss.setBounds(105, 59, 74, 27);
		panel2_2.add(jlARboss);

		jtARboss = new JTextField();
		jtARboss.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARboss.setBounds(190, 56, 240, 27);
		panel2_2.add(jtARboss);
		jtARboss.setColumns(10);

		jlARloc = new JLabel("사업장주소");
		jlARloc.setBounds(105, 83, 74, 27);
		panel2_2.add(jlARloc);

		jtARloc = new JTextField();
		jtARloc.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARloc.setBounds(190, 83, 240, 27);
		panel2_2.add(jtARloc);
		jtARloc.setColumns(10);

		jlARcategory = new JLabel("업태");
		jlARcategory.setBounds(105, 110, 74, 27);
		panel2_2.add(jlARcategory);

		jtARcategory = new JTextField();
		jtARcategory.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARcategory.setBounds(190, 110, 240, 27);
		panel2_2.add(jtARcategory);
		jtARcategory.setColumns(10);

		jlARevent = new JLabel("종목");
		jlARevent.setBounds(105, 138, 74, 24);
		panel2_2.add(jlARevent);

		jtARevent = new JTextField();
		jtARevent.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARevent.setBounds(190, 137, 240, 27);
		panel2_2.add(jtARevent);
		jtARevent.setColumns(10);

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 230, 882, 48);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		jldate = new JLabel("일자");
		jldate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jldate.setBounds(14, 2, 41, 18);
		panel3.add(jldate);

		// 날짜선택
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date today = new Date();
		String day = formatter.format(today);

		jtdate = new JTextField(day);
		jtdate.setBounds(14, 20, 90, 25);
		panel3.add(jtdate);
		jtdate.setColumns(10);

		JButton jbdate = new JButton("▼");
		jbdate.setFont(new Font("굴림", Font.PLAIN, 8));
		jbdate.setBounds(64, 4, 40, 18);
		panel3.add(jbdate);

		jbdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// create frame new object f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				jtdate.setText(new DatePicker(f).setPickedDate());
			}
		});

		jllist = new JLabel("품목");
		jllist.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jllist.setBounds(120, 2, 41, 18);
		panel3.add(jllist);

		jtlist = new JTextField("");
		jtlist.setColumns(10);
		jtlist.setBounds(120, 20, 90, 25);
		panel3.add(jtlist);

		jlstandard = new JLabel("규격");
		jlstandard.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jlstandard.setBounds(225, 2, 41, 18);
		panel3.add(jlstandard);

		jbstandard = new JTextField("");
		jbstandard.setColumns(5);
		jbstandard.setBounds(225, 20, 60, 25);
		panel3.add(jbstandard);

		jlamount = new JLabel("수량");
		jlamount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jlamount.setBounds(300, 2, 41, 18);
		panel3.add(jlamount);

		jbamount = new JTextField("");
		jbamount.setColumns(5);
		jbamount.setBounds(300, 20, 60, 25);
		panel3.add(jbamount);

		jlunit_price = new JLabel("단가");
		jlunit_price.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jlunit_price.setBounds(370, 2, 41, 18);
		panel3.add(jlunit_price);

		jbunit_price = new JTextField("");
		jbunit_price.setColumns(10);
		jbunit_price.setBounds(370, 20, 90, 25);
		panel3.add(jbunit_price);

		JLabel jlprovision = new JLabel("공급가액");
		jlprovision.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jlprovision.setBounds(475, 2, 70, 18);
		panel3.add(jlprovision);

		jbprovision = new JTextField("");
		jbprovision.setColumns(10);
		jbprovision.setBounds(475, 20, 90, 25);
		panel3.add(jbprovision);

		jlect = new JLabel("비고");
		jlect.setFont(new Font("SansSerif", Font.PLAIN, 15));
		jlect.setBounds(577, 2, 41, 18);
		panel3.add(jlect);

		jtect = new JTextField();
		jtect.setBounds(577, 20, 218, 25);
		panel3.add(jtect);
		jtect.setColumns(30);
		
		JButton jbent1 = new JButton("저장");
		jbent1.setBounds(809, 2, 61, 41);
		panel3.add(jbent1);

		JPanel panel4 = new JPanel();
		panel4.setBounds(0, 275, 882, 100);
		getContentPane().add(panel4);
		panel4.setLayout(null);

		// 테이블
		DefaultTableModel model = new DefaultTableModel(tablestr1, tablestr);
		TaxTable = new JTable(model);
		TaxTable .setBackground(SystemColor.inactiveCaptionBorder);

		// 격자선
		TaxTable.setGridColor(Color.gray); // 격자선색
		TaxTable .setShowGrid(true); // 격자선그릴지 여부

		// 칸 너비 지정중
		TaxTable .getColumnModel().getColumn(0).setPreferredWidth(60);
		TaxTable .getColumnModel().getColumn(2).setPreferredWidth(40);
		TaxTable .getColumnModel().getColumn(4).setPreferredWidth(70);
		TaxTable .getColumnModel().getColumn(5).setPreferredWidth(80);
		TaxTable .getColumnModel().getColumn(6).setPreferredWidth(80);
		
		TaxTable .setBounds(0, 0, 895, 160);

		TaxTable .setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일선택

		jsp = new JScrollPane(TaxTable );
		jsp.setSize(881, 100);
		jsp.setLocation(0, 0);
		panel4.add(jsp);

		JPanel panel5 = new JPanel();
		panel5.setBounds(0, 375, 882, 25);
		getContentPane().add(panel5);

		JPanel panel6 = new JPanel();
		panel6.setBounds(0, 400, 882, 45);
		getContentPane().add(panel6);
		panel6.setLayout(new GridLayout(2, 6));

		jltotal = new JLabel("합계금액");
		panel6.add(jltotal);

		jlcash = new JLabel("현금");
		panel6.add(jlcash);

		jlcheck = new JLabel("수표");
		panel6.add(jlcheck);

		jlpromissory_note = new JLabel("어음");
		panel6.add(jlpromissory_note);

		jlcredit = new JLabel("외상미수금");
		panel6.add(jlcredit);

		jlpay = new JLabel("이금액을");
		panel6.add(jlpay);

		jttotal = new JTextField();
		jttotal.setEditable(false);
		panel6.add(jttotal);
		jttotal.setColumns(20);

		jtcash = new JTextField();
		jtcash.setColumns(20);
		panel6.add(jtcash);

		jtcheck = new JTextField();
		jtcheck.setColumns(20);
		panel6.add(jtcheck);

		jtpromissory_note = new JTextField();
		jtpromissory_note.setColumns(20);
		panel6.add(jtpromissory_note);

		jtcredit = new JTextField();
		jtcredit.setColumns(20);
		panel6.add(jtcredit);

		jcbpay = new JComboBox<String>();
		jcbpay.setModel(new DefaultComboBoxModel(new String[] {"청구", "영수"}));
		panel6.add(jcbpay);

		setVisible(true);
	}

	public static void main(String[] args) throws SQLException {
		new Tax_Bill();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
