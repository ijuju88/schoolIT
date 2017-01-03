<jsp:include page="/admin/head.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../notice/script/notice.js"></script>
</head>
<body>
	<div id="wrap" align="center">
	<h1>게시물 수정</h1>
	<form name="frm" method="post" action="NoticeServlet">
	<input type="hidden" name="command" value="notice_update">
	<input type="hidden" name="num" value="${notice.num }">
	<table>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" size="12" name="name" value="${notice.name }">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" size="12" name="passwd" value="${notice.passwd }">*필수 작성!(게시물 수정 삭제시 필요합니다)
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" size="40" maxlength="50" name="id" value="${notice.id }">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" size="70" name="title" value="${notice.title }">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="15" cols="70" name="content">${notice.content }</textarea>
			</td>
		</tr>
	</table>
	<br><br>
	<input type="submit" value="등록" onclick="return noticeCheck()">
	<input type="reset" value="다시작성">
	<input type="button" value="목록" onclick="location.href='NoticeServlet?command=notice_list'">
	</form>
	</div>
</body>
</html>
<%-- <jsp:include page="foot.html" /> --%>