<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Enumeration<String> names = session.getAttributeNames(); 
while (names.hasMoreElements()) { 
    String name = names.nextElement().toString(); 
    String value = session.getAttribute(name).toString(); 
    out.println(name + " : " + value + "<br>"); 
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
test페이지죠!!<br>

<%=session.getAttribute("id") %>님 안녕하세요~~ >-<
<%=session.getAttribute("pw") %>
</body>
</html>