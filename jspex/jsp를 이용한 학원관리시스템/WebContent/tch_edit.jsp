<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title> 강사 편집 </title>
</head>
<body>

<form method="post" action="./tch_ModifyAction.do">
<table border="1">
<tr> <td align="center"> 수정할 아이디</td>
<td><input type="text" name="tch_no" size="10" maxlength="14">
</td> </tr>
<tr> <td align="center"> 비밀번호 </td>
<td><input type="password" name="tch_pass" size="16" maxlength="16"> </td> </tr>
<tr> <td align="center"> 이름 </td>
<td><input type="text" name="tch_name" size="16" maxlength="16"> </td> </tr>
<tr> <td align="center"> 학력 </td> 
<td> <input type="text" name="acab" size="20" maxlength="6"> </td> </tr>
<tr> <td align="center"> 담당과목 </td>
<td> <input type="text" name="resp_sub" size="20" maxlength="20">
</td> </tr>
<tr> <td align="center"> 연락처</td>
<td> <input type="text" name="tch_hp" size="20" maxlength="20">
</td> </tr>
</table> <p>
<input type="submit" value="수정완료" >
<input type="reset" value="다시쓰기" >
</form>



<form action="./tch_DeleteAction.do" method="post">
<table>
<tr> <td align="center"> 삭제할 아이디</td>
<td><input type="text" name="tch_no" size="15" maxlength="14">
<input type="button" name="idcheck" value="삭제 ID유무확인"> &nbsp;
</td> </tr>
</table>
<input type="submit" value="삭제하기" >
</form>
</body>
</html>


