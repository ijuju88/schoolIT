<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	out.println(request.getProtocol() + "<br>");
	out.println(request.getServerName() + "<br>");
	out.println(request.getMethod() + "<br>");
	out.println(request.getQueryString() + "<br>");
	out.println(request.getRequestURI() + "<br>");
	out.println(request.getRemoteHost() + "<br>");
	out.println(request.getRemoteAddr() + "<br>");
	out.println(request.getServerPort() + "<br>");
	out.println(request.getContextPath() + "<br>");
	out.println(request.getHeaderNames() + "<br>");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request 정보</title>
</head>
<body>

</body>
</html>