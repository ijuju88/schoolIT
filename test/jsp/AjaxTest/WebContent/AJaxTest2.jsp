<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div#displayArea{
width:200px; height:200px; border:5px double #6699ff;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("button").click(function(){
$("#displayArea").html("<img src='images/googlelogo.png' border='0' height='30%' width='100%'>")
});
});
</script>
</head>
<body>
<div id="displayArea">이곳의 내용이 변경</div>
<button>표시</button>
</body> </html>