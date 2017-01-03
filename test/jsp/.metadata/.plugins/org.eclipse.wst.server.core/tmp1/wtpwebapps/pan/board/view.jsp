<%@page import="java.io.File"%>
<%@page import="board.dao.BoardDao"%>
<%@page import="board.vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<%
	int pageno = Integer.parseInt(request.getParameter("pageno"));
	BoardDao dao = new BoardDao();
	BoardBean vo = new BoardBean();
	vo = dao.selectBoard(Integer.parseInt(request.getParameter("no")));
	//out.print(pageno);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
		
</head>
<body>
<jsp:include page="../common/head.jsp"></jsp:include>
	<div class="content" id="content">
		<div class="viewForm">
		<div id="wrap"> 
	<form>
	<center>
	 <div class="gallery-info" align="center">
					<h2>Review View</h2>
    </div>
			
	<div class="input-group" align="left">
		<span class="input-group-addon" class="form-control" placeholder="username" aria-describedby="sizing-addon1"id="sizing-addon1">등록자</span>
			<input type="text"  disabled="disabled" class="form-control" placeholder="username" aria-describedby="sizing-addon1" id="username" name="username" value="<%=vo.getUsername() %>">
	</div>		
			
	<div class="input-group" align="left">
		<span class="input-group-addon" id="sizing-addon2">구분</span>
		
		<% 
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
		</div>		
			
		<div class="input-group" align="left">	
			<span class="input-group-addon" id="sizing-addon3">제목</span>
			<input type="text"  disabled="disabled" class="form-control" placeholder="title" aria-describedby="sizing-addon3" id="title" name="title" value="<%= vo.getTitle() %>">
			
		</div>	
			
		<div class="input-group" align="left">
			<span class="input-group-addon" id="sizing-addon4">내용</span>
			<textarea  disabled="disabled" class="form-control" placeholder="content" aria-describedby="sizing-addon4"  rows="15" cols="75%" name="content"  id="content" ><%=vo.getContent() %></textarea>
		</div>	
			
		<div class="input-group" align="left">	
			<span class="input-group-addon" id="sizing-addon5">이미지</span>
			<img src="/pan/files/<%=vo.getFile_name() %>" width="100%" height="300px">
		</div>		
			
		<div class="input-group" align="left">
			<span class="input-group-addon" id="sizing-addon6">설명/다운로드</span>
			<a href='/pan/Download?file=<%=vo.getFile_name() %>'><%=vo.getFile_name() %></a>
		</div>		
			
		
			<input type="button" id="button1" value="수정" onclick="location.href='/pan/board/upd.jsp?no=<%=vo.getNo()%>&pageno=<%=pageno%>'"/>
			<input type="button" id="button1" value="삭제" onclick="location.href='/pan/board/del.jsp?no=<%=vo.getNo()%>&pageno=<%=pageno%>'"/>
			<input type="button" id="button1" name="버튼" value="이전" onclick="location.href='/pan/board/BoardServlet?command=board_list'"/>
		</center>		
			
		
	</form>		
</div></div></div>
<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>