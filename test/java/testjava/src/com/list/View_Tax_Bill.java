package com.list;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class View_Tax_Bill extends JFrame {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	Date today = new Date();
	String day = formatter.format(today);
	Vector<Vector> data1 = null;
	Vector<String> in = new Vector<>();
	Vector<String> title = new Vector<>();

	int mount, unit_price, tax_amount;
	int provision;
	String ect = "";
	Object critem, aritem;

	private JLabel jltotal, jlcash, jlcheck, jlpromissory_note, jlcredit, jlpay;
	JTextField jttotal, jtcash, jtcheck, jtpromissory_note, jtcredit;

	private int tot = 0, cash = 0, check = 0, promissory = 0, credit = 0;

	private JTextField jtbooknum1, jtbooknum2, jtbooknum4;
	private JTextField jtbooknum5;

	private JLabel jlCRno, jlCRname, jlCRboss, jlCRloc, jlCRcategory, jlCRevent, jlARno, jlARname, jlARboss, jlARloc,
			jlARcategory, jlARevent;
	private JTextField jtCRname, jtCRboss, jtCRloc, jtCRcategory, jtCRevent, jtARname, jtARboss, jtARloc, jtARcategory,
			jtARevent;

	private JLabel jlCR, jlAR;
	JTextField jtect;

	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql;
	private Vector<String> crstr;
	private Vector<Vector<String>> crdata = new Vector<Vector<String>>();

	private Vector<String> arstr;
	private Vector<Vector<String>> ardata = new Vector<Vector<String>>();

	private Vector<Object> totstr;
	private Vector<Vector<Object>> totdata = new Vector<Vector<Object>>();

	private JTextField jtCRno;
	private JTextField jtARno;

	String[] str = null;
	String daynum = null;
	String daynum1 = null;
	private JPanel panel4;
	private JScrollPane scrollPane;
	private JTextField jtpay;

	String stamp = null;

	// 화면 구성과 화면 출력
	public View_Tax_Bill(String row1, String row2, String row3) {
		getContentPane().setLayout(null);

		setBounds(0, 0, 900, 600);

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

		JButton jbTax_Bill_ent = new JButton("확인");
		jbTax_Bill_ent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jbTax_Bill_ent.setBounds(10, 5, 60, 43);
		panel1_2_1.add(jbTax_Bill_ent);

		JButton jbTax_Bill_Excel1 = new JButton("세금계산서엑셀");
		jbTax_Bill_Excel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					String crname = jtCRname.getText();
					String crboss = jtCRboss.getText();
					String crloc = jtCRloc.getText();
					String crcategory = jtCRcategory.getText();
					String crevent = jtCRevent.getText();

					String arname = jtARname.getText();
					String arboss = jtARboss.getText();
					String arloc = jtARloc.getText();
					String arcategory = jtARcategory.getText();
					String arevent = jtARevent.getText();

					int total = Integer.parseInt(jttotal.getText());
					int cash = Integer.parseInt(jtcash.getText());
					int check = Integer.parseInt(jtcheck.getText());
					int promissory = Integer.parseInt(jtpromissory_note.getText());
					int credit = Integer.parseInt(jtcredit.getText());
					String pay = jtpay.getText();

					new ViewTax_BillexcelAction(row1, row2, crname, crboss, crloc, crcategory, crevent, stamp, row3,
							arname, arboss, arloc, arcategory, arevent, data1, total, cash, check, promissory, credit,
							pay);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jbTax_Bill_Excel1.setFont(new Font("굴림", Font.PLAIN, 12));
		jbTax_Bill_Excel1.setBounds(80, 5, 140, 43);
		panel1_2_1.add(jbTax_Bill_Excel1);

		JButton jbTax_Bill_Excel2 = new JButton("거래명세서엑셀");
		jbTax_Bill_Excel2.setFont(new Font("굴림", Font.PLAIN, 12));
		jbTax_Bill_Excel2.setBounds(230, 5, 140, 43);
		panel1_2_1.add(jbTax_Bill_Excel2);

		jbTax_Bill_Excel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewTax_BillexcelAction2();
			}
		});

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
		jtbooknum1.setEditable(false);
		jtbooknum1.setBounds(140, 2, 50, 24);
		panel1_2_1_1.add(jtbooknum1);
		jtbooknum1.setColumns(3);

		JLabel jbbooknum2 = new JLabel("권");
		jbbooknum2.setBounds(121, 5, 22, 18);
		panel1_2_1_1.add(jbbooknum2);

		jtbooknum2 = new JTextField();
		jtbooknum2.setEditable(false);
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

		String[] str = row1.split("-");
		String daynum = str[0];
		String daynum1 = str[1];
		jtbooknum4 = new JTextField(daynum);
		jtbooknum4.setEditable(false);
		jtbooknum4.setBounds(70, 2, 64, 24);
		panel1_2_1_2.add(jtbooknum4);
		jtbooknum4.setColumns(3);

		JLabel jbbooknum5 = new JLabel("-");
		jbbooknum5.setBounds(140, 5, 15, 21);
		panel1_2_1_2.add(jbbooknum5);

		jtbooknum5 = new JTextField(daynum1);
		jtbooknum5.setEditable(false);
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

		jtCRno = new JTextField(row2);
		jtCRno.setEditable(false);
		jtCRno.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRno.setColumns(15);
		jtCRno.setBounds(190, 2, 240, 27);
		panel2_1.add(jtCRno);
		CRsettext(row2);

		jlCRname = new JLabel("상호");
		jlCRname.setBounds(105, 32, 74, 24);
		panel2_1.add(jlCRname);

		jtCRname = new JTextField((String) crstr.get(0));
		jtCRname.setEditable(false);
		jtCRname.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRname.setBounds(190, 29, 240, 27);
		panel2_1.add(jtCRname);
		jtCRname.setColumns(10);

		jlCRboss = new JLabel("성명");
		jlCRboss.setBounds(105, 59, 74, 24);
		panel2_1.add(jlCRboss);

		jtCRboss = new JTextField((String) crstr.get(1));
		jtCRboss.setEditable(false);
		jtCRboss.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRboss.setBounds(190, 56, 240, 27);
		panel2_1.add(jtCRboss);
		jtCRboss.setColumns(10);

		jlCRloc = new JLabel("사업장주소");
		jlCRloc.setBounds(105, 86, 74, 24);
		panel2_1.add(jlCRloc);

		jtCRloc = new JTextField((String) crstr.get(2));
		jtCRloc.setEditable(false);
		jtCRloc.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRloc.setBounds(190, 83, 240, 27);
		panel2_1.add(jtCRloc);
		jtCRloc.setColumns(10);

		jlCRcategory = new JLabel("업태");
		jlCRcategory.setBounds(105, 113, 74, 24);
		panel2_1.add(jlCRcategory);

		jtCRcategory = new JTextField((String) crstr.get(3));
		jtCRcategory.setEditable(false);
		jtCRcategory.setFont(new Font("굴림", Font.PLAIN, 12));
		jtCRcategory.setBounds(190, 110, 240, 27);
		panel2_1.add(jtCRcategory);
		jtCRcategory.setColumns(10);

		jlCRevent = new JLabel("종목");
		jlCRevent.setBounds(105, 140, 74, 24);
		panel2_1.add(jlCRevent);

		jtCRevent = new JTextField((String) crstr.get(4));
		jtCRevent.setEditable(false);
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

		jtARno = new JTextField(row3);
		jtARno.setEditable(false);
		jtARno.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARno.setColumns(15);
		jtARno.setBounds(190, 2, 240, 27);
		panel2_2.add(jtARno);
		ARsettext(row3);

		jlARname = new JLabel("상호");
		jlARname.setBounds(105, 29, 74, 27);
		panel2_2.add(jlARname);

		jtARname = new JTextField((String) arstr.get(1));
		jtARname.setEditable(false);
		jtARname.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARname.setBounds(190, 29, 240, 27);
		panel2_2.add(jtARname);
		jtARname.setColumns(10);

		jlARboss = new JLabel("성명");
		jlARboss.setBounds(105, 59, 74, 27);
		panel2_2.add(jlARboss);

		jtARboss = new JTextField((String) arstr.get(2));
		jtARboss.setEditable(false);
		jtARboss.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARboss.setBounds(190, 56, 240, 27);
		panel2_2.add(jtARboss);
		jtARboss.setColumns(10);

		jlARloc = new JLabel("사업장주소");
		jlARloc.setBounds(105, 83, 74, 27);
		panel2_2.add(jlARloc);

		jtARloc = new JTextField((String) arstr.get(3));
		jtARloc.setEditable(false);
		jtARloc.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARloc.setBounds(190, 83, 240, 27);
		panel2_2.add(jtARloc);
		jtARloc.setColumns(10);

		jlARcategory = new JLabel("업태");
		jlARcategory.setBounds(105, 110, 74, 27);
		panel2_2.add(jlARcategory);

		jtARcategory = new JTextField((String) arstr.get(4));
		jtARcategory.setEditable(false);
		jtARcategory.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARcategory.setBounds(190, 110, 240, 27);
		panel2_2.add(jtARcategory);
		jtARcategory.setColumns(10);

		jlARevent = new JLabel("종목");
		jlARevent.setBounds(105, 138, 74, 24);
		panel2_2.add(jlARevent);

		jtARevent = new JTextField((String) arstr.get(5));
		jtARevent.setEditable(false);
		jtARevent.setFont(new Font("굴림", Font.PLAIN, 12));
		jtARevent.setBounds(190, 137, 240, 27);
		panel2_2.add(jtARevent);
		jtARevent.setColumns(10);

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 230, 882, 30);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		title = new Vector<>();
		data1 = new Vector<>();

		// 테이블에 사용될 타이틀 벡터 초기화
		title.add("날짜");
		title.add("품목");
		title.add("규격");
		title.add("수량");
		title.add("단가");
		title.add("공급가액");
		title.add("세액");
		title.add("비고");

		getData(row1);

		JTable table_1 = new JTable(data1, title);
		table_1.setEnabled(false);
		 System.out.println("data:"+data1);

		panel4 = new JPanel();
		panel4.setBounds(0, 262, 872, 231);
		getContentPane().add(panel4);
		panel4.setLayout(null);

		scrollPane = new JScrollPane(table_1);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(12, 0, 846, 227);
		panel4.add(scrollPane);

		JPanel panel5 = new JPanel();
		panel5.setBounds(12, 490, 860, 56);
		getContentPane().add(panel5);
		panel5.setLayout(new GridLayout(2, 6));

		jltotal = new JLabel("합계금액");
		panel5.add(jltotal);

		jlcash = new JLabel("현금");
		panel5.add(jlcash);

		jlcheck = new JLabel("수표");
		panel5.add(jlcheck);

		jlpromissory_note = new JLabel("어음");
		panel5.add(jlpromissory_note);

		jlcredit = new JLabel("외상미수금");
		panel5.add(jlcredit);

		jlpay = new JLabel("이금액을");
		panel5.add(jlpay);

		gettotData(row1);
		// System.out.println("호호:"+(String)totstr.get(2));

		jttotal = new JTextField((String) totstr.get(0));
		jttotal.setEditable(false);
		panel5.add(jttotal);
		jttotal.setColumns(20);

		jtcash = new JTextField((String) totstr.get(1));
		jtcash.setEditable(false);
		jtcash.setColumns(20);
		panel5.add(jtcash);

		jtcheck = new JTextField((String) totstr.get(2));
		jtcheck.setEditable(false);
		jtcheck.setColumns(20);
		panel5.add(jtcheck);

		jtpromissory_note = new JTextField((String) totstr.get(3));
		jtpromissory_note.setEditable(false);
		jtpromissory_note.setColumns(20);
		panel5.add(jtpromissory_note);

		jtcredit = new JTextField((String) totstr.get(4));
		jtcredit.setEditable(false);
		jtcredit.setColumns(20);
		panel5.add(jtcredit);

		jtpay = new JTextField((String) totstr.get(5));
		jtpay.setEditable(false);
		jtpay.setColumns(20);
		panel5.add(jtpay);
		// System.out.println(data1);

		// 도장
		stamp = (String) crstr.get(5);
		System.out.println(stamp);
		setSize(900, 600);
		setVisible(true);

	}

	private void getData(String row1) {

		try {
			conn();

			stmt = conn.createStatement();
			String str = row1;
			String sql = "select * from Tax_bill where tbnum='" + str + "'";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				in = new Vector<>();

				in.add(rs.getString(2).toString().substring(0, 10));
				in.add(rs.getString(3));
				in.add(rs.getString(4));
				in.add(rs.getString(5));
				in.add(rs.getString(6));
				in.add(rs.getString(7));
				in.add(rs.getString(8));
				in.add(rs.getString(9));

				data1.add(in);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	// 밑에내용
	private void gettotData(String row1) {
		try {
			stmt = conn.createStatement();
			String str = row1;
			String sql = "select * from Tax_bill_key where tbnum='" + str + "'";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				totstr = new Vector<Object>();
				totstr.addElement(rs.getString("TBTOTAL"));
				totstr.addElement(rs.getString("TBcash"));
				totstr.addElement(rs.getString("TBcheck"));
				totstr.addElement(rs.getString("TBpromissory"));
				totstr.addElement(rs.getString("TBcredit"));
				totstr.addElement(rs.getString("TBpay"));
				totstr.addElement(totstr);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회사 사업번호 선택시
	private void CRsettext(String row2) {
		try {
			conn();
			pstmt = conn.prepareStatement("select * from COMPANYREGISTRATION where CNO=?"); // SQL
			pstmt.setString(1, (String) row2); // 질의
			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다.

			while (rs.next()) {
				crstr = new Vector<String>();
				crstr.addElement(rs.getString("CNAME"));
				crstr.addElement(rs.getString("CBOSS"));
				crstr.addElement(rs.getString("CLOC"));
				crstr.addElement(rs.getString("CCATEGORY"));
				crstr.addElement(rs.getString("CEVENT"));
				crstr.addElement(rs.getString("CSTAMP"));
				crdata.addElement(crstr);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 거래처 사업번호 선택시
	private void ARsettext(String row3) {
		try {
			conn();
			pstmt = conn.prepareStatement("select * from Accountregistration where ANO=?"); // SQL
			pstmt.setString(1, (String) row3); // 질의
			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다.

			while (rs.next()) {
				arstr = new Vector<String>();
				arstr.addElement(rs.getString("ANO"));
				arstr.addElement(rs.getString("ANAME"));
				arstr.addElement(rs.getString("ABOSS"));
				arstr.addElement(rs.getString("ALOC"));
				arstr.addElement(rs.getString("ACATEGORY"));
				arstr.addElement(rs.getString("AEVENT"));
				ardata.addElement(arstr);
			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void conn() {
		// 오라클 드라이버 선언
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 오라클 DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxju88", "1234");
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
	}
}
