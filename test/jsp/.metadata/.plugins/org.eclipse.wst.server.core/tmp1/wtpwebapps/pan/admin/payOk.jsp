<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="reservation.ReservationAction"%>
�Ա� �Ϸ� ó���� .....
<%
	int rsno = Integer.parseInt(request.getParameter("rsno"));
	String currentPage = request.getParameter("currentPage");
	new ReservationAction().setPayOk(rsno);
%>
<script language="javascript">
	opener.document.searchFrm.currentPage.value = <%= currentPage %>;
	opener.document.searchFrm.submit();
	self.close();
</script>