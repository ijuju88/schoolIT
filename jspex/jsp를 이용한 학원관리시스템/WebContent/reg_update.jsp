<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
<script language="javascript">
	function List() {
		location.href = "./RegisterListAction.bo";
	}
</script>
</head>
<body>
	<table align="center" border="1" style="width: 660px; height: 15px;">
		<tr>
			<td align="center"
				style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);">����������</td>
		</tr>
	</table>
	<form method="post" action="./RegisterModifyAction.bo" name="modify">
		<table align="center"
			style="background-color: rgb(166, 188, 209); width: 660px; height: 15px;"
			border="1" cellspacing="1" cellpadding="0">
			<tr>
				<td width="45%"
					style="padding: 3px 4px 2px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(98, 132, 171);"><p>���¾��̵�</p></td>
				<td width="55%"
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);"><p>
						<input type="text" name="rg_id" size="60" placeholder="ex)����"
							required="required">
					</p></td>
			</tr>
			<tr height=10px;>
				<td width="45%"
					style="padding: 3px 4px 2px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(98, 132, 171);"><p>
						���¹�ȣ</p></td>
				<td width="55%"
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);"><p>
						<input type="text" name="sub_no" size="60" placeholder="���ڸ� �Է��ϼ���"
							required="required">
					</p></td>
			</tr>
			<tr height=10px;>
				<td width="45%"
					style="padding: 3px 4px 2px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(98, 132, 171);"><p>���۳�¥</p></td>
				<td width="55%"
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);"><p>
						<input type="text" name="rg_start" size="60"
							placeholder="ex)20140101" required="required">
					</p></td>
			</tr>
			<tr height=10px;>
				<td width="45%"
					style="padding: 3px 4px 2px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(98, 132, 171);"><p>���ᳯ¥</p></td>
				<td width="55%"
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);"><p>
						<input type="text" name="rg_end" size="60"
							placeholder="ex)20140101" required="required">
					</p></td>
			</tr>
			<tr height=10px;>
				<td width="45%"
					style="padding: 3px 4px 2px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(98, 132, 171);"><p>
						������</p></td>
				<td width="55%"
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);"><p>
						<input type="text" name="charge" size="60" placeholder="���ڸ� �Է��ϼ���"
							required="required">
					</p></td>
			</tr>
			<tr height=10px;>
				<td width="45%"
					style="padding: 3px 4px 2px; text-align: left; color: rgb(255, 255, 255); font-weight: normal; background-color: rgb(98, 132, 171);"><p>
						���ǽ�</p></td>
				<td width="55%"
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); background-color: rgb(255, 255, 255);"><p>
						<input type="text" name="classroom" size="60"
							placeholder="���ڸ� �Է��ϼ���" required="required">
					</p></td>
			</tr>
			<tr align="center" width=660px; height=10px>
				<td
					style="padding: 3px 4px 2px; color: rgb(61, 118, 171); border-bottom-color: rgb(235, 235, 235); border-bottom-width: 1px; border-bottom-style: solid; background-color: rgb(246, 248, 250);"
					rowspan="1" colspan="6"><input type="submit" value="�����ϱ�">
					<input type="reset" value="�ʱ�ȭ"> <input Type='Button'
					Value='���' onClick='List();'></td>
			</tr>
		</table>

	</form>
</body>
</html>