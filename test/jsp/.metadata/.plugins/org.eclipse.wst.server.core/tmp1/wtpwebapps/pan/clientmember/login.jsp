<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>메인입니다..</title>
</head>
<%
	try {
		if (session.getAttribute("memId") == null) {
%>
<script language="javascript">
	function focusIt() {
		document.inform.id.focus();
	}
	function checkIt() {
		inputForm = eval("document.inform");
		if (!inputForm.id.value) {
			alert("아이디를 입력하세요..");
			inputForm.id.focus();
			return false;
		}
		if (!inputForm.passwd.value) {
			alert("패스워드를 입력하세요..");
			inputForm.passwd.focus();
			return false;
		}
	}
</script>
</head>
<body onLoad="focusIt();" >
	<div class="login" id="login">
		<form name="inform" method="post"
			action="../clientmember/loginPro.jsp" onSubmit="return checkIt();">
			<table cellpadding="0" cellspacing="0" align="center" border="0">
				<tr>
					<td width="100" align="right" style="color: white;" class="formLabel">아이디</td>
					<td width="100"><input type="text" name="id" size="15" maxlength="10" class="form-style"></td>
				</tr>
				<tr>
					<td width="100" align="right" style="color: white;" class="formLabel">패스워드</td>
					<td width="100"><input type="password" name="passwd" size="15" maxlength="10" class="form-style"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						name="Submit" value="로그인" class="f2"> <input
						type="button" value="회원가입"
						onclick="location.href='../clientmember/MemberJoin.jsp';" class="f2"></td>
				</tr>
			</table>
		</form>
		</div>
		<%
			} else {
		%>
			<div class="login" id="login">
		<form method="post" action="../clientmember/logout.jsp" style="background: rgba(0,0, 0, 0.4);">
			
			<table  align="center" >
			<tr><td width="300" align="center"> 
			<font color="#ffffff" style="font-size: 20px"><%=session.getAttribute("memId")%>님이 방문하셨습니다</font></td>
			</tr>
				<tr>
					<td width="300" align="left" > 
					<input type="submit" value="로그아웃"> 
					<input type="button" value="회원정보변경" onclick="location.href='../clientmember/modifyForm.jsp';"> 
					<input type="button" value="회원탈퇴" onclick="javascript:$('#content').load('../clientmember/deleteForm.jsp');"></td>

				</tr>
			</table>
		</form>
	</div>
	<%
		}
		} catch (NullPointerException e) {
		}
	%>
</body>
</html>