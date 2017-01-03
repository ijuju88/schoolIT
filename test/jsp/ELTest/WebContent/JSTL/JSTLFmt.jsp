<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt</title>
</head>
<body>
<h2>fmt:formatNumber</h2>
<fmt:formatNumber value="1234567.89"/><br>
<fmt:formatNumber value="1234567.89" groupingUsed="false"/><hr>
<h4>type</h4>
<fmt:formatNumber value="0.5" type="percent"/><br>
<fmt:formatNumber value="10000" type="currency"/><br>
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"/>
<hr>
<h4>pattern</h4>
<fmt:formatNumber value="1234567.891234" pattern="#,#00.0#"/><br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"/><br>
<fmt:formatNumber value="1234567.89" pattern="000"/>
<hr><hr>

<h2>fmt:formatDate</h2>
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
${now}<br>
<fmt:formatDate value="${now}"/><br>
date : <fmt:formatDate value="${now}" type="date"/><br>
time : <fmt:formatDate value="${now}" type="time"/><br>
both : <fmt:formatDate value="${now}" type="both"/><br>
<hr>
default : <fmt:formatDate value="${now}" type="both" dateStyle="default"
timeStyle="default"></fmt:formatDate><br>
short : <fmt:formatDate value="${now}" type="both" dateStyle="short"
timeStyle="short"></fmt:formatDate><br>
medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium"
timeStyle="medium"></fmt:formatDate><br>
long : <fmt:formatDate value="${now}" type="both" dateStyle="long"
timeStyle="long"></fmt:formatDate><br>
full : <fmt:formatDate value="${now}" type="both" dateStyle="full"
timeStyle="full"></fmt:formatDate><br>
pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" :
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"></fmt:formatDate>
<hr>
</body>
</html>