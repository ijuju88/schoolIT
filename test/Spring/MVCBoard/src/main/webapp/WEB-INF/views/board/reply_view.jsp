<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reply" method="post">
<input type="hidden" name="bId" value="${redto.bId}">
<table width="500" border=1>
	<tr>
		<td>이름</td>
		<td><input type="text" name="bName"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="bTitle" value="re:"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="bContent" rows="10" cols="50"></textarea></td>
	</tr>
	<tr>
		<td colspan=2><input type="submit" value="전송"></td>
	</tr>
	</table>
</form>
</body>
</html>