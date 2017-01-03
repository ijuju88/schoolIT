<%@page import="mission.*"%>
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
<title>수정하기</title>
</head>
<body>
	<jsp:useBean id="moviebean" class="mission.MovieBean">
		<jsp:setProperty property="*" name="moviebean" />
	</jsp:useBean>
	<%
		DBCon dbcon = DBCon.getInstance();
		MovieBean mb = dbcon.ModityMovie(moviebean);
		response.sendRedirect("MovieWrite.jsp");
	%>
</body>
</html>