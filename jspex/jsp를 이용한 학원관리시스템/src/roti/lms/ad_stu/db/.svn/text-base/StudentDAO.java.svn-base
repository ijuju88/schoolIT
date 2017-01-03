/* JDK version : JDK1.70_51
 날짜 : 2014년 05월 21일 
 핵심구문 : if,try~catch
 기능: DB에 열결 하여 select,insert,update,delete의 쿼리문을 실행 하는 기능 */
package roti.lms.ad_stu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;










//import net.board.db.BoardBean;

public class StudentDAO {
	
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
public StudentDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}

public int getListCount() {
	int x= 0;
	
	try{
		
		con=ds.getConnection();
		System.out.println("getConnection");
		pstmt=con.prepareStatement("select count(*) from student");
		rs = pstmt.executeQuery();
		if(rs.next()){
			x=rs.getInt(1);
		}
	}catch(Exception ex){
		System.out.println("getListCount 에러: " + ex);			
	}finally{
		if(rs!=null) try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		if(con!=null) try{con.close();}catch(SQLException ex){}
	}
	return x;
}

public boolean studentDelete(String st_id){
	
	String student_delete_sql="delete from student where st_id=?";
	
	int result=0;
	
	try{
		con = ds.getConnection();
		pstmt=con.prepareStatement(student_delete_sql);
		pstmt.setString(1, st_id);
		result=pstmt.executeUpdate();
		if(result==0)return false;
		
		return true;
	}catch(Exception ex){
		System.out.println("studentDelete 에러 : "+ex);
	}	finally{
		try{
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			}
			catch(Exception ex){}
		
	}
	
	return false;
}


//public List getStudentList(int page,int limit){
public List getStudentList(int page,int limit){
//	String student_list_sql="select * from "+
//	"(select rownum rnum,st_id,st_pass,st_name,birth,addr"
//	+ ",st_hp,st_ehp,gender,rdate from "+
//	"(select * from student order by st_id desc)) "+
//	"where rnum>=? and rnum<=?";

	//리스트 검색 쿼리문 실행
	String student_list_sql="select * from student";
	List list = new ArrayList();
	int startrow=(page-1)*10+1; //읽기 시작할 row 번호.
	int endrow=startrow+limit-1; //읽을 마지막 row 번호.		
	try{
		con = ds.getConnection();
		pstmt=con.prepareStatement(student_list_sql);
//		pstmt.setInt(1, startrow);
//		pstmt.setInt(2, endrow);
		rs = pstmt.executeQuery();
        
		while(rs.next()){
			StudentBean student = new StudentBean();
//			StudentBean student = new StudentBean();
			student.setSt_id(rs.getString("st_id"));
			student.setSt_pass(rs.getString("st_pass"));
			student.setSt_name(rs.getString("st_name"));
			student.setBirth(rs.getInt("birth"));
			student.setAddr(rs.getString("addr"));
			student.setSt_hp(rs.getString("st_hp"));
			student.setSt_ehp(rs.getString("st_ehp"));
			student.setGender(rs.getString("gender"));
			student.setRdate(rs.getString("rdate"));
			list.add(student);

		}
		
		return list;
	}catch(Exception ex){
		System.out.println("실패");
		System.out.println("getStudentList 에러 : " + ex);
	}finally{
		if(rs!=null) try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		if(con!=null) try{con.close();}catch(SQLException ex){}
	}
	return null;
}


public boolean studentInsert(StudentBean student){
	

//	String sql="";
	
	int result=0;
	try{
		con = ds.getConnection();

		//학생 등록 쿼리문 실행
		String sql="insert into student" +" values(?,?,?,?,?,?,?,?,?)";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getSt_id());
	    pstmt.setString(2, student.getSt_pass());
	    pstmt.setString(3, student.getSt_name());
	    pstmt.setInt(4, student.getBirth());
	    pstmt.setString(5, student.getAddr());
	    pstmt.setString(6, student.getSt_hp());
	    pstmt.setString(7, student.getSt_ehp());
	    pstmt.setString(8, student.getGender());
	    pstmt.setString(9, student.getRdate());	    
		
		result=pstmt.executeUpdate();
		if(result==0)return false;
		return true;
	}catch(Exception ex){
		System.out.println("studentInsert 에러 : "+ex);
	}finally{
		if(rs!=null) try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		if(con!=null) try{con.close();}catch(SQLException ex){}
	}
	return false;
}

public boolean studentModify(StudentBean modifystudent) throws Exception{
	System.out.println("1");
	//수정  쿼리문 실행 
	String sql="update student set ST_PASS = ?,ST_NAME = ?,BIRTH = ?,ADDR = ?,ST_HP = ?,ST_EHP = ?"
	           +",GENDER = ?,RDATE = ? where ST_ID=?";
	System.out.println("2");
	try{
		System.out.println("3");
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, modifystudent.getSt_pass());
		pstmt.setString(2, modifystudent.getSt_name());
		pstmt.setInt(3, modifystudent.getBirth());
		pstmt.setString(4, modifystudent.getAddr());
		System.out.println("4");
		pstmt.setString(5, modifystudent.getSt_hp());
		pstmt.setString(6, modifystudent.getSt_ehp());
		pstmt.setString(7, modifystudent.getGender());
		pstmt.setString(8, modifystudent.getRdate());
		pstmt.setString(9, modifystudent.getSt_id());
		System.out.println("5");
		pstmt.executeUpdate();
		return true;
	}catch(Exception ex){
		System.out.println("boardModify 에러 : " + ex);
	}finally{
		if(rs!=null)try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
		if(con!=null) try{con.close();}catch(SQLException ex){}
		}
	return false;
}

//public boolean isStudentWriter(String st_id){
//public String isStudentWriter(String member_id, String st_id){	
//	String student_sql="select * from student where st_id=?";
//	try{
//		con = ds.getConnection();
//		pstmt=con.prepareStatement(student_sql);
//		pstmt.setString(1, member_id);
//		rs=pstmt.executeQuery();
//		rs.next();
//		if(st_id.equals(rs.getString("st_id"))){
//			return null;
//		}
//	}catch(SQLException ex){
//		System.out.println("isBoardWriter 에러 : "+ex);
//	}
//finally{
//		try{
//		if(pstmt!=null)pstmt.close();
//		if(con!=null) con.close();
//		}
//		catch(Exception ex){}
//	
//}
//	return null;
//}

public boolean isStudentWriter(String member_id, String st_id){	
	String student_sql="select * from student where st_id=?";
	try{
		con = ds.getConnection();
		pstmt=con.prepareStatement(student_sql);
		pstmt.setString(1, member_id);
		rs=pstmt.executeQuery();
		rs.next();
		if(st_id.equals(rs.getString("st_id"))){
			return true;
		}
	}catch(SQLException ex){
		System.out.println("isBoardWriter 에러 : "+ex);
	}
finally{
		try{
		if(pstmt!=null)pstmt.close();
		if(con!=null) con.close();
		}
		catch(Exception ex){}
	
}
	return false;
}

public int idCheck(String st_id){
	  int rst = 0;
	  Connection conn = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  try{
	   conn = ds.getConnection();
	   String sql = "select * from student where st_id=?";
	   ps = conn.prepareStatement(sql);
	   ps.setString(1, st_id);
	   rs = ps.executeQuery();
	   if(rs.next()){
	    rst = 1;
	   }
	  }catch(Exception e){
	   e.printStackTrace();
	  }finally{
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null) conn.close();
				}
				catch(Exception ex){}
			
		}
			return rst;
	 }
}
