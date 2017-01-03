<%@page import="roti.lms.ad_login.AdminDao"%>
<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("tch_no");
	String pass = request.getParameter("tch_pass");
	
	AdminDao adao= AdminDao.getInstance();
	int check = adao.userCheck(id, pass);
	
	if(check == 1) {
		session.setAttribute("tch_no", id);
		response.sendRedirect("admin_main.jsp");
	} else if (check == 0) {
		%>
		<script>
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
	<%} else { %>
		<script>
			alert("아이디가 맞지 않습니다.");
			history.go(-1);
		</script>
<%} %>

<html>
<head>
<title>로그인 체크</title>
</head>
<body>

</body>
</html>