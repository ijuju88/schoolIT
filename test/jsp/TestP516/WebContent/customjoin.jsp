<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="Join/script/Join.js" ></script>
<style type="text/css">
td {
	border: 1px solid black;
	width: 200px;
	text-align: left;
}
</style>
</head>
<body>
	<form action="custom.do" method="post" name="frm">
		<table align="center" width="550">
			<tr>
				<td colspan="2" align="left" bgcolor="#cfcfcf">사원등록 (*는 꼭
					입력해주세요)</td>
			</tr>
			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">아이디*</td>
				<td><input type="text" name="id"> <input type="hidden"
					name="reid" size="20"> <input type="button" value="중복 체크"
					onclick="idCheck()"></td>
			</tr>
			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">비밀번호*</td>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">비밀번호확인*</td>
				<td><input type="password" name="pwd_check"></td>
			</tr>


			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">이름*</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">성별*</td>
				<td><select name="gender">
						<option value="1">남자</option>
						<option value="2">여자</option>
				</select></td>
			</tr>
			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">전화번호</td>
				<td colspan="3"><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td align="left" style="width: 100px" bgcolor="#cfcfcf">주소</td>
				<td align="left" valign="middle"><input type="text"
					id="postcode" style="width: 80px" disabled="disabled"> <input
					type="button" onclick="DaumPostcode()" value="우편번호 찾기"> <label>
						<input name="Address" type="text" id="Address" size="50"
						maxlength="20" />
				</label></td>
			</tr>

			<tr>
				<td align="left" width="140" bgcolor="#cfcfcf">권한</td>
				<td><select name="lev">
						<option value="A">운영자</option>
						<option value="B">일반회원</option>
				</select></td>
			</tr>


			<tr align="left">
				<td colspan="2"><input type="submit" onclick="return  joinCheck()" value="확인">
				<input type="reset" value="취소">
					<input type="button" value="메인 페이지로 이동"
					onclick="location.href='main.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>