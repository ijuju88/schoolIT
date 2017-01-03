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
<title>보기</title>
</head>
<body>
	<h2>상품보기</h2>
	<input type="hidden" name="no" value="<%=ib.getNo()%>">

	<table>
		<tr>
			<td bgcolor="#8C8C8C">상품명</td>
			<td><%=ib.getName()%></td>
		</tr>
		<tr>
			<td bgcolor="#8C8C8C">가격</td>
			<td><%=ib.getPrice()%>원</td>
		</tr>
		<tr>
			<td bgcolor="#8C8C8C">설명</td>
			<td><textarea cols="80" rows="5" style="resize: none"
					name="description" disabled="disabled"><%=ib.getDescription()%></textarea></td>
		</tr>

		<tr>
		<td colspan="2" align="center"><a href="ItemList.jsp"><button>이전으로</button></a>
					<a href="ItemModityForm.jsp?no=<%=ib.getNo()%>"><button>수정</button></a>
					<a href="ItemDelForm.jsp?no=<%=ib.getNo()%>"><button>삭제</button></a>
					</td>
		</tr>

	</table>
</body>
</html>