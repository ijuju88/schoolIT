<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#b1").click(function(){
$("#b2").text($("p").text());
});
$("#b2").click(function(){
$("#display").html("<img src='images/googlelogo.png' border='0'/>");
});
});
</script>
</head>
<body>
<p>이미지 표시</p>
<button id="b1">버튼 레이블 변경</button>
<div id="display"></div>
<button id="b2">버튼</button>
</body>
</html>