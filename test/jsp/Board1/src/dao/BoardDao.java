package dao;

import java.sql.*;
import java.util.*;

import dto.BoardReplyVo;
import dto.BoardVo;
import util.DBManager;

public class BoardDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardDao() {
		// TODO Auto-generated constructor stub
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	// 리스트
	public List<BoardVo> selectAllBaords(int start, int end) {
		String sql = "select * from board1 order by num desc limit ?, ?";

		List<BoardVo> list = new ArrayList<>();
		conn = null;
		pstmt = null;
		rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVo bVo = new BoardVo();

				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				

				list.add(bVo);
			}
		} catch (Exception e) {
			System.err.println("select 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 삽입
	public void insertBoard(BoardVo bVo) {
		String sql = "insert into board1(name, email, pass,title, content, writedate) values(?,?,?,?,?,now())";

		conn = null;
		pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("insert 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 카운터
	public void updateReadCount(int num) {
		String sql = "update board1 set readcount=readcount+1 where num=?";

		conn = null;
		pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("카운터 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 상세
	public BoardVo selectOneBoardByNum(int num) {
		String sql = "select * from board1 where num=?";
		
		BoardVo bVo=null;
		conn = null;
		pstmt = null;
		rs=null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs=pstmt.executeQuery();
			
			while(rs.next()){
				bVo=new BoardVo();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
			}
			
		} catch (Exception e) {
			System.err.println("selectOne 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}
	
	
	//수정
	public void updateBoard(BoardVo bVo){
		String sql = "update board1 set name=?, email=?, pass=?, title=?, content=? where num=?";

		conn = null;
		pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("update 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//pass체크
	public BoardVo checkPassWord(String pass, String num){
String sql = "select * from board1 where pass=? num=?";
		
		BoardVo bVo=null;
		conn = null;
		pstmt = null;
		rs=null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pass);
			pstmt.setString(2, num);

			rs=pstmt.executeQuery();
			
			while(rs.next()){
				bVo=new BoardVo();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
			
		} catch (Exception e) {
			System.err.println("passCheck 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}
	
	
	//삭제
	public void deleteBoard(String num){
		String sql = "delete from board1 where num=?";

		conn = null;
		pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("delete 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//페이지
	public int getBoardCount(){
		int count=0;
		conn = null;
		pstmt = null;
		rs=null;
		
		String sql="select count(*) from board1;";
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch (Exception e) {
			System.err.println("count 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return count;
	}
	
	//댓글삽입
	public void insertReply(BoardReplyVo BRvo){
		String sql = "insert into reply(name, pass, content,group_num) values(?,?,?,?)";

		conn = null;
		pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, BRvo.getName());
			pstmt.setString(2, BRvo.getPass());
			pstmt.setString(3, BRvo.getContent());
			pstmt.setInt(4, BRvo.getGroup_num());

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("댓글insert 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//댓글리스트
	public List<BoardReplyVo> selectReply(int num) {
		String sql = "select * from reply where group_num=? order by num desc";

		List<BoardReplyVo> replyList = new ArrayList<>();
		conn = null;
		pstmt = null;
		rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				BoardReplyVo BRvo = new BoardReplyVo();
				BRvo.setNum(rs.getInt("num"));
				BRvo.setName(rs.getString("name"));
				BRvo.setPass(rs.getString("pass"));
				BRvo.setContent(rs.getString("content"));
				BRvo.setGroup_num(rs.getInt("group_num"));
				BRvo.setWritedate(rs.getTimestamp("writedate"));

				replyList.add(BRvo);
			}
		} catch (Exception e) {
			System.err.println("select 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return replyList;
	}
	
	//댓글개수
	public int getBoardRelpyCount(int num){
		int count=0;
		conn = null;
		pstmt = null;
		rs=null;
		
		String sql="select count(*) from reply where group_num=?";
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch (Exception e) {
			System.err.println("댓글count 에러 =>" + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return count;
	}
}
