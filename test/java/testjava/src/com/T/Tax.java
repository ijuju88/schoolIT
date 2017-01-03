package com.T;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.main.DatePicker;

public class Tax extends JFrame {
	private static final long serialVersionUID = 1L;
	
	MyTableModel model = new MyTableModel();
	JTable table = new JTable(model);
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatternum = new SimpleDateFormat("yyMMdd");
	SimpleDateFormat formatternum1 = new SimpleDateFormat("HHmmss");
	Date today = new Date();
	String day = formatter.format(today);
	String daynum = formatternum.format(today);
	String daynum1 = formatternum1.format(today);

	int mount, unit_price, tax_amount;
	int provision;
	String ect = "";
	JButton jbsetrow = new JButton("항목추가");
	JTextField jtdate;
	Object critem, aritem;

	private JLabel jltotal, jlcash, jlcheck, jlpromissory_note, jlcredit, jlpay;
	JTextField jttotal, jtcash, jtcheck, jtpromissory_note, jtcredit;
	JComboBox jcbpay;

	private int tot = 0, cash = 0, check = 0, promissory = 0, credit = 0;

	private JTextField jtbooknum1, jtbooknum2, jtbooknum4;
	private JButton jbTax_Cel;
	private JTextField jtbooknum5;

	private JLabel jlCRno, jlCRname, jlCRboss, jlCRloc, jlCRcategory, jlCRevent, jlARno, jlARname, jlARboss, jlARloc,
			jlARcategory, jlARevent;
	private JTextField jtCRname, jtCRboss, jtCRloc, jtCRcategory, jtCRevent, jtARname, jtARboss, jtARloc, jtARcategory,
			jtARevent;

	public JComboBox jbCRno, jbARno;

	private JScrollPane jsp;

	private JLabel jlCR, jlAR;
	JTextField jtect;

	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs = null;
	private ResultSetMetaData rsmd = null;
	String sql;
	private Vector crstr;
	private Vector<Vector<String>> crdata = new Vector<Vector<String>>();

	private Vector arstr;
	private Vector<Vector<String>> ardata = new Vector<Vector<String>>();
	private JButton jbdelrow;

	private Vector<Object> init, temp;

