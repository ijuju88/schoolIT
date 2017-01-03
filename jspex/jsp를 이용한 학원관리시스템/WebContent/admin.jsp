<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%
    if(session.getAttribute("tch_no") == null) {
    	response.sendRedirect("admin_main.jsp");
    } else {
    
    %>
<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8"); 

SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
String date = sdf.format(new Date());
%>
<html>
<head>

<title>관리자 페이지</title>
<link href="css/roti2.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="maintop">
	<a href="index.jsp" class="aa">HOME</a>
</div>
<div class="top">

<nav id="topMenu" >
		<ul>
			<li><a class="menuLink" href="admin.jsp">M A I N</a></li>
			<li>|</li>
			<li><a class="menuLink" href="StudentList.eo">학생관리</a></li>
			<li>|</li>
			<li><a class="menuLink" href="SubListAction.ao">강좌관리</a></li>
			<li>|</li>
			<li><a class="menuLink" href=tch_ListAction.do>강사관리</a></li>
		</ul>
	</nav>
	

<div class="info">
<%= session.getAttribute("tch_no") %>님 접속 중 <br>
현재 시각: <%= date %>
<form method="post" action="admin_logout.jsp">
	<input type="submit" value="로그아웃">
	</form>
</div>
 </div>

</body>
</html>
<%} %>
