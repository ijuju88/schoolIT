<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>학생 로그인</title>
<style type="text/css">

#center{position:absolute; width:1000px;left:30px;top:350px; z-index:2;}
#log{margin-left: 300px;}
#con{text-align: center; margin-left: 350px;}
#gohome{width:1000px;text-align: right;padding: 50px;}
#back{position:absolute;left:300px;top:200px; z-index:1;}
</style>
</head>
<body>
<div id="gohome">
<a href="index.jsp"><img border="none" src="image/home_button.png"></a>
</div>
<div id="center">
<div id="log">
<img src="image/login/login.png">
</div>
<div id="con">
<%-- 아이디와 비밀번호를 입력받은 뒤 정보를 stu_login_check.jsp로 넘긴다. --%>
<form method="post" action="stu_login_check.jsp">
<table>
<tr>
<td><img src="image/login/login_id.gif"></td>
<td><input type="text" name="st_id" placeholder="아이디" required></td>
<td rowspan="2"><input type="image" src ="image/login/login_Button.png" ></td>
</tr>
<tr>
<td><img src="image/login/login_pw.gif"></td>
<td><input type="password" name="st_pass"></td>
</tr>
<tr>
<td><a href="memberjoin.jsp"><img border="none" src="image/login/btn_join.gif"></a></td>
<td><a href="idfind.jsp"><img border="none" src="image/login/btn_find.gif"></a></td>
</tr>
</table>
</form>
</div>
</div>
<div id="back">
<img src="image/login/login_bg.png">
</div>
</body>
</html>