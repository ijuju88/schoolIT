<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키값알아보기~</title>
</head>
<body>
<h2>쿠키값을 얻어봅시다</h2>
<%
Cookie[] cookies=request.getCookies();
for(Cookie c:cookies){
out.println(c.getName() +" : "+c.getValue() +"<br>");
}
%>
</body>
</html>