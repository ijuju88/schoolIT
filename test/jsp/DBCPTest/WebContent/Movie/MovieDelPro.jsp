<%@page import="mission.*"%>
<%@page import="mission.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	String pw = request.getParameter("pass");
	DBCon dbcon = DBCon.getInstance();
	if (dbcon.DelMovie(no, pw) == true) {
		response.sendRedirect("MovieWrite.jsp");
	} else {
		response.sendRedirect("MovieDelForm.jsp?no="+no);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제</title>
</head>
<body>
</body>
</html>