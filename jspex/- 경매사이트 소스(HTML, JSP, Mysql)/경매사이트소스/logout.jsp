<%@ page contentType="text/html; charset=utf-8" session="false" language="java" import="java.sql.*" errorPage="" %>

<%
	HttpSession session = request.getSession(false);
	
	session.invalidate();
	response.sendRedirect("login.jsp");
%>