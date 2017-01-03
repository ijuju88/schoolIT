<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String[] hobby = request.getParameterValues("hobby");

	out.println("이름 - " + name + "<p>");
	out.println("나이 - " + age + "<p>");
	out.print("취미 - ");
	for (String h : hobby) {
		out.print(h + " ");
	}
	out.println("<p>");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>

</body>
</html>