<%@page import="item.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	ItemDBConn dbcon = ItemDBConn.getInstance();

	ItemBean ib = dbcon.ViewItem(no);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정하기</title>
</head>
<body>
	<h2>상품수정!!</h2>
	<form action="ItemModityPro.jsp" method="post">
		<input type="hidden" name="no" value="<%=ib.getNo()%>">
		<table>
			<tr>
				<td bgcolor="#8C8C8C">상품명</td>
				<td><input type="text" name="name" value="<%=ib.getName()%>"></td>
			</tr>
			<tr>
				<td bgcolor="#8C8C8C">가격</td>
				<td><input type="text" name="price" value="<%=ib.getPrice()%>">원</td>
			</tr>
			<tr>
				<td bgcolor="#8C8C8C">설명</td>
				<td><textarea cols="80" rows="5" style="resize: none"
						name="description"><%=ib.getDescription()%></textarea></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록">
					<a href="ItemListe.jsp"><button>이전으로</button></a></td>
			</tr>

		</table>
	</form>
</body>
</html>