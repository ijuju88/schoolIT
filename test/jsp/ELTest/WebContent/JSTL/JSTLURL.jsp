<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>import, url</title>
</head>
<body>
<c:url value="../img/mug.jpg" var="data"></c:url>
<c:url value="http://localhost:8081/DBCPTest/Movie/MovieForm.jsp" var="Movie"></c:url>
<h2>${data}</h2>
<img src="${data}">
<c:import url="${Movie}"></c:import>
</body>
</html>
