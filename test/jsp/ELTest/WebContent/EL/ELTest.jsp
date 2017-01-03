<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL언어사용하기</title>
</head>
<body>
	정수 ${10}
	<br> 실수 ${10.1}
	<br> 문자 ${"홍길동"}
	<br>

	<h2>연산자</h2>

	\${5+2} : ${5+2}
	<br> \${5/2} : ${5/2}
	<%-- <br> \${5 div 2} : ${5 div 2} --%>
	<br> \${5 mod 2} : ${5 mod 2}
	<br> \${5 > 2} : ${5 > 2}
	<br> \${2 gt 10} : ${2 gt 10}
	<br> \${(5 > 2) ? 5 : 2} : ${(5 > 2) ? 5 : 2}
	<br> \${(5 > 2) || (2 < 10)} : ${(5 > 2) || (2 < 10)}
	<br>

	<p>
	<h2>조건식</h2>
	</p>
	<h4>if문</h4>
	<%
		String input = null;
	%>
	\${empty input} : ${empty input}
	<br>
	<c:if test=$(emptyinput)>
텅빈 객체(null)입니다
</c:if>
<%-- 	<h4>switch 문</h4>
	<br>

	<c:choose>
		<c:when test="${param.sel == 'a'}">
           a 를 선택하셨근영
       </c:when>
		<c:when test="${param.sel == 'b'}">
           b 를 선택하셨근영
       </c:when>
		<c:when test="${param.sel == 'c'}">
           c 를 선택하셨근영
       </c:when>
		<c:otherwise>
           a, b, c 가 아닌 다른거근영...
       </c:otherwise>
	</c:choose>

	<h4>반복문</h4>
	<br>
	<c:forEach items="${ 리스트 }" var="i" begin="0" end="5"
		varStatus="status">
리스트 출력 : ${ i.key이름 }
인덱스 출력 : ${ status.index }
카운트 출력 : ${ status.count }
</c:forEach> --%>

</body>
</html>