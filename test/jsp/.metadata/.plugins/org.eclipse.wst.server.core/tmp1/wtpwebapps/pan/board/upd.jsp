<%@page import="board.vo.BoardBean"%>
<%@page import="board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	BoardDao dao = new BoardDao();
	BoardBean vo = new BoardBean();
	int no = Integer.parseInt(request.getParameter("no"));
	int pageno = Integer.parseInt(request.getParameter("pageno"));
	vo = dao.selectBoard(no);
%>
<html>
<head>
<script language="JavaScript" src="/pan/board/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>


<style type="text/css">
.listtitle {
	background: #c83cc8;
	color: white;
	font-weight: bold;
}
</style>

</head>
<body>
<jsp:include page="../common/head.jsp"></jsp:include>
<div class="updateForm">
<div class="content">
<div id="wrap">
	 <div class="gallery-info" align="center">
					<h2>Review Update</h2>
    </div>
<form name="frm" action="/pan/board/BoardServlet?command=board_update" method="post" enctype="multipart/form-data">
	<center>
	<input type="hidden" id="no" name="no" value=<%=no%>> <input type="hidden" id="pageno" name="pageno" value=<%=pageno%> />
					
	<div class="input-group">	
		<span class="input-group-addon" id="sizing-addon1">등록자</span>
		<input type="text" class="form-control" placeholder="username" aria-describedby="sizing-addon1" name="username" id="username" value=<%=vo.getUsername()%>>
	</div>	
	
	<div class="input-group">	
		<span class="input-group-addon" id="sizing-addon2">비밀번호</span>
		<input type="password" class="form-control" placeholder="password" aria-describedby="sizing-addon2" name="password" id="password">
	</div>	
					
	<div class="input-group">	
		<span class="input-group-addon" id="sizing-addon3">제목
		
		<select name="category" style="width: 150px">
			<option value="00001">방후기</option>
			<option value="00002">서비스</option>
			<option value="00003">주변</option>
			<option value="00004">기타</option>
		</select></span>
		 <input type="text" class="form-control" placeholder="title" aria-describedby="sizing-addon3"  name="title" id="title" value=<%=vo.getTitle()%>>
		</div>	
						
		<div class="input-group">
			<span class="input-group-addon" id="sizing-addon4">내용</span>
			<textarea class="form-control" placeholder="content" aria-describedby="sizing-addon4" rows="15" cols="75%" id="content" name="content" wrap="virtural"><%=vo.getContent()%></textarea>
		</div>
					
		<div class="input-group">	
			<span class="input-group-addon" id="sizing-addon5">이미지/설명</span>
			<input type="file" name="file_name"  class="form-control" placeholder="file_name" aria-describedby="sizing-addon5"  value=<%=vo.getFile_name()%> /> 
			<input type="hidden" name="file_chk" />
		</div>	
			
			<input type="submit" onclick="return writeSave()"/>
			<a href="/pan/board/BoardServlet?command=board_list"><input type="button" value="취소"></a>
			
		</center>
		</form>
	</div></div></div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>