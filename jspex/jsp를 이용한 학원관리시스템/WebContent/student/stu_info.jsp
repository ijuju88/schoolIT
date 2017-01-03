
<!--  * 팀명 : 로티플 -->
<!--  * 프로그램명 : 학원출결관리 프로그램 ver 3.0 -->
<!--  * 학생관리 담당자: 김민래 -->
<!--  * 내용 : 수강생 정보(등록,수정,삭제),교육과목 정보(등록,수정,삭제),수강정보(등록,수정,삭제),출결체크,출결 상태 확인 -->
<!--  * java 클래스 : Action,ActionForward,StudentAddAction,StudentDeleteAction,StudentListAction,StudentModifyAction,StudentFrontController,StudentBean,StudentDAO  -->
<!--  * jsp 페이지 : stu_info,stu_insert,stu_edit,idCheck,idCheck2,editCheck,editCheck2                -->
<!--  * JDK version : JDK1.7.0_51 -->
<!--  * 개발툴 : 이클립스 kepler Service Release 1 -->
<!--  * DB : Oracle ( Version - OraDb11g )  -->
<!--  * 날짜 : 2014년 03월 18일 - java.io사용하여 데이터 저장, 스윙창에서 등록/수정/삭제 구현 -->
<!--  *        2014년 04월 04일 - java.io 에서 DB(Oracle)로 데이터 저장  방식 변경 -->
<!--                  2014년 05월 21일 - 스윙창 구현 방식에서 JSP 이용한 web구현 방식으로 변경 -->
<!--                                             - control 자바 통한 page이동으로 보안성 강화 -->
<!--  * 추가 기능 : - 학생 등록,수정,삭제시 ID중복 검사 바로 할 수 있도록 구현 -->
<!--                          -  학생 등록시 password 확인 바로 되도록 구현 -->
<!--  * 핵심기능 : 스윙 ActionListener , Getter,Setter , Connection , Statement , PreparedStatement , ResultSet,DataSource -->
<!--  * 핵심구문 : while, if~else ,try~catch,finally   -->

<!-- 등록된 학생 리스트와 학생 관리에 필요한 등록,편집page로 바로 이동 가능한 stu_info.jsp  -->
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="roti.lms.ad_stu.db.*" %>   
<%
//  등록된 학생 리스트를 정렬 하고 DB에 등록된 학생이 20명 이상이 될 경우 다른 페이지로 보여지도록 DB값 카운트 및 페이지 이동 
	List studentList=(List)request.getAttribute("studentlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/css; charset=EUC-KR">
<title> 학생관리 </title>
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
			<li><a class="menuLink" href="StudentWrite.eo">학생등록</a></li>
			<li><a class="menuLink" href="StudentModify.eo">학생편집</a></li>
			<li><a class="menuLink" href="RegisterListAction.bo">수강관리</a></li>
			<li><a class="menuLink" href="stu_check.co" target="#">출결현황</a></li>
		</ul>
	</nav>
</p>
</td>
</tr>
<tr>
<td>
<table width=50% border="0" cellpadding="0" cellspacing="0">
<%
if(listcount > 0){
%>
	<tr align="center" valign="middle">
		<td colspan="4">학생 관리</td>
		<td align=right>
			<font size=2>글 개수 : ${listcount }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="9%" height="26"> 
			<div align="center">아이디</div> 
 		</td> 
<!-- 		<td style="font-family:Tahoma;font-size:8pt;" width="9%"> -->
<!-- 			<div align="center">아이디</div> -->
<!-- 		</td> -->
		<td style="font-family:Tahoma;font-size:8pt;" width="9%">
			<div align="center">이름</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="9%">
			<div align="center">생년월일</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="28%">
			<div align="center">주소</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="9%">
			<div align="center">연락처</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="9%">
			<div align="center">비상연락처</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="9%">
			<div align="center">성별</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="9%">
			<div align="center">등록일</div>
		</td>
	</tr>
	
	<%
	//받아온 학생 정보 정렬
		for(int i=0;i<studentList.size();i++){
			StudentBean bl=(StudentBean)studentList.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">

		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="left">
			
			</div>
		</td>
	<tr>	
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getSt_id() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getSt_name() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getBirth() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getAddr() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getSt_hp() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getSt_ehp() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getGender() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;">
			<div align="center"><%=bl.getRdate() %></div>
		</td>
		<tr>

	</tr>
	<%} %>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
<!-- 		학생 정보가 다수일 경우 이전 다음 페이지로 이동  -->
			<%if(nowpage<=1){ %>
			[이전]&nbsp;
			<%}else{ %>
			<a href="./StudentList.eo?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./StudentList.eo?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음]
			<%}else{ %>
			<a href="./StudentList.eo?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
	<%
    }
	else
	{
	%>
	<tr align="center" valign="middle">
		<td colspan="4">MVC 게시판</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
	<%
	}
	%>

</table>


</td>
</tr>

</table>
</div>


</body>
</html>