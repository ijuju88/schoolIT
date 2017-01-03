<%@page import="mission.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	DBCon dbcon = DBCon.getInstance();

	MovieBean mb = dbcon.ViewMovie(no);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정하기</title>
</head>
<body>
	<center>
		<h2>영화정보수정</h2>
		<form method="post" action="MovieNModityPro.jsp">
		<input type="hidden" name="no" value="<%=mb.getNo() %>">
			<table>
				<tr>
					<td bgcolor="#8C8C8C">제목</td>
					<td><input type="text" name="title" value="<%=mb.getTitle() %>"></td>

				</tr>
				
				<tr>
				<td bgcolor="#8C8C8C">비번</td>
				<td><input type="password" name="pw" value="<%=mb.getPw() %>"></td>

				</tr>
			
				<tr>
					<td bgcolor="#8C8C8C">가격</td>
					<td><input type="text" name="price" value="<%=mb.getPrice() %>">원</td>
				</tr>
				<tr>
					<td bgcolor="#8C8C8C">감독</td>
					<td><input type="text" name="director" value="<%=mb.getDirector() %>"></td>
				</tr>
				<tr>
					<td bgcolor="#8C8C8C">출연배우</td>
					<td><input type="text" name="actor" value="<%=mb.getActor() %>"></td>
				</tr>
				<tr>
					<td height="100px" bgcolor="#8C8C8C">시놉시스</td>
					<td><textarea cols="80" rows="5" style="resize: none" name="synopsis" ><%=mb.getSynopsis() %></textarea></td>
				</tr>
				<tr>
					<td bgcolor="#8C8C8C">장르</td>
					<td><select name="genre"  id="genre" >
							<option value="로맨스" >로맨스</option>
							<option value="스릴러" >스릴러</option>
							<option value="미스터리" >미스터리</option>
							<option value="액션">액션</option>
							<option value="코미디" >코미디</option>
							<option value="애니메이션" >애니메이션</option>
					</select>				
					</td>
				<tr>
			</table>
			<input type="submit" value="수정"> <input type="reset"
				value="다시작성">
		</form>

	</center>
</body>
</html>