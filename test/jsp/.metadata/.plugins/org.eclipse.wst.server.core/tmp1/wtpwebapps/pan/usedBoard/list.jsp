<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="board.BoardDB"%>
<%@ page import="board.BoardDataBean"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>


<%
    int pageSize = 10;  // 한 페이지에 나타낼 글 수
    SimpleDateFormat sdf =
    new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<%
    String pageNum = request.getParameter("pageNum");
    if (pageNum == null) {//페이지 번호가 인수로 넘어오지 않으면 1을 기억
        pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow = (currentPage - 1) * pageSize + 1;  //그 페이지의 시작행 지정
    // 2페이지의 경우
    // (2-1)*10 + 1 = 11
    int endRow = currentPage * pageSize; // 그 페이지의 끝행 지정
    // 2페이지의 경우
    //  2+10 = 20
    int count = 0;    // 전체 글 수
    int number=0;   // 그 페이지에서 시작행 번호

    List articleList = null;
    BoardDB dbPro = BoardDB.getInstance();
    count = dbPro.getArticleCount();
    if (count > 0) {
    //    articleList = dbPro.getArticles(startRow, pageSize);
        articleList = dbPro.getArticles(startRow, endRow);
    }

    number=count-(currentPage-1)*pageSize;//그 페이지에서 시작 행 번호
    // 전체 52개의 글인 경우 2페이지 시작 행 번호
    //    52 - (2-1)*10 = 42
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<script type="text/javascript">
$(function() {
	$("#search").click(function() {
		var url = "../usedBoard/searchList.jsp?flag=search&gubun=";
		var Gubun=$("#gubun option:selected").val();
		var url2="&sstring=";
		var Str=$("#sstring").val();

		
		location.href=(url+Gubun+url2+Str);
	});

});
</script>     

    </head>
<body>
  <jsp:include page="../common/head.jsp"></jsp:include>
<div class="content" id="content">
		<div class="userboradlist">
		<div class="bs-docs-example">
		<div class="gallery-info" align="center">
					<h2>Question</h2>
    </div>
    <hr>
<%
    if (count == 0) {  // 등록된 글이 없는 경우
%>
	<center>
    <table border="1"  class="list" id="board" style="width: 80%;">

        <thead><tr>
            <td align="center">
                게시판에 저장된 글이 없습니다.
            </td>
        </tr></thead>
    </table>
    </center>
<%  } else {     // 등록된 글이 있는 경우%> 
<center>
    <table border="1"  class="list" id="board" style="width: 80%;">  
		<thead>
        <tr height="30" bgcolor="black">
            <td align="center"  width="25" ><font color="white" face="HY나무M" size="3">번 호</font></td>
            <td align="center"  width="250" ><font color="white" face="HY나무M" size="3">제   목</font></td>
            <td align="center"  width="100" ><font color="white" face="HY나무M" size="3">작성자</font></td>
            <td align="center"  width="150" ><font color="white" face="HY나무M" size="3">작성일</font></td>
            <td align="center"  width="50" ><font color="white" face="HY나무M" size="3">조 회</font></td>
           
        </tr></thead>
<% 
    for (int i = 0 ; i < articleList.size() ; i++) {
        BoardDataBean article = (BoardDataBean)articleList.get(i);
%>
        <tbody><tr height="30">
            <td align="center"  width="50"><%=number--%></td>
            <td  width="250" >
<%
    int wid=0;  // 들여쓰기 설정(레벨에 따라)
    if(article.getRe_level()>0){
        wid=5*(article.getRe_level());
%>
      <%--   <img src="../Main/images/level.gif" width="<%=wid%>" height="16"> --%>
        <img src="../usedBoard/img/ioc-reply.gif">
<%}else{%>
       <%--  <img src="../Main/images/level.gif" width="<%=wid%>" height="16"> --%>
<%}%>  
    <a href="javascript:location.href=('../usedBoard/content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>&sstring=<%=article.getSubject()%>');"><%=article.getSubject()%></a>
<% if(article.getReadcount()>=20){%>
        <img src="../usedBoard/img/11.bmp" border="0"  height="16"><%}%> </td>
            <td align="center"  width="100">
            <!-- Gmail로 설정 http://fantaziulo.blog.me/150188563111 -->
            <a href="mailto:<%=article.getEmail()%>?Subject=Hello%20again" target="_blank"><%=article.getWriter()%></a></td>
            <td align="center"  width="150"><%= sdf.format(article.getReg_date())%></td>
            <td align="center"  width="50"><%=article.getReadcount()%></td>
        </tr></tbody>
<%}%>
	</table></center>
<%}%>
<input type="hidden" name="flag" value="search">
<center>
<table class="table" bordercolor="#ffffff" cellspacing="0" style="width: 80%;"><tr>
<td align="center" ><select name="gubun" id="gubun">
    <option value="subject"> 제    목</option>
    <option value="content">내    용</option>
    <option value="writer">작성자</option>
</select>
<input type="text" name="sstring" id="sstring" size=15>  
<a href="#" id="search">
<input type="image" src="../usedBoard/img/btn_search.gif">
</a></td>
<td>
<ul class="pagination pagination-sm">
<%


    if (count > 0) {  // 등록된 글이 있는 경우
    int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
    // 총페이지 수 계산
    //  5 + 1 = 6(등록된 글이 52개인 경우)
    // 5 + 0 = 5 (등록된 글이 50개인 경우)     
    int startPage = (int)(currentPage/10)*10+1;
    int pageBlock=10;
    // 시작 페이지 번호
    // (int)15/10 * 10 + 1= 11(15페이지의 경우)
    int endPage = startPage + pageBlock-1;
    //
    if (endPage > pageCount) endPage = pageCount;

        if (startPage > 10) {    %>
        <li class="disabled">
            <a href="javascript:location.href='list.jsp?pageNum=<%= startPage - 10 %>';">
            <i class="fa fa-angle-left">
            [이전]</i></a></li>
<%      }
        for (int i = startPage ; i <= endPage ; i++) {  %>
        <li class="active"><a href="javascript:location.href='../usedBoard/list.jsp?pageNum=<%= i %>';">
           [<%= i %>]</a>
            </li>
<%
        }
        if (endPage < pageCount) {  %>
        <li><a href="javascript:location.href='../usedBoard/list.jsp?pageNum=<%= startPage + 10 %>';" >
            <i class="fa fa-angle-right">
            [다음]</i></a></li>

<%
        }
    }
%>
</ul>
</td>
<td><a href="javascript:location.href='../usedBoard/wirteForm.jsp';">
<img src="..\usedBoard\img\btn_write.gif" border="0"></a></td>
</tr></table></center></div></div></div>
<jsp:include page="../common/foot.jsp"></jsp:include>

</body>
</html>

