<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="board/shopping.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap" align="center">
<table>
<c:forEach var="reply" items="${replyList}">
	<tr>
		<td>${reply.name}</td>
		<td>${reply.content}</td>
		<td>${reply.writedate}</td>
		<td>수정</td><td>삭제</td>
	</tr></c:forEach>
</table>
</div>
</body>
</html>