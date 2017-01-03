<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String seasonArr[] = request.getParameterValues("season");
	String season="";

	for(String s:seasonArr){
		switch(s){
		case "1":season+="<b>"+"봄"+"</b>"; break;
		case "2":season+="<b>"+"여름"+"</b>"; break;
		case "3":season+="<b>"+"가을"+"</b>"; break;
		case "4":season+="<b>"+"겨울"+"</b>"; break;
		}
		//season+="<b>"+s+"</b>";
	}
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
<style type="text/css">
b {
    font-size: 16pt;
}
</style>
</head>
 
<body>
	<h2>설문 조사 결과</h2>

	<table border="1">
		<tr>
			<td>이름 :</td>
			<td><%=name%></td>
		</tr>
		
		<tr>
			<td>성별 :</td>
			<td><%=gender%></td>
		</tr>
		
		<tr>
			<td>당신이 좋아하는 계절은</td>
			<td>
			<%=season %>
			입니다.
			</td>
		</tr>
		

	</table>
	<b><a href='javascript:history.go(-1)'>다시</a></b>
</body>
</html>