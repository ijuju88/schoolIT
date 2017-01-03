<!-- 학생 편집 페이지 -->
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
//id중복 확인 작업 시작 하도록 스크립트 활용
function idcheck(check_id){
	 var st_id = check_id.st_id.value;
	 if(st_id.length<1 || st_id==null){
	  alert("편집 할 아이디를 입력하십시오");
	  return false;
	 }
	 var url = "student/editCheck.jsp?st_id=" + st_id;
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
<title> 학생 편집 </title>
</head>
<body>

<form action="./StudentModifyAction.eo" method="post" >
<table border="1">
<tr> <td align="center"> 수정할 ID</td>
<td><input type="text" name="st_id" size="15" maxlength="14">
<!-- 수정할 ID를 DB정보와 비교 하여 있을 경우에 해당 ID에 해당 하는 데이터 수정 예정 -->
<input type="button" onclick="idcheck(this.form)" value="편집ID유무확인"> &nbsp;(한글7글자 / 영문14글자 이하)
</td> </tr>
<!-- 입력 비밀번호와 비밀번호 확인과 일치할 경우에만 등록 되도록 구현 예정 -->
<tr> <td align="center"> 비밀번호 </td>
<td><input id="pass_chk1" type="password" name="st_pass" size="17" maxlength="16"> </td> </tr>
<tr> <td align="center"> 비밀번호 확인 </td>
<td><input id="pass_chk2" type="password" name="st_pass_chk" size="17" maxlength="16" onblur="passchk()"> &nbsp;<input id="pass_res" type="text" style="border-width: 0px" size="30" name="chk" value="비밀번호를 입력하세요" readonly="readonly"></td> </tr>
<tr> <td align="center"> 이름 </td>
<td><input type="text" name="st_name" size="8" maxlength="20"> </td> </tr>
<tr> <td align="center"> 생일 </td> 
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
<input type="radio" name="gender" value="여자">여자 </td> </tr>

<tr> <td align="center"> 등록일 </td>
<td> <input type="date" name="rdate" id="meeting" maxlength="20">(예: 20xx-xx-xx) 
 </td> </tr>


</table> <p>
<input type="submit" value="수정완료" >
<input type="reset" value="다시쓰기" >
</form>
<br><br>====================================================================================================<br><br>
<form action="./StudentDeleteAction.eo" method="post" >
<table>
<tr> <td align="center"> 삭제할 ID</td>
<td><input type="text" name="st_id" size="15" maxlength="14">
<input type="button" onclick="idcheck(this.form)" value="편집 ID유무확인"> &nbsp;(한글7글자 / 영문14글자 이하)
</td> </tr>
</table>
<input type="submit" value="삭제하기" >
</form>
</body>
</html>


