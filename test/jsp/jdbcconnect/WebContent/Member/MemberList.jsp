<%@page import="dao.DBConnect"%>
<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Member> list = null;
	DBConnect dbcon = DBConnect.getInstance();
	list = dbcon.selectMember();

	int count = list.size();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트확인</title>
</head>
<body>
	<%
		if (count < 0) {
			out.print("데이터 없음!!");
		} else {
	%>

	<table align="center">
		<tr align="center" bgcolor="#8C8C8C">
			<th width="15%">아이디</th>
			<th width="15%">비ㅡ번</th>
			<th width="15%">이ㅡ름</th>
			<th width="15%">전ㅡ화</th>
			<th width="15%">나ㅡ이</th>
		</tr>
		<%
			for (int i = 0; i < count; i++) {
					Member member = list.get(i);
		%>
		<tr align="center" bgcolor="#D4F4FA">
			<td width="15%"><%=member.getId() %></td>
			<td width="15%"><%=member.getPw() %></td>
			<td width="15%"><%=member.getName() %></td>
			<td width="15%"><%=member.getTel() %></td>
			<td width="15%"><%=member.getAge() %></td>
		</tr>
		<%
			}
		%>
	</table>

	<%
		}
	%>

</body>
</html>