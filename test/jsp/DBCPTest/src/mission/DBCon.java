package mission;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.*;

public class DBCon {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public DBCon() {
	}

	private static DBCon dbconn = new DBCon();

	public static DBCon getInstance() {
		return dbconn;
	}

	private Connection getDBCon() {
		Connection conn = null;

//		String url1 = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id1 = "test2";
//		String pw1 = "1234";

		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/test2Oracl");
			conn = ds.getConnection();
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url1, id1, pw1);*/

			System.out.println("연결완료!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return conn;
	}

	public void InsertMovie(MovieBean moviebean) {
		conn = null;
		pstmt = null;
		String sql = "insert into Movietest values(movie_no.nextval, ?,?,?,?,?,?,?)";

		try {
			conn = getDBCon();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, moviebean.getTitle());
			pstmt.setString(2, moviebean.getPw());
			pstmt.setInt(3, moviebean.getPrice());
			pstmt.setString(4, moviebean.getDirector());
			pstmt.setString(5, moviebean.getActor());
			pstmt.setString(6, moviebean.getSynopsis());
			pstmt.setString(7, moviebean.getGenre());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("안들어감??:" + e.getMessage());
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

	public ArrayList<MovieBean> SelectMovie() {
		ArrayList<MovieBean> list = new ArrayList<>();

		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from Movietest";

		try {
			conn = getDBCon();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieBean mb = new MovieBean();
				mb.setNo(rs.getInt(1));
				mb.setTitle(rs.getString(2));
				// mb.setPw(rs.getString(3));
				mb.setPrice(rs.getInt(4));
				mb.setDirector(rs.getString(5));
				mb.setActor(rs.getString(6));
				mb.setSynopsis(rs.getString(7));
				mb.setGenre(rs.getString(8));

				list.add(mb);
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

	public MovieBean ViewMovie(int no) {
		MovieBean mb = null;
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from Movietest where no=?";

		try {
			conn = getDBCon();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new MovieBean();
				mb.setNo(rs.getInt(1));
				mb.setTitle(rs.getString(2));
				mb.setPw(rs.getString(3));
				mb.setPrice(rs.getInt(4));
				mb.setDirector(rs.getString(5));
				mb.setActor(rs.getString(6));
				mb.setSynopsis(rs.getString(7));
				mb.setGenre(rs.getString(8));
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

		return mb;

	}

	public MovieBean ModityMovie(MovieBean moviebean) {
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "update Movietest set title=?, pw=?, price=? ,director=?,"
				+ "actor=? ,synopsis=? ,genre=? where no=?";

		try {
			conn = getDBCon();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, moviebean.getTitle());
			pstmt.setString(2, moviebean.getPw());
			pstmt.setInt(3, moviebean.getPrice());
			pstmt.setString(4, moviebean.getDirector());
			pstmt.setString(5, moviebean.getActor());
			pstmt.setString(6, moviebean.getSynopsis());
			pstmt.setString(7, moviebean.getGenre());
			pstmt.setInt(8, moviebean.getNo());

			pstmt.executeUpdate();

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

		return null;
	}

	public boolean DelMovie(int no, String pw) {
		boolean b = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from Movietest where no=?";
		String dbPass = getPassword(no);
		System.out.println(dbPass.toString());
		if (dbPass.equals(pw)) {
			b = true;
			try {
				con = getDBCon();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
				}
			}

		}
		return b;
	}

	private String getPassword(int no) {
		String pw = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pw from Movietest where no=?";
		try {
			con = getDBCon();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return pw;
	}

}
