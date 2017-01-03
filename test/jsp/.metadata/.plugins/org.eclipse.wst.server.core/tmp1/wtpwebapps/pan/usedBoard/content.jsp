<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@page import="board.BoardDB"%>
<%@page import="board.BoardDataBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>게시판</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

</head>

<%
	String gogo=null;
	request.setCharacterEncoding("UTF-8");
	String flag = request.getParameter("flag");
	String gubun = request.getParameter("gubun");
	String sstring = new String(request.getParameter("sstring").getBytes("ISO-8859-1"),"UTF-8");
   

   int num = Integer.parseInt(request.getParameter("num"));
   String pageNum = request.getParameter("pageNum");

   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

   try{
      BoardDB dbPro = BoardDB.getInstance();
      BoardDataBean article =  dbPro.getArticle(num);
 
      int ref=article.getRef();
      int re_step=article.getRe_step();
      int re_level=article.getRe_level();
%>
<body> 
 <jsp:include page="../common/head.jsp"></jsp:include>
<div class="contentForm">
		<div class="content">
		<div class="bs-docs-example">
<div class="gallery-info" align="center">
					<h2>Question View</h2>
    </div>
    <br>
 
<form>
     <center>
  <div class="input-group" align="left">
   <span class="input-group-addon" id="sizing-addon1"> <img src="../usedBoard/img/01.gif"></span>
    <input type="text"  disabled="disabled" class="form-control" placeholder="writer" aria-describedby="sizing-addon1" id="writer" name="writer" value="<%=article.getWriter()%>">
  </div>  
  
   <div class="input-group" align="left">
    <span class="input-group-addon" id="sizing-addon2"><img src="../usedBoard/img/8.gif"></span>
   	<input type="text"  disabled="disabled" class="form-control" placeholder="reg_date" aria-describedby="sizing-addon2" id="reg_date" name="reg_date" value="<%= sdf.format(article.getReg_date())%>" >
   </div>
   
    <div class="input-group" align="left">
  	  <span class="input-group-addon" id="sizing-addon3"> <img src="../usedBoard/img/05.gif"></span>
       <input type="text" class="form-control" placeholder="subject" aria-describedby="sizing-addon3" name="subject" value="<%=article.getSubject()%>" disabled="disabled">
   </div>
  
   <div class="input-group" align="left">
     <span class="input-group-addon" id="sizing-addon4"><img src="../usedBoard/img/06.gif"></span>
    <textarea name="content" class="form-control" placeholder="content" aria-describedby="sizing-addon4"  rows="13" cols="100" disabled="disabled"><%=article.getContent()%></textarea>
    </div>
      <a href="javascript:location.href=('../usedBoard/updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>');"><img src="../usedBoard/img/btn_modify.gif" border="0"></a>
  
      <a href="javascript:location.href=('../usedBoard/deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>');"><img src="../usedBoard/img/btn_delete.gif" border="0"></a>

      <a href="javascript:location.href=('../usedBoard/wirteForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>');">
      <img src="../usedBoard/img/btn_write.gif" border="0"></a>   
    
      <a href="../usedBoard/list.jsp?pageNum=<%=pageNum%>"> <img src="../usedBoard/img/btn_list.gif" border="0"></a>

    
  
    
<%
 }catch(Exception e){}
 %>
  <% 
     
     if(flag != null && flag.equals("search")) { 
		%>
         <a href="javascript:$('#content').load(searchList.jsp?pageNum=<%=pageNum%>&gubun=<%=gubun%>&sstring=<%=sstring%>&flag=search1');">
         </a>
     <% }%>
     </center>
</form></div></div></div>     
<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html> 