<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here </title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
</head>
<body>
  <jsp:include page="../common/head.jsp"></jsp:include>
<div class="content" id="content">
		<div class="about-section">
			<div class="container">
<div id="wrap" align="center">
<h1> 게시글 상세보기</h1>
	<table>
		<tr>
			<th> 아이디 </th><td>${notice.id}</td>
			<th> 이름 </th><td>${notice.name}</td>
		</tr>
		
		<tr>
			<th> 내용 </th>
			<td colspan="3"><pre>${notice.content}</pre></td>
		</tr>
		</table><br><br>
		<input type="button" value="게시판 리스트" onclick="javascript:location.href=('../noticeboard/NoticeMainServlet?command=notice_list');">
		<!--javascript:$('#content').load - 자바스크립트를 html태그 안에 넣는 방법 
		출력은 페이지 중간부분으로 표현되게 함 -->
</div>
</div></div></div>
  <jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>