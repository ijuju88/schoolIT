<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modify" method="post">
<input type="hidden" name="bId" value="${dto.bId}">
<table width="500" border=1>
	<tr><td>번호</td>
		<td>${dto.bId}</td>
	</tr>
	<tr><td>조회수</td>
		<td>${dto.bHit}</td>
	</tr>
	<tr><td>이름</td>
		<td><input type="text" name="bName" value="${dto.bName}"></td>
	</tr>
	<tr><td>제목</td>
		<td><input type="text" name="bTitle" value="${dto.bTitle}"></td>
	</tr>
	<tr><td>내용</td>
		<td><textarea rows=10 cols=50 name="bContent">${dto.bContent}</textarea></td>
	</tr>
	<tr><td colspan=2>
		<input type="submit" value="수정">
		<a href="delete?bId=${dto.bId}">삭제</a>
		<a href="reply_view?bId=${dto.bId}">답변글 달기</a>		
		<a href="list">목록보기</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>