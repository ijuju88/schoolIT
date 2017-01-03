<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forench</title>
</head>
<body>
	<%
		String[] movieList = { "타이타닉", "시네마 천국", "혹성 탈출", "킹콩" };
		pageContext.setAttribute("movieList", movieList);
	%>
	<%-- <c:forEach var="movie" items="${movieList}">
		${movie}<br>
	</c:forEach> --%>

	<%-- <table border="1" style="width:90%; text-align: center;">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
		<c:forEach var="movie" items="${movieList}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${movie}</td>
		</tr>
		</c:forEach>
	</table> --%>
	<%-- <ul>
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		<c:choose>
			<c:when test="${status.first}">
			<li style="font-weight: bold; color: red">${movie}</li>
			</c:when>
			<c:otherwise>
			<li>${movie}</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</ul>
	
	<c:forEach var="movie" items="${movieList}" varStatus="status">
	${movie} <c:if test="${not status.last}">, </c:if>
	</c:forEach> --%>
	
	<c:forEach var="movie" begin="1" end="10" varStatus="status">
	${cnt} <c:if test="">${not status.last}, </c:if>
	</c:forEach>

	<table border="1" style="width: 90%; text-align: center;">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>cnt</th>
		</tr>
		<c:forEach var="cnt" begin="7" end="10" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<p>

<table border="1" style="width: 90%; text-align: center;">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>cnt</th>
		</tr>
		<c:forEach var="cnt" begin="1" end="10" step="2" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>