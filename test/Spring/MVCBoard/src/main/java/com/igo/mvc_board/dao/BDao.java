package com.igo.mvc_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.igo.mvc_board.dto.BDto;
import com.igo.mvc_board.util.Constant;

public class BDao {
	DataSource dataSource;
	JdbcTemplate template=null;

	public BDao(){
		/*try{
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:/comp/env/jdbc/dataSource");
		}catch(Exception e){
			e.printStackTrace();
		}*/
		template=Constant.template;
	}
	
	public ArrayList<BDto> list(){
		/*ArrayList<BDto> dtos=new ArrayList<BDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from mvc_board order by bGroup desc, bStep";
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				BDto dto=new BDto();
				dto.setbId(rs.getInt("bId"));
				dto.setbName(rs.getString("bName"));
				dto.setbTitle(rs.getString("bTitle"));
				dto.setbContent(rs.getString("bContent"));
				dto.setbDate(rs.getTimestamp("bDate"));
				dto.setbHit(rs.getInt("bHit"));
				dto.setbGroup(rs.getInt("bGroup"));
				dto.setbStep(rs.getInt("bStep"));
				dto.setbIndent(rs.getInt("bIndent"));
				dtos.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt,rs);
		}
		return dtos;*/
		
		if(template != null)
			System.out.println("list");
		String query = "select * from mvc_board order by bGroup desc, bStep asc";
        return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	//안에 함수와 밖에 메소드의 변수를 불려오니 메소드 변수에 final을 해야하는군요 음~~
	public void write(final String bName, final String bTitle, final String bContent){
		/*Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into mvc_board(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)"
				+" values(mvc_board_seq.nextval, ?, ?, ?, mvc_board_seq.currval, 0, 0)";
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt);
		}*/
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String query="insert into mvc_board(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)"
						+" values(mvc_board_seq.nextval, ?, ?, ?, mvc_board_seq.currval, 0, 0)";
				
				PreparedStatement pstmt=conn.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
	}
	
	
	public BDto content_view(String strId){
		/*BDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from mvc_board where bId=?";
		upHit(strId);
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto=new BDto();
				dto.setbId(rs.getInt("bId"));
				dto.setbName(rs.getString("bName"));
				dto.setbTitle(rs.getString("bTitle"));
				dto.setbContent(rs.getString("bContent"));
				dto.setbDate(rs.getTimestamp("bDate"));
				dto.setbHit(rs.getInt("bHit"));
				dto.setbGroup(rs.getInt("bGroup"));
				dto.setbStep(rs.getInt("bStep"));
				dto.setbIndent(rs.getInt("bIndent"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt,rs);
		}
		
		return dto;*/
		
		String query="select * from mvc_board where bId =" + strId;
		upHit(strId);
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	private void upHit(final String strId){
		/*Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update mvc_board set bHit=bHit+1 where bId=?";
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			pstmt.executeUpdate();			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt);
		}*/
		
		String query="update mvc_board set bHit=bHit+1 where bId=?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				
				 pstmt.setInt(1, Integer.parseInt(strId));
				
			}
		}); 
		
	}
	public void modify(final String strId, final String bName, final String bTitle, final String bContent){
	/*	Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(strId));
			pstmt.executeUpdate();			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt);
		}*/
		
		String query="update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(strId));			
			}
		});
	}
	
	public void delete(final String strId){
		/*Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from mvc_board where bId=?";
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			pstmt.executeUpdate();			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt);
		}*/
		
		String query="delete from mvc_board where bId=?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(strId));			
			}
		});
	}
	
	public void reply(final String strId, final String bName, final String bTitle, final String bContent){
		final BDto dto= content_view(strId);
		//int group=dto.getbGroup();
		//int step=dto.getbStep()+1;
		//int indent=dto.getbIndent()+1;
		
		/*String sql="insert into mvc_board(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)"
				+"values(mvc_board_seq.nextval,?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, group);
			pstmt.setInt(5, step);
			pstmt.setInt(6, indent);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closedb(conn,pstmt);
		}*/
		
		upstep(dto.getbGroup(), dto.getbStep());
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				
				String query="insert into mvc_board(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)"
						+"values(mvc_board_seq.nextval,?,?,?,?,?,?)";
				  PreparedStatement pstmt = conn.prepareStatement(query);  
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, dto.getbGroup());
				pstmt.setInt(5, dto.getbStep()+1);
				pstmt.setInt(6, dto.getbIndent()+1);
				return pstmt;
			}
		});
		
		
	}
	
	public void upstep(final int group, final int step){
		String query="update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, group);
				pstmt.setInt(2, step);
			}
		});
	}
	
	/*private void closedb(Connection con, PreparedStatement pstmt, ResultSet rs){
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
			
		}catch(Exception e){}
	}
	private void closedb(Connection con, PreparedStatement pstmt){
		try{
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
			
		}catch(Exception e){}
	}*/

}