	// 화면 구성과 화면 출력
	public Tax() {
		super("계산서 작성");
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
		JLabel jlTitleName = new JLabel("계산서");
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
		jbTax_Ent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cash = Integer.parseInt(jtcash.getText());
				int check = Integer.parseInt(jtcheck.getText());
				int promissory_note = Integer.parseInt(jtpromissory_note.getText());
				int credit = Integer.parseInt(jtcredit.getText());

				int pay = cash + check + promissory_note + credit;
				System.out.println("합계 : " + pay);
				if (tot != pay) {
					JOptionPane.showMessageDialog(null, "합계금액하고 맞지않습니다", "계산오류", JOptionPane.ERROR_MESSAGE);
				} else {
					Object comboboxpay = jcbpay.getSelectedItem();

					inputdb(daynum, daynum1, critem, aritem, jtCRname, jtCRboss, jtCRloc, jtCRcategory, jtCRevent,
							aritem, jtARname, jtARboss, jtARloc, jtARcategory, jtARevent, tot, cash, check,
							promissory_note, credit, comboboxpay, table);

					inputdbnum(daynum, daynum1, critem, aritem, tot, cash, check, promissory_note, credit, comboboxpay);

				}
			}

			
			public void disconn() {
				// 연결 끊기
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (pstmt1 != null)
						pstmt1.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

			public void inputdb(String daynum, String daynum1, Object critem, Object aritem, JTextField jtCRname,
					JTextField jtCRboss, JTextField jtCRloc, JTextField jtCRcategory, JTextField jtCRevent,
					Object aritem2, JTextField jtARname, JTextField jtARboss, JTextField jtARloc,
					JTextField jtARcategory, JTextField jtARevent, int tot, int cash, int check, int promissory_note,
					int credit, Object comboboxpay, JTable table) {

				try {
					// 연결s
					conn();

					String sql = "insert into Tax values(?,?,?,?,?,?,?,?)";
					String sql1 = "insert into Tax_key values(?,?,?,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt1 = conn.prepareStatement(sql1);

					pstmt1.setString(1, daynum + "-" + daynum1);
					pstmt1.setString(2, (String) critem);
					pstmt1.setString(3, (String) aritem);
					pstmt1.setInt(4, tot);
					pstmt1.setInt(5, cash);
					pstmt1.setInt(6, check);
					pstmt1.setInt(7, promissory_note);
					pstmt1.setInt(8, credit);
					pstmt1.setString(9, (String) comboboxpay);

					// System.out.println(critem);

					for (int row = 0; row < table.getRowCount(); row++) {
						String Row1 = (String) table.getValueAt(row, 0);
						String Row2 = (String) table.getValueAt(row, 1);
						String Row3 = (String) table.getValueAt(row, 2);
						int Row4 = Integer.parseInt(String.valueOf(table.getValueAt(row, 3)));
						int Row5 = Integer.parseInt(String.valueOf(table.getValueAt(row, 4)));
						int Row6 = Integer.parseInt(String.valueOf(table.getValueAt(row, 5)));
						String Row7 = (String) table.getValueAt(row, 6);

						pstmt.setString(1, daynum + "-" + daynum1);
						pstmt.setString(2, Row1);
						pstmt.setString(3, Row2);
						pstmt.setString(4, Row3);
						pstmt.setInt(5, Row4);
						pstmt.setInt(6, Row5);
						pstmt.setInt(7, Row6);
						pstmt.setString(8, Row7);

						pstmt.addBatch();
						pstmt.clearParameters();
					}

					// inputdbnum();
					pstmt.executeBatch();

					pstmt.executeUpdate();
				} catch (SQLException se) {
					System.err.println(se.getMessage());
					return;
				} finally {
					disconn();
					// JOptionPane.showMessageDialog(null, "저장이 완료되었습니다", "성공",
					// JOptionPane.YES_OPTION);
					jtCRname.setText("");
					jtCRboss.setText("");
					jtCRloc.setText("");
					jtCRcategory.setText("");
					jtCRevent.setText("");

					jtARname.setText("");
					jtARboss.setText("");
					jtARloc.setText("");
					jtARcategory.setText("");
					jtARevent.setText("");

				}

			}

			public void inputdbnum(String daynum, String daynum1, Object critem, Object aritem, int tot, int cash,
					int check, int promissory_note, int credit, Object comboboxpay) {
				try {
					// 연결s
					conn();

					String sql1 = "insert into Tax_key values(?,?,?,?,?,?,?,?,?)";
					pstmt1 = conn.prepareStatement(sql1);

					pstmt1.setString(1, daynum + "-" + daynum1);
					pstmt1.setString(2, (String) critem);
					pstmt1.setString(3, (String) aritem);
					pstmt1.setInt(4, tot);
					pstmt1.setInt(5, cash);
					pstmt1.setInt(6, check);
					pstmt1.setInt(7, promissory_note);
					pstmt1.setInt(8, credit);
					pstmt1.setString(9, (String) comboboxpay);

					pstmt1.executeUpdate();
				} catch (SQLException se) {
					System.err.println("!!" + se.getMessage());
					return;
				} finally {
					disconn();
					JOptionPane.showMessageDialog(null, "저장이 완료되었습니다", "성공", JOptionPane.YES_OPTION);
					dispose();

				}

			}

		});
		jbTax_Ent.setBounds(14, 5, 61, 43);
		panel1_2_1.add(jbTax_Ent);

		jbTax_Cel = new JButton("취소");
		jbTax_Cel.setBounds(80, 5, 61, 43);
		jbTax_Cel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel1_2_1.add(jbTax_Cel);

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

		jtbooknum4 = new JTextField(daynum);
		jtbooknum4.setBounds(70, 2, 64, 24);
		panel1_2_1_2.add(jtbooknum4);
		jtbooknum4.setColumns(3);

		JLabel jbbooknum5 = new JLabel("-");
		jbbooknum5.setBounds(140, 5, 15, 21);
		panel1_2_1_2.add(jbbooknum5);

		jtbooknum5 = new JTextField(daynum1);
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
		CRcombolist();
		jbCRno.setFont(new Font("굴림", Font.PLAIN, 12));
		jbCRno.setBounds(190, 2, 240, 27);
		panel2_1.add(jbCRno);
		jbCRno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				critem = jbCRno.getSelectedItem();
				CRsettext(critem);
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
		ARcombolist();
		jbARno.setFont(new Font("굴림", Font.PLAIN, 12));
		jbARno.setBounds(190, 2, 240, 27);
		panel2_2.add(jbARno);
		jbARno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				aritem = jbARno.getSelectedItem();
				ARsettext(aritem);
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
		panel3.setBounds(0, 230, 882, 30);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		jtdate = new JTextField(day);
		jtdate.setBounds(14, 0, 116, 24);
		panel3.add(jtdate);
		jtdate.setColumns(10);

		JButton jbdate = new JButton("▼");
		jbdate.setBounds(140, 5, 39, 19);
		panel3.add(jbdate);
		jbdate.setFont(new Font("굴림", Font.PLAIN, 8));
		jbsetrow.setBounds(261, 1, 89, 27);
		panel3.add(jbsetrow);

		jbdelrow = new JButton("항목삭제");
		jbdelrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				System.out.println(row);
				if (row == -1) {
					return;
				} else {
					model.data.removeElementAt(row);
					table.updateUI();
					table.setBackground(SystemColor.inactiveCaptionBorder);

					// 격자선
					table.setGridColor(Color.gray); // 격자선색
					table.setShowGrid(true); // 격자선그릴지 여부

					// 칸 너비 지정중
					table.getColumnModel().getColumn(0).setPreferredWidth(60);
					table.getColumnModel().getColumn(2).setPreferredWidth(40);
					table.getColumnModel().getColumn(4).setPreferredWidth(70);
					table.getColumnModel().getColumn(5).setPreferredWidth(80);
					table.getColumnModel().getColumn(6).setPreferredWidth(80);
					table.getColumnModel().getColumn(7).setPreferredWidth(145);
					table.setRowHeight(30);
				}

			}
		});
		jbdelrow.setBounds(364, 1, 89, 27);
		panel3.add(jbdelrow);

		JPanel panel4 = new JPanel();
		panel4.setBounds(0, 260, 882, 230);

		getContentPane().add(panel4);
		panel4.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 0, 860, 224);
		panel4.add(scrollPane);

		table.setBackground(SystemColor.inactiveCaptionBorder);

		// 격자선
		table.setGridColor(Color.gray); // 격자선색
		table.setShowGrid(true); // 격자선그릴지 여부

		// 칸 너비 지정중
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.setRowHeight(30);
		table.setBounds(0, 0, 895, 160);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일선택

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

		jttotal = new JTextField(tot);
		jttotal.setEditable(false);
		panel5.add(jttotal);
		jttotal.setColumns(20);

		jtcash = new JTextField(cash);
		jtcash.setColumns(20);
		panel5.add(jtcash);

		jtcheck = new JTextField(check);
		jtcheck.setColumns(20);
		panel5.add(jtcheck);

		jtpromissory_note = new JTextField(promissory);
		jtpromissory_note.setColumns(20);
		panel5.add(jtpromissory_note);

		jtcredit = new JTextField(credit);
		jtcredit.setColumns(20);
		panel5.add(jtcredit);

		jcbpay = new JComboBox<String>();
		jcbpay.setModel(new DefaultComboBoxModel(new String[] { "청구", "영수" }));
		panel5.add(jcbpay);

		jbsetrow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initial();
			}
		});

		jbdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// create frame new object f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				jtdate.setText(new DatePicker(f).setPickedDate());
			}
		});

		setSize(900, 600);
		setVisible(true);
	}

	// 테이블에 입력하는 레코드를 추가하기 위한 초기화
	public void initial() {
		init = new Vector();
		if (model.getRowCount() < 4) {
			init.add(0, jtdate.getText());
			for (int i = 1; i < model.getColumnCount(); i++) {
				init.addElement("");

			}
		} else {
			JOptionPane.showMessageDialog(null, "4개이상 row를 추가할수 없습니다", "row 초과오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		model.data.addElement(init);
		model.fireTableDataChanged();
	}

	// 테이블에 이벤트 처리
	public void eventProc() {

		// 한 셀에서 수정이 되면 발생하는 이벤트 처리
		model.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent ev) {

				// 이벤트가 발생한 행과 열을 얻어온다
				// 4번째 열( 수학점수 셀)에서 이벤트가 발생했을시만 수행하려한다
				int row = ev.getFirstRow();
				int col = ev.getColumn();
				if (col != 4)
					return;

				temp = new Vector<Object>();

				for (int i = 0; i < 5; i++) {

					temp.addElement(model.getValueAt(row, i));
				}

				mount = Integer.parseInt((String) temp.elementAt(3));
				unit_price = Integer.parseInt((String) temp.elementAt(4));

				provision = mount * unit_price;
				temp.addElement(String.valueOf(provision));
				tot += provision;
				jttotal.setText("" + tot);
				jtcash.setText("" + cash);
				jtcheck.setText("" + check);
				jtpromissory_note.setText("" + promissory);
				jtcredit.setText("" + credit);

				System.out.println(tot);
				ect = "";
				temp.addElement(String.valueOf(ect));

				table.setSurrendersFocusOnKeystroke(true);
				model.data.removeElementAt(row);
				model.data.addElement(temp);

				// initial();
			}
		});

	}

	// 회사사업자번호 combobox
	public void CRcombolist() {
		try {
			conn();
			pstmt = conn.prepareStatement("select * from COMPANYREGISTRATION"); // SQL
																				// 질의
			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다.
			rsmd = rs.getMetaData(); // 메타정보를 저장

			while (rs.next()) {
				jbCRno.addItem(rs.getObject(1));
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회사 사업번호 선택시
	private void CRsettext(Object critem) {
		try {
			conn();
			pstmt = conn.prepareStatement("select * from COMPANYREGISTRATION where CNO=?"); // SQL
			pstmt.setString(1, (String) critem); // 질의
			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다.

			while (rs.next()) {
				crstr = new Vector();
				crstr.addElement(rs.getString("CNAME"));
				crstr.addElement(rs.getString("CBOSS"));
				crstr.addElement(rs.getString("CLOC"));
				crstr.addElement(rs.getString("CCATEGORY"));
				crstr.addElement(rs.getString("CEVENT"));
				crdata.addElement(crstr);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 거래처사업자번호 combobox
	public void ARcombolist() {
		try {
			conn();
			pstmt = conn.prepareStatement("select * from Accountregistration"); // SQL
																				// 질의
			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다.
			rsmd = rs.getMetaData(); // 메타정보를 저장

			while (rs.next()) {

				jbARno.addItem(rs.getObject(1));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 거래처 사업번호 선택시
	private void ARsettext(Object aritem) {
		try {
			conn();
			pstmt = conn.prepareStatement("select * from Accountregistration where ANO=?"); // SQL
			pstmt.setString(1, (String) aritem); // 질의
			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다.

			while (rs.next()) {
				arstr = new Vector();
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

class MyTableModel extends AbstractTableModel {
	Vector<Vector<Object>> data = new Vector<Vector<Object>>(8);
	private String tablestr[] = { "날짜", "품목", "규격", "수량", "단가", "공급가액", "비고" };

	public int getColumnCount() {
		return tablestr.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public Object getValueAt(int row, int col) {
		Vector temp = (Vector) data.elementAt(row);
		return temp.elementAt(col);
	}

	public String getColumnName(int col) {
		return tablestr[col];
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 5 ) {
			return false;
		} else {
			return true;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		Vector rowTemp = (Vector) (data.elementAt(row));
		rowTemp.set(col, value);
		fireTableCellUpdated(row, col);

	}
}
