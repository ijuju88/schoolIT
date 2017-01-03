<%@page import="board.dao.BoardDao"%>
<%@page import="board.vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	int pageno = Integer.parseInt(request.getParameter("pageno"));
%>
<html>
<head>
<script language=javascript>
	function proc(frm){
		if (!$('#password').val()) {
			alert("비번을 입력해주세요.");
			$('#password').focus();
			return false;
		}
		frm.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/head.jsp"></jsp:include>
<center>
	<form name="frm" action="/pan/board/delpro.jsp" method="post">
		<input type="hidden" name="no" value=<%=no %> />
		<input type="hidden" name="pageno" value=<%=pageno %> />
		<table boader="0">
			<tr>
				<td>비밀번호 입력 : </td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="삭제" onclick="javascript:proc(this.form);"/>
					<input type="button" value="취소" onclick="location.href='/pan/board/BoardServlet?command=board_view&no=<%=no%>&pageno=<%=pageno%>'";/>
				</td>
			</tr>
		</table>
	</form>
</center>
<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>