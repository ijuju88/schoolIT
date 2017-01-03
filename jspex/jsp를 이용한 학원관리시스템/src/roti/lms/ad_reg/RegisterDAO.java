package roti.lms.ad_reg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import roti.lms.ad_reg.*;

public class RegisterDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public RegisterDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println("db성공");
		} catch (Exception ex) {
			System.out.println("DB 에러 : " + ex);
			return;
		}
	}

	// ���� ���� ���ϱ�.
	public int getListCount() {
		int x = 0;

		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from register");
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

	// �� ��� ����.
	public List<RegisterBean> getRegisterList(int page, int limit) {
		System.out.println("리스트");
		String list_sql = "select * from (select rownum rnum, rg_id, sub_no, rg_start, rg_end, classroom, charge from (select * from register)) where rnum>=? and rnum<=?";
		List<RegisterBean> list = new ArrayList<RegisterBean>();
		int startrow = (page - 1) * 10 + 1; // �б� ������ row ��ȣ.
		int endrow = startrow + limit - 1; // ���� ������ row ��ȣ.

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			System.out.println("while실행");
			while (rs.next()) {
				RegisterBean board = new RegisterBean();

				board.setRg_id(rs.getString("rg_id"));
				board.setSub_no(rs.getInt("sub_no"));
				board.setRg_start(rs.getString("rg_start"));
				board.setRg_end(rs.getString("rg_end"));
				board.setClassroom(rs.getInt("classroom"));
				board.setCharge(rs.getInt("charge"));
				list.add(board);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("getRegisterList Catch에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("List_rs");
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					System.out.println("List_pstmt");
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					System.out.println("List_con");
				}
		}
		return null;
	}

	// �� ���.
	public boolean RegisterInsert(RegisterBean board) {
		int num = 0;
		String sql = "";

		int result = 0;
		System.out.println("InserDao실행");
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from register");
			System.out.println("갯수쿼리실행1");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(10) + 1;
			else
				num = 1;

			sql = "insert into register (rg_id,sub_no,rg_start,rg_end,classroom,charge) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getRg_id());
			pstmt.setInt(2, board.getSub_no());
			pstmt.setString(3, board.getRg_start());
			pstmt.setString(4, board.getRg_end());
			pstmt.setInt(5, board.getClassroom());
			pstmt.setInt(6, board.getCharge());
			
			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("List catch 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("등록실패");
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					System.out.println("�Է�pstmt");
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					System.out.println("�Է�con");
				}
		}
		return false;
	}

	// �� ����.
	public boolean registerModify(RegisterBean registermodify) throws Exception {

		String sql = "";

		System.out.println("ModifyDao����");

		try {
			con = ds.getConnection();
			sql = "update register set rg_id=?,sub_no=?,rg_start=?,rg_end=?,classroom=?,charge=? where rg_id=? and sub_no=?";
			System.out.println("������������");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, registermodify.getRg_id());
			pstmt.setInt(2, registermodify.getSub_no());
			pstmt.setString(3, registermodify.getRg_start());
			pstmt.setString(4, registermodify.getRg_end());
			pstmt.setInt(5, registermodify.getClassroom());
			pstmt.setInt(6, registermodify.getCharge());
			pstmt.setString(7, registermodify.getRg_id());
			pstmt.setInt(8, registermodify.getSub_no());
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("RegisterModify ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("����rs-try");
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					System.out.println("����pstmt-try");
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					System.out.println("����con-try");
				}
		}
		return false;
	}

	// �� ����.
	public boolean registerDelete(String rg_id, int sub_no) {
		String delete_sql = "";
		System.out.println("����Dao����");
		int result;

		try {
			con = ds.getConnection();

			delete_sql = "delete from register where rg_id =? and sub_no=? ";
			System.out.println("������������");
			// commit ="commit";
			pstmt = con.prepareStatement(delete_sql);
			pstmt.setString(1, rg_id);
			pstmt.setInt(2, sub_no);
			result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("RegisterDelete ���� : " + ex);
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
