<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품입력합시다!!</title>
</head>
<body>
<h2>상품입력!!</h2>
<form action="ItemPro.jsp" method="post">
<table>
	<tr>
		<td bgcolor="#8C8C8C">상품명</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td bgcolor="#8C8C8C">가격</td>
		<td><input type="text" name="price">원</td>
	</tr>
	<tr>
		<td bgcolor="#8C8C8C">설명</td>
		<td><textarea cols="80" rows="5" style="resize:none"  name="description"></textarea></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="등록"> <input type="reset"
				value="다시작성">
		</td>
		</tr>
	
</table>
</form>
</body>
</html>