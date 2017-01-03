<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Ajax메소드 -load() 응답처리</title>
<style type="text/css">
 #result{ width : 200px; height : 200px; border : 5px double #6699FF; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
 $(document).ready(function(){
 //[결과]버튼을 클릭하면 xhrTest3.txt가 <div id="result">엘리먼트에 로드
 $("#b2").click(function(){
 $("#result").load("xhrTest3.txt", function(response,stu,xhr){
 if(stu=="success")//서버요청이 성공시
 alert("로드 성공!"); //메시지상자 표시
 if(stu=="error")//서버요청 실패시
 alert("에러: "+xhr.status+": "+xhr.stu);
 });
 });
 });
</script>
</head>
<body>
 <button id="b2">결과</button>
 <div id="result"></div>
</body>
</html>