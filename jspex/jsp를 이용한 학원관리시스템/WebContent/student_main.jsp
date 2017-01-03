<%@ page language="java" contentType="text/html; charset= UTF-8" pageEncoding="UTF-8"%>
<%
	// 로그인 상태인 경우 세션의 값이 null이기 아니기 때문에 학생 페이지로 이동. 
	if (session.getAttribute("st_id") == null) {
%>
<jsp:forward page="stu_login.jsp" />
<%
	} else {
%>
<jsp:forward page="student.fo" />
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Rotiple</title>
</head>
<body>

</body>
</html>