<%@ page contentType="text/html;charset=UTF-8"  session="true" pageEncoding="utf-8" %>
<HTML>
<HEAD>
<style text="Text/css">
body {
 margin-left: 0px;
 margin-top: 0px;
 margin-right: 0px;
 margin-bottom: 0px;
 overflow-y: hidden;
 overflow-x: hidden;
}
</style>
<TITLE>로그인 화면</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</HEAD>
<script language="javascript">
	top.submenu2.location.reload();
	top.bottommenu.location.reload();
	top.sidemenu.location.reload();
</script>
<%

if(!(session.isNew())){
		if(session.getAttribute("login.id") != null)
		response.sendRedirect("logining.jsp");
}
%>
<script language="javascript">
function regist(){
	

	top.bottommenu.location.href="inregist.jsp";
}
function income(){

	$ = document.getElementById;
	if($("id").value == ""){ 
			alert("아이디를 입력해주세요!");
			$("id").focus();
			return false;
	}
	else if($("id").value != ""){
			if(1){
				for(i=0;i<document.login.id.value.length ;i++ )
					{
					 ch=document.login.id.value.charAt(i)
					  if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
					  {
					  alert ("아이디는 소문자, 숫자만 입력가능합니다.")
					  document.login.id.focus();
					  return false;
					  }
					}
			}
			if(document.login.id.value.length <= 3 ){
				alert ("아이디는 4~12문자를 입력해야합니다.")
					  document.Regist.id.focus();
					  return false;
			}
	}
	if($("password").value == ""){ 
			alert("패스워드를 입력해주세요!");
			$("pasword").focus();
			return false;
	}
	else if(1){
			if(1){
				for(i=0;i<document.login.password.value.length ;i++ )
					{
					 ch=document.login.password.value.charAt(i)
					  if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
					  {
					  alert ("비밀번호 소문자, 숫자만 입력가능합니다.")
					  document.Regist.password.focus();
					  return false;
					  }
					}
			}
			if(document.login.password.value.length <= 3 ){
				alert ("비밀번호는 4~12문자를 입력해야합니다.")
					  document.Regist.password.focus();
					  return false;
			}
			
	}

				document.login.submit();
		
}

</script>
<BODY>
<table width="165" height="110" border="0">
  <tr>
    <td width="164" height="110" bgcolor="#FFD9EC"><form name="login" method="post" action="gologin.jsp">
        <p align="left">&nbsp;&nbsp;ID : &nbsp;
          <input name="id" id="id" type="text" id="password" size="10" maxlength="12" />
		  <br />
		  &nbsp;&nbsp;비밀번호 : 
		  <input name="password" id="password" type="password" size="10" maxlength="12">
		</p>
        <p align="center"> 
          <input name="login" type="button" id="login" value="로그인" onclick="income()">
          &nbsp;
          <input name="joinin" type="button" id="joinin" onclick="regist()" value="회원가입">
</p>
    </form></td>
  </tr>
</table>
</BODY>
</HTML>
