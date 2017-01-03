package com.list;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.*;

public class Tax_Bill_List extends JFrame {

	private static final long serialVersionUID = 1L;

	Connection conn;// 연결객체

	Statement stmt;
	DefaultTableModel model;
	JTable table;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date today = new Date();
	Date today1 = new Date();
	String firstday = formatter.format(today);
	String lastday = formatter.format(today1);
	JTextField jtfirstday, jtlastday;
	String day, day1;
	String[] strarr, strarr1 ;
	int daydata, daydata1;
	String row1= null, row2= null, row3= null, row4= null, 
			row5= null, row6= null, row11= null;

	int row7=0, row8= 0,row9= 0,row10= 0;


	public Tax_Bill_List() {
		// jdbc드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxju88", "1234");
			stmt = conn.createStatement();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		setTitle("세금계산서 날짜 검색");

		dispose();

		getContentPane().setLayout(null);// 레이아웃설정

		String colName[] = { "일련번호", "공급자사업번호", "공급받는자사업번호", "날짜", "품목", "규격", "수량", "단가", "공급가액", "세액", "비고" };
		
		//수정못하게 하기
		model = new DefaultTableModel(colName, 0){
		    public boolean isCellEditable(int row, int col) {
		        return false;
		       }};


		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 1188, 60);
		getContentPane().add(panel1);
		panel1.setLayout(null);

		JLabel jlfirstday = new JLabel("시작날짜");
		jlfirstday.setBounds(20, 14, 56, 22);
		jlfirstday.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel1.add(jlfirstday);

		jtfirstday = new JTextField(firstday);
		jtfirstday.setEditable(false);
		jtfirstday.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jtfirstday.setBounds(85, 10, 110, 30);
		panel1.add(jtfirstday);
		jtfirstday.setColumns(10);

