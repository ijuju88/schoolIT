<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제</title>
</head>
<body>
	<form method="post" action="MovieDelPro.jsp">
<input type="hidden" name="no" value="<%=no %>">
	<table>
		<tr>
			<td bgcolor="#8C8C8C">비번입력</td>
			<td><input type="text" name="pass"></td>

		</tr>
	</table>
	<input type="submit" value="삭제">
	<a href="MovieWrite.jsp"><button>이전으로</button></a>
</form>
</body>
</html>