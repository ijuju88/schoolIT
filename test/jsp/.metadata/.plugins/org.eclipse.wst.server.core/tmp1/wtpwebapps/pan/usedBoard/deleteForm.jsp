<%@ page contentType="text/html;charset=UTF-8"%>


<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<link href="../usedBoard/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
$(function() {
	$("#slider").responsiveSlides({
		auto : true,
		nav : true,
		speed : 500,
		namespace : "callbacks",
		pager : true,
	});


	function deleteSave() {
		if (document.delForm.passwd.value == '') {
			alert("비밀번호를 입력하십시요.");
			document.delForm.passwd.focus();
			return false;
		}
	}
});
</script>
</head>
<body>
  <jsp:include page="../common/head.jsp"></jsp:include>
	<div class="content">
		<div class="wirteForm">
			<div class="bs-docs-example">
			<div class="gallery-info" align="center">
					<h2>Question Delete</h2>
    </div>
				<form method="POST" name="delForm"
					action="../usedBoard/deletePro.jsp?pageNum=<%=pageNum%>"
					onsubmit="return deleteSave()">
					<table id="table" border="1" align="center" cellspacing="0"
						cellpadding="0" width="360">
						<tbody>
							<tr height="30">
								<td align=center><b>비밀번호를 입력해 주세요.</b></td>
							</tr>
						</tbody>
						<tbody>
							<tr height="30">
								<td align=center>비밀번호 : <input type="password"
									name="passwd" size="8" maxlength="12"> <input
									type="hidden" name="num" value="<%=num%>"></td>
							</tr>
						</tbody>
						<tbody>
							<tr height="30">
								<td align=center><input type="image" src="../usedBoard/img/btn_ok.gif">
									<a 
									href="javascript:location.href='../usedBoard/list.jsp?pageNum=<%=pageNum%>';">
										<img src="../usedBoard/img/btn_list.gif" border="0">
								</a></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
</html>

