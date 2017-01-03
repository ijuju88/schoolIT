<%@page import="clientmember.LogonDataBean"%>
<%@page import="clientmember.LogonDB"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>게시판</title>

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script language="JavaScript" src="../usedBoard/script.js"></script>
</head>
<%
	String id = null;
	try{
		id = session.getAttribute("memId").toString();		
	}catch(NullPointerException e){
%>
	<script type="text/javascript">
		alert("작성은 회원만 가능합니다!");
		 history.go(-2);
	</script>
<%
	}
%>
<%
	int num = 0, readcount = 0, ref = 1, re_step = 0, re_level = 0; // readcount()추가
	try {
		if (request.getParameter("num") != null) {
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
	
		LogonDB manager = LogonDB.getInstance();
		LogonDataBean c = manager.getMember(id);
		//out.print(id.toString());
%>

<body>
<jsp:include page="../common/head.jsp"></jsp:include>
<div class="wirteForm">
		<div class="content">
	<center>
	<div class="gallery-info" align="center">
					<h2>Question Wirte</h2>
    </div>
	
	<form method="post" name="writeform" action="..\usedBoard\writePro.jsp"
		onsubmit="return writeSave()">
		<input type="hidden" name="num" value="<%=num%>"> <input
			type="hidden" name="readcount" value="<%=readcount%>"> <input
			type="hidden" name="ref" value="<%=ref%>"> <input
			type="hidden" name="re_step" value="<%=re_step%>"> <input
			type="hidden" name="re_level" value="<%=re_level%>">

			
				<br><div class="input-group">
				<span class="input-group-addon" id="sizing-addon1"><img src="../usedBoard/img/01.gif"></span>
				<input type="text"  class="form-control" placeholder="writer" aria-describedby="sizing-addon1" name="writer" value="<%=c.getId()%>"disabled="disabled">
				</div>
				
				<div class="input-group">
				<span class="input-group-addon" id="sizing-addon2"><img src="..\usedBoard\img\05.gif"></span>
				
					<%
						if (request.getParameter("num") == null) {
					%> <input type="text" class="form-control" placeholder="subject" aria-describedby="sizing-addon2" name="subject"></div>
				
				<%
					} else {
				%>
				<input type="text" class="form-control"  placeholder="subject" aria-describedby="sizing-addon2" name="subject"
					value="[답변]"></div>				
				<%
					}
				%>

				
			
			<div class="input-group">
				<span class="input-group-addon" id="sizing-addon3"><img src="..\usedBoard\img\03.gif"></span>
				<input type="text" size="30" class="form-control" placeholder="email" aria-describedby="sizing-addon3" 
				name="email" value="<%=c.getEmail()%>" disabled="disabled">
				</div>
			
			<div class="input-group">
				<span class="input-group-addon" id="sizing-addon4"><img src="..\usedBoard\img\06.gif"></span>
				<textarea name="content" class="form-control" placeholder="content" aria-describedby="sizing-addon4"  rows="13" cols="100"></textarea>
				</div>
			
			<div class="input-group">
				<span class="input-group-addon" id="sizing-addon5"><img src="..\usedBoard\img\02.gif"></span>
				<input type="password" class="form-control" placeholder="password" aria-describedby="sizing-addon5"  size="10" name="passwd">
			</div>

		<input type="submit" onclick="return writeSave()" value="작성"/>
		<input type="reset" value="취소"/>
		<a href="../usedBoard/list.jsp"><input type="button" value="리스트로"></a>
		
		</center>	
		
		<%
			} catch (Exception e) {
			}
		%>
	</form></div></div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>

