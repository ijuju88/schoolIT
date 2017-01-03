<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("ID");
	String pw = request.getParameter("PW");
	
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	
	//session.setAttribute("name", "홍길동");
	
	response.sendRedirect("SessionOut.jsp");
%>
