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
<form action="BoardServlet" method="post" name="frm">
<input type="hidden" name="command" value="board_replywrite"/>
	<input type="hidden" name="num" value="${board.num}"/>
	<input type="hidden" name="pageNum" value="${pageNum}"/>
<table>
	<tr>
		<td colspan="3">댓글수 :${reCount}</td>
	</tr>
	
	<tr>
		<td align="center">name:<input type="text" class="box" name="name" size="10" /></td>
		<td rowspan="2" align="center"><textarea name="content" cols="70" rows="3"></textarea></td>
		<td rowspan="2" align="center"><input type="submit" class="box3"  value="등록" onclick="return replyCheck()"/></td>
	</tr>
	
	<tr>
		<td align="center">pass:<input type="password" class="box" name="pass" size="10" /></td>
	</tr>
	</table></form>
</body>
</html>