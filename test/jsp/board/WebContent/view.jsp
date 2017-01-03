<%@page import="dao.BoardDao"%>
<%@page import="vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int pageno = Integer.parseInt(request.getParameter("pageno"));
	BoardDao dao = new BoardDao();
	BoardVO vo = new BoardVO();
	vo = dao.selectBoard(Integer.parseInt(request.getParameter("no")));
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.0.0.js"></script>
</head>
<body>
<center>
	<form>
		<table border="0" cellspacing="10">
			<tr>
				<td align="left" width="120">작성자 : </td>
				<td align="left" width = "680"><%=vo.getUsername() %></td>
			</tr>
			<tr>
				<td align="left">구분 : </td>
				<td align="left">
					<% 
						if("00001".equals(vo.getCategory())){
							out.println("유머글");
						}else if("00002".equals(vo.getCategory())){
							out.println("시사");
						}else if("00003".equals(vo.getCategory())){
							out.println("연예");
						}else if("00004".equals(vo.getCategory())){
							out.println("고민상담");
						}
					%>
				</td>
			</tr>
			<tr>
				<td align="left">제목 : </td>
				<td align="left"><%= vo.getTitle() %></td>
			</tr>
			<tr><td width="800" height="2" bgcolor="blue" colspan=7></td></tr>
			<tr>
				<td align="left" colspan=2><%=vo.getContent().replaceAll("\r\n", "<br/>") %></td>
			</tr>
			<tr><td width="800" height="2" bgcolor="blue" colspan=7></td></tr>
			<tr>
				<td align="left">파일 : </td>
				<td align="left"><%=vo.getFile_name() %></td>
			</tr>
			<tr>
				<td></td>
				<td align="right">
					<input type="button" value="수정" onclick="javascript:location.href='upd.jsp?no=<%=vo.getNo()%>&pageno=<%=pageno%>';">
					<input type="button" value="삭제" onclick="javascript:location.href='del.jsp?no=<%=vo.getNo()%>&pageno=<%=pageno%>';">
					<input type="button" value="목록 " onclick="javascript:location.href='list.jsp?pageno=<%=pageno%>';">
				</td>
			</tr>
		</table>
	</form>		
</center>
</body>
</html>