<%@page import="dao.DBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	DBBean dbCon=DBBean.getInstance();
	int check=dbCon.confirmId(id);
	out.println(check);
%>