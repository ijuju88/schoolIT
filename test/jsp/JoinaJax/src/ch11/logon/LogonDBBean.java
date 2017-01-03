package ch11.logon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class LogonDBBean {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private LogonDBBean() {
	}
	
	private static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance() {
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
 
   //회원 가입 처리(registerPro.jsp)에서 사용하는  새 레코드 추가 메소드
    public void insertMember(MemberBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
        	
            pstmt = conn.prepareStatement(
            	"insert into member values (?,?,?,?,?,?)");
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
        	DBclose();   
        }
    }
 
	//로그인 폼 처리(loginPro.jsp)페이지의 사용자 인증 처리 및
    //회원정보수정/탈퇴를 사용자인증(memberCheck.jsp)에서 사용하는 메소드
  public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		try {
            conn = getConnection();
          
            pstmt = conn.prepareStatement(
            	"select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){//해당 아이디가 있으면 수행
				String dbpasswd= rs.getString("passwd"); 
				if(rs.getString("PASSWD").equals(dbpasswd))
					x= 1; //인증성공
				else
					x= 0; //비밀번호 틀림
			}else//해당 아이디 없으면 수행
				x= -1;//아이디 없음
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			DBclose();
        }
		return x;
	}

    //아이디 중복 확인 (confirmId.jsp)에서 아이디의 중복 여부를 확인하는 메소드
	public int confirmId(String id) {
		conn = null;
        pstmt = null;
		rs= null;
		int x=-1;
        
		try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select id from member where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next())//아이디 존재
				x= 1; //같은 아이디 있음
			else
				x= -1;//같은 아이디 없음
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			DBclose();
        }
		return x;
	}

   //회원 정보 수정 폼(modifyForm.jsp)을 위한 기존 가입 정보를 가져오는 메소드
    public MemberBean getMember(String id, String passwd){
        conn = null;
        pstmt = null;
        rs = null;
        MemberBean member=null;
     
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select * from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {//해당 아이디에 대한 레코드가 존재
                  member = new MemberBean();//데이터저장빈 객체생성
                  member.setId(rs.getString("id"));
				  member.setName(rs.getString("name"));
                  member.setReg_date(rs.getTimestamp("reg_date"));
                  member.setAddress(rs.getString("address"));
                  member.setTel(rs.getString("tel"));
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
           DBclose();
        }
		return member;//데이터 저장빈 객체 member 리턴
    }
    
    //회원 정보 수정 처리(modifyPro.jsp)에서 회원 정보 수정을 처리하는 메소드
    public void updateMember(MemberBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
    
            pstmt = conn.prepareStatement("update member set passwd=?, name=?, "
                            + "address=?,tel=? where id=?");
            pstmt.setString(1, member.getPasswd());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getAddress());
            pstmt.setString(4, member.getTel());	
            pstmt.setString(5, member.getId());
            pstmt.executeUpdate();
          
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	DBclose();
        }
    }
    
    //회원 탈퇴 처리(deletePro.jsp)에서 회원 정보를 삭제하는 메소드
    public int deleteMember(String id, String passwd){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
    
        try {
			conn = getConnection();
            pstmt = conn.prepareStatement("select passwd from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				String dbpasswd= rs.getString("passwd"); 
				if(dbpasswd.equals(rs.getString("PASSWD"))){
					pstmt = conn.prepareStatement("delete from member where id=?");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
					x= 1;//회원탈퇴처리 성공
				}else
					x= 0;//회원탈퇴 처리 실패
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
          DBclose();
        }
		return x;
    }
}