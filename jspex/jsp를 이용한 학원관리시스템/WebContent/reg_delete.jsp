<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>삭제페이지</title>
<script language="javascript">
	function List() {
		location.href = "./RegisterListAction.bo";
	}
</script>
</head>
<body>
	<table align="center" border="1" cellspacing="1" cellpadding="0"
		style="padding: 3px 4px 2px; width: 660px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);">
		<tr>
			<td align="center"">삭제페이지</td>
		</tr>
	</table>
	<form method="post" action="./RegisterDeleteAction.bo" name="delete">
		<table align="center" border="1" cellspacing="1" cellpadding="0"
			style="padding: 3px 4px 2px; width: 660px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);">

			<tr>
				<td
					style="padding: 3px 4px 2px; width: 45%; height: 10px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(201, 224, 240);"
					rowspan="1"><p>삭제할 과목아이디</p></td>
				<td
					style="padding: 3px 4px 2px; width: 55%; height: 10px; color: rgb(61, 118, 171); background-color: rgb(255, 232, 232);"
					rowspan="1"><p>
						<input type="text" name="rg_id" size="60" required="required">
					</p></td>
			</tr>
			<tr>
				<td
					style="padding: 3px 4px 2px; width: 45%; height: 10px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(201, 224, 240);"
					rowspan="1" colspan="1">삭제할 과목번호</td>
				<td
					style="padding: 3px 4px 2px; width: 55%; height: 10px; color: rgb(61, 118, 171); background-color: rgb(255, 232, 232);"
					rowspan="1" colspan="1"><p>
						<input type="text" name="sub_no" size="60" required="required" placeholder="숫자만 입력하세요">
					</p></td>
			</tr>
			<tr>
				<td
					style="padding: 3px 4px 2px; width: 540px; height: 10px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(217, 238, 236);"
					rowspan="1" colspan="2"><a width='500' align='center'><input
						Type='Submit' Value='삭제'> <input Type='reset' Value='초기화'>
						<input Type='Button' Value='취소' onClick='List();'></a></td>
			</tr>
		</table>
	</form>

</body>
</html>