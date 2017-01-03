<%@page import="dao.*" import="dto.*" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	DBConnect memberDAO = DBConnect.getInstance();
	Connection conn = memberDAO.getDBConnect();
	//out.println("DB연결");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type="text/javascript" src="member/script/member.js"></script>
</head>
<body>
	<h2 align="center">로그인</h2>
	<form action="login.do" method="post" name="frm">
		<table width="30%" align="center">
			<tr align="center">
				<td bgcolor="#8C8C8C" style="color: #ffffff">아이디</td>
				<td><input type="text" style="width: 150px" name="userid" value="${userid}" /></td>
			</tr>
			<tr align="center">
				<td bgcolor="#8C8C8C" style="color: #ffffff">비ㅡ번</td>
				<td><input type="password"  style="width: 150px" name="pwd" value="${pwd}" /></td>
			</tr>
			<tr align="center">
				<td colspan="2" align="center">
				<input type="submit" value="로그인" onclick="return loginCheck()"/>
				<input type="reset" value="취소"/>
				<input type="button" value="회원가입" onclick="location.href='join.do'"/>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>