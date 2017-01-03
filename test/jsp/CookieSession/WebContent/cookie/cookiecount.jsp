<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카운트</title>
</head>
<body>
<%! int i=0; %>
<%
int f=0;
Cookie cookie = new Cookie("id", "count");
cookie.setMaxAge(5);
response.addCookie(cookie);
Cookie[] c1=request.getCookies();

for(Cookie c:c1){
	if(c.getValue().equals("count")){
		f=1;
	}
}
if(f==0){
	out.println(i++);
}else{
	out.println(i);
}
%>
</body>
</html>