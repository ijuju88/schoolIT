<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키</title>
</head>
<body>
<%
Cookie c=new Cookie("id","park");
c.setMaxAge(365 * 24 * 60 * 60);
response.addCookie(c);

response.addCookie(new Cookie("pw", "1234"));
response.addCookie(new Cookie("age", "20"));
%>
</body>
</html>
