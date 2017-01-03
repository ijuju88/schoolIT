package roti.lms.ad_sub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public DAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}

	}

	// 글의 개수 구하기
	public int getListCount() {
		int x = 0;

		try {

			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from subject");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount 에러: " + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// 글 목록 보기
	public List getSubList(int page, int limit) {

		String board_list_sql = "select * from " + "(select rownum rnum,sub_no,sub_name,tch_no from" + "(select * from subject )) " + "where rnum>=? and rnum<=?";

		List list = new ArrayList();

		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호.
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호.
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Bean board = new Bean();
				board.setSub_no(rs.getInt("sub_no"));
				board.setSub_name(rs.getString("sub_name"));
				board.setTch_no(rs.getString("tch_no"));
				list.add(board);
			}

			return list;
		} catch (Exception ex) {
			System.out.println("getBoardList 에러 : " + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	// 글 내용 보기.
	public Bean getDetail(int num) throws Exception {

		Bean sub = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from sub where sub_no = ?");
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				sub = new Bean();
				sub.setSub_no(rs.getInt("sub_no"));
				sub.setSub_name(rs.getString("sub_name"));
				sub.setTch_no(rs.getString("tch_no"));
			}
			return sub;
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	// 글 등록
	public boolean SubInsert(Bean sub) {

		int num = 0;
		String sql = "";

		int result = 0;

		try {
			con = ds.getConnection();

			sql = "insert into subject values(?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, sub.getSub_no());
			pstmt.setString(2, sub.getSub_name());
			pstmt.setString(3, sub.getTch_no());

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("subInsert 에러 : " + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	// 글 수정
	public boolean subModify(Bean subModify) throws Exception {

		String sql = "update subject set  tch_no=? ,sub_name=? where sub_no=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(3, subModify.getSub_no());
			pstmt.setString(2, subModify.getSub_name());
			pstmt.setString(1, subModify.getTch_no());
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("subModify 에러 : " + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	// 글 삭제
	public boolean SubDelete(int num) {

		String sub_delete_sql = "delete from subject where sub_no=?";

		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sub_delete_sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("subDelete 에러 : " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}

		}

		return false;
	}

}
