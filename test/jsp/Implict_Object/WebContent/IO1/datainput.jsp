<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out, request 예제</title>
</head>
<body>
<form method="post" action="datapro.jsp">
이름 : <input type="text" name="name"><p>
나이 : <input type="text" name="age"><p>
취미 : <input type="checkbox" name="hobby" value="여행"> 여행
<input type="checkbox" name="hobby" value="영화"> 영화
<input type="checkbox" name="hobby" value="등산"> 등산
<input type="checkbox" name="hobby" value="자전거타기"> 자전거타기
<p>
<input type="submit" value="전송">
</form>
</body>
</html>