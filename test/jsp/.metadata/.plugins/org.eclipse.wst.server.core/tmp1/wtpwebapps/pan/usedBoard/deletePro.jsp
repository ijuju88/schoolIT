<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="board.BoardDB"%>
<%@ page import="java.sql.Timestamp"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	String passwd = request.getParameter("passwd");

	BoardDB dbPro = BoardDB.getInstance();
	int check = dbPro.deleteArticle(num, passwd);

	if (check == 1) {
%>

<script language="JavaScript">
	alert("삭제가 완료되었습니다");
	location.href = "../usedBoard/list.jsp";
</script>
<%
	} else {
%>
<script language="JavaScript">
	alert("비밀번호가 맞지 않습니다");
	location.href = "../usedBoard/list.jsp";
</script>
<%
	}
%>

