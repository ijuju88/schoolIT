<%@page import="mission.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>

<jsp:useBean id="moviebean" class="mission.MovieBean">
		<jsp:setProperty property="*" name="moviebean" />
	</jsp:useBean>
	<%
		DBCon dbcon = DBCon.getInstance();
		dbcon.InsertMovie(moviebean);
		response.sendRedirect("MovieWrite.jsp");
	%>
	<h2>들어감</h2>
</body>
</html>