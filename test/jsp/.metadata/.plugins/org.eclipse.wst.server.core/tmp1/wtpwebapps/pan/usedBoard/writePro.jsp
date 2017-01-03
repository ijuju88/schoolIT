<%@page import="clientmember.LogonDataBean"%>
<%@page import="clientmember.LogonDB"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="board.BoardDB"%>
<%@ page import="java.sql.Timestamp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="article" class="board.BoardDataBean" scope="page">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%
	article.setReg_date(new Timestamp(System.currentTimeMillis()));
	String id = (String) session.getAttribute("memId");

	LogonDB manager = LogonDB.getInstance();
	LogonDataBean c = manager.getMember(id);

	article.setWriter(id);
	article.setEmail(c.getEmail());

	BoardDB dbPro = BoardDB.getInstance();
	dbPro.insertArticle(article);
%>
<script language="JavaScript">
location.href = "../usedBoard/list.jsp";
</script>


