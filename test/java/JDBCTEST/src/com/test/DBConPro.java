package com.test;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DBConPro {
	static DBConPro DBCP = new DBConPro();

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	ArrayList<Memberber> listMember = new ArrayList<>();

	public static DBConPro getInstance() {
		return DBCP;
	}

	public DBConPro() {

	}

	private Connection DBcon() {
		try {
			// 오라클 드라이버 선언
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxju88", "1234");
			System.out.println("성공");
		} catch (Exception ee) {
			ee.printStackTrace();
		}

		return conn;
	}

	public void inputDB(Memberber memberber) throws SQLException {
		String sql = "insert into member values(?, ? , ?)";

		try {
			DBcon();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberber.getName());
			stmt.setInt(2, memberber.getAge());
			stmt.setString(3, memberber.getGender());
			
			stmt.executeUpdate();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		} finally {
			stmt.close();
			conn.close();
		}
	}

	public ArrayList<Memberber> SetTableDB(Memberber memberber) {
		try {
			listMember.clear();
			DBcon();

			System.out.println(memberber.getName());
			if(memberber.getName().equals("")){
				stmt = conn.prepareStatement("select * from member");
			}else
			{
				stmt = conn.prepareStatement("select * from member where name=?");
				stmt.setString(1, memberber.getName());
			}
			rs=stmt.executeQuery();
			
			while (rs.next()) {
				Memberber mb = new Memberber();
				mb.setName(rs.getString("name"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				listMember.add(mb);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {

			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listMember;
	}
	public void upDB(Memberber memberber){
		try {
			DBcon();
			stmt = conn.prepareStatement("update member SET name=?, age=?, gender=? where name=?");
			stmt.setString(1, memberber.getName());
			stmt.setInt(2, memberber.getAge());
			stmt.setString(3, memberber.getGender());
			stmt.setString(4, memberber.getName());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {

			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delectDb(Memberber memberber){
		String sql="delete from member where name=?";
		try {
			DBcon();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberber.getName());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {

			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}


}