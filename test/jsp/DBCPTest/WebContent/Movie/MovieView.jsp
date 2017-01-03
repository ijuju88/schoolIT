<%@page import="mission.MovieBean"%>
<%@page import="mission.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	DBCon dbcon = DBCon.getInstance();

	MovieBean mb = dbcon.ViewMovie(no);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보기</title>
</head>
<body>
	<center>
		<h2>
			영화정보
			<%=mb.getNo()%></h2>
		<table>
			<tr>
				<td bgcolor="#8C8C8C">제목</td>
				<td><%=mb.getTitle()%></td>

			</tr>
			
			<tr>
				<td bgcolor="#8C8C8C">가격</td>
				<td><%=mb.getPrice()%>원</td>
			</tr>
			<tr>
				<td bgcolor="#8C8C8C">감독</td>
				<td><%=mb.getDirector()%></td>
			</tr>
			<tr>
				<td bgcolor="#8C8C8C">출연배우</td>
				<td><%=mb.getActor()%></td>
			</tr>
			<tr>
				<td height="100px" bgcolor="#8C8C8C">시놉시스</td>
				<td><textarea cols="80" rows="5" style="resize: none"
						name="synopsis" disabled="disabled"><%=mb.getSynopsis()%></textarea></td>
			</tr>
			<tr>
				<td bgcolor="#8C8C8C">장르</td>
				<td><%=mb.getGenre()%></td>
			<tr>
			<tr>
				<td colspan="2" align="center"><a href="MovieWrite.jsp"><button>이전으로</button></a>
					<a href="MovieModityForm.jsp?no=<%=mb.getNo()%>"><button>수정</button></a>
					<a href="MovieDelForm.jsp?no=<%=mb.getNo()%>"><button>삭제</button></a>
					</td>
			<tr>
		</table>


	</center>
</body>
</html>