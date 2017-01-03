<%@page import="clientmember.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link href="style.css" rel="stylesheet" type="text/css"></link>
	<script language="javascript">
	
		function begin(){
			document.myform.id.focus();
		}
		
		function checkIt(){
			if(document.myform.id.value=="" || document.myform.passwd.value==""){
				alert("아이디와 패스워드를 입력해주세요.");
				document.myform.id.focus();
				return false;
			}
		}

	</script>
	<%
	String id = (String) session.getAttribute("memId");
	LogonDB manager = LogonDB.getInstance();
	LogonDataBean c = manager.getMember(id);
	%>
	</head>
	<body onLoad="begin()">
		<form name="myform" action="../clientmember/deletePro.jsp" method="post" onSubmit="return checkIt()">
			<table cellspacing="0"cellpadding="3" width="260" border="1" align="center">
				<tr>
					<td colspan="2" align="middle">
						회원탈퇴를 위해 다시 한 번 아이디와 비밀번호를 입력해주세요.
					</td>
				</tr>	
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id" size="15" maxlength="15" value="<%=c.getId()%>" disabled="disabled"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" id="passwd" size="15" maxlength="15"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" name="btn_quit" value="회원탈퇴" class="f2"></td>
				</tr>
			</table>
		</form>
	</body>
</html>