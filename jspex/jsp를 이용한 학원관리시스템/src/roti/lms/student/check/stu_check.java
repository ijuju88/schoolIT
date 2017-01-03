package roti.lms.student.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.DataSource;

import roti.lms.student.check.*;

public class stu_check {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public stu_check() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}

	}

	// �л��� ���ϱ�.
	public int getListCount() {
		int x = 0;

		try {

			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from ATTENDANCE");
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

	// �л�����Ʈ���ϱ�
	public List getchecklist(int page, int limit) {

		String stu_check_sql = "select * from " + "(select rownum rnum,at_id,at_date,checkin,checkout,at_stmt from " + "(select * from attendance order by at_date asc)) " + "where rnum>=? and rnum<=?";
		String stu_check_name_sql = "select student.st_name from " + "student,attendance where attendance.at_id = student.st_id";

		List list = new ArrayList();

		int startrow = (page - 1) * 10 + 1; // �б� ������ row ��ȣ.
		int endrow = startrow + limit - 1; // ���� ������ row ��ȣ.
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(stu_check_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				checkBean chb = new checkBean();
				chb.setAt_id(rs.getString("at_id"));
				chb.setAt_date(rs.getString("at_date"));
				chb.setCheckin(rs.getString("checkin"));
				chb.setCheckout(rs.getString("checkout"));
				chb.setAt_stmt(rs.getString("at_stmt"));
				list.add(chb);
			}
			// pstmt = con.prepareStatement(stu_check_name_sql);
			// rs = pstmt.executeQuery();
			// while(rs.next()){
			// checkBean chb = new checkBean();
			// chb.setAt_name(rs.getString("student.name"));
			// }
			//
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

	public void inCheck(String id, String pass) {
		// TODO Auto-generated method stub

		checkBean chb = new checkBean();
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;
		int date = cal.get(cal.DATE);
		int hour = cal.get(cal.HOUR_OF_DAY);
		int min = cal.get(cal.MINUTE);
		int sec = cal.get(cal.SECOND);
		int hour2 = (hour * 60) + min;
		String stmt = null;
		String at_date = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(date);
		String stu_check_sql = "select * from attendance where at_id=? and at_date=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(stu_check_sql);
			pstmt.setString(1, id);
			pstmt.setString(2, at_date);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("���Ϲ� ����");
				String datequals = rs.getString("at_date");
				if (datequals.equals(at_date)) {
					stu_check_sql = "update attendance set at_stmt=?,checkout=? where at_id=? and at_date=?";

					if (hour < 18) {

						stmt = "����";
					} else if (rs.getString("at_stmt").equals("����")) {

						stmt = "����";
					} else {
						stmt = "�⼮";
					}
					String checkout = Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
					try {
						con = ds.getConnection();
						pstmt = con.prepareStatement(stu_check_sql);
						pstmt.setString(1, stmt);
						pstmt.setString(2, checkout);
						pstmt.setString(3, id);
						pstmt.setString(4, at_date);
						pstmt.executeUpdate();

					} catch (Exception ex) {
						System.out.println("stu_update ���� : " + ex);
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
				} else {
					System.out.println("��¥���ٸ��� �μ�Ʈ��");
					stu_check_sql = "insert into attendance(at_id,at_pass,at_date,checkin,at_stmt,checkout) values(?,?,?,?,?,?)";
					if (hour2 >= 550) {
						stmt = "����";
					} else {
						stmt = "�⼮";
					}
					String checkin = Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
					try {
						con = ds.getConnection();
						pstmt = con.prepareStatement(stu_check_sql);
						pstmt.setString(1, id);
						pstmt.setString(2, pass);
						pstmt.setString(3, at_date);
						pstmt.setString(4, checkin);
						pstmt.setString(5, stmt);
						pstmt.setString(6, "");
						pstmt.executeUpdate();
					} catch (Exception ex) {
						System.out.println("stu_insert ���� : " + ex);
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
				}

			}
			System.out.println("�����ѳ�¥������ �μ�Ʈ�� ����");
			stu_check_sql = "insert into attendance(at_id,at_pass,at_date,checkin,at_stmt,checkout) values(?,?,?,?,?,?)";
			if (hour2 >= 550) {
				stmt = "����";
			} else {
				stmt = "�Ἦ";
			}
			String checkin = Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(stu_check_sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				pstmt.setString(3, at_date);
				pstmt.setString(4, checkin);
				pstmt.setString(5, stmt);
				pstmt.setString(6, "");
				pstmt.executeUpdate();
			} catch (Exception ex) {
				System.out.println("stu_insert ���� : " + ex);
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

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
