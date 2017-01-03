<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	String name = (String) request.getAttribute("name");
%>
<%
	URLEncoder.encode("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성인이닷!</title>
</head>
<body>
	<h2><%=name%>님
		<%=age%>살 성인이시군요!!!
	</h2>
</body>
</html>