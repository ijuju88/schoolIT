<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="dao" class="roti.lms.ad_stu.db.StudentDAO"/>
<%
 int rst = 0;
 String st_id = (String)request.getParameter("st_id");
 rst = dao.idCheck(st_id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01

 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>아이디 중복 확인</title>
</head>
<body>
<%
if(rst == 1){
%>
사용 중인 아이디가 존재 합니다. ID확인 후 다시 입력 하세요.
<%}else{ %>
사용 가능한 아이디 입니다.
<%} %>
</body>
</html>