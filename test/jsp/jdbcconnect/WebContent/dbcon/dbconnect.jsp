<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String url1 = "jdbc:oracle:thin:@localhost:1521:xe";
	String id1 = "test2";
	String pw1 = "1234";

	//mysql
	String url2 = "jdbc:mysql://localhost:3306/emp";
	String id2 = "oxju88";
	String pw2 = "1234";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jdbc</title>
</head>
<body>
	<table>
		<tr bordercolor="#D8D8D8">
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>전화번호</th>
		</tr>

		<%
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url1, id1, pw1);
				//Class.forName("org.gjt.mm.mysql.Driver");
				//conn = DriverManager.getConnection(url2, id2, pw2);
				out.println("연결완료!!" + "<br>");

				try {
					//String sql="insert into login values('abcd', '1234', '김철수', '111-2222-2222')";
					//pstmt=conn.prepareStatement(sql);
					//pstmt.executeUpdate();

					String sql = "select * from login";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
			
						String id = rs.getString(1);
						String pw = rs.getString(2);
						String name = rs.getString(3);
						String tel = rs.getString(4);
						
						out.println("<tr>");
						out.println("<td>"+id+"</td>");
						out.println("<td>"+pw+"</td>");
						out.println("<td>"+name+"</td>");
						out.println("<td>"+tel+"</td>");
						out.println("<tr>");
					}

					out.println("들어감!!" + "<br>");
				} catch (Exception e) {
					out.print(e.getMessage());
				}

			} catch (Exception e) {
				out.println("실패 ㅠㅠ" + "<br>");
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}
			}
		%>
	</table>
</body>
</html>