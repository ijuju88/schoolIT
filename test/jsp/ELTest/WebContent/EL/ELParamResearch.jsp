<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
	아이디 : ${param.id}
	<br> 비-번 : ${param.pw}
	<br> 일반적인 방법
	<br>
	<%
		String seasonArr[] = request.getParameterValues("season");
		out.println("당신이 좋아하는 계절: ");
		request.setAttribute("name", "홍길동");
		for (String season : seasonArr) {
			out.println(season);
		}
	%>
	<c:forEach items="${paramValues.season}" var="season">
${season}
</c:forEach>
</body>
</html>