package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import util.ConnectionUtil;

public class ActionBean {
	
	public ActionBean(){}
	
	
	// DB연결객체 Close
	private void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(rs != null) try{ rs.close(); }catch(SQLException e){}finally{ rs = null; }
		if(pstmt != null) try{ pstmt.close(); }catch(SQLException e){}finally{ pstmt = null; }
		if(conn != null) try{ conn.close(); }catch(SQLException e){}finally{ conn = null; }
	}
	
	
	// 방정보 검색(방정보불러오기 방테이블은 Room)
	public Vector<RoomBean> getRoom(){
		Vector<RoomBean> rooms = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "//작성부분";
		try{
			conn = ConnectionUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			/*
				while(rs.next()){...}
				으로만 작성하면 마지막 줄만 나옴 ㅋ
			*/
			if( rs.next() ){
				rooms = new Vector<RoomBean>();
				do{
					//작성부분
				}while(rs.next());	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return rooms;
	}
}