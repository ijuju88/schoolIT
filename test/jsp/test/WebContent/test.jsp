<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
/* var a=6;
function test() {
	var a=7;
	function again() {
		var a=8;
		alert(a);
	}
	again();
	alert(a);
}
test();
alert(a); */

var p={fname:"kim", age:20};
var x;

for(x in p){
	alert(p[x]+" ");
}
</script>
</body>
</html>