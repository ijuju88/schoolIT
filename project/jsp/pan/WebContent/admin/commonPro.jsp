<%@ page contentType="text/html; charset=UTF-8" 
	import="common.CommonAction"
%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- 작성부분
	jsp:useBean(id:common, class:common.CommonBean)
	과 jsp:setProperty 작성하기
 -->
<%
	CommonAction action = CommonAction.getInstance();
	common.setSseason(request.getParameter("sseason1")+"-"+request.getParameter("sseason2"));
	common.setEseason(request.getParameter("eseason1")+"-"+request.getParameter("eseason2"));
	action.updateCommon(common);
	response.sendRedirect("common.jsp");
%>