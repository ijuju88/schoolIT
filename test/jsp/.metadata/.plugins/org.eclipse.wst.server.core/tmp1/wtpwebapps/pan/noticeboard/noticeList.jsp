<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<!-- <script type="text/javascript">
/* $(function() {
	$("#list tr").click(function(){
        $(this).find("td").eq(0).each(function(){
        	var num=$(this).eq(0).html();
        	//alert($(this).eq(0).html());
            $("#content").load("../noticeboard/NoticeMainServlet?command=notice_view&num="+num);   		
        });
    });
}); */
</script>  -->




</head>
<body>
  <jsp:include page="../common/head.jsp"></jsp:include>
	<div class="content" id="content">
		<div class="about-section">
			<div class="container">
			<div id="wrap" align="center">
			<h1> 공지사항 게시판 </h1>
			<table class="list" id="list">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
				</tr>
				<c:forEach var="notice" items="${noticeList}">
					
					<tr class="record">
						<td>${notice.num}</td>             
						<td><a href="../noticeboard/NoticeMainServlet?command=notice_view&num=${notice.num}"> ${notice.title}</a></td>
						<td>${notice.name}</td>
						<td><fmt:formatDate value="${notice.writedate}"/></td>
						<td>${notice.readcount}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
			</div></div></div>
			  <jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>