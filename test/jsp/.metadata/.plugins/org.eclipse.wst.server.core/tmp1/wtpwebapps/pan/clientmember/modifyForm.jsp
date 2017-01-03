<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="clientmember.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../Main/css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
	
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script language="JavaScript" src="../clientmember/MemberJoin.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	
<script type="text/javascript">
 function openDaumPostcode() {
	   new daum.Postcode({
		   oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
          // 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
          document.getElementById('zip').value = data.postcode1+"-"+data.postcode2;
          document.getElementById('addr1').value = data.address;

          //전체 주소에서 연결 번지 및 ()로 묶여 있는 부가정보를 제거하고자 할 경우,
          //아래와 같은 정규식을 사용해도 된다. 정규식은 개발자의 목적에 맞게 수정해서 사용 가능하다.
          //var addr = data.address.replace(/(\s|^)\(.+\)$|\S+~\S+/g, '');
          //document.getElementById('addr').value = addr;

          document.getElementById('addr2').focus();
      }
  }).open();

}

	function checkIt(userinput) {
		if (document.getElementById("passwd").value == "") {
			alert("비밀번호를 입력하세요");
			return false;
		}

		if (document.getElementById("name").value == "") {
			alert("사용자 이름을 입력하세요");
			return false;
		}
		
		//alert(document.getElementById("email").value);
		var str = document.getElementById("email").value;
		var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		if (userinput.email.value == ""){
			alert('이메일주소를 입력 해 주세요');
			document.getElementById("email").focus();
            return false;
		} else if(regEmail.test(str)==false) {
            alert('이메일 주소가 유효하지 않습니다');
            document.getElementById("email").focus();
            return false;
        }

	}
</script>
</head>
<%
	String id = (String) session.getAttribute("memId");
	LogonDB manager = LogonDB.getInstance();
	LogonDataBean c = manager.getMember(id);

	try {
%>
<body><!--header-->
		<jsp:include page="../common/head.jsp"></jsp:include>
	
	<div class="content" id="content">
		<div class="membermodify">
			<div class="container">
	<form method="post" action="modifyPro.jsp" name="userinput"
		onsubmit="return checkIt(userinput)">
		<table width="600" border="1" cellspacing="0" cellpadding="3"
			align="center" bordercolor="#FFC8FF">
			<tr>
				<td colspan="2" height="39" align="center"><b>회원정보수정</b></td>
			</tr>
			<tr>
				<td colspan="2" align="center">회원의 정보를 수정합니다.</td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#FFC8FF" class="f1">아이디입력</td>

			</tr>
			<tr>
				<td class="f1">사용자ID</td>
				<td><%=c.getId()%></td>
			</tr>
			<tr>
				<td class="f1">비밀번호</td>
				<td><input type="password"  id="passwd" name="passwd" size="10"
					maxlength="10" value="<%=c.getPasswd()%>"></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#FFC8FF" class="f1">개인정보 입력</td>

			</tr>
			<tr>
				<td class="f1">사용자 이름</td>
				<td><input type="text" id="name" name="name" size="12" maxlength="12"
					value="<%=c.getName()%>"></td>
			</tr>
			<tr>
				<td class="f1">주민등록번호</td>
				<td><%=c.getJumin1()%>-<%=c.getJumin2()%></td>
			</tr>
			<tr>
				<td class="f1">E-Mail</td>
				<td><input type="text" id="email"  name="email" size="40" maxlength="30"
					value="<%=c.getEmail()%>"></td>
			</tr>
			<tr>
				<td class="f1">이메일 수신여부</td>
				<td><input type="radio" name="recv_yn" value="y"
					<%if (c.getRecv_yn().equals("y")) {%> checked <%}%>>예 <input
					type="radio" name="recv_yn" value="n"
					<%if (c.getRecv_yn().equals("n")) {%> checked <%}%>>아니오
			</tr>
			<tr>
				<td class="f1">전화번호</td>
				<td>
					<%
						if (c.getPhone1() == null) {
					%> <input type="text" name="phone1" size="4" maxlength="4">-
					<input type="text" name="phone2" size="4" maxlength="4">- <input
					type="text" name="phone3" size="4" maxlength="4"> <%
 	} else {
 %> <input type="text" name="phone1" size="4" maxlength="4"
					value="<%=c.getPhone1()%>">- <input type="text"
					name="phone2" size="4" maxlength="4" value="<%=c.getPhone2()%>">-
					<input type="text" name="phone3" size="4" maxlength="4"
					value="<%=c.getPhone3()%>"> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<td class="f1">휴대전화</td>
				<td><input type="text" name="cell1" size="4" maxlength="4"
					value="<%=c.getCell1()%>">- <input type="text" name="cell2"
					size="4" maxlength="4" value="<%=c.getCell2()%>">- <input
					type="text" name="cell3" size="4" maxlength="4"
					value="<%=c.getCell3()%>"></td>
			</tr>
			<tr>
				<td align="left" class="f1">주소</td>
				<td>
					<%
						if (c.getAddr1() == null) {
					%> <input type="text" id="zip" name="zip"> <input
					type="button" name="btnzip" value="우편번호찾기" class="f2"
					onClick="openDaumPostcode()">
					<p /> <input type="text" id="addr1" name="addr1"
					style="width: 300px"> <input type="text" id="addr2"
					name="addr2" style="width: 150px"> <%
 	} else {
 %> <input type="text" id="zip" name="zip" value="<%=c.getZip()%>">
					<input type="button" name="btnzip" value="우편번호찾기" class="f2"
					onClick="openDaumPostcode()">
					<p />
						<input type="text" id="addr1" name="addr1" style="width: 300px"
							value="<%=c.getAddr1()%>"> <input type="text" id="addr2"
							name="addr2" style="width: 150px" value="<%=c.getAddr2()%>">
				</td>
				<%
					}
				%>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="modify" value="수 정" class="f2">&nbsp;&nbsp; <input
					type="button" value="취 소"
					onClick="javascript:window.location='../Main/centerMain.jsp'"
					class="f2">&nbsp;&nbsp; <input type="button" value="회원탈퇴"
					onClick="javascript:window.location='deleteForm.jsp'" class="f2">
				</td>
			</tr>
		</table>
	</form></div></div></div>

	<jsp:include page="../common/foot.jsp"></jsp:include>
</body>
<%
	} catch (Exception e) {
	}
%>
</html>