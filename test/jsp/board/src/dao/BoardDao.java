package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConnectionUtil;
import vo.BoardVO;

public class BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDao() throws SQLException{
		conn = ConnectionUtil.getConnection();
	}
	
	public ArrayList<BoardVO> selectBoard(String search, String category, int pageno) throws SQLException{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT  NO, CATEGORY, TITLE, USERNAME, USERIP				\n");
		sql.append("		, CONTENT, HIT, FILE_NAME, FILE_SIZE, TIME						\n");
		sql.append("FROM(																	\n");
		sql.append("	SELECT ROWNUM R, NO, CATEGORY, TITLE, USERNAME, USERIP	\n");
		sql.append("		 , CONTENT, HIT, FILE_NAME, FILE_SIZE, TIME 					\n");
		sql.append("	FROM BOARD 															\n");
		sql.append("	WHERE TITLE LIKE '%'|| ? ||'%'										\n");
		sql.append("	AND CATEGORY LIKE '%' || ? || '%'									\n");
		sql.append("	AND ROWNUM <= ?														\n");
		sql.append("	)	 																\n");
		sql.append("WHERE R >= ?															\n");
		sql.append("ORDER BY NO DESC														\n");

				
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, search);
		pstmt.setString(2, "all".equals(category)?"":category);
		pstmt.setInt(3, pageno*10);
		pstmt.setInt(4, ((pageno-1)*10)+1);
		
		rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			BoardVO vo = new BoardVO();
			vo.setNo(rs.getInt("no"));
			vo.setCategory(rs.getString("category"));
			vo.setTitle(rs.getString("title"));
			vo.setUsername(rs.getString("username"));
			vo.setUserip(rs.getString("userip"));
			vo.setContent(rs.getString("content"));
			vo.setHit(rs.getInt("hit"));
			vo.setFile_name(rs.getString("file_name"));
			vo.setFile_size(rs.getInt("file_size"));
			vo.setTime(rs.getDate("time"));
			
			list.add(vo);
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return list;
	}
	
	public int cntTotalBoard(String category, String search) throws SQLException{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*)	cnt											\n");
		sql.append("FROM BOARD 													\n");
		sql.append("WHERE TITLE LIKE '%'|| ? ||'%'								\n");
		sql.append("	AND CATEGORY LIKE '%' || ? || '%'						\n");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, search);
		pstmt.setString(2, "all".equals(category)?"":category);
		rs = pstmt.executeQuery();
		
		int result = 0;
		if(rs.next()){
			result = rs.getInt("cnt");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return result;
	}
	
	public BoardVO selectBoard(int no) throws SQLException{
		BoardVO vo = new BoardVO();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT NO, CATEGORY, TITLE, USERNAME, USERIP		\n");
		sql.append("	 , CONTENT, HIT, FILE_NAME, FILE_SIZE, TIME 			\n");
		sql.append("FROM BOARD 													\n");
		sql.append("WHERE NO = ?												\n");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, no);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			vo.setNo(rs.getInt("no"));
			vo.setCategory(rs.getString("category"));
			vo.setTitle(rs.getString("title"));
			vo.setUsername(rs.getString("username"));
			vo.setUserip(rs.getString("userip"));
			vo.setContent(rs.getString("content"));
			vo.setHit(rs.getInt("hit"));
			vo.setFile_name(rs.getString("file_name"));
			vo.setFile_size(rs.getInt("file_size"));
			vo.setTime(rs.getDate("time"));
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return vo;
	}
	
	public int insertBoard(String category, String title, String username, String userip
					 	 , String content, String file_name, int file_size) throws SQLException{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		int max_num = 1;
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT MAX(NO) FROM BOARD");
		
		pstmt = conn.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		if(rs.next()){
			max_num = rs.getInt(1)+1;
		}
		
		sql.delete(0, sql.length());
		
		sql.append("INSERT INTO BOARD(NO, CATEGORY, TITLE, USERNAME, USERIP,  CONTENT, FILE_NAME, HIT, FILE_SIZE, TIME )	\n");
		sql.append("	   VALUES(?, ?, ?, ?, ?, ?, ?, 0, ?, sysdate) 															\n");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, max_num);
		pstmt.setString(2, category);
		pstmt.setString(3, title);
		pstmt.setString(4, username);
		pstmt.setString(5, userip);
		pstmt.setString(6, content);
		pstmt.setString(7, file_name);
		pstmt.setInt(8, file_size);
		
		int result = pstmt.executeUpdate();
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return result;
	}

	public int updateBoard(String category, String title, String username, String userip,
							String content, String file_name, int file_size, int no	) throws SQLException{
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		int max_num = 1;
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE BOARD																									\n");
		sql.append("SET CATEGORY = ?, TITLE = ?, USERNAME = ?, USERIP = ?, CONTENT = ?, FILE_NAME=?, FILE_SIZE = ?, TIME = SYSDATE 	\n");
		sql.append("WHERE NO = ?																									\n"); 
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, category);
		pstmt.setString(2, title);
		pstmt.setString(3, username);
		pstmt.setString(4, userip);
		pstmt.setString(5, content);
		pstmt.setString(6, file_name);
		pstmt.setInt(7, file_size);
		pstmt.setInt(8, no);
		
		int result = pstmt.executeUpdate();
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return result;
		}
	
	public int deleteBoard(int no) throws SQLException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE FROM BOARD		\n");
		sql.append("WHERE NO = ?			\n");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, no);
		
		int result = pstmt.executeUpdate();
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return result;
	}	
	
}
