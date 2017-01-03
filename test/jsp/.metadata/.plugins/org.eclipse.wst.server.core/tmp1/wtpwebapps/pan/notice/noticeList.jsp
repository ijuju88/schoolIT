<jsp:include page="/admin/head.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>공지사항 게시판</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border:white; text-align:right;">
					<a href="NoticeServlet?command=notice_write_form">게시글 등록</a>
				</td>
			</tr>
			<tr><th class="numc">번호</th><th class="titlec">제목</th><th class="idc">작성자</th><th class="writedatec">작성일</th><th class="readcountc">조회</th></tr>
			<c:forEach var="notice" items="${noticeList }">
			<tr class="record">
				<td>${notice.num }</td>
				<td>
					<a href="NoticeServlet?command=notice_view&num=${notice.num }">
					${notice.title }
					</a>
				</td>
				<td>${notice.name }</td>
				<td><fmt:formatDate value="${notice.writedate }"/></td>
				<td>${notice.readcount }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
<%-- <jsp:include page="foot.html" /> --%>