<%@page import="roti.lms.student.CookieBox"%>
<%@page import="roti.lms.student.login.stu_loginDao"%>
<%@ page language="java" contentType="text/html; charset= UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("st_id");
	String pass = request.getParameter("st_pass");
	
	// stu_loginDao 객체를 생성, DB에 사용자 아이디, 패스워드 값과 과목번호를 받아온다.
	stu_loginDao adao= stu_loginDao.getInstance();
	int check = adao.userCheck2(id, pass);
	int sub_no = adao.getSub_no(id);
	
	// 사용자가 입력한 아이디, 비밀번호가 DB와 일치하는 경우 세션과 쿠키에 아이디, 비밀번호, 과목번호, 로그인 유무 정보를 저장한다.
	if(check == 1) {
		session.setAttribute("st_id", id);
		session.setAttribute("st_pass", pass);
		
		response.addCookie(
	CookieBox.createCookie("LOGIN", "SUCCESS", "/", -1)
		);
		response.addCookie(
	CookieBox.createCookie("ID", id, "/", -1)
		);
		
		response.addCookie(
		CookieBox.createCookie("st_id", id, "/", -1)
		);
		response.addCookie(
		CookieBox.createCookie("st_pass", pass, "/", -1)
		);
		response.addCookie(
		CookieBox.createCookie("sub_no", String.valueOf(sub_no), "/", -1)
		);
		
		response.sendRedirect("student_main.jsp");
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
<!DOCTYPE html>
<html>
<head>
<title>로그인 체크</title>
</head>
<body>

</body>
</html>