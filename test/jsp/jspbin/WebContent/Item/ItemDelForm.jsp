<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제하장~~</title>
</head>
<body>
	<form method="post" action="ItemDelPro.jsp">
		<input type="hidden" name="no" value="<%=no%>">
		<table>
			<tr>
				<td bgcolor="#8C8C8C">삭제하실 상품명과 같은 상품명을 적어주세요</td>
				<td><input type="text" name="namedel"/></td>
			</tr>
		</table>
		<input type="submit" value="삭제" /> 
		
		<input type="button" value="이전"
			onclick="historyBack();">
		<script type="text/javascript">
			function historyBack() {
				history.back();
			}
		</script>
	</form>
</body>
</html>