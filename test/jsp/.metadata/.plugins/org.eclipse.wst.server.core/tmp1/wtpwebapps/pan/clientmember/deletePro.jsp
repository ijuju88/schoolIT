<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="clientmember.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%
	String id = (String) session.getAttribute("memId");
	String passwd = request.getParameter("passwd");
	LogonDB manager = LogonDB.getInstance();
	int check = manager.deleteMember(id, passwd);

	if (check == 1) {
		session.invalidate();
		response.sendRedirect("../Main/index.jsp");
%>


<script type="text/javascript">
	alert("탈퇴가 완료되었습니다");
	window.location = '../Main/index.jsp'
</script>

<%
	} else {
%>
<script>
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
</script>
<%
	}
%>
</body>
</html>