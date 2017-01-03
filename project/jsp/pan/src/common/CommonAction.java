package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import reservation.ReservationBean;
import util.ConnectionUtil;

public class CommonAction {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static CommonAction instance = new CommonAction();
	
	public CommonAction(){}
	
	// 객체 리턴
	public static CommonAction getInstance(){
		return instance;
	}

	
	// commonPro.jsp 처리 수정 (테이블명 PUBLICPENSION / CommonBean.jsp 참고)
	public void updateCommon(CommonBean common){

		String SQL = "//작성부분";
		//작성부분(try~finally)
		//getConnection와 finally문은 selectMember문참고
		
	}
	
	// commonPro.jsp 처리 보기 --회원찾기  (테이블명 PUBLICPENSION / CommonBean.jsp 참고)
	public CommonBean selectCommon(){
		CommonBean cb = null;
		
		//작성부분(try~finally)
		
		return cb;
	}
	
	
	// member.jsp 회원리스트  --searcht:검색타이틀명  searchv:검색내용
	public Vector<MemberBean> selectMember(String searcht,String searchv,int startNum,int endNum){
		Vector<MemberBean> vmb = null;
		
		String whereSearch = "";
		if( searcht.length() > 0 && searchv.length() > 0 ){
			//검색하기 (힌트 : like 들어감)
			whereSearch = " //작성부분 (sql)";
		}
		
		// 검색한 회원 select
		String CSQL ="/* 작성부분 */"+whereSearch ;

		String SQL = "SELECT * FROM (SELECT ROWNUM AS RNUM,MEM.* FROM " + 
					 "(SELECT * FROM MEMBER "+whereSearch+" ORDER BY MNO DESC) " + 
					 "MEM) WHERE RNUM BETWEEN ? AND ?";
		try{
			conn = ConnectionUtil.getConnection();
			if( startNum == 0 && endNum == 0 ){
				pstmt = conn.prepareStatement(CSQL);
			}else{
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1,startNum);
				pstmt.setInt(2,endNum);
			}
			rs = pstmt.executeQuery();
			if( startNum == 0 && endNum == 0 ){
				if( rs.next() ){
					vmb = new Vector<MemberBean>();
					MemberBean mb = new MemberBean();
					mb.setMno(rs.getInt(1));
					vmb.add(mb);
				}
			}else{
				if( rs.next() ){
					vmb = new Vector<MemberBean>();
					do{
						//회원얻기
						MemberBean mb = new MemberBean();
						mb.setMno(rs.getInt("mno"));
						/*
						작성부분(MemberBean를 참고해 나머지도 작성, add도 ㅋㅋ)
						지금 코드는 passwd,zip,addr1,addr2 가 빠지고 나머지임
						
						*zip(주소),addr1(주소1),addr2(주소2-상세주소)도 추가하고
						member.jsp에도 테이블 추가하기
						*/
					}while( rs.next() );
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(conn, pstmt, rs);
		}
		return vmb;
	}
	
}