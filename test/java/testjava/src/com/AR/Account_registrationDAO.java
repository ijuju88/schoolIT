package com.AR;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Account_registrationDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql, name, grade, stunum;
	private Vector<String> col = new Vector<String>();
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	JTable j;

	public void conn() {
		try {
			// 오라클 드라이버 선언
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return;
		}
		try {
			// 오라클 DB연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxju88", "1234");
			System.out.println("성공");
		} catch (SQLException ee) {
			ee.printStackTrace();
		}

	}

	public void disconn() {
		// 연결 끊기
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	// 저장버튼 누르면 1
	public void inputdb(String jtf1, String jtf2, String jtf3, String jtf4, String jtf5, String jtf6) {
		try {
			// 연결s
			conn();
				String sql = "insert into Accountregistration(ANO, ANAME, ABOSS , ALOC , ACATEGORY , AEVENT)" + " values('" + jtf1 + "','" + jtf2 + "','" + jtf3
						+ "','" + jtf4 + "','" + jtf5 + "','" + jtf6 + "')";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate(); 
		} catch (SQLException se) {
			System.err.println(se.getMessage());
			JOptionPane.showMessageDialog(null, "회사명이나 사업자번호가 같은것이 존재하거나 다 입력하지 않았습니다 다시 적어용", "경고", JOptionPane.YES_OPTION);
			return;						
		} finally {
			disconn();
		}

		defJTable();
	}

	public void defJTable() {
		try {
			conn();
			pstmt = con
					.prepareStatement("select ANO, ANAME, ABOSS , ALOC , ACATEGORY , AEVENT  from Accountregistration");
			rs = pstmt.executeQuery();
			System.out.println(rs.toString());
			// DB의 데이터 받아 와 row입력
			while (rs.next()) {
				Vector row = new Vector();
				row.addElement(rs.getString("ANO"));
				row.addElement(rs.getString("ANAME"));
				row.addElement(rs.getString("ABOSS"));
				row.addElement(rs.getString("ALOC"));
				row.addElement(rs.getString("ACATEGORY"));
				row.addElement(rs.getString("AEVENT"));
				data.addElement(row);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			disconn();
		}
	}

	// renew
	public void redefJTable() {
		data.clear();
		try {
			conn();
			pstmt = con
					.prepareStatement("select ANO, ANAME, ABOSS , ALOC , ACATEGORY , AEVENT  from Accountregistration");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				row.addElement(rs.getString("ANO"));
				row.addElement(rs.getString("ANAME"));
				row.addElement(rs.getString("ABOSS"));
				row.addElement(rs.getString("ALOC"));
				row.addElement(rs.getString("ACATEGORY"));
				row.addElement(rs.getString("AEVENT"));
				data.addElement(row);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			disconn();
		}
	}

	// JTable을 리턴.
	public JTable getJTable() {
		defJTable();
		col.addElement("번호");
		col.addElement("회사명");
		col.addElement("대표명");
		col.addElement("주소");
		col.addElement("업태");
		col.addElement("종목");

		// 더블클릭해서 수정금지하기
		DefaultTableModel model = new DefaultTableModel(data, col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		j = new JTable(model);

		return j;
	}

	
	// 수정1
		public void update(String jtf1, String jtf2, String jtf3, String jtf4, String jtf5, String jtf6) {
			try {
				conn();
				String sql = "UPDATE Accountregistration SET " + "ANAME='" + jtf2 + "'," + "ABOSS='" + jtf3 + "',"
						+ "ALOC='" + jtf4 + "'," + "ACATEGORY='" + jtf5 + "'," + "AEVENT='" + jtf6 + "'" + " WHERE ANO ='" + jtf1 + "'";

				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();

				pstmt.setString(1, jtf2);
				pstmt.setString(2, jtf3);
				pstmt.setString(3, jtf4);
				pstmt.setString(4, jtf5);
				pstmt.setString(5, jtf6);
				pstmt.setString(6, jtf1);

				pstmt.executeUpdate();
		
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return;
			} finally {
				disconn();
			}
		}
		
		

	// 삭제
	public void deleteRow(String no) {
		try {
			conn();
			pstmt = con.prepareStatement("delete from Accountregistration where ANO = '" + no + "'");
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

}
