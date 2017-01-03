<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>페이지이동</title>
</head>
<body>
	<form action="sitetest.jsp" method="post">
		<select name="site">
			<option value="1" selected="selected">네이버</option>
			<option value="2" >다음</option>
			<option value="3">구글</option>
		</select>
		<button>확인</button>
	</form>
</body>
</html>