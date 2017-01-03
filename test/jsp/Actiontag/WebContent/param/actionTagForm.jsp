<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="actionTagTest.jsp">
		아이디 : <input type="text" name="userID"><br>
		비&nbsp;&nbsp;&nbsp;번: <input type="password" name="userPW"><br>
		<input type="radio" name="loginCheck" value="user" checked="checked">
		사용자 <input type="radio" name="loginCheck" value="manager">관리자<br>
		<button>로그인</button>
	</form>
</body>
</html>