<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String oid="abcd";
	String opw="1234";
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	request.setAttribute("name", "홍길동");
	
	if(id.equals(oid) && pw.equals(opw)){
		//response.sendRedirect("loginsuccess.jsp?id="+id);
		//request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
	%>
	<jsp:forward page="loginsuccess.jsp"/>
	<%
	}else{
		response.sendRedirect("loginform.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인결과</title>
</head>
<body>

</body>
</html>