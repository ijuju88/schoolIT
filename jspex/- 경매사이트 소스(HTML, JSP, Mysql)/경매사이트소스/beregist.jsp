<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8"%>
<!-- 12101574 이찬희 입력받아서 alert 창으로 띄우는 웹페이지-->
<HTML>
<HEAD>
<style type="Text/css">
table{font-size:12px;}
</style>
<TITLE>회원가입</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script language="javascript">
	
function jumincheck(code){
	
			  for(i=0;i<document.Regist.jumin1.value.length ;i++ )
				{
				 code=document.Regist.jumin1.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.jumin1.value = "";
					  return false;
					  }
			   }
			   for(i=0;i<document.Regist.jumin2.value.length ;i++ )
				{
				 code=document.Regist.jumin2.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.jumin2.value = "";
					  return false;
					  }
			   }
			   for(i=0;i<document.Regist.cell1.value.length ;i++ )
				{
				 code=document.Regist.cell1.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.cell1.value = "";
					  return false;
					  }
			   }
			   for(i=0;i<document.Regist.cell2.value.length ;i++ )
				{
				 code=document.Regist.cell2.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.cell2.value = "";
					  return false;
					  }
			   }
			   for(i=0;i<document.Regist.cell3.value.length ;i++ )
				{
				 code=document.Regist.cell1.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.cell3.value = "";
					  return false;
					  }
			   }
			   for(i=0;i<document.Regist.phone1.value.length ;i++ )
				{
				 code=document.Regist.phone1.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.phone1.value = "";
					  return false;
					  }
			   }
			    for(i=0;i<document.Regist.phone2.value.length ;i++ )
				{
				 code=document.Regist.phone2.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.phone2.value = "";
					  return false;
					  }
			   }
			    for(i=0;i<document.Regist.phone3.value.length ;i++ )
				{
				 code=document.Regist.phone3.value.charAt(i);
					if (!(code>='0' && code<='9'))
					  {
					  var t = "";
					 
					  alert ("숫자만 입력가능합니다.");
					  document.Regist.phone3.value = "";
					  return false;
					  }
			   }
					
}
function check(){

	$ = document.getElementById;
	if($("id").value == ""){ 
			alert("아이디를 입력해주세요!");
			$("id").focus();
			return false;
	}
	else if($("id").value != ""){
			if(1){
				for(i=0;i<document.Regist.id.value.length ;i++ )
					{
					 ch=document.Regist.id.value.charAt(i)
					  if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
					  {
					  alert ("아이디는 소문자, 숫자만 입력가능합니다.")
					  document.Regist.id.focus();
					  return false;
					  }
					}
			}
			if(document.Regist.id.value.length <= 3 ){
				alert ("아이디는 4~12문자를 입력해야합니다.")
					  document.Regist.id.focus();
					  return false;
			}
	}
	
	if($("password").value == "") {
			alert("암호를 입력해주세요!");
			$("password").focus();
				return false;
	}
	else if(1){
			if(1){
				for(i=0;i<document.Regist.password.value.length ;i++ )
					{
					 ch=document.Regist.password.value.charAt(i)
					  if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
					  {
					  alert ("비밀번호 소문자, 숫자만 입력가능합니다.")
					  document.Regist.password.focus();
					  return false;
					  }
					}
			}
			if(document.Regist.password.value.length <= 3 ){
				alert ("비밀번호는 4~12문자를 입력해야합니다.")
					  document.Regist.password.focus();
					  return false;
			}
	}
	if($("password2").value == "") {
			alert("암호를 입력해주세요!");
			$("password2").focus();
				return false;
	}
	else if(1){
			if(1){
				for(i=0;i<document.Regist.password2.value.length ;i++ )
					{
					 ch=document.Regist.password2.value.charAt(i)
					  if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
					  {
					  alert ("비밀번호 소문자, 숫자만 입력가능합니다.")
					  document.Regist.password2.focus();
					  return false;
					  }
					}
			}
			if(document.Regist.password2.value.length <= 3 ){
				alert ("비밀번호는 4~12문자를 입력해야합니다.")
					  document.Regist.password2.focus();
					  return false;
			}
		    if(document.Regist.password2.value != document.Regist.password.value) {
			alert("암호가 서로 다릅니다 다시 입력하세요!");
			
			document.Regist.password2.focus();
			return false;
			}
	}
	
	
    
	
	if($("name").value == ""){
			alert("이름을 입력해주세요!");
			$("name").focus();
			return false;
	}
	if(!($("jumin1").value.length==6)){
			alert("주민번호를 입력해주세요!");
			$("jumin1").focus();
			return false;
		
	}

	if(!($("jumin2").value.length==7)){
			alert("주민번호를 입력해주세요!");
			$("jumin2").focus();
			return false;
	}

	if(1){
				str1=document.Regist.jumin1.value
				str2=document.Regist.jumin2.value
				str=str1+str2
				var sum = 0
				sum+=parseInt(str.charAt(0))*2
				sum+=parseInt(str.charAt(1))*3
				sum+=parseInt(str.charAt(2))*4
				sum+=parseInt(str.charAt(3))*5
				sum+=parseInt(str.charAt(4))*6
				sum+=parseInt(str.charAt(5))*7
				sum+=parseInt(str.charAt(6))*8
				sum+=+parseInt(str.charAt(7))*9
				sum+=parseInt(str.charAt(8))*2
				sum+=parseInt(str.charAt(9))*3
				sum+=parseInt(str.charAt(10))*4
				sum+=parseInt(str.charAt(11))*5

				z=(sum%11)
				z=11-z

				if (z==10) {z=0}
				if (z==11) {z=1}

				if (z!=parseInt(str.charAt(12))) 
				{
				 alert ("틀린 주민등록번호입니다.")
				 return
				}

	
	}
	/*if(document.Regist.sex.checked=false){
			alert("성별을 입력해주세요!");
			$("sex").focus();
			return false;
	}*/
	if($("zipcode1").value == ""){
			alert("주소를 입력해주세요!");
			$("zipcode").focus();
			return false;
	}
	if($("zipcode2").value == ""){
			alert("주소를 입력해주세요!");
			$("zipcode2").focus();
			return false;
	}
	if($("add1").value == ""){
			alert("주소를 입력해주세요!");
			$("add1").focus();
			return false;
	}
	if($("add2").value == ""){
			alert("주소를 입력해주세요!");
			$("add2").focus();
			return false;
	}
	if($("email1").value == ""){
			alert("이메일을 입력해주세요!");
			$("email1").focus();
			return false;
	}
	if($("email2").value == ""){
			alert("이메일을 입력해주세요!");
			$("email2").focus();
			return false;
	}
	if($("cell1").value == ""){
			alert("핸드폰 번호를 입력해주세요!");
			$("cell1").focus();
			return false;
	}
	if($("cell2").value == ""){
			alert("핸드폰 번호를 입력해주세요!");
			$("cell2").focus();
			return false;
	}
	if($("cell3").value == ""){
			alert("핸드폰 번호를 입력해주세요!");
			$("cell3").focus();
			return false;
	}
	if($("bank").value == ""){
			alert("은행을 입력해주세요!");
			$("bank").focus();
			return false;
	}
	if($("account").value == ""){
			alert("계좌번호를 입력해주세요!");
			$("account").focus();
			return false;
	}
	if($("account_name").value == ""){
			alert("계좌번호 이름을 입력해주세요!");
			$("account_name").focus();
			return false;
	}
	else{
	document.Regist.submit();
	}
}
</script>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
//-->
</script>
</HEAD>

<BODY onLoad="Load()">
<table width="902" height="236" border="0" align="center">
  <tr>
    <td align="left" widt="950" height="184" >
	<iframe name="submenu" width="950" frameborder="0" style="overflow:hidden border:0 solid #FFFFFF padding:0px margin:0px" height="184" border="0" src="submain.jsp">아이프레임 지원안해요 ㅠ
	</iframe>
	
	</td>
  </tr>
  <tr>
    <td align="center" bgcolor="#FFCCFF">   <img src="image/regist.jpg" width="250" height="45" /></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#FFE8FF"><p>
      <div id="login" style="position:absolute; width:210px; height:150px; z-index:1; left: 138px; top: 255px;">
	  <iframe name="login" width="210px" height="150px" border=0 frameborder="0" style="overflow:hidden" height="138"  src="login.jsp">
	  아이프레임 지원안해요 ㅠ
	</iframe>
	  </div>
      <table align="center">
	<tr >
		 
		<td colspan=3>
		<form name="Regist" method="post" action="./regist.jsp"   > <!--post 방식으로 전달한다-->
		
			<table border="1" width="600" align="center" >  <!--테이블 작성-->
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>아이디<font color="red"> *</font></font></td>  <!--아이디 칸-->
						<td colspan="3"><input type="text" id="id" name="id" size="15" maxlength="12">
						<font size="1">(최소 4자리~최대 12자리 영소문자, 숫자만 가능)</font>
						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>암호<font color="red"> *</font></font></td> <!--암호칸-->
						<td ><input type="password" name="password" id="password" size="12"  maxlength="12">
						</td>
						<td width=100 align="center"  bgcolor="#E0E0E0"><font size=2>암호 확인<font color="red"> *</font></font></td> <!--암호칸-->
						<td width=200 ><input type="password" name="password2" id="password2" size="12"  maxlength="12">
						</td>
				</tr>
				<tr>
						<td align="center"  bgcolor="#E0E0E0"><font size=2>이름<font color="red"> *</font></font></td> <!--암호칸-->
						<td  colspan="3"><input type="text" name="name" id="name" size="12"  maxlength="12">
						
						</td>
				</tr>
				<tr>
						<td align="center"  bgcolor="#E0E0E0"><font size=2>주민등록번호<font color="red"> *</font></font></td> <!--암호칸-->
						<td colspan="3"><input type="text" onkeydown="jumincheck(event.keyCode)" name="jumin1" id="jumin1" size="6"  maxlength="6"> - 
						<input type="paaword" name="jumin2" onkeydown="jumincheck(event.keyCode)" id="jumin2" size="7"  maxlength="7"> 
						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>성별<font color="red"> *</font></font></td> <!--성별 칸-->
						<td colspan="3"><input type="radio" name="sex" id="sex" value="남자"><font size=2>남자</font>
						<input type="radio" name="sex" id="sex"  value="여자"><font size=2>여자</font>
						</td>
				</tr>
				<tr>
						<td rowspan="2" align="center" bgcolor="#E0E0E0"><font size=2>주소<font color="red"> *</font></font></td> <!--성별 칸-->
						<td colspan="3"><input type="text" name="zipcode1" id="zipcode1" size="3" maxlength="3"> -
						<input type="Text" name="zipcode2" id="zipcode2" size="3" maxlength="3"> 
						<input type="button" value="우편번호 검색">
						</td>
				</tr>
				<tr>
					     <!--성별 칸-->
					    <td colspan="3">
						주소 : <input type="text" name="add1" id="add1" size="30" maxlength="30"> <br>
						상세주소 : <input type="Text" name="add2" id="add2" size="35" maxlength="35"> 
						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>전화번호<font color="red"> *</font></font></td> <!--성별 칸-->
						<td colspan="3"> 
						집 번호 : <input type="text" onkeydown="jumincheck(event.keyCode)"  name="phone1" id="phone1" size="3" maxlength="3"> -
						<input type="Text" name="phone2"  onkeydown="jumincheck(event.keyCode)" id="phone2" size="4" maxlength="4"> -
						<input type="Text" name="phone3"  onkeydown="jumincheck(event.keyCode)" id="phone3" size="4" maxlength="4"> <br />
						 핸드폰 번호 : <input type="cell1"  onkeydown="jumincheck(event.keyCode)" name="cell1" id="zipcode1" size="3" maxlength="3"> -
						<input type="Text"  onkeydown="jumincheck(event.keyCode)" name="cell2" id="cell2" size="4" maxlength="4"> -
						<input type="Text"  onkeydown="jumincheck(event.keyCode)" name="cell3" id="cell3" size="4" maxlength="4"> 
						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>이메일<font color="red"> *</font></font></td> <!--성별 칸-->
						<td colspan="3"> 
						 <input type="text" name="email1" id="email1" size="12" maxlength="12"> @
						<input type="Text" name="email2" id="email2" size="30" maxlength="20"> 
					
						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>관심사</font></td> <!--관심사 칸-->
						<td colspan="3"><input type="checkbox" name="habit" id="habit"  value="요리"><font size=2>요리</font>
						<input type="checkbox" name="habit" id="habit" value="스포츠"><font size=2>스포츠</font>
						<input type="checkbox" name="habit" id="habit" value="게임"><font size=2>게임</font>
						<input type="checkbox" name="habit" id="habit" value="독서"><font size=2>독서</font><br />
						<input type="checkbox" name="habit" id="habit" value="음악감상"><font size=2>음악감상</font>
						<input type="checkbox" name="habit" id="habit" value="공부"><font size=2>공부</font>
						<input type="checkbox" name="habit" id="habit" value="잠"><font size=2>잠</font>
	

						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2><p>자기소개</p></font></td> <!--자기소개 칸-->
						<td colspan="3">
							<textarea id="intro" name="intro" cols=45 rows=10 ></textarea>
						</td>
				</tr>
				<tr>
						<td align="center" bgcolor="#E0E0E0"><font size=2>계좌번호<font color="red"> *</font></font></td> <!--성별 칸-->
						<td colspan="3">
						<select  name="bank" id="bank">
						    <option value="국민은행">국민은행</option>
							<option value="하나은행">하나은행</option>
							<option value="우리은행">우리은행</option>
							<option value="농협">농협</option>
							<option value="기업은행">기업은행</option>
							<option value="SC제일은행">SC제일은행</option>
							<option value="외환은행">외환은행</option>
							<option value="신협">신협</option>
							<option value="없음">없음</option>
							
						</select> 
						계좌이름 : <input type="text" id="account_name" name="account_name" size="4" maxlength="4"> <br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;계좌번호 : 
							
							<input type="text" id="account" name="acount" size="30" maxlength="30">
						</td>
				</tr>
				<tr>
						<td colspan="4" align="center">
							<input type="button" value="회원가입" onclick="return check(this)" > <!--전송버튼-->
							<input type="Reset" value="취소">
						</td>
				</tr>
			

			</table>
		</form>
		</td>
		
	</tr>
</table>
</form>
	
	
	</p>
    </td>
  </tr>
</table>
<!--html 태그 부분-->


</BODY>
</HTML>