		JButton jbfirstday = new JButton("▼");
		jbfirstday.setFont(new Font("굴림", Font.PLAIN, 8));
		jbfirstday.setBounds(205, 11, 43, 30);
		panel1.add(jbfirstday);
		jbfirstday.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// create frame new object f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				jtfirstday.setText(new com.main.DatePicker(f).setPickedDate());

			}
		});

		JLabel jllastday = new JLabel("마지막날짜");
		jllastday.setBounds(260, 14, 70, 22);
		jllastday.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel1.add(jllastday);

		jtlastday = new JTextField(lastday);
		jtlastday.setEditable(false);
		jtlastday.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jtlastday.setBounds(340, 10, 110, 30);
		panel1.add(jtlastday);
		jtfirstday.setColumns(10);

		JButton jblastday = new JButton("▼");
		jblastday.setFont(new Font("굴림", Font.PLAIN, 8));
		jblastday.setBounds(455, 11, 43, 30);
		panel1.add(jblastday);
		jblastday.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// create frame new object f
				final JFrame f = new JFrame();
				// set text which is collected by date picker i.e. set date
				jtlastday.setText(new com.main.DatePicker(f).setPickedDate());

			}
		});

		JButton btnlist = new JButton("검색");
		btnlist.setBounds(535, 11, 90, 30);
		panel1.add(btnlist);

		btnlist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String day = jtfirstday.getText();
				String day1 = jtlastday.getText();
				String[] strarr = day.split("-");
				String[] strarr1 = day1.split("-");

				int daydata = Integer.parseInt(strarr[0] + strarr[1] + strarr[2]);
				int daydata1 = Integer.parseInt(strarr1[0] + strarr1[1] + strarr1[2]);
				System.out.println("!!"+daydata1);

				if (daydata > daydata1) {
					JOptionPane.showMessageDialog(null, "처음날짜가 나중에 날짜보다 큽니다 다시하세용", "날짜 오류", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					list(daydata, daydata1);

				}

			}
		});
		JButton UpdateButton = new JButton("보기");
		UpdateButton.setBounds(630, 10, 90, 30);
		panel1.add(UpdateButton);
		UpdateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (row1.equals("")) {
					JOptionPane.showMessageDialog(null, "행을선택해야 볼수 있습니다 선택할 테이블을 더블클릭해주세요-_<", "실패",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{new View_Tax_Bill(row1, row2, row3);}
			}
		});
		
		
		JButton DeleteButton = new JButton("삭제");
		DeleteButton.setLocation(725, 10);
		DeleteButton.setSize(90, 30);
		panel1.add(DeleteButton);

		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 70, 1178, 481);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		table = new JTable(model);
		table.setFont(new Font("SansSerif", Font.PLAIN, 13));
		table.setBounds(1, 27, 470, 0);
		table.setPreferredScrollableViewportSize(new Dimension(470, 200));
		panel2.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(0, 0, 1177, 481);
		panel2.add(scrollPane);
		
		table.setBackground(SystemColor.inactiveCaptionBorder);

		// 격자선
		table.setGridColor(Color.gray); // 격자선색
		table.setShowGrid(true); // 격자선그릴지 여부

		// 칸 너비 지정중
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		table.getColumnModel().getColumn(10).setPreferredWidth(130);
		table.setRowHeight(30);
		

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 table = (JTable) e.getComponent();// 클릭한 테이블 구하기
				 model = (DefaultTableModel) table.getModel();// 테이블의 모델 구하기
				 row1 = (String) model.getValueAt(table.getSelectedRow(), 0);
				 row2 = (String) model.getValueAt(table.getSelectedRow(), 1);
				 row3 = (String) model.getValueAt(table.getSelectedRow(), 2);
				 row4 = (String) model.getValueAt(table.getSelectedRow(), 3);
				 row5 = (String) model.getValueAt(table.getSelectedRow(), 4);
				 row6 = (String) model.getValueAt(table.getSelectedRow(), 5);
				 row7 = (int) model.getValueAt(table.getSelectedRow(), 6);
				 row8 = (int) model.getValueAt(table.getSelectedRow(), 7);
				 row9 = (int) model.getValueAt(table.getSelectedRow(), 8);
				 row10 = (int) model.getValueAt(table.getSelectedRow(), 9);
				 row11 = (String) model.getValueAt(table.getSelectedRow(), 10);
				 System.out.println(row7);
				
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		// 종료이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		
		// 삭제버튼 이벤트 처리
		DeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				

				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				System.out.println("삭제"+row1);
				// Yes를 누르면 삭제
				if (result == JOptionPane.YES_OPTION) {
					try {
						 PreparedStatement  stmt = conn.prepareStatement("delete from Tax_Bill where tbnum = '" + row1 + "'");
						stmt.executeUpdate();

					} catch (Exception e1) {
						// e.getStackTrace();
						System.out.println(e1.getMessage());
					}
					
					try {
						PreparedStatement  stmt = conn.prepareStatement("delete from Tax_Bill_key where tbnum = '" + row1 + "'");
						stmt.executeUpdate();
						JOptionPane.showConfirmDialog(null, "삭재했습니다~~", "삭제", JOptionPane.YES_NO_OPTION);
						model.setNumRows(0);
		
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}

				}

			}
		});

		 setResizable(false);// 화면크기고정
		 setSize(1200, 600);// 화면크기
		 setVisible(true);
	}

	public void list(int daydata, int daydata1) {
		System.out.println(daydata1);
		String sql="select distinct  tk.TBNUM, tk.CNO, tk.ANO, t.TBdate,"
				+ "t.TBlist, t.TBstandard,t.TBamount,t.TBunit_price ,t.TBprovision,"
				+ "t.TBtax_amount, t.TBect from TAX_BILL t,TAX_BILL_KEY tk"
				+ " where substr(tk.TBNUM, 1,6) >= TO_DATE"
				+ "('"+daydata+"','YYYYMMDD') AND  substr(tk.TBNUM, 1,6) "
				+ "<  TO_DATE('"+daydata1+"','YYYYMMDD')+1 and tk.tbnum=t.tbnum order by tk.TBNUM";

		try {
			System.out.println("연결되었습니다.....");


			ResultSet rs = stmt.executeQuery(sql);
			

			// JTable 초기화
			model.setNumRows(0);

			while (rs.next()) {
				Object[] row = new Object[11];// 컬럼의 갯수가 3

				row[0] = rs.getString("TBNUM");
				row[1] = rs.getString("CNO");
				row[2] = rs.getString("ANO");
				
				String str = rs.getString("TBdate");
				row[3] =str.toString().substring(0, 10);
				
				row[4] = rs.getString("TBlist");
				row[5] = rs.getString("TBstandard");
				row[6] = rs.getInt("TBamount");
				row[7] = rs.getInt("TBunit_price");
				row[8] = rs.getInt("TBprovision");
				row[9] = rs.getInt("TBtax_amount");
				row[10] = rs.getString("TBect");
				
	
				System.out.println(str);
				
				model.addRow(row);
			}
			rs.close();

		} catch (Exception e1) {
			// e.getStackTrace();
			System.out.println(e1.getMessage());
		}
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		new Tax_Bill_List();// 생성자호출
	}
}
