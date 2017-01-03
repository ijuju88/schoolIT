<%@page import="dao.DBConnect"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	//자바빈으로~~
	/* Member member = new Member();
	member.setId(request.getParameter("id"));
	member.setPw(request.getParameter("pw"));
	member.setName(request.getParameter("name"));
	member.setTel(request.getParameter("tel"));
	member.setAge(Integer.parseInt(request.getParameter("age")));
	
	DBConnect dbcon=DBConnect.getInstance();
	dbcon.InsertMember(member); */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
	<jsp:useBean id="member" class="dto.Member" scope="session">
		<jsp:setProperty property="*" name="member" />
	</jsp:useBean>
	<%
		DBConnect dbcon = DBConnect.getInstance();
		dbcon.InsertMember(member);
	%>
	<h2>가입완료!!</h2>
	<a href="MemberList.jsp">리스트확인</a>
</body>
</html>