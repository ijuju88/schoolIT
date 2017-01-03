<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="register.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
<%
	Date reg_date = new Date();
%>
<jsp:useBean id="register" class="register.RegisterBean">
    <jsp:setProperty property="*" name="register"/>
    <jsp:setProperty property="reg_date" name="register" value="<%=reg_date%>" />
</jsp:useBean>
	<table>
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty name="register" property="idt"/></td>
		</tr>
		<tr>
			<td>비ㅡ번</td>
			<td><jsp:getProperty name="register" property="password"/></td>
		</tr>
		<tr>
			<td>이ㅡ름</td>
			<td>${param.name}</td>
		</tr>
		<tr>
			<td>가입일</td>
			<td><jsp:getProperty name="register" property="reg_date" />${reg_date}</td>
		</tr>
	</table>
</body>
</html>