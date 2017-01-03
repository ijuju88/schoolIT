package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberBean;

public class DBBean {
	//DBBean 전역 객체 생성 <- 한개의 객제만 생성해서 공유
    private static DBBean instance = new DBBean();
    
    //DBBean객체를 리턴하는 메소드
    public static DBBean getInstance() {
        return instance;
    }
    
    private DBBean() {}
    
    //커넥션 풀에서 커넥션 객체를 얻어내는 메소드
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/test1Mysql");
        return ds.getConnection();
    }
 
    //회원 가입 처리(registerPro.jsp)에서 사용하는  새 레코드 추가 메소드
    public void insertMember(MemberBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql="insert into member values (?,?,?,?,?,?)";
        try {
            conn = getConnection();        	
            pstmt = conn.prepareStatement(sql); 	
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPasswd());
            pstmt.setString(3, member.getName());
            pstmt.setTimestamp(4, member.getReg_date());
            pstmt.setString(5, member.getAddress());
            pstmt.setString(6, member.getTel());		
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	 closeDB(conn, pstmt, rs);
        }
    }
 
	//로그인 폼 처리(loginPro.jsp)페이지의 사용자 인증 처리 및
    //회원정보수정/탈퇴를 사용자인증(memberCheck.jsp)에서 사용하는 메소드
    public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        String sql="select passwd from member where id = ?";
		try {
            conn = getConnection();
        	
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){//해당 아이디가 있으면 수행
				String dbpasswd= rs.getString("passwd"); 
				if(passwd.equals(dbpasswd))
					x= 1; //인증성공
				else
					x= 0; //비밀번호 틀림
			}else//해당 아이디 없으면 수행
				x= -1;//아이디 없음
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	 closeDB(conn, pstmt, rs);
        }
		return x;
	}
    
    //아이디 중복 확인 (confirmId.jsp)에서 아이디의 중복 여부를 확인하는 메소드
	public int confirmId(String id) {
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql="select id from member where id = ?";
		int x=-1;
		try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(sql	);
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next())//아이디 존재
				x= 1; //같은 아이디 있음
			else
				x= -1;//같은 아이디 없음
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	 closeDB(conn, pstmt, rs);
        }
		return x;
	}

   //회원 정보 수정 폼(modifyForm.jsp)을 위한 기존 가입 정보를 가져오는 메소드
    public MemberBean getMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberBean member=null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select * from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
     
            if (rs.next()) {//해당 아이디에 대한 레코드가 존재
            	String dbpasswd= rs.getString("passwd");
            	//사용자가 입력한 비밀번호와 테이블의 비밀번호가 같으면 수행
				if(passwd.equals(dbpasswd)){
                  member = new MemberBean();//데이터저장빈 객체생성
                  member.setId(rs.getString("id"));
				  member.setName(rs.getString("name"));
                  member.setReg_date(rs.getTimestamp("reg_date"));
                  member.setAddress(rs.getString("address"));
                  member.setTel(rs.getString("tel"));
				}
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	 closeDB(conn, pstmt, rs);
        }
		return member;//데이터 저장빈 객체 member 리턴
    }
    
    //회원 정보 수정 처리(modifyPro.jsp)에서 회원 정보 수정을 처리하는 메소드
    public int updateMember(MemberBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
                	"select passwd from member where id = ?");
            pstmt.setString(1, member.getId());
            rs = pstmt.executeQuery();
                
            if(rs.next()){//해당 아이디가 있으면 수행
				String dbpasswd= rs.getString("passwd"); 
				if(member.getPasswd().equals(dbpasswd)){
                    pstmt = conn.prepareStatement(
                     "update member set name=?,address=?,tel=? where id=?");
                    pstmt.setString(1, member.getName());
                    pstmt.setString(2, member.getAddress());
                    pstmt.setString(3, member.getTel());
                    pstmt.setString(4, member.getId());
                    pstmt.executeUpdate();
                    x= 1;//회원정보 수정 처리 성공
				}else
					x= 0;//회원정보 수정 처리 실패
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	 closeDB(conn, pstmt, rs);
        }
        return x;
    }
    
    //회원 탈퇴 처리(deletePro.jsp)에서 회원 정보를 삭제하는 메소드
    public int deleteMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        
        try {
			conn = getConnection();
			
            pstmt = conn.prepareStatement(
            	"select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(passwd.equals(dbpasswd)){
					pstmt = conn.prepareStatement(
            	      "delete from member where id=?");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
					x= 1;//회원탈퇴처리 성공
				}else
					x= 0;//회원탈퇴 처리 실패
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
           closeDB(conn, pstmt, rs);
        }
		return x;
    }
    private void closeDB(Connection con, PreparedStatement ps, ResultSet rs){
    	try{
    		if(rs!=null) rs.close();
    		if(ps!=null)ps.close();
    		if(con!=null)con.close();
    	}catch(Exception e){}
    }
}
