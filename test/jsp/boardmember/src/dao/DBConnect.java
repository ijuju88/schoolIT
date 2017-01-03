package dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

import dto.BoardMemberBean;

public class DBConnect {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public DBConnect() {
	}

	private static DBConnect dbconn = new DBConnect();

	public static DBConnect getInstance() {
		return dbconn;
	}

	public Connection getDBConnect() {
		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/test2Oracl");
			conn = ds.getConnection();

			System.out.println("연결완료!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return conn;
	}

	private void DBclose() {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	// 회원인증
	public int userCheck(String userid, String pwd) {
		int result = -1;
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from boardmember where USERID=?";

		try {
			conn = getDBConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			System.err.println("인증실패" + e.getMessage());
		} finally {
			DBclose();
		}

		return result;
	}

	// 회원정보
	public BoardMemberBean getBoardMember(String userid) {
		BoardMemberBean bmb = null;
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from boardmember where userid=?";
		System.out.println(userid);
		try {
			conn = getDBConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bmb = new BoardMemberBean();
				bmb.setName(rs.getString("name"));
				bmb.setUserid(rs.getString("userid"));
				bmb.setPwd(rs.getString("pwd"));
				bmb.setEmail(rs.getString("email"));
				bmb.setPhone(rs.getString("phone"));
				bmb.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			System.err.println("회원정보 가져오기실패" + e.getMessage());
		} finally {
			DBclose();
		}
		return bmb;
	}

	// 아이디중복찾기
	public int confirmID(String userid) {
		int result = -1;
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from boardmember where USERID=?";

		try {
			conn = getDBConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			System.err.println("인증실패" + e.getMessage());
		} finally {
			DBclose();
		}

		return result;
	}

	public int insertMember(BoardMemberBean bmb) {
		int result = -1;
		conn = null;
		pstmt = null;
		String sql = "insert into boardmember values(?,?,?,?,?,?)";
		
		try {
			conn = getDBConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bmb.getName());
			pstmt.setString(2, bmb.getUserid());
			pstmt.setString(3, bmb.getPwd());
			pstmt.setString(4, bmb.getEmail());
			pstmt.setString(5, bmb.getPhone());
			pstmt.setInt(6, bmb.getAdmin());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("가입실패" + e.getMessage());
		} finally {
			DBclose();
		}
		
		
		return result;
	}
	
	
	public int updateMember(BoardMemberBean bmb) {
		int result = -1;
		conn = null;
		pstmt = null;
		String sql = "update boardmember set pwd=?, email=?,"
				+ "phone=?, admin=? where userid=?";
		
		try {
			conn = getDBConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bmb.getPwd());
			pstmt.setString(2, bmb.getEmail());
			pstmt.setString(3, bmb.getPhone());
			pstmt.setInt(4, bmb.getAdmin());
			pstmt.setString(5, bmb.getUserid());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("가입실패" + e.getMessage());
		} finally {
			DBclose();
		}
		
		
		return result;
	}


}
