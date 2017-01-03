package roti.lms.ad_tchdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Tch_BoardDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public Tch_BoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}

	}

	// ���� ���� ���ϱ�
	public int getListCount() {
		int x = 0;

		try {

			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count (*) from teacher");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount ����: " + ex);
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

	// �� ��� ����

	public List getBoardList(int page, int limit) {

		String board_list_sql = "select * from" + " (select rownum rnum, tch_no, tch_pass, tch_name, acab, resp_sub, tch_hp from" + " (select * from teacher)) " + "where rnum>=? and rnum<=?";
		List list = new ArrayList();

		int startrow = (page - 1) * 10 + 1; // �б� ������ row ��ȣ.
		int endrow = startrow + limit - 1; // ���� ������ row ��ȣ.
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Tch_Bean board = new Tch_Bean();
				board.setTch_no(rs.getString("tch_no"));
				board.setTch_pass(rs.getString("tch_pass"));
				board.setTch_name(rs.getString("tch_name"));
				board.setAcab(rs.getString("acab"));
				board.setResp_sub(rs.getString("resp_sub"));
				board.setTch_hp(rs.getString("tch_hp"));
				list.add(board);
			}

			return list;
		} catch (Exception ex) {
			System.out.println("getBoardList ���� : " + ex);
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

	// �� ���� ����.
	public Tch_Bean getDetail(int tch_no) throws Exception {

		Tch_Bean board = null;
		try {
			con = ds.getConnection();

			String s_sql = "select * from teacher where tch_no = ?";
			pstmt = con.prepareStatement(s_sql);
			pstmt.setInt(1, tch_no);
			// pstmt.setString(1, "a");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Tch_Bean();
				board.setTch_no(rs.getString("tch_no"));
				board.setTch_pass(rs.getString("tch_pass"));
				board.setTch_name(rs.getString("tch_name"));
				board.setAcab(rs.getString("acab"));
				board.setResp_sub(rs.getString("resp_sub"));
				board.setTch_hp(rs.getString("tch_hp"));

			}
			return board;
		} catch (Exception ex) {
			System.out.println("getDetail ���� : " + ex);
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

	// �� ���
	public boolean boardInsert(Tch_Bean tch) {

		int num = 0;
		String sql = "";

		int result = 0;

		try {
			con = ds.getConnection();
			sql = "insert into teacher values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, tch.getTch_no());
			pstmt.setString(2, tch.getTch_pass());
			pstmt.setString(3, tch.getTch_name());
			pstmt.setString(4, tch.getAcab());
			pstmt.setString(5, tch.getResp_sub());
			pstmt.setString(6, tch.getTch_hp());

			result = pstmt.executeUpdate();

			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("������  ���� : " + ex);
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

	// �� ����
	public boolean boardModify(Tch_Bean modifyboard) throws Exception {

		String sql = "update teacher set TCH_PASS=?, tch_name=?, ACAB=?, RESP_SUB=?, tch_hp=? where tch_no=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getTch_pass());
			pstmt.setString(2, modifyboard.getTch_name());
			pstmt.setString(3, modifyboard.getAcab());
			pstmt.setString(4, modifyboard.getResp_sub());
			pstmt.setString(5, modifyboard.getTch_hp());
			pstmt.setString(6, modifyboard.getTch_no());
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("boardModify ���� : " + ex);
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

	// �� ����
	public boolean Tch_Delete(String num) {

		String teacher_delete_sql = "delete from teacher where tch_no=?";

		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(teacher_delete_sql);
			pstmt.setString(1, num);
			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("TeacherDelete ���� : " + ex);
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

	// �۾������� Ȯ��
	public boolean isBoardWriter(String num, String pass) {

		String board_sql = "select * from teacher where tch_no=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			rs.next();

			if (pass == (rs.getString("tch_pass"))) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("isBoardWriter ���� : " + ex);
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