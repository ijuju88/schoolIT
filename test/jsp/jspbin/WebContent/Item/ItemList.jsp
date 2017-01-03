<%@page import="item.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	ArrayList<ItemBean> list = null;
	ItemDBConn dbcon = ItemDBConn.getInstance();
	list = dbcon.SelectItem();

	int count = list.size();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional
//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품명리스트</title>
</head>
<body>
	<%
		if (count < 0) {
			out.print("데이터 없음!!");
		} else {
	%>
	<table align="center">
		<tr align="center" bgcolor="#fCfCfC">
			<th width="10%">번호</th>
			<th width="20%">제목</th>
			<th width="10%">가격</th>
			<th width="50%">설명</th>
		</tr>
		<%
			for(int i = 0; i < count; i++){
				ItemBean ib=list.get(i);
		%>
		<tr  align="center" bgcolor="#D4F4FA">
			<td width="10%"><%=ib.getNo() %></td>
			<td width="20%"><a href="ItemView.jsp?no=<%=ib.getNo() %>"><%=ib.getName() %></a></td>
			<td width="10%"><%=ib.getPrice() %></td>
			<td width="50%"><textarea cols="60" rows="4"
					style="resize: none" name="description" disabled="disabled"><%=ib.getDescription() %></textarea></td>
		</tr>
		<%
		}
		%>
	</table>
	<h3 align="center">
		<a href="ItemForm.jsp">등록하기</a>
	</h3>
	<%
		}
	%>
</body>
</html>