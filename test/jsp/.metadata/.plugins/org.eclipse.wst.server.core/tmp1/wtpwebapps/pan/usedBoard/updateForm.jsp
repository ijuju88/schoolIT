<%@page import="clientmember.LogonDataBean"%>
<%@page import="clientmember.LogonDB"%>
<%@ page import="board.BoardDB"%>
<%@ page import="board.BoardDataBean"%>
<%@ page contentType = "text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<%

String id = null;
try {
	id = session.getAttribute("memId").toString();
} catch (NullPointerException e) {
%>
<script type="text/javascript">
alert("수정은 회원만 가능합니다!");
location.href="../usedBoard/list.jsp";
</script>
<%
}
  int num = Integer.parseInt(request.getParameter("num"));
  String pageNum = request.getParameter("pageNum");
  try{
      BoardDB dbPro = BoardDB.getInstance();
      BoardDataBean article = dbPro.updateGetArticle(num);
  	  LogonDB manager = LogonDB.getInstance();
  	  LogonDataBean c = manager.getMember(id);

%>

</head>
<body> 
<jsp:include page="../common/head.jsp"></jsp:include>
<div class="updateForm">
		<div class="content">
		<div class="gallery-info" align="center">
					<h2>Question Update</h2>
    </div>
	<center>
    <form method="post" name="writeform" action="../usedBoard/updatePro.jsp?pageNum=<%=pageNum%>" onsubmit="return writeSave()">
   	<input type="hidden" name="num" value="<%= article.getNum() %>" />
   
  		<div class="input-group">
       <span class="input-group-addon" id="sizing-addon1"><img src="../usedBoard/img/01.gif"></span>		
         <input type="text"  disabled="disabled" class="form-control" placeholder="writer" aria-describedby="sizing-addon1"name="writer" value="<%=article.getWriter()%>">	
      </div>
    
      <div class="input-group">
        <span class="input-group-addon" id="sizing-addon2"><img src="../usedBoard/img/05.gif"> </span>
        <input type="text"  class="form-control" placeholder="subject" aria-describedby="sizing-addon2" name="subject" value="<%=article.getSubject()%>">
      </div>
	
		<div class="input-group">
        <span class="input-group-addon" id="sizing-addon3"><img src="../usedBoard/img/03.gif"></span>
        <input type="text" disabled="disabled" class="form-control" placeholder="email" aria-describedby="sizing-addon3" name="email" value="<%=article.getEmail()%>">
      </div>
         
      <div class="input-group">
        <span class="input-group-addon" id="sizing-addon4"><img src="../usedBoard/img/06.gif"></span>
        <textarea name="content" class="form-control" placeholder="content" aria-describedby="sizing-addon4" rows="13" cols="100"><%=article.getContent()%></textarea> 
      </div>
      
	<div class="input-group">
		<span class="input-group-addon" id="sizing-addon5"><img src="../usedBoard/img/02.gif"></span>        
       <input type="password" class="form-control" placeholder="writer" aria-describedby="sizing-addon5" name="passwd">
        </div> 
      
      <center>
      <input type="submit" value="작성"  onclick="return writeSave()"/>
	<input type="reset" value="취소"/>
      <input type="button" value="리스트로" OnClick="javascript:location.href='../usedBoard/list.jsp?pageNum=<%=pageNum%>';" >
    	</center>
    
    </form></center></div></div>   
    <%
}catch(Exception e){}%>     
 <jsp:include page="../common/foot.jsp"></jsp:include>    
</body>
</html>

