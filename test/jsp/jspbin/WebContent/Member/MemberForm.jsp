<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member</title>
</head>
<body>
	<form action="MemberPro.jsp" method="post">
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비ㅡ번 :</td>
				<td><input type="password"name="pw" /></td>
			</tr>
			<tr>
				<td>이ㅡ름 :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>나ㅡ이 :</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td><input type="text" name="tel" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>전송</button> <input
					type="reset" value="취소" /></td>
			</tr>
		</table>
	</form>
</body>
</html>