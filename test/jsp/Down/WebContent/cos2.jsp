<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cos로 업로드하기</title>
</head>
<body>
<!-- 파일 다운로드시 폼의 method 및 enctype타입 -->
<form action="cosPro2.do" method="post" enctype="multipart/form-data">
<!-- 파일 다운로드시 type:file-->
글쓴이 : <input type="text" name="name" /> <br>
제&nbsp;&nbsp;&nbsp;목 : <input type="text" name="title" /> <br>
파&nbsp;&nbsp;일1 : <input type="file" name="cosselect1" /><br>
파&nbsp;&nbsp;일 2 : <input type="file" name="cosselect2" /><br>
<input type="submit" value="업로드 전송">
</form>
</body>
</html>