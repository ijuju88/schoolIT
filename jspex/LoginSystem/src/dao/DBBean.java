package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberBean;

public class DBBean {
	private DBBean(){}
	private static DBBean instance=new DBBean();
	public static DBBean getInstance(){
		return instance;
	}
	
	private Connection getConnect(){
		Connection conn=null;
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mypgmDB");
			conn = ds.getConnection();
			//etc.
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public void insertMember(MemberBean member){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into member(id, passwd, name, address, tel) values(?,?,?,?,?)";
		try{
			conn=getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getTel());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB(conn, pstmt, rs);
		}
	}
	
	public int confirmId(String id){
		int x=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select id from member where id=?";
		try{
			conn=getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				x=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB(conn, pstmt, rs);
		}
		return x;
	}
	
	public int userCheck(String id, String pwd){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=-1;
		String sql="select passwd from member where id=?";
		try{
			conn=getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("passwd").equals(pwd)){
					x=1;
				}else{
					x=0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB(conn, pstmt,rs);
		}
			
		
		return x;
	}
	
	public MemberBean getMember(String id){
		MemberBean member=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from member where id=?";
		try{
			conn=getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getTimestamp("reg_date"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB(conn, pstmt,rs);
		}
		
		return member;
	}
	
	public int updateMember(MemberBean member){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=-1;
		String sql="update member set passwd=?, name=?, address=?, tel=? where id=?";
		try{
			conn=getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getId());
			x=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB(conn, pstmt, rs);
		}
		return x;
	}
	
	public int deleteMember(String id){
		int x=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from member where id=?";
		try{
			conn=getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			x=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB(conn, pstmt, rs);
		}
		
		return x;
	}
	
	private void closeDB(Connection con, PreparedStatement ps, 
			ResultSet rs){
		try{
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		}catch(Exception e){}
	}

}
