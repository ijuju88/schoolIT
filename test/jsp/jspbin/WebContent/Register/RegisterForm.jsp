<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입하기</title>
</head>
<body>
	<form action="RegisterPro.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="idt"/></td>
			</tr>
			<tr>
				<td>비ㅡ번</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>이ㅡ름</td>
				<td><input type="text" name="name"/></td>
			</tr>

			<tr>
				<td colspan="2"><button>제출</button></td>

			</tr>
		</table>
	</form>
</body>
</html>