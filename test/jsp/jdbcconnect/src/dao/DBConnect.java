package dao;

import java.sql.*;
import java.util.*;
import dto.Member;

public class DBConnect {
	private DBConnect() {
	}

	// 한개의 db연결을 위한 싱글톤생성
	private static DBConnect dbconn = new DBConnect();

	public static DBConnect getInstance() {
		return dbconn;
	}

	private Connection getDBconnect() {

		Connection conn = null;

		// oracle
		String url1 = "jdbc:oracle:thin:@localhost:1521:xe";
		String id1 = "test2";
		String pw1 = "1234";

		// mysql
		// String url2 = "jdbc:mysql://localhost:3306/emp";
		// String id2 = "oxju88";
		// String pw2 = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url1, id1, pw1);

			// mysql
			// Class.forName("org.gjt.mm.mysql.Driver");
			// conn = DriverManager.getConnection(url2, id2, pw2);

			System.out.println("연결완료!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return conn;

	}

	// insert문
	public void InsertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?)";

		try {
			conn = getDBconnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setInt(5, member.getAge());
			pstmt.executeQuery();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}

		}
	}

	// select문
	public ArrayList<Member> selectMember() {
		ArrayList<Member> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";

		try {
			conn = getDBconnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member me = new Member();
				me.setId(rs.getString(1));
				me.setPw(rs.getString(2));
				me.setName(rs.getString("name"));
				me.setTel(rs.getString("tel"));
				me.setAge(rs.getInt(5));

				list.add(me);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}

		}

		return list;
	}
}
