package item;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.*;

public class ItemDBConn {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ItemBean ib=null;

	public ItemDBConn() {
	}

	private static ItemDBConn dbconn = new ItemDBConn();

	public static ItemDBConn getInstance() {
		return dbconn;
	}

	private Connection getItemDBConn() {
		Connection conn = null;

		/*String url = "jdbc:mysql://localhost:3306/emp";
		String id = "oxju88";
		String pw = "1234";*/

		try {
			/*Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		*/
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/oxju88Mysql");
			conn = ds.getConnection();
			
			System.out.println("연결완료!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return conn;
	}
	
	public void dicon(){
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void InsertItem(ItemBean ib){
		conn=null;
		pstmt=null;
		String sql="insert into item(name, price, description) values(?,?,?)";
		
		try {
			conn = getItemDBConn();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ib.getName());
			pstmt.setInt(2, ib.getPrice());
			pstmt.setString(3, ib.getDescription());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("안들어감??:" + e.getMessage());
		} finally {
			dicon();
			
		}
	}
	
	public ArrayList<ItemBean> SelectItem(){
		ArrayList<ItemBean> list=new ArrayList<>();
		conn=null;
		pstmt=null;
		rs=null;
		String sql="select * from emp.item";
		
		try {
			conn = getItemDBConn();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ib=new ItemBean();
				
				ib.setNo(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setPrice(rs.getInt(3));
				ib.setDescription(rs.getString(4));
				
				list.add(ib);
				
			}

		} catch (Exception e) {
			System.err.println("안나옴??:" + e.getMessage());
		} finally {
			dicon();
		}
		return list;
		
	}
	
	public ItemBean ViewItem(int no){
		ib=null;
		conn=null;
		pstmt=null;
		rs=null;
		String sql="select * from item where no=?";
		
		try {
			conn = getItemDBConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ib=new ItemBean();			
				ib.setNo(rs.getInt(1));
				ib.setName(rs.getString(2));
				ib.setPrice(rs.getInt(3));
				ib.setDescription(rs.getString(4));
				
			}

		} catch (Exception e) {
			System.err.println("안나옴??:" + e.getMessage());
		} finally {
			dicon();
		}
		
		return ib;	
	}
	
	public ItemBean ModityItem(ItemBean ib){
		conn = null;
		pstmt = null;
		rs = null;
		String sql="update item set name=?, price=?, description=? where no=?";
		
		try {
			conn = getItemDBConn();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ib.getName());
			pstmt.setInt(2, ib.getPrice());
			pstmt.setString(3, ib.getDescription());
			pstmt.setInt(4, ib.getNo());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("수정안됨??:" + e.getMessage());
		} finally {
			dicon();
		}
		return ib;
	}
	
	public boolean DelItem(int no, String namedel){
		boolean re=false;
		conn=null;
		pstmt=null;
		String sql="delete from item where no=?";
		String dbname=getNameDel(no);
		System.out.println(dbname.toString()+", "+namedel);
		if(dbname.equals(namedel)){
			re=true;
			try{
				conn = getItemDBConn();
				pstmt = conn.prepareStatement(sql);
				System.out.println(no);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}catch (Exception e) {
				System.err.println("안지워짐??:" + e.getMessage());
			} finally {
				dicon();
			}
			
		}
		return re;
		
	}

	private String getNameDel(int no) {
		String renamedel=null;
		conn=null;
		pstmt=null;
		rs=null;
		String sql="select name from item where no=?";
		
		try{
			conn = getItemDBConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				renamedel=rs.getString("name");
			}
		}catch (Exception e) {
			System.err.println("안맞음??:" + e.getMessage());
		} finally {
			dicon();
		}
		return renamedel;
	}
}
