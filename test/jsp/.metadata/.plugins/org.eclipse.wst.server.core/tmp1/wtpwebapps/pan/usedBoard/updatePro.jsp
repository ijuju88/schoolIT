<%@page import="clientmember.LogonDataBean"%>
<%@page import="clientmember.LogonDB"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.Timestamp"%>
<%@page import="board.BoardDB"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="article" scope="page" class="board.BoardDataBean">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%
	String id = (String) session.getAttribute("memId");
	
	String pageNum = request.getParameter("pageNum");
	
	LogonDB manager = LogonDB.getInstance();
	LogonDataBean c = manager.getMember(id);

	article.setWriter(id);
	article.setEmail(c.getEmail());
	
	BoardDB dbPro = BoardDB.getInstance();
	int check = dbPro.updateArticle(article);

	if (check == 1) {
%>
<script>
	alert("수정이 완료되었습니다");
	location.href = "../usedBoard/list.jsp";
	//history.go(-1);
</script>
<%
	} else {
%>
<script>
	alert("비밀번호가 맞지 않습니다");
	location.href = "../usedBoard/list.jsp";
</script>
<%
	}
%>

