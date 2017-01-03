package roti.lms.ad_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDao {

	private static AdminDao instance = new AdminDao();

	public static AdminDao getInstance() {
		return instance;
	}

	public AdminDao() {
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		return ds.getConnection();
	}

	public int userCheck(String tch_no, String tch_pass) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		String dbpass = "";
		int x = -1;

		try {
			conn = getConnection();
			sql = "select tch_pass from teacher where tch_no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tch_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpass = rs.getString("tch_pass");
				if (dbpass.equals(tch_pass)) {
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
