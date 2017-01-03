package roti.lms.student.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class stu_loginDao {
	DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static stu_loginDao instance = new stu_loginDao();

	public static stu_loginDao getInstance() {
		return instance;
	}

	public stu_loginDao() {
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		return ds.getConnection();
	}
	
	//DB�� �����ȣ �ҷ�����
	public int getSub_no (String rg_id) {
		int x = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select sub_no from register where rg_id = ?");
			pstmt.setString(1, rg_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	//student ���̺��� id�� password�� ���Ͽ� ���� ��ġ�ϴ� ��� 1 �ƴϸ� 0�� ����
	public int userCheck2(String st_id, String st_pass) throws Exception {
		String sql = "";
		String dbpass = "";
		int x = -1;

		try {
			conn = getConnection();
			sql = "select st_pass from student where st_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, st_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpass = rs.getString("st_pass");
				if (dbpass.equals(st_pass)) {
					x = 1;
				} else {
					x = 0;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			execClose(rs, pstmt, conn);
		}
		return x;
	}

	public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn) throws Exception {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException sqle) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException sqle) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
	}

}
