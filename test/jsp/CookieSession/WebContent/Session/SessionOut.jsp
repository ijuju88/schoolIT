<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
</head>
<body>
<%=session.getAttribute("id") %>님 안녕하세요~~ >-<
<a href="test.jsp">test이동</a>
<a href="sessioninfor.jsp">session정보 이동</a>
<a href="logout.jsp">로그아웃</a>
<br>

</body>
</html>