<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="board/shopping.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="board/js/board.js"></script>
</head>
<body>
<div align="center">
<h1>비번확인</h1>
<form action="BoardServlet" name="frm" method="get">
	<input type="hidden" name="command" value="board_check_pass"/>
	<input type="hidden" name="num" value="${param.num}"/>
	<input type="hidden" name="pageNum" value="${param.pageNum}"/>
	<table>
		<tr>
			<th>비번</th>
		</tr>
		<tr>
			<td><input type="password" name="pass" size="20" /></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="확인" onclick="return passCheck()">
<br>${message}
</form>
</div>
</body>
</html>