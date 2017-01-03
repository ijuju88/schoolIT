<%@page import="reservation.ReservationAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Vector"
	import="reservation.ReservationBean"
	import="reservation.ReservationBean"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>펜션예약</title>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<%
	String id = "";
	try {
		id = session.getAttribute("memId").toString();
	} catch (NullPointerException e) {
%>

<script language="javascript">
	alert("예약은 회원만 가능합니다!");
	location.href = "/pan/Main/index.jsp";
</script>
<%
	}
	if (id.equals("")) {
%>
<script language="javascript">
	alert("예약 확인은 로그인을 하여야 합니다.");
	location.href = "/pan/Main/index.jsp";
</script>
<%
	} else {
%>
</head>
<body>
  <jsp:include page="../common/head.jsp"></jsp:include>
<div class="comfirm">
	<div class="content">
			<div class="bs-docs-example">
				<h3 align="center">예약 목록 입니다.</h3>
				<table  style="width: 80%; font-size: 20px;" align="center"   border="1">
					<thead>
						<tr>
							<td class="tableSubject2">번호</td>
							<td class="tableSubject2">객실이름</td>
							<td class="tableSubject2">사용인원</td>
							<td class="tableSubject2">결제금액</td>
							<td class="tableSubject2">결제방법</td>
							<td class="tableSubject2">결제유무</td>
							<td class="tableSubject2">예약날짜</td>
							<td class="tableSubject2">숙발일수</td>
							<td class="tableSubject2">신청날짜</td>
						</tr>
					</thead>
					<%
						Vector<ReservationBean> vrb = new ReservationAction().confirmBook(id);

							if (vrb == null) {
					%>
					<thead>
						<tr>
							<td colspan="11">[ 찾으시는 내용이 없습니다 ]</td>
						</tr>
					</thead>
					<%
						} else {
								for (int i = 0; i < vrb.size(); i++) {
									ReservationBean rb = vrb.get(i);
					%>
					<tbody>
						<tr>
							<td><%=i + 1%></td>
							<td><%=rb.getRoomname()%></td>
							<td><%=rb.getUsemen()%></td>
							<td><%=rb.getPrice()%></td>
							<td><%=rb.getPay_name()%></td>
							<td><%=rb.getPay_yn()%></td>
							<td><%=rb.getRes_date()%></td>
							<td><%=rb.getNight()%></td>
							<td><%=rb.getReg_date()%></td>
						</tr>
					</tbody>
					<%
						}
							}
					%>
				</table>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	
<%
	}
%>
  <jsp:include page="../common/foot.jsp"></jsp:include>