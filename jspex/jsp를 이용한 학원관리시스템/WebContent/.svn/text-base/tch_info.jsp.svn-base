<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="roti.lms.ad_tchdb.*" %>    
<%@ page import="roti.lms.ad_tch.*" %>
    <%
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>

    
    
<html>
<head>

<title> 강사관리 </title>
<link href="css/roti2.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="maintop">
	<a href="index.jsp" class="aa">HOME</a>
</div>
<div class="top">

<nav id="topMenu" >
		<ul>  
			<li><a class="menuLink" href="admin.jsp">M A I N</a></li>
			<li>|</li> 
			<li><a class="menuLink" href="StudentList.eo">학생관리</a></li>
			<li>|</li>
			<li><a class="menuLink" href="SubListAction.ao">강좌관리</a></li>
			<li>|</li>
			<li><a class="menuLink" href="tch_ListAction.do">강사관리</a></li>
		</ul>
	</nav>
		<nav id="stu_Menu" >
		<ul>  
			<li><a class="menuLink" href="tch_insert.do">강사 등록</a></li>
			<li><a class="menuLink" href="tch_edit.do">강사 편집</a></li>
		</ul>
	</nav>




<table width=50% border="0" cellpadding="0" cellspacing="0">
<%
if(listcount > 0){
%>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">강사번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">강사이름</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">강사학력</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">강사담당과목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">강사연락처</div>
		</td>
	</tr>
	
	<%
		for(int i=0;i<boardList.size();i++){
			Tch_Bean bl=(Tch_Bean)boardList.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getTch_no() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getTch_name() %></div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getAcab() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getResp_sub() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getTch_hp() %></div>
		</td>
	</tr>
	<%} %>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./tch_info.do?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./tch_info.do?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %>
			<a href="./tch_info.do?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<%
    }
	else
	{
	%>
	<tr align="center" valign="middle">
		<td colspan="4">강사관리</td>
		<td align=right>
			<font size=2>등록된 강사가 없습니다</font>
		</td>
	</tr>
	<%
	}
	%>

</table>



</body>
</html>