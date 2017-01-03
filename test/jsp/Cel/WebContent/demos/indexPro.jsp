<%@page import="DTO.Celbean"%>
<%@page import="DAO.CelDBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String title= request.getParameter("title");
	String url = request.getParameter("url");
	int sday =Integer.parseInt(request.getParameter("sday"));
	int st = Integer.parseInt(request.getParameter("st"));
	int totday = Integer.parseInt(request.getParameter("totday"));
	int lt = Integer.parseInt(request.getParameter("lt"));
	
	CelDBConn dbCon = CelDBConn.getInstance();
	Celbean cb = new Celbean();
	cb.setTitle(title);
	cb.setUrl(url);
	cb.setSday(sday);
	cb.setSt(st);
	cb.setTotday(totday);
	cb.setLt(lt);
	
	dbCon.insertMember(cb);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>