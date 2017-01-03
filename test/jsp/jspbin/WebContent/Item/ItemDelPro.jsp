<%@page import="item.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String namedel = request.getParameter("namedel");
	ItemDBConn dbcon = ItemDBConn.getInstance();

	if (dbcon.DelItem(no, namedel) == true) {
		response.sendRedirect("ItemList.jsp");
	} else {
		response.sendRedirect("ItemDelForm.jsp?no=" + no);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제</title>
</head>
<body>
</body>
</html>