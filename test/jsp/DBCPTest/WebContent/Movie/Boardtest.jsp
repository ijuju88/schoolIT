<%@page import="java.util.*"%>
<%@page import="mission.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("UTF-8");

	DBCon dbcon = DBCon.getInstance();
	ArrayList<MovieBean> list = dbcon.SelectMovie();
	
	int count = list.size();

	pageContext.setAttribute("list", list);
	pageContext.setAttribute("count", count);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional
//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<c:choose>
		<c:when test="${count<1}">데이터 없음</c:when>
		<c:otherwise>
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
				<c:forEach var="movie" items="${list}">
					<tr align="center" bgcolor="#D4F4FA">
						<td width="5%">${movie.no}</td>
						<td width="15%"><a href="MovieView.jsp?no=${movie.no}">${movie.title}</a></td>
						<td width="10%">${movie.price}</td>
						<td width="10%">${movie.director}</td>
						<td width="10%">${movie.actor}</td>
						<td width="10%">${movie.genre}</td>
						<td width="40%"><textarea cols="40" rows="5"
								style="resize: none" name="synopsis" disabled="disabled">${movie.synopsis}</textarea></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<h3 align="center">
		<a href="MovieForm.jsp">등록하기</a>
	</h3>
</body>
</html>