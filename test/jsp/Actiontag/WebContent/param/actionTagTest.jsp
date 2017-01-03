<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userID=request.getParameter("userID");
String userPW=request.getParameter("userPW");
String loginCheck=request.getParameter("loginCheck");

if(loginCheck.endsWith("user")){
	%>
	<jsp:forward page="userMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("전고객","UTF-8")%>' name="userName"/>
	</jsp:forward>
	<%
}else{%>
	<jsp:forward page="managerMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("성관리","UTF-8")%>' name="userName"/>
	</jsp:forward>
<%
}
%>