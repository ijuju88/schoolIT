package roti.lms.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public StudentDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}

	}
	
	// 출결 테이블의 항목 수를 불러온다.
	public int getAttCount(String at_id) {
		int x = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select count(*) from attendance where at_id = ?");
			pstmt.setString(1, at_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (SQLException ex) {
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

	// 아이디에 맞는 학생 테이블의 정보를 불러온다. 
	public StudentBean getStudentList(String stu_id) throws Exception {
		StudentBean student = null;
		try {
			con = ds.getConnection();
			
			String s_sql = "select * from student where st_id = ?";
			pstmt = con.prepareStatement(s_sql);
			
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				student = new StudentBean();
				student.setSt_id(rs.getString("st_id"));
				student.setSt_pass(rs.getString("st_pass"));
				student.setSt_name(rs.getString("st_name"));
				student.setBirth(rs.getInt("birth"));
				student.setAddr(rs.getString("addr"));
				student.setSt_hp(rs.getString("st_hp"));
				student.setSt_ehp(rs.getString("st_ehp"));
				student.setGender(rs.getString("gender"));
				student.setRdate(rs.getString("rdate"));
			}
			return student;
		} catch (SQLException ex) {
			System.out.println("getStudentList 에러 : " + ex);
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

	// 학생 아이디와 과목번호를 기준으로 수강 테이블의 정보를 불러온다. 
	public StudentBean getRegisterList(String st_id, int subj_no) throws Exception {

		StudentBean register = null;
		try {
			con = ds.getConnection();
			String r_sql = "select s.sub_name, r.rg_start, r.rg_end, r.classroom, r.charge "
					+ "from register r, subject s " 
					+ "where r.rg_id = ? and s.sub_no = ?";

			pstmt = con.prepareStatement(r_sql);
			pstmt.setString(1, st_id);
			pstmt.setInt(2, subj_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				register = new StudentBean();
				register.setSub_name(rs.getString("sub_name"));
				register.setRg_start(rs.getString("rg_start"));
				register.setRg_end(rs.getString("rg_end"));
				register.setClassroom(rs.getString("classroom"));
				register.setCharge(rs.getString("charge"));
			}
			return register;
		} catch (Exception ex) {
			System.out.println("getRegisterList 에러 : " + ex);
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

	//학생 아이디를 기준으로 출결 정보를 불러온다.
	public StudentBean getAttendanceList(String stu_id) throws Exception {
		StudentBean atten = null;
		try {
			con = ds.getConnection();
			String a_sql = "select at_date, checkin, checkout, at_stmt "
					+ "from attendance "
					+ "where at_id = ?";
			pstmt = con.prepareStatement(a_sql);
			
			pstmt.setString(1, stu_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				atten = new StudentBean();
				atten.setAt_date(rs.getString("at_date"));
				atten.setCheckin(rs.getString("checkin"));
				atten.setCheckout(rs.getString("checkout"));
				atten.setAt_stmt(rs.getString("at_stmt"));
			}
			return atten;
		} catch (SQLException ex) {
			System.out.println("getAttendanceList 에러 : " + ex);
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
	
	// 출결정보를 반복해서 출력하기 위해 List를 이용, List를 리턴한다.
	public List<Object> getAttendanceFor(String stu_id) throws Exception {
		List<Object> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			String a_sql = "select at_date, checkin, checkout, at_stmt "
					+ "from attendance "
					+ "where at_id = ?";
			pstmt = con.prepareStatement(a_sql);
			
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentBean student = new StudentBean();
				student.setAt_date(rs.getString("at_date"));
				student.setCheckin(rs.getString("checkin"));
				student.setCheckout(rs.getString("checkout"));
				student.setAt_stmt(rs.getString("at_stmt"));
				list.add(student);
			}

			return list;
		} catch (SQLException ex) {
			System.out.println("getAttendanceFor 에러 : " + ex);
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

	// 회원 정보 수정
	public boolean boardModify(StudentBean modifystudent) throws Exception {
		String sql = "update student set "
				+ "st_name=?, birth=?, addr= ?, st_hp = ?, st_ehp = ?, gender = ?, rdate = ? "
				+ "where st_id = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifystudent.getSt_name());
			pstmt.setInt(2, modifystudent.getBirth());
			pstmt.setString(3, modifystudent.getAddr());
			pstmt.setString(4, modifystudent.getSt_hp());
			pstmt.setString(5, modifystudent.getSt_ehp());
			pstmt.setString(6, modifystudent.getGender());
			pstmt.setString(7, modifystudent.getRdate());
			pstmt.setString(8, modifystudent.getSt_id());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println("studentModify 에러 : " + ex);
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
	 
}