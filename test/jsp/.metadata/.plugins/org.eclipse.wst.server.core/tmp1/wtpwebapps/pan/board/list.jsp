<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="board.vo.BoardBean"%>
<%@page import="board.dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	int pageno = request.getParameter("pageno")==null?1:Integer.parseInt(request.getParameter("pageno"));
	String search = request.getParameter("search")==null?"":request.getParameter("search");
	String category = request.getParameter("category")==null?"all":request.getParameter("category");
	BoardDao dao = new BoardDao();
	System.out.println("category : " + request.getParameter("category"));
	ArrayList<BoardBean> list = dao.selectBoard(search, category, pageno);
	
	dao = new BoardDao();
	int listsize = dao.cntTotalBoard(category, search);
	
	int totalPage = 0; 
	
	if((listsize % 10) == 0){
		totalPage=(listsize/10);
		 }else{
			 totalPage=(listsize/10 + 1);
		 }
	
%>
<head>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<link rel="stylesheet" href="/pan/board/css/notice.css">
<script>
	$(function() {
		
		<%-- $("#board tr").click(function(){
	        $(this).find("td").eq(0).each(function(){
	        	var num=$(this).eq(0).html();
	        	//alert($(this).eq(0).html());
	            $("#content").load("../pan/BoardServlet?command=board_view&no="+num+"&pageno=<%=pageno%>");   	
	        });
	    }); --%>
		
		
		$("#wirte").click(function() {
			location.href="/pan/board/BoardServlet?command=board_write_form";
		});
	
		
		$("#se").click(function() {

			var url = "/pan/board/BoardServlet?command=board_list&category=";
			var category=$("#category option:selected").val();
			var url2="&search=";
			var Str=$("#search").val();
			
			location.href=url+category+url2+Str;
		});
		
		 $("#category").change(function() {
			
			var url = "/pan/board/BoardServlet?command=board_list&category=";
			var category=$("#category option:selected").val();
			var url2="&search=";
			var Str=$("#search").val();
			
			location.href=url+category+url2+Str;
		}); 

	});
</script>
    </head>
  <body>  
  <jsp:include page="../common/head.jsp"></jsp:include>
<div class="content" id="content">
		<div class="boradlist">
		<div class="bs-docs-example">
		<div id="wrap" align="center">
		
    <div class="gallery-info" align="center">
					<h2>Review</h2>
    </div>
	
    <br>
	<p>&nbsp;</p>
<!-- <form name="frm" action="/pan/BoardServlet?command=board_list" method="get" >  -->
 <table border="1"  class="list" id="board" style="width: 80%;">  
	 
		<thead><tr style="font-size: 20px">
			<td align="right" colspan="6">
			검색 : <input type="text" name="search" id="search" value=<%=search%>><a href="#" id="se"><input type="button" value="검색"></a>
				<select name="category" id="category">
					<option value="all" <%if("all".equals(category)){%> selected<%}%>>전체</option>
					<option value="00001" <%if("00001".equals(category)){%> selected<%}%>>방후기</option>
					<option value="00002" <%if("00002".equals(category)){%> selected<%}%>>서비스</option>
					<option value="00003" <%if("00003".equals(category)){%> selected<%}%>>주변</option>
					<option value="00004" <%if("00004".equals(category)){%> selected<%}%>>기타</option>
				</select>			
				 	<a href="#" id="wirte"><img src="\pan\board\img\btn_write.gif" height="20px"></a>
			</td>
		</tr></thead>
		<thead><tr class="list">
			<th width="6%" style="text-align: center;">번호</th>
			<th width="10%" style="text-align: center;">구분</th>
			<th width="34%" style="text-align: center;">내용</th>
			<th width="14%" style="text-align: center;">작성자</th>
			<th width="12%" style="text-align: center;">작성일</th>
			<th width="12%" style="text-align: center;">조회수</th>
		</tr></thead>		
		<%
		if(list.size() > 0){
			for(int i=0; i<list.size(); i++){
				BoardBean vo = list.get(i);	
			%>
			<tbody><tr style="font-size: 15px">
				<td><%=vo.getNo() %></td>
				<td><% 
						if("00001".equals(vo.getCategory())){
							out.println("방후기");
						}else if("00002".equals(vo.getCategory())){
							out.println("서비스");
						}else if("00003".equals(vo.getCategory())){
							out.println("주변");
						}else if("00004".equals(vo.getCategory())){
							out.println("기타");
						}
					%>
				</td>
			<td><a href="javascript:location.href=('/pan/board/BoardServlet?command=board_view&no=<%=vo.getNo()%>&pageno=<%=pageno%>');"><%=vo.getTitle() %></a>
								<% if(vo.getHit()>=20){%>
             <img src="\pan\board\img\btn.gif">
<%}%></td>
				<td><%=vo.getUsername() %></td>
				<td><%=vo.getTime() %></td>
				<%-- <td><%=vo.getFile_name() %></td> --%>
				<td><%=vo.getHit() %></td>
			</tr></tbody><tbody>
<%
			}
		}else{
			out.println("<td colspan=6>해당게시판에 글이 없습니다.</td>");
		}
		%>
		<tr>
			<td colspan="7" style="font-size: 15px" align="center">
				<a href="/pan/board/BoardServlet?command=board_list&pageno=1">[처음]</a>
				<%
					if(totalPage <= 10){
						for(int i=1; i<=totalPage; i++){
				%>
							<a href="/pan/board/BoardServlet?command=board_list&pageno=<%=i%>">[<%=i%>]</a>
				<%
						}
					}else{
						if(pageno >= 6){
							for(int i=pageno-5; i<pageno+5; i++){
								if(i == totalPage+1) break;
							%>
								<a href="/pan/board/BoardServlet?command=board_list&pageno=<%=i%>">[<%=i%>]</a>
							<%
							}
						}else{
							for(int i=1; i<=10; i++){
							%>
								<a href="/pan/board/BoardServlet?command=board_list&pageno=<%=i%>">[<%=i%>]</a>
        <%
							}			
						}
					}
				%>
				<a href="/pan/board/BoardServlet?command=board_list&pageno=<%=totalPage%>">[마지막]</a>
			</td>
		</tr></tbody>
	</table>
	</div></div></div></div>
	  <jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>