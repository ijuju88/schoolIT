<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	/*
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String tel=request.getParameter("tel"); */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 아이디 : <%=id %><p>
비ㅡ번 : <%=pw %><p>
이ㅡ름 : <%=name %><p>
나ㅡ이 : <%=age %><p>
연락처 : <%=tel %> --%>
<jsp:useBean id="member" class="bin.Member" scope="session">
	<jsp:setProperty property="*" name="member"/>
</jsp:useBean>

	아이디 :<jsp:getProperty name="member" property="id"/><p>
	비ㅡ번 :<jsp:getProperty name="member" property="pw"/><p>
	이ㅡ름 :<jsp:getProperty name="member" property="name"/><p>
	나ㅡ이 :<jsp:getProperty name="member" property="age"/><p>
	연락처 :<jsp:getProperty name="member" property="tel"/>
</body>
</html>