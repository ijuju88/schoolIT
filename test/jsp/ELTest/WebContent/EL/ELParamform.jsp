<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Param 테스트</title>
</head>
<body>
	<form action="ELParamResearch.jsp" method="get">
		아이디:<input type="text" name="id" /><br> 
		비ㅡ번:<input type="password" name="pw" /><br> 
		
		<select name="season">
			<option value="spring" selected="selected">spring</option>
			<option value="summer">summer</option>
			<option value="fall">fall</option>
			<option value="winter">winter</option>
		</select> 
		<input type="submit" value="전송" />
	</form>
</body>
</html>