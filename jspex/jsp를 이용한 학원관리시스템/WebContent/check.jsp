<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>출결 체크</title>
<style type="text/css">

.tbl_type,.tbl_type th,.tbl_type td{border:0}
.tbl_type{width:600px;border-bottom:1px solid #dcdcdc;font-family:Tahoma;font-size:11px;text-align:center}
.tbl_type th{padding:7px 0 4px;border-top:1px solid #dcdcdc;background-color:#f5f7f9;color:#666;font-family:'돋움',dotum;font-size:12px;font-weight:bold}
.tbl_type td{padding:6px 0 4px;border-top:1px solid #e5e5e5;color:#4c4c4c}

#cap{font-family:'돋움',dotum;font-size:17px;font-weight:bold;}
#outline{width:1000px;margin:0 auto;}
#top{padding:50px 0px 50px 900px;}
#midright {float:right; height:200px; width:280px;padding: 100px 10px 100px 100px;background-image: url(image/check/check_bg.png); background-repeat: no-repeat; background-position: right;}
#loginarea{float:left; width:200px;height:200px;background-color:skyblue;}
#menuarea{width:200px;height:300px;float:left;background-color:orange;}
#center{float:left;}

</style>
</head>
<body>
 <div id="outline">
  <div id="top">
  <a href="index.jsp"><img border="none" src="image/home_button.png"></a>
  </div>
  <div id="midleft">
  
  </div>
  <div id="midright">
  <form action="" method="post">
  <img src="image/login/login_id.gif">
  <input type="text" name="stu_id">
  <img src="image/login/login_pw.gif">
  <input type="password" name="stu_pass">
  <p></p>
  <br>
  <input name="in" type="image" src="image/check/in.png">
  <input name="out" type="image" src="image/check/out.png">
  </form>
  </div>
  <div id="midleft">
  <table summary="수강관리 과정리스트" class="tbl_type" border="1" cellspacing="0">
<caption id="cap">출 결 사 항<p></caption>
<colgroup>
<col width="20%"><col><col><col><col>
</colgroup>
<thead>
<tr>
<th scope="col">이름</th>
<th scope="col">과정이름</th>
<th scope="col">출결시간</th>
</tr>
</thead>
<tbody>
<tr>
<td>김민준</td>
<td>자바전문가 과정</td>
<td>입실(08:45) 퇴실(18:05)</td>
</tr>
<tr>
<td>김민래</td>
<td>안드로이드 개발자 과정</td>
<td>입실(09:45)</td>
</tr>
<tr>
<td>조홍연</td>
<td>LG 우승하기 프로젝트</td>
<td>퇴실(19:45)</td>
</tr>
</tbody>
</table>
  </div>
 </div>


</body>
</html>