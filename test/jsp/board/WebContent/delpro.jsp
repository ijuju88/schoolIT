<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String no = request.getParameter("no");
	int pageno = Integer.parseInt(request.getParameter("pageno"));


	BoardDao dao = new BoardDao();
	BoardVO vo = new BoardVO();
	vo = dao.selectBoard(Integer.parseInt(request.getParameter("no")));


		
		dao = new BoardDao();
		
		if(dao.deleteBoard(Integer.parseInt(no)) > 0){
			%>
			<script language=javascript>
				alert("글이 삭제되었습니다.");
				location.href="list.jsp";
			</script>
			<%		
		}else{
			%>
			<script language=javascript>
				alert("삭제에 실패하였습니다.");
				location.href="list.jsp";
			</script>
			<%	
		}
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.0.0.js"></script>
</head>
<body>

</body>
</html>