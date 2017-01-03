<%@page import="roti.lms.student.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Bean의 학생 정보를 호출.
	StudentBean student = (StudentBean) request.getAttribute("studentdata");
%>
<!DOCTYPE html>
<html>
<head>

<title>회원 정보 수정</title>
<style type="text/css">

.tbl_type,.tbl_type th,.tbl_type td{border:0}
.tbl_type{width:600px;border-bottom:1px solid #dcdcdc;font-family:Tahoma;font-size:11px;text-align:center}
.tbl_type th{padding:7px 0 4px;border-top:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
.tbl_type td{padding:6px 0 4px;border-top:1px solid #e5e5e5;color:#4c4c4c}

#cap{font-family:'돋움',dotum;font-size:17px;font-weight:bold;}

</style>
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentModifyAction.fo" method="post" name="modifyform">
	<div class="student_info">
		<table class="tbl_type" border="1">
			<tbody>
				<tr>
					<td colspan="2" rowspan="1">
						<p style="text-align: center;" id="cap">학생 정보</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">이름</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="st_name" type="text" value="<%= student.getSt_name() %>" style="text-align: center;" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">생년월일</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="birth" type="text" value="<%= student.getBirth() %>" style="text-align: center;" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">주소</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="addr" type="text" value="<%= student.getAddr() %>" style="text-align: center;" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">연락처</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="st_hp" type="text" value="<%= student.getSt_hp() %>" style="text-align: center;" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">비상연락처</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="st_ehp" type="text" value="<%= student.getSt_ehp() %>" style="text-align: center;" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">성별</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="gender" type="text" value="<%= student.getGender() %>" style="text-align: center;" />
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<p style="text-align: center;">등록일</p>
					</td>
					<td>
						<p style="text-align: center;">
							<input name="rdate" type="text" value="<%= student.getRdate() %>" readonly="readonly" style="text-align: center;" />
						</p>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
		<table cellspacing="0" cellpadding="0" border="1"
			style="width: 600px; height: 30px; font-size: 10pt; border: 0px solid rgb(0, 0, 0); border-collapse: collapse; background-color: rgb(255, 255, 255);">
			<tbody>
				<tr style="height: 29px;">
					<td
						style="width: 200px; height: 30px; border: 1px solid rgb(255, 255, 255);">
						<p style="text-align: center;">
							<input name="update" type="submit" value="수정" style="font-size: 10pt;" />
						</p>
					</td>
					<td
						style="width: 200px; height: 29px; border: 1px solid rgb(255, 255, 255);">
						<p style="text-align: center;">
							<input onClick="window.close()" name="update" type="submit" value="취소" />
						</p>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>