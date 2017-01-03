<%@page import="board.vo.BoardBean"%>
<%@page import="board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int no = Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password") == null ? "" : request.getParameter("password");

	BoardDao dao = new BoardDao();
	int check = dao.userCheck(no, password);

	if (check == 1) {
		dao.deleteBoard(no);
%>
<script language=javascript>
	alert("글이 삭제되었습니다.");
	location.replace("/pan/board/BoardServlet?command=board_list"); 
</script>
<%
	} else {
%>
<script language="JavaScript">
	alert("비밀번호가 맞지 않습니다");
	history.go(-1);
</script>
<%
	}
%>


