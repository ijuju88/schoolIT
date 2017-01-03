<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session 정보 얻기</h1>
	<%
	String se=session.getId();
	long lasttime = session.getLastAccessedTime();
	long createdtime = session.getCreationTime();
	long time_used = (lasttime - createdtime) / 60000;
	int inactive = session.getMaxInactiveInterval() / 60;
	boolean b_new = session.isNew();
	%>
	getId() : <%=se%><br>
	getLastAccessedTime() : <%=lasttime%><br>
	getCreationTime() : <%=createdtime%><br>
	<%=time_used%><br>
	getMaxInactiveInterval()/60 : <%=inactive%><br>
	isNew() : <%=b_new%><br>
</body>
</html>