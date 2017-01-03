<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!DOCTYPE>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<script src="http://code.jquery.com/jquery-migrate-1.1.0.min.js"></script>

<script>
function push(){
	window.location.href='./index.jsp';	
}
	

 $(document).ready(function(){
	 var url = './TestAjax';  //서블릿 위치
	
  //폼아이디가 my 의 submit 이벤트 받음
	  
$('#wrap').load(url,$(this).serialize()); 
$('#my').submit(function(event){


	     //jquery의 serialize 함수 이용하여 폼데이터들을 직렬화로 전송시키고 응답 받음
	   $.post('./TestAjax', $('form').serialize(), function(r){});
	   event.preventDefault();  //기본 폼의 submit이 발생되지 않게 막기
	   location.reload()


	  });

	  });
 
/*   $('#my').submit(function(event){


   $('#wrap').load(url,$(this).serialize());   //jquery의 serialize 함수 이용하여 폼데이터들을 직렬화로 전송시키고 응답 받음

   

   event.preventDefault();  //기본 폼의 submit이 발생되지 않게 막기

  });

 }); */

</script>

</head>

<body>


<div id='wrap'>

</div>
<form id='my'>

 아이디 : <input type='text' id='name' name='st_id' required />
비밀번호 : <input type='password' name='st_pass'  required/>
 <input type='submit' value='입실' />
  <input type='submit' value='퇴실' />
  <input type='button' value='홈' onClick="push()" />

</form>

</body>

</html>

