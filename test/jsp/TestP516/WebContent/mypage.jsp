<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="Join/script/Join.js"></script>
</head>
<body>
	<form action="mypage.do" method="post" name="frm">
		<table align="center" width="60%">
			<tr>
				<td colspan="2" align="center">마이페이지</td>
			</tr>
			<tr>
				<td id="front" style="width: 20%">아이디</td>
				<td><input type="text" name="id" value="${loginUser.id}"
					readonly="readonly" style="width: 80%"></td>
			</tr>
			<tr>
				<td id="front">비밀번호</td>
				<td><input type="password" name="pwd" style="width: 80%"></td>
			</tr>
			<tr>
				<td id="front">이름</td>
				<td><input type="text" name="name" value="${loginUser.name}"
					style="width: 80%"></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><select name="gender" style="width: 80%">
						<c:choose>
							<c:when test="${loginUser.gender==1}">
								<option value="1" selected="selected">남자</option>
								<option value="2">여자</option>
							</c:when>
							<c:otherwise>
								<option value="1">남자</option>
								<option value="2" selected="selected">여자</option>
							</c:otherwise>
						</c:choose>
				</select></td>
			</tr>
			<tr>
				<td align="center">전화번호</td>
				<td colspan="3"><input type="text" name="phone"
					value="${loginUser.phone}" style="width: 80%"></td>
			</tr>
			<tr>
				<td align="center">주소</td>
				<td align="left" valign="middle"><input type="text"
					id="postcode" style="width: 80px" disabled="disabled"> <input
					type="button" onclick="DaumPostcode()" value="우편번호 찾기"> <label>
						<input name="Address" type="text" id="Address"
						value="${loginUser.address}" style="width: 80%" />
				</label></td>
			</tr>

			<tr>
				<td id="front">권한</td>
				<td><select name="lev" style="width: 80%">
						<c:choose>
							<c:when test="${result==2}">
								<option value="A" selected="selected">운영자</option>
								<option value="B">일반회원</option>
							</c:when>
							<c:otherwise>
								<option value="A">운영자</option>
								<option value="B" selected="selected">일반회원</option>
							</c:otherwise>
						</c:choose>
				</select></td>
			</tr>

			<tr align="center">
				<td colspan="2"><input type="submit"
					onclick="return joinCheck()" value="수정"> 
					<input type="reset" value="취소"></td>
			</tr>

		</table>
	</form>
</body>
</html>