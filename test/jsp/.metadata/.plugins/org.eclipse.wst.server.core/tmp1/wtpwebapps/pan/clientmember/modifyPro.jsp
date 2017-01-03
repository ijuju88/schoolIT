<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="clientmember.*"%>

<% request.setCharacterEncoding("UTF-8");%>

<jsp:useBean id="member" class="clientmember.LogonDataBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<%
	String id= (String)session.getAttribute("memId");
	member.setId(id);

	LogonDB manager = LogonDB.getInstance();
	manager.updateMember(member);
%>
<html>
<body>
<script type="text/javascript">
	alert("수정이 완료되었습니다");
	window.location = '../Main/index.jsp'
</script>

</body>
</html>