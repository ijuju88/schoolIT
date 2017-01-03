<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request 결과</title>
</head>
<body>
	<h2>기존</h2>
	<%
		int num1 = (Integer) request.getAttribute("num1");
		int num2 = (Integer) request.getAttribute("num2");
		int add = (Integer) request.getAttribute("add");
	%>
	<%=num1 %> + <%=num2 %> = <%=add %> <br>

	<h2>EL</h2>
	${num1} + ${num2} = ${add}
</body>
</html>