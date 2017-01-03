package com.people.subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SubjectDB {

	// 1. JDBC MARIADB JAR 파일 받고 클래스 패스 (라이브러리) 추가해주기 
	
	// 2. MariaDB URL (저장 장소) 지정
	
//	private String url = "jdbc:mariadb://localhost:3306/java";
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
		
	// 3. MariaDB DriverClass (객체 로딩) 실행
//	private String driverClass = "org.mariadb.jdbc.Driver";
	private String driverClass = "oracle.jdbc.OracleDriver";
	
	// Username, Password 설정
	private String dbuid = "oxju88";
	private String dbpwd = "1234";

	
	// 저장하기
	public void insert (String a1, String a2, String a3, String a4, String a5, String a6) {

		try {
			// 드라이버 클래스 로딩
			Class.forName(driverClass);
			// 커넥션 개체 가져오기 (위에서 설정한 url, username, password)
			Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);

			// Preparedstatement 사용 sql 쿼리 보내기
//			String sql = "insert into 건국대.건국대학교 (학기, 필수여부, 과목코드, 과목명, 과목설명, 학점시수)"
//					+ " values ('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "')";
			String sql = "INSERT INTO 건국대학교 VALUES ('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "')";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 조회하기
	public List<Subject> search() throws ClassNotFoundException, SQLException, IOException  {

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
//		String sql = "select * from 건국대.건국대학교";
		String sql = "SELECT * FROM 건국대학교";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery(sql);
		
		List<Subject> list = new ArrayList<>();

		while(rs.next() == true) {
		 	Subject subject = new Subject();
			subject.setSemester(rs.getString("학기"));
			subject.setIsRequired(rs.getString("필수여부"));
			subject.setSubjectCode(rs.getString("과목코드"));
			subject.setSubjectName(rs.getString("과목명"));
			subject.setSubjectDescription(rs.getString("과목설명"));
			subject.setScore(rs.getString("학점시수"));
			list.add(subject);
		}
		
		connection.close();

	 return list;
}
		
	// 삭제하기 (1개)
	public void delete (String primary) throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
		String sql = "DELETE FROM 건국대학교 WHERE 과목명='" + primary + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeQuery();
		connection.close();
		}
	
	// 삭제하기 (복수)
	public void delete (List<String> delList)  throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
			for (int i = 0; i < delList.size(); i++) {
				String primaryKey = delList.get(i);
				String sql = "DELETE FROM 건국대학교 WHERE 과목명='" + primaryKey + "'";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeQuery();
			}
			connection.close();
		}
	
	// 선택셀 보여주기
	public Subject selectView(String primary) throws ClassNotFoundException, SQLException, IOException  {

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
		String sql = "select * from 건국대학교 where 과목명 = '"+primary+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery(sql);
		
		Subject subject = new Subject();
		while(rs.next() == true) {
			subject.setSemester(rs.getString("학기"));
			subject.setIsRequired(rs.getString("필수여부"));
			subject.setSubjectCode(rs.getString("과목코드"));
			subject.setSubjectName(rs.getString("과목명"));
			subject.setSubjectDescription(rs.getString("과목설명"));
			subject.setScore(rs.getString("학점시수"));
		}
		
		connection.close();

	 return subject;
	 
}
	
	// 수정하기
	public void modify (String primary, String s1, String s2, String s3, String s4, String s5) throws ClassNotFoundException, SQLException    {
		
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
		
		String sql = "UPDATE 건국대학교 SET 학기='"+s1+"',"
				+ "필수여부 = '"+s2+"',"
				+ "과목코드 = '"+s3+"',"
				+ "과목설명 = '"+s4+"',"
				+ "학점시수 = '"+s5+"'"
				+ " WHERE 과목명='" +primary+ "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeQuery();
		connection.close();
	}
	
	// 조건검색하기
	public List<Subject> partSearch(String sql) throws ClassNotFoundException, SQLException, IOException  {

		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, dbuid, dbpwd);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery(sql);
		
		List<Subject> list = new ArrayList<>();

		while(rs.next() == true) {
		 	Subject subject = new Subject();
			subject.setSemester(rs.getString("학기"));
			subject.setIsRequired(rs.getString("필수여부"));
			subject.setSubjectCode(rs.getString("과목코드"));
			subject.setSubjectName(rs.getString("과목명"));
			subject.setSubjectDescription(rs.getString("과목설명"));
			subject.setScore(rs.getString("학점시수"));
			list.add(subject);
		}
		
		connection.close();

	 return list;
}
}
	
	
	
	




