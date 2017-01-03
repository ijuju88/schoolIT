<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age<=19){
			%>
			<script type="text/javascript">
				alert("성인이 아니자녀!! 썩돌아가라")
				history.go(-1)
			</script>
			<%
		}else{
			request.setAttribute("name", "홍길동");
		RequestDispatcher dispatcher=request.getRequestDispatcher("agesuccess.jsp");
		dispatcher.forward(request, response);
		}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional
//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나이결과</title>
</head>
<body>

</body>
</html>