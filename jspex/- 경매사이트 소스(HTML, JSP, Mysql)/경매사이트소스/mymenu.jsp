<%@ page contentType="text/html; charset=utf-8"  session="false" import="java.sql.*" session="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> 나의 메뉴 화면 </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</HEAD>
<style text="Text/css">
body {
 margin-left: 0px;
 margin-top: 0px;
 margin-right: 0px;
 margin-bottom: 0px;
 overflow-y: hidden;
 overflow-x: hidden;
}
</style>
<style text="Text/css">
.style1 {
	font-size:10px;
	color:blue;
}
.style2 {
	font-size:11px;
	color:blue;
}
.style3 {
	font-size:11px;
	color:red;
}
.style4 {
	font-size:11px;
	color:brown;
}
.style5 {
	font-size:11px;
	color:black;
}

</style>
<script language="javascript">
function click(){
	alert("헐!");
	
}
</script>
<BODY bgcolor="#FFD5D2">
 <table width="183" border="1">
        <tr>
        <th width="173" height="29" bgcolor="#99FF00" class="k1">MY PAGE<br />
<%
HttpSession session = request.getSession(false);
if(!(session.isNew())){
		if(session.getAttribute("login.id") != null){
		

%>
          <span class="style1"><%=(String)session.getAttribute("login.id") %>님 안녕하세요</span></th>
      </tr>
      <tr>
        <td height="185" align="center" valign="top"><br /><b>쇼핑내역</b></p>
          <span class="style2"><a  href="myendbuy.jsp" target="bottommenu"> ● 내가 주문한 내역<br />
          <span class="style3"><a  href="auctioning.jsp" target="bottommenu">● 진행중인 경매</span><br />
          <span class="style4"><a  href="mysell.jsp" target="bottommenu">● 내가 판매하는 내역</a></span><br />
          <span class="style5"><a  href="myendsell.jsp" target="bottommenu">● 판매-경매종료된 물건</span></p></td>
      </tr>
    </table>
	<%}

else{ %>



       
      
<span class="style1">손님 안녕하세요.<br/> 로그인이 필요합니다.!</span></th>
      </tr>
      <tr>
        <td height="185" align="center" valign="top"><br /><b>쇼핑내역</b></p>
          <span class="style2"> ● 내가 주문한 내역<br />
          <span class="style3">● 진행중인 경매</span><br />
          <span class="style4">● 내가 판매하는 내역</span><br />
          <span class="style5">● 판매-겅매종료된 물건</span></p></td>
      </tr>
  </table>

	<% } 
	
}%>
</BODY>
</HTML>
