<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="clientmember.LogonDB"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head><title>ID 중복 확인</title>
	<link href="style.css" rel="stylesheet" type="text/css"></link>
	</head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String id = request.getParameter("id");
		LogonDB manager = LogonDB.getInstance();
		int check = manager.confirmId(id);
	%>
	<body>
		<%
			if(check == 1){ %>
		<table width="270" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td height="39"><%=id%> 이미 사용중인 아이디입니다</td>
			</tr>
		</table>
		<form name="checkForm" method="post" action="confirmId.jsp">
		<table width="270" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td>
					다른 아이디를 선택하세요<p>
					<input type="text" size="15" maxlength="15" name="id" style="ime-mode:disabled;">
					<input type="submit" value="아이디 중복확인" class="f2">
				</td>
			</tr>
		</table>
		</form>
		<%}else{%>
		<table width="270" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td>
					<p>입력하신 <%=id%>는 사용하실 수 있는 ID입니당.</p>
					<input type="button" value="닫기" onclick="setid()" class="f2">
				</td>
			</tr>
		</table>
		<%}%>
	</body>
</html>
<script language="javascript">
	function setid(){
		opener.document.memberjoin.id.value="<%=id%>";
		opener.document.memberjoin.idCheck.value="yes";
		self.close();
	}

</script>