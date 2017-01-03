<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="../js/login.js" type="text/javascript"></script>
</head>
<body>
<div id="main_image" class="box">
<img class="noborder" id="log" src="../images/mollahalf.png">
</div>
<div id="main_auth" class="box">
<jsp:include page="loginForm.jsp"/>
</div>
</body>
</html>