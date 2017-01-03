<%@page import="roti.lms.student.CookieBox"%>
<%@ page language="java" contentType="text/html; charset= UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 세션값을 비우고 쿠키값을 전부 공백으로 비운 뒤 인덱스 페이지로 이동한다.
	session.invalidate();
	response.addCookie(CookieBox.createCookie("LOGIN", "", "/", 0));
	response.addCookie(CookieBox.createCookie("st_id", "", "/", -1));
	response.addCookie(CookieBox.createCookie("st_pass", "", "/", -1));
	response.addCookie(CookieBox.createCookie("sub_no", String.valueOf(0), "/", -1));

	response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<title>Rotiple</title>
</head>
<body>

</body>
</html>