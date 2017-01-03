<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	BoardDao dao = new BoardDao();
	BoardVO vo = new BoardVO();
	int no = Integer.parseInt(request.getParameter("no"));
	vo = dao.selectBoard(no);
%>
<html>
<head>
<script language=javascript>
	function proc(frm){
		if(frm.file_name.value=="" || frm.file_name.value == null){
			frm.file_chk.value = "00";
		}else{
			frm.file_chk.value = "01";
		}
		frm.submit();
	}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>글수정</h3>
	<form name="frm" action="updpro.jsp" method = "post" enctype="multipart/form-data">
		<input type="hidden" name="no" value=<%=no %>> 
		<table>
			<tr>
				<td align="right">이름 : </td>
				<td align="left"><input type="text" lang="20" size="20" name="username" value=<%=vo.getUsername() %>></td>
			</tr>
			<tr>
				<td align="right">제목 : </td>
				<td align="left">
					<select name="category">
						<option value="00001">유머글</option>
						<option value="00002">시사</option>
						<option value="00003">연예</option>
						<option value="00004">고민상담</option>
					</select>	
					<input type="text" lang="50" size="50" name="title" value=<%=vo.getTitle() %>>
				</td>
			</tr>
			<tr>
				<td align="right">내용</td>
				<td align="left"><textarea rows="10" cols="55" name="content"><%=vo.getContent() %></textarea></td>
			</tr>
			<tr>
				<td align="right">파일업로드</td>
				<td align="left">
					<input type="file" name="file_name" value=<%=vo.getFile_name() %> />
					<input type="hidden" name="file_chk" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right">
					<input type="button" value="수정" onclick="javascript:proc(this.form);" />
					<input type="button" value="취소" onclick="javascript:location.href='list.jsp';" />
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>