<%@page import="bin.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
	//String id=request.getParameter("id");
	//String pw=request.getParameter("pw");
	//String name=request.getParameter("name");
	//int age=Integer.parseInt(request.getParameter("age"));
	//String tel=request.getParameter("tel");
	//response.sendRedirect("MemberOut.jsp?id="+id+"&pw="+tel);
	
	//자바빈으로~~
	//Member member=new Member();
	//member.setId(request.getParameter("id"));
	//member.setPw(pw);
	//member.setName(name);
	//member.setAge(age);
	//member.setTel(tel);
	//response.sendRedirect("MemberOut.jsp?member="+member);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
<%-- 아이디 : <%=member.getId() %><p>
비ㅡ번 : <%=member.getPw() %><p>
이ㅡ름 : <%=member.getName() %><p>
나ㅡ이 : <%=member.getAge() %><p>
연락처 : <%=member.getTel() %><p> --%>
<%-- <a href="MemberOut.jsp?id=<%=id %>+&pw=<%=pw %>&name=
<%=name %>&age=<%=age %>&tel=<%=tel %>">회원정보</a> --%>
<jsp:useBean id="member" class="bin.Member" scope="session">
	<jsp:setProperty property="*" name="member"/>
</jsp:useBean>
아이디 : <jsp:getProperty name="member" property="id"/><p>
비ㅡ번 : <jsp:getProperty name="member" property="pw"/><p>
이ㅡ름 : <jsp:getProperty name="member" property="name"/><p>
나ㅡ이 : <jsp:getProperty name="member" property="age"/><p>
연락처 : <jsp:getProperty name="member" property="tel"/><p>
<a href="MemberOut.jsp">회원정보</a> 

</body>
</html>