<%@page import="mission.DBCon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mission.MovieBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	ArrayList<MovieBean> list = null;
	DBCon dbcon = DBCon.getInstance();
	list = dbcon.SelectMovie();

	int count = list.size();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
</head>
<body>

	<%
		if (count < 0) {
			out.print("데이터 없음!!");
		} else {
	%>

	<table align="center">
		<tr align="center" bgcolor="#8C8C8C">
			<th width="5%">번호</th>
			<th width="15%">제목</th>
			<th width="10%">가격</th>
			<th width="10%">감독</th>
			<th width="10%">출현배우</th>
			<th width="10%">장르</th>
			<th width="40%">시놉시스</th>
		</tr>
		<%
			for (int i = 0; i < count; i++) {
					MovieBean member = list.get(i);
		%>
		<tr align="center" bgcolor="#D4F4FA">
			<td width="5%"><%=member.getNo() %></td>
			<td width="15%"><a href="MovieView.jsp?no=<%=member.getNo() %>"><%=member.getTitle()%></a></td>
			<td width="10%"><%=member.getPrice()%></td>
			<td width="10%"><%=member.getDirector()%></td>
			<td width="10%"><%=member.getActor()%></td>
			<td width="10%"><%=member.getGenre()%></td>
			<td width="40%"><textarea cols="40" rows="5" style="resize:none" name="synopsis"
					disabled="disabled"><%=member.getSynopsis()%></textarea></td>
		</tr>
		<%
			}
		%>
	</table>
	<h3 align="center">
		<a href="MovieForm.jsp">등록하기</a>
	</h3>

	<%
		}
	%>

</body>
</html>