<%@page import="dao.BoardDao"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String realPath="c:\\files";			//파일이 업로드 될 경로
	int maxSize=1024*1024*10 ; 			//파일 크기제한  1k * 1k * 10 = 10메가
	int file_size = 0;
	
	MultipartRequest mul = new MultipartRequest(request, realPath, maxSize, "UTF-8");
	
	String file_name = "";
	int no = Integer.parseInt(mul.getParameter("no"));
	String category = mul.getParameter("category");
	String username = mul.getParameter("username");
	String title = mul.getParameter("title");
	String content = mul.getParameter("content");
	String userip = request.getRemoteAddr();
	String file_chk = mul.getParameter("file_chk");
	
	File f = new File(realPath);
	if(!f.isFile()){
		if(!f.isDirectory()){
			f.mkdir();
		}
	}
	if("01".equals(file_chk)){
		f = mul.getFile("file_name");
		file_name = f.getName();
		file_size = (int)f.length();
	}else{
		file_name = "-";
		file_size = 0;
	}
	
	BoardDao dao = new BoardDao();
	
	if(dao.updateBoard(category, title, username, userip, content, file_name, file_size, no) > 0){
		%>
			<script language=javascript>
				alert("글이 수정되었습니다.");
				location.href="list.jsp";
			</script>
		<%
	}else{
		%>
		<script language=javascript>
			alert("글수정에 실패했습니다.");
			location.href="list.jsp";
		</script>
		<%
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.0.0.js"></script>
</head>
<body>

</body>
</html>