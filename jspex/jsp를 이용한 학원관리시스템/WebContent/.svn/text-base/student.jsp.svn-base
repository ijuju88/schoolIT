<%@page import="roti.lms.student.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentBean student = (StudentBean)request.getAttribute("studentdata");
	StudentBean register = (StudentBean)request.getAttribute("registerdata");
	StudentBean attendance = (StudentBean)request.getAttribute("attendancedata");
	List att_list = (List)request.getAttribute("at_list");
	int listcount = ((Integer)request.getAttribute("at_listcount")).intValue();
	
%>

<!DOCTYPE html>
<html>
<head>

<title>출결 체크</title>
<style type="text/css">

.tbl_type,.tbl_type th,.tbl_type td{border:0}
.tbl_type{width:600px;height:150px;border-bottom:1px solid #dcdcdc;font-family:Tahoma;font-size:11px;text-align:center}
.tbl_type th{padding:7px 0 4px;border-top:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
.tbl_type td{padding:6px 0 4px;border-top:1px solid #e5e5e5;color:#4c4c4c}
#cap{font-family:'돋움',dotum;font-size:17px;font-weight:bold;}
#outline{width:1000px;margin:0 auto;}
#top{padding:50px 0px 50px 900px;}
#midright {float:right; height:200px; width:280px;padding: 100px 10px 100px 100px;background-image: url(image/check/check_bg.png); background-repeat: no-repeat; background-position: right;}
#loginarea{float:left; width:200px;height:200px;background-color:skyblue;}
#menuarea{width:200px;height:300px;float:left;background-color:orange;}
#center{float:left;}
</style>
<title>학생 페이지</title>
<body>
<div id="gohome">
<a href="index.jsp"><img border="none" src="image/home_button.png"></a>
</div>
	<table>
		<tr>
			<td>
				<div class="student_info">
					<table class="tbl_type" border="1">
						<tbody>
							<tr>
								<td colspan="2" rowspan="1">
									<p style="text-align: center;" id="cap">학 생 정 보</p>
								</td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">이름</p>
								</td>
								<td><%=student.getSt_name()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">생년월일</p>
								</td>
								<td><%=student.getBirth()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">주소</p>
								</td>
								<td><%=student.getAddr()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">연락처</p>
								</td>
								<td><%=student.getSt_hp()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">비상연락처</p>
								</td>
								<td><%=student.getSt_ehp()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">성별</p>
								</td>
								<td><%=student.getGender()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">등록일</p>
								</td>
								<td><%=student.getRdate()%></td>
							</tr>
						</tbody>
					</table>
					<a href="<%=request.getContextPath()%>/StudentModifyView.fo"> 
					<input name="update" type="submit" value="정보수정" /></a>
					
					<a href="<%=request.getContextPath()%>/stu_logout.jsp"> 
					<input type="submit" value="로그아웃" />
					</a>
				</div>
			</td>
			
			<td>
				<div class="register_info">
					<table class="tbl_type" border="1">
						<tbody>
							<tr>
								<td colspan="2" rowspan="1">
									<p style="text-align: center;" id="cap">수 강 정 보</p>
								</td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">과목명</p>
								</td>
								<td><%=register.getSub_name()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">시작일</p>
								</td>
								<td><%=register.getRg_start()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">종료일</p>
								</td>
								<td><%=register.getRg_end()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">강의실</p>
								</td>
								<td><%=register.getClassroom()%></td>
							</tr>
							<tr>
								<td>
									<p style="text-align: center;">수강비</p>
								</td>
								<td><%=register.getCharge()%></td>
							</tr>
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>

	<div class="attendance_info">
		<table summary="수강관리 과정리스트" class="tbl_type" border="1">
			<caption id="cap">출 결 사 항</caption>
			<colgroup>
				<col width="20%">
				<col>
				<col>
				<col>
				<col>
			</colgroup>
			<thead>
				<tr>
					<th scope="col">이름</th>
					<th scope="col">과목명</th>
					<th scope="col">날짜</th>
					<th scope="col">입실시간</th>
					<th scope="col">퇴실시간</th>
					<th scope="col">출결상태</th>
				</tr>
			</thead>
			<tbody>
			<!-- 사용자 아이디에 따른 출결 테이블의 항목수만큼 반복하여 테이블에 반복출력한다. -->
				<%
					for (int i = 0; i < listcount; i++) {
						StudentBean bl = (StudentBean) att_list.get(i);
				%>
				<tr>
					<td><%=student.getSt_name()%></td>
					<td><%=register.getSub_name()%></td>
					<td><%=bl.getAt_date()%></td>
					<td><%=bl.getCheckin()%></td>
					<td><%=bl.getCheckout()%></td>
					<td><%=bl.getAt_stmt()%></td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>