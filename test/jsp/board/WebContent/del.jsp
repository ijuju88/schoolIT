<%@page import="dao.BoardDao"%>
<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String no = request.getParameter("no");
	int pageno = Integer.parseInt(request.getParameter("pageno"));
%>
<html>
<head>
<script language=javascript>
	function proc(frm){
		frm.submit();
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form name="frm" action="delpro.jsp" method="post">
		<input type="hidden" name="no" value=<%=no %> />
		<input type="hidden" name="pageno" value=<%=pageno %> />
		<table boader="0">
			<tr>
				<td>비밀번호 입력 : </td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="삭제" onclick="javascript:proc(this.form);"/>
					<input type="button" value="취소" onclick="javascript:location.href='view.jsp?no=<%=no%>&pageno=<%=pageno%>';" />
				</td>
			</tr>
		</table>
	</from>
</center>
</body>
</html>