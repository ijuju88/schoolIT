<%@page import="dao.DBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pwd=request.getParameter("passwd");
	System.out.println(id+pwd);
	DBBean dbCon=DBBean.getInstance();
	int check=dbCon.userCheck(id, pwd);
	if(check==1)
		session.setAttribute("id", id);
	out.println(check);
%>