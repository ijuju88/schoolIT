<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="roti.lms.ad_reg.*"%>
<%
	String id = null;
	if (session.getAttribute("id") != null) {
		id = (String) session.getAttribute("id");
	}
	List boardList = (List) request.getAttribute("boardlist");
	int listcount = ((Integer) request.getAttribute("listcount"))
			.intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = ((Integer) request.getAttribute("maxpage"))
			.intValue();
	int startpage = ((Integer) request.getAttribute("startpage"))
			.intValue();
	int endpage = ((Integer) request.getAttribute("endpage"))
			.intValue();
%>

<html>

<head>
<script language="javascript">
	function insert1() {
		location.href = "./InsertPage.bo";
	}
	function delete1() {
		location.href = "./DeletePage.bo";
	}

	function update1() {
		location.href = "./UpdatePage.bo";
	}
	function home() {
		location.href = "./HomePage.bo";
	}
</script>
<title>강좌 게시판</title>
<link href="css/roti2.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div id="maintop">
		<a href="index.jsp" class="aa">HOME</a>
	</div>
	<div class="top">

		<nav id="topMenu">
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
		<nav id="stu_Menu">
			<ul>
				<li><a class="menuLink" href="StudentWrite.eo" target="#">학생등록</a></li>
				<li><a class="menuLink" href="StudentModify.eo" target="#">학생편집</a></li>
				<li><a class="menuLink" href="RegisterListAction.bo">수강관리</a></li>
				<li><a class="menuLink" href="stu_check.co" target="#">출결현황</a></li>
			</ul>
		</nav>
		<table align="center" border="1" cellspacing="0" cellpadding="0"
			style="padding: 3px 4px 2px; width: 660px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);">
			<tr>
				<td align="center">강좌페이지</td>
			</tr>
			<tr>
				<td align=right><font size=2>등록수 : ${listcount }</font></td>
			</tr>
		</table>
		<table align="center" border="1" cellspacing="0" cellpadding="0"
			style="padding: 3px 4px 2px; width: 660px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);">

			<tr>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; border-top-color: rgb(70, 105, 151); border-bottom-color: rgb(70, 105, 151); border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; background-color: rgb(98, 132, 171);"><p>강좌아이디</p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; border-top-color: rgb(70, 105, 151); border-bottom-color: rgb(70, 105, 151); border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; background-color: rgb(98, 132, 171);"><p>강좌번호</p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; border-top-color: rgb(70, 105, 151); border-bottom-color: rgb(70, 105, 151); border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; background-color: rgb(98, 132, 171);"><p>시작날짜</p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; border-top-color: rgb(70, 105, 151); border-bottom-color: rgb(70, 105, 151); border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; background-color: rgb(98, 132, 171);"><p>종료날짜</p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; border-top-color: rgb(70, 105, 151); border-bottom-color: rgb(70, 105, 151); border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; background-color: rgb(98, 132, 171);"><p>수강료</p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; border-top-color: rgb(70, 105, 151); border-bottom-color: rgb(70, 105, 151); border-top-width: 1px; border-bottom-width: 1px; border-top-style: solid; border-bottom-style: solid; background-color: rgb(98, 132, 171);"><p>강의실</p></td>
			</tr>
			<%
				for (int i = 0; i < boardList.size(); i++) {
					RegisterBean rb = (RegisterBean) boardList.get(i);
			%>
			<tr>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(255, 255, 255);"><p><%=rb.getRg_id()%></p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(255, 255, 255);"><p><%=rb.getSub_no()%></p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(255, 255, 255);"><p><%=rb.getRg_start()%></p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(255, 255, 255);"><p><%=rb.getRg_end()%></p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(255, 255, 255);"><p><%=rb.getCharge()%></p></td>
				<td
					style="padding: 3px 4px 2px; width: 110px; height: 15px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(255, 255, 255);"><p><%=rb.getClassroom()%></p></td>
			</tr>
			<%
				}
			%>
			<tr align=center height=20>
				<td colspan=7 style="font-family: Tahoma; font-size: 10pt;">
					<%
						if (nowpage <= 1) {
					%> [이전]&nbsp; <%
 	} else {
 %> <a href="./BoardList.bo?page=<%=nowpage - 1%>">[이전]</a>&nbsp; <%
 	}
 %> <%
 	for (int a = startpage; a <= endpage; a++) {
 		if (a == nowpage) {
 %> [<%=a%>] <%
 	} else {
 %> <a href="./BoardList.bo?page=<%=a%>">[<%=a%>]
				</a> &nbsp; <%
 	}
 %> <%
 	}
 %> <%
 	if (nowpage >= maxpage) {
 %> [다음] <%
 	} else {
 %> <a href="./BoardList.bo?page=<%=nowpage + 1%>">[다음]</a> <%
 	}
 %>
				</td>
			</tr>
			<tr align="center">
				<td
					style="padding: 3px 4px 2px; width: 540px; height: 20px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(246, 248, 250);"
					rowspan="1" colspan="6"><p>
						<input type="button" value="등록하기" onClick='insert1();'> <input
							type="button" value="수정하기" onClick='update1();'> <input
							type="button" value="삭제하기" onClick='delete1();'> <input
							type="button" value="상위페이지로" onClick='home();'>
					</p></td>

			</tr>

		</table>
</body>
</html>