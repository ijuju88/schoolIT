<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function getCookie( name ){
	var nameOfCookie = name + "=";
	var x = 0;
	while ( x <= document.cookie.length )
	{
			var y = (x+nameOfCookie.length);
			if ( document.cookie.substring( x, y ) == nameOfCookie ) {
					if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
							endOfCookie = document.cookie.length;
					return unescape( document.cookie.substring( y, endOfCookie ) );
			}
			x = document.cookie.indexOf( " ", x ) + 1;
			if ( x == 0 )
					break;
	}
	return "";
}


// 팝업창에서 만들어진 쿠키 Notice(Notice2) 의 값이 done(done2) 이 아니면(즉, 체크하지 않으면,) 
// 공지창 (test_pop.html test_pop2.html) 을 띄웁니다

if ( getCookie( "Notice" ) !="done") {
	noticeWindow  =  window.open('daypop.jsp','notice','left=0, top=0, width=502,height=430');
	noticeWindow.opener = self;
}

/* if ( getCookie( "Notice2" ) !="done") {
	noticeWindow  =  window.open('test_pop2.html','notice2','left=100, top=0, width=400,height=400');
	noticeWindow.opener = self;
} */
</script>
</head>
<body>
팝업을 뛰우는 창 입니다.
</body>
</html>