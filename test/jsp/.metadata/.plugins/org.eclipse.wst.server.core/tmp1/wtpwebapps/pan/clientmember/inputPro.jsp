<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="clientmember.LogonDB"%>

<%@ page import="java.sql.Timestamp"%>

<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="member" class="clientmember.LogonDataBean">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<%
	member.setReg_date(new Timestamp(System.currentTimeMillis()));
	LogonDB manager = LogonDB.getInstance();
	manager.insertMember(member);

	 response.sendRedirect("../Main/index.jsp");
%>
