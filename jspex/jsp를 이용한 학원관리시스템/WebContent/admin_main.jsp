<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    if(session.getAttribute("tch_no") == null) {
    %>
    <jsp:forward page="admin_login.jsp" />
    <%} else {%>
    <jsp:forward page="admin.jsp" />
    <%} %>
    
    
<!DOCTYPE html>
<html>
<head>
<title>Rotiple</title>
</head>
<body>

</body>
</html>