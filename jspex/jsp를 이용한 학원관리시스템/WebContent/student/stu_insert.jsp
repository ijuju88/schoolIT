<!-- 학생 등록 페이지 -->
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <% --%>
<!-- // 	request.setCharacterEncoding("utf-8"); -->
<%-- %> --%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
//id중복 확인 작업 시작 하도록 스크립트 활용
function idcheck(check_id){
	 var st_id = check_id.st_id.value;
	 if(st_id.length<1 || st_id==null){
	  alert("중복체크할 아이디를 입력하십시오");
	  return false;
	 }
	 var url = "student/inCheck.jsp?st_id=" + st_id;
	 window.open(url, "get", "height = 180, width = 300");
	}
</script>
<script>
//password 재확인을 통해 정확히 입력 되었는지 표시
function passchk(){
	 var st_pass=document.getElementById("pass_chk1").value;
	 var st_pass_chk=document.getElementById("pass_chk2").value;	
	 if (st_pass_chk.length == 0 || st_pass_chk == null) {
		 document.getElementById("pass_res").value = "확인 비밀번호를 입력하세요";
	 } else if (st_pass!=st_pass_chk) {
		 document.getElementById("pass_res").value = "비밀번호가 다릅니다.";
	 } else {   
		 document.getElementById("pass_res").value = "비밀번호가 동일합니다.";
	 }
	 return;
	}
</script>
<title> 학생 등록 </title>
</head>
<body>
<form action="./StudentAddAction.eo" method="post" >
<table border="1">
<tr> <td align="center"> ID</td>
<td><input type="text" name="st_id" size="15" maxlength="14">
<!-- 등록할 ID를 DB정보와 비교 하여 중복이 있을 경우 경고 표시 되도록 구현 예정 -->
<input type="button" onclick="idcheck(this.form)" value="ID유무확인 "> &nbsp;(한글7글자 / 영문14글자 이하)
</td> </tr>
<!-- 입력 비밀번호와 비밀번호 확인과 일치할 경우에만 등록 되도록 구현 예정 -->
<tr> <td align="center"> 비밀번호 </td>
<td><input id="pass_chk1" type="password" name="st_pass" size="17" maxlength="16"> </td> </tr>
<tr> <td align="center"> 비밀번호 확인 </td>
<td><input id="pass_chk2" type="password" name="st_pass_chk" size="17" maxlength="16" onblur="passchk()">&nbsp; <input id="pass_res" type="text" style="border-width: 0px" size="30" name="chk" value="비밀번호를 입력하세요" readonly="readonly"> </td> </tr>
<tr> <td align="center"> 이름 </td>
<td><input type="text" name="st_name" size="8" maxlength="20"> </td> </tr>
<tr> <td align="center"> 생년월일 </td> 
<td> <input type="number" name="birth" size="6" maxlength="6">(주민번호 앞 6자리) </td> </tr>
<!-- 읍,면,동으로 주소 검색 할 수 있도록 구현 예정 -->
<tr> <td align="center"> 주소 </td>
<td> <input type="text" name="addr" size="30" maxlength="100">
</td> </tr>
<tr> <td align="center"> 연락처</td>
<td> <input type="text" name="st_hp" size="22" maxlength="20">(예:-포함 작성 010-****-****)
</td> </tr>
<tr> <td align="center"> 연락처</td>
<td> <input type="text" name="st_ehp" size="22" maxlength="20">(예:-포함 작성 010-****-**** / 02-****-****)
</td> </tr>
<tr> <td align="center"> 성별 </td>
<td> <input type="radio" name="gender" value="남자" checked> 남자
<input type="radio" name="GENDER" value="여자">여자 </td> </tr>

<tr> <td align="center"> 등록일 </td>
<td> <input type="date" name="rdate" id="meeting" maxlength="20">(예: 20xx-xx-xx) 
 </td> 
<td>
<a href="javascript:addstudent()">[등록]</a>&nbsp;&nbsp; 

 </td>
 </tr>


</table> <p>
<!-- 1.등록 버튼을 선택 하였을경우 입력 값이 모두 정상 입력 되었을 경우 DB로 데이터 전송 되도록 구현 예정 -->
<!-- 2.등록 버튼을 선택 하였을경우 입력 값중 형식에 맞지 않거나 미입력 등의 오류가 있을 경우 DB로 전송되지 않고 재입력 하도록 구현 예정 -->
<input type="submit" value="등록" >
<input type="reset" value="다시 쓰기" >
</form>

</body>
</html>