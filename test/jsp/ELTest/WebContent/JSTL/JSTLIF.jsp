<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제어문</title>
</head>
<body>
	<form action="ColorSelect.jsp">
		<label for="color">색상선택하기</label><br> 
		<select name="color" id="color">
		<option value="red">빨강</option>
		<option value="green">그린</option>
		<option value="blue">파랑</option>
		</select>
		<input type="submit" value="전송" />
	</form>
</body>
</html>