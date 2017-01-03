package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import DVO.JoinBean;


public class JoinDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private JoinDAO() {
	}
	
	private static JoinDAO instance = new JoinDAO();
	
	public static JoinDAO getInstance() {
		return instance;
	}

	Connection getConnection(){
		Connection conn = null;
		Context initContext;
		
		try{
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/test2Oracl");
			conn = ds.getConnection();
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
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
	
	public int userCheck(String userid, String pwd, String lev){
		int result=1;
		Connection conn = null;
		String sql="SELECT * FROM employees WHERE id =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				//비밀번호가 일치하고
				if(pwd.equals(rs.getString("PASS"))){
					//회원등급이 일치하면
					if(lev.equals(rs.getString("LEV"))){
						result = 2; //관리자로 로그인 성공
						if(lev.equals("B")){
							result=3;//일반 회원으로 로그인 성공
						}
					}else{//레벨 불일치 로그인 실패
						result =1;
					}
				}else{  //비밀번호 불일치 로그인 실패
					result = 0;
				}
			}else{  //아이디 불일치 로그인 실패
				result = -1;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBclose();
		}
		return result;
	}
	
	public JoinBean getJB(String id){
		JoinBean JB = null;
		
		Connection conn = null;
		String sql="select * from employees where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				JB = new JoinBean();
				JB.setId(rs.getString("ID"));
				JB.setPass(rs.getString("PASS"));
				JB.setName(rs.getString("NAME"));			
				JB.setGender(rs.getInt("GENDER"));
				JB.setPhone(rs.getString("PHONE"));
				JB.setAddress(rs.getString("ADDRESS"));
				JB.setLev(rs.getString("LEV"));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBclose();
		}
		return JB;
	}
	
	public void insertJB(JoinBean JB) {
		String sql = "insert into employees values(?,?,?,?,?,?,?)";		
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?에 값 세팅
			pstmt.setString(1, JB.getId());
			pstmt.setString(2, JB.getPass());
			pstmt.setString(3, JB.getName());
			pstmt.setInt(4, JB.getGender());
			pstmt.setString(5, JB.getPhone());
			pstmt.setString(6, JB.getAddress());
			pstmt.setString(7, JB.getLev());
			System.out.println(pstmt.executeUpdate());			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
	}

	public int updateJB(JoinBean JB) {
		int result = -1;
		String sql = "update employees set pass=?, name=?, gender=?,phone=? ,address=?, lev=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, JB.getPass());
			pstmt.setString(2, JB.getName());
			pstmt.setInt(3, JB.getGender());
			pstmt.setString(4, JB.getPhone());
			pstmt.setString(5, JB.getAddress());
			pstmt.setString(6, JB.getLev());
			pstmt.setString(7, JB.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DBclose();
		}
		return result;
	}

	public int confirmID(String id) {
		int result = -1;
		conn = null;
		pstmt = null;
		rs = null;
		String sql = "select * from EMPLOYEES where id=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
}
