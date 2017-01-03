package DAO;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

import DTO.*;

public class CelDBConn {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private CelDBConn() {
	}
	
	private static CelDBConn instance = new CelDBConn();
	
	public static CelDBConn getInstance() {
		return instance;
	}

	public Connection getConnection(){
		Connection conn = null;
		Context initContext;
		
		try{
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/test10Mysql");
			conn = ds.getConnection();
			System.out.println("연결성공");
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
	
	public int insertMember(Celbean CDC) {
		int result = -1;
		conn = null;
		pstmt = null;
		String sql = "insert into Celtest values(?,?,?,?,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CDC.getTitle());
			pstmt.setString(2, CDC.getUrl());
			pstmt.setInt(3, CDC.getSday());
			pstmt.setInt(4, CDC.getSt());
			pstmt.setInt(5, CDC.getTotday());
			pstmt.setInt(6, CDC.getLt());
			
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("넣기실패" + e.getMessage());
		} finally {
			DBclose();
		}
		
		
		return result;
	}
}
