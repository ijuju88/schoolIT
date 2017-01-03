<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	int pageno = request.getParameter("pageno")==null?1:Integer.parseInt(request.getParameter("pageno"));
	String search = request.getParameter("search")==null?"":request.getParameter("search");
	String category = request.getParameter("category")==null?"all":request.getParameter("category");
	BoardDao dao = new BoardDao();
	System.out.println("category : " + request.getParameter("category"));
	ArrayList<BoardVO> list = dao.selectBoard(search, category, pageno);
	
	dao = new BoardDao();
	int listsize = dao.cntTotalBoard(category, search);
	int totalpage = listsize>0 ? (listsize/10) : 1;
%>
<head>
<script src="http://code.jquery.com/jquery-2.0.0.js"></script>
<script language=javascript>
	$(function() {
		$("#category").change(function() {

			var url = "list.jsp?category=";
			var category = $("#category option:selected").val();
			var url2 = "&search=";
			var Str = $("#search").val();

			location.href = url + category + url2 + Str;
		});

	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>게시판</h2>
	
	<form name="frm" action="list.jsp" method="post">
	<table border="0">
		<tr>
			<td align="left" colspan="3">글 개수 : <%= listsize %> 개	</td>
			<td align="right" colspan="4">
				<select name="category" id="category">
					<option value="all" <%if("all".equals(category)){%> selected<%}%>>전체</option>
					<option value="00001" <%if("00001".equals(category)){%> selected<%}%>>유머글</option>
					<option value="00002" <%if("00002".equals(category)){%> selected<%}%>>시사</option>
					<option value="00003" <%if("00003".equals(category)){%> selected<%}%>>연예</option>
					<option value="00004" <%if("00004".equals(category)){%> selected<%}%>>고민상담</option>
				</select>			
				<input type="button" value="글쓰기" onclick="javascript:location.href='add.jsp';">
			</td>
		</tr>
		<tr align="center">
			<th width="60">번호</th>
			<th width="60">구분</th>
			<th width="300">제목</th>
			<th width="120">작성자</th>
			<th width="60">조회수</th>
			<th width="100">작성일자</th>
			<th width="80">파일</th>
		</tr>		
		<tr><td width="800" height="2" bgcolor="red" colspan=7></td></tr>
		<%
		if(list.size() > 0){
			for(int i=0; i<list.size(); i++){
				BoardVO vo = list.get(i);	
			%>
			<tr align="center">
				<td><%=vo.getNo() %></td>
				<td><% 
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
				<td><a href="view.jsp?no=<%=vo.getNo()%>&pageno=<%=pageno%>"><%=vo.getTitle() %></a></td>
				<td><%=vo.getUsername() %></td>
				<td><%=vo.getHit() %></td>
				<td><%=vo.getTime() %></td>
				<td><%=vo.getFile_name() %></td>
			</tr>
			<%
			}
		}else{
			out.println("<td colspan=6>해당게시판에 글이 없습니다.</td>");
		}
		%>
		<tr><td width="800" height="2" bgcolor="red" colspan=7></td></tr>
		<tr>
			<td colspan="7">
				<a href="list.jsp?pageno=1&category=<%=category%>&search=<%=search%>">[처음]</a>
				<%
					if(totalpage <= 10){
						for(int i=1; i<=totalpage; i++){
				%>
							<a href="list.jsp?pageno=<%=i%>&category=<%=category%>&search=<%=search%>">[<%=i%>]</a>
				<%
						}
					}else{
						if(pageno >= 6){
							for(int i=pageno-5; i<pageno+5; i++){
								if(i == totalpage+1) break;
							%>
								<a href="list.jsp?pageno=<%=i%>&category=<%=category%>&search=<%=search%>">[<%=i%>]</a>
							<%
							}
						}else{
							for(int i=1; i<=10; i++){
							%>
								<a href="list.jsp?pageno=<%=i%>&category=<%=category%>&search=<%=search%>">[<%=i%>]</a>
							<%
							}			
						}
					}
				%>
				<a href="list.jsp?pageno=<%=totalpage%>&category=<%=category%>&search=<%=search%>">[마지막]</a>
			</td>
		</tr>
		<tr>
			<td colspan="7">검색 : <input type="text" name="search" id="search" value=<%=search%>><input type="submit" value="검색"></td>
		</tr>
	</table>
	</form>
</center>	
</body>
</html>