<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Ajax메소드 -load()</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
 $(document).ready(function(){
 //[결과]버튼을 클릭하면 xhrTest1.jsp페이지가 실행된다.
 $("#b1").click(function(){
 $("#result").load("/AjaxTest/AJaxTestLoadResult.jsp");
 });
 });
</script>
</head>
<body>
 <button id="b1">결과</button>
 <div id="result"></div>
</body>
</html>