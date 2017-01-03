package com.list;

import java.sql.*;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class listDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	String day, day1;
	private Vector<String> col = new Vector<String>();
	private Vector<Vector<String>> data = new Vector<Vector<String>>();
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


}
