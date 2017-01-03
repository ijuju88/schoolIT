<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>선택한 색상</title>
</head>
<body>
<%-- ${param.color=="red"} --%>
<c:if test="${param.color == 'red'}">
<span style="color: red;">빨강</span>
</c:if>
<c:if test="${param.color == 'green'}">
<span style="color: green;">그린</span>
</c:if>
<c:if test="${param.color =='blue'}">
<span style="color: blue;">파랑</span>
</c:if>

<c:choose>
		<c:when test="${param.color == 'red'}">
			<span style="color: red;">빨강</span>
		</c:when>
		<c:when test="${param.color == 'green'}">
			<span style="color: green;">그린</span>
		</c:when>
		<c:when test="${param.color == 'blue'}">
			<span style="color: blue;">파랑</span>
		</c:when>
	</c:choose>
</body>
</html>