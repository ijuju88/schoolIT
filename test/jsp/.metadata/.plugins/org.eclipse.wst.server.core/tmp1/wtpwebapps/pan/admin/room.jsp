<jsp:include page="head.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Vector"
    import="reservation.ReservationAction"
    import="reservation.RoomBean"
%>
<%
request.setCharacterEncoding("UTF-8");	
Vector<RoomBean> vrb = new ReservationAction().getRoom();
%>
<script language="javascript">

	// 객실 추가
	function addRoom(form){
		if( form.nrname.value == "" ){
			alert("객실 이름을 입력하세요!");
			form.nrname.focus();
			return;
		}
		if( form.nrsize.value == "" ){
			alert("객실 평수를 입력하세요!");
			form.nrsize.focus();
			return;
		}
		if( form.nmen.value == "" ){
			alert("객실 최대이용인원을 입력하세요!");
			form.nmen.focus();
			return;
		}
		if( form.naddman.value == "" ){
			alert("객실 이용인원 추가 금액을 입력하세요!");
			form.naddman.focus();
			return;
		}
		if( form.nweekday.value == "" ){
			alert("객실 비수기 평일 금액을 입력하세요!");
			form.nweekday.focus();
			return;
		}
		if( form.nweekend.value == "" ){
			alert("객실 비수기 주말 금액을 입력하세요!");
			form.nweekend.focus();
			return;
		}
		if( form.nsweekday.value == "" ){
			alert("객실 성수기 평일 금액을 입력하세요!");
			form.nsweekday.focus();
			return;
		}
		if( form.nsweekend.value == "" ){
			alert("객실 성수기 주말 금액을 입력하세요!");
			form.nsweekend.focus();
			return;
		}
		form.action="roomPro.jsp?type=add"
								+"&rname="+form.nrname.value
								+"&rsize="+form.nrsize.value
								+"&men="+form.nmen.value
								+"&addman="+form.naddman.value
								+"&weekday="+form.nweekday.value
								+"&weekend="+form.nweekend.value
								+"&sweekday="+form.nsweekday.value
								+"&sweekend="+form.nsweekend.value;
		form.submit();
	}

	// 객실 수정 ( 폼이름,수정객실값 )
	function resetRoom(form,no){
		if( !confirm("정말 객실을 수정 하시겠습니까?") ){
			document.getElementById("rname"+no).focus();
			return;
		}
		if( document.getElementById("rname"+no).value == "" ){
			alert("객실 이름을 입력하세요!");
			document.getElementById("rname"+no).focus();
			return;
		}
		if( document.getElementById("rsize"+no).value == "" ){
			alert("객실 평수를 입력하세요!");
			document.getElementById("rsize"+no).focus();
			return;
		}
		if( document.getElementById("men"+no).value == "" ){
			alert("객실 최대이용인원을 입력하세요!");
			document.getElementById("men"+num).focus();
			return;
		}
		if( document.getElementById("addman"+no).value == "" ){
			alert("객실 이용인원 추가 금액을 입력하세요!");
			document.getElementById("addman"+no).focus();
			return;
		}
		if( document.getElementById("weekday"+no).value == "" ){
			alert("객실 비수기 평일 금액을 입력하세요!");
			document.getElementById("weekday"+no).focus();
			return;
		}
		if( document.getElementById("weekend"+no).value == "" ){
			alert("객실 비수기 주말 금액을 입력하세요!");
			document.getElementById("weekend"+no).focus();
			return;
		}
		if( document.getElementById("sweekday"+no).value == "" ){
			alert("객실 성수기 평일 금액을 입력하세요!");
			document.getElementById("sweekday"+no).focus();
			return;
		}
		if( document.getElementById("sweekend"+no).value == "" ){
			alert("객실 성수기 주말 금액을 입력하세요!");
			document.getElementById("sweekend"+no).focus();
			return;
		}
		form.action="roomPro.jsp?type=reset"
								+"&rno="+document.getElementById("no"+no).value
								+"&rname="+document.getElementById("rname"+no).value
								+"&rsize="+document.getElementById("rsize"+no).value
								+"&men="+document.getElementById("men"+no).value
								+"&addman="+document.getElementById("addman"+no).value
								+"&weekday="+document.getElementById("weekday"+no).value
								+"&weekend="+document.getElementById("weekend"+no).value
								+"&sweekday="+document.getElementById("sweekday"+no).value
								+"&sweekend="+document.getElementById("sweekend"+no).value;
		form.submit();
	}

	// 객실 제거
	function delRoom(form,no){
		if( !confirm("정말 객실을 제거 하시겠습니까?") ){
			alert(document.getElementById("no"+no).value);
			return;
		}
		if( document.getElementById("no"+no).value == "" ){
			alert("제거기능에 문제가 발생하였습니다!\n\n페이지를 새로고치고 시도하세요!");
		}
		form.action="roomPro.jsp?type=del"
								+"&rno="+document.getElementById("no"+no).value;
		alert("제거했어요!");
		form.submit();
	}

</script>
<form name="roomFrm" method="post">
	<table border="1">
		<tr>
			<th colspan="10" class="tableSubject1">객실 목록</th>
		</tr>
		<tr>
			<td rowspan="2" class="tableSubject2">번호</td>
			<td rowspan="2" class="tableSubject2">객실이름</td>
			<td rowspan="2" class="tableSubject2">객실크기(평)</td>
			<td rowspan="2" class="tableSubject2">최대인원수</td>
			<td rowspan="2" class="tableSubject2">추가인원금액</td>
			<td colspan="2" class="tableSubject2">비수기</td>
			<td colspan="2" class="tableSubject2">성수기</td>
			<td rowspan="2" class="tableSubject2">수정/삭제</td>
		</tr>
		<tr>
			<td class="tableSubject2">주중가격</td><td class="tableSubject2">주말가격</td><td class="tableSubject2">주중가격</td><td class="tableSubject2">주말가격</td>
		</tr>
	<% for( int i=0; i<vrb.size(); i++){
		RoomBean rb = vrb.get(i);
	%>
		<tr>
			<td><%= i+1 %><input type="hidden" id="no<%= i %>" name="no<%= i %>" value="<%= rb.getRno() %>"></td>
			<td><input type="text" id="rname<%= i %>" name="rname<%= i %>" size="10" value="<%= rb.getRname() %>" /></td>
			<td><input type="text" id="rsize<%= i %>" name="rsize<%= i %>" size="7" value="<%= rb.getRsize() %>" /></td>
			<td><input type="text" id="men<%= i %>" name="men<%= i %>" size="7" value="<%= rb.getMen() %>" /></td>
			<td><input type="text" id="addman<%= i %>" name="addman<%= i %>" size="7" value="<%= rb.getAddman() %>" /></td>
			<td><input type="text" id="weekday<%= i %>" name="weekday<%= i %>" size="7" value="<%= rb.getWeekday() %>" /></td>
			<td><input type="text" id="weekend<%= i %>" name="weekend<%= i %>" size="7" value="<%= rb.getWeekend() %>" /></td>
			<td><input type="text" id="sweekday<%= i %>" name="sweekday<%= i %>" size="7" value="<%= rb.getSweekday() %>" /></td>
			<td><input type="text" id="sweekend<%= i %>" name="sweekend<%= i %>" size="7" value="<%= rb.getSweekend() %>" /></td>
			<td>
				<input type="button" value="객실수정" onClick="resetRoom(this.form,<%= i %>)" /> 
				<input type="button" value="삭제" onClick="delRoom(this.form,<%= i %>)" />
			</td>
		</tr>
	<% 	} %>
		<tr>
			<td colspan="10"  class="tableSubject2">객실 추가</td>
		</tr>
		<tr>
			<td>입력</td>
			<td><input type="text" name="nrname" size="10" /></td>
			<td><input type="text" name="nrsize" size="7" /></td>
			<td><input type="text" name="nmen" size="7" /></td>
			<td><input type="text" name="naddman" size="7" /></td>
			<td><input type="text" name="nweekday" size="7" /></td>
			<td><input type="text" name="nweekend" size="7" /></td>
			<td><input type="text" name="nsweekday" size="7" /></td>
			<td><input type="text" name="nsweekend" size="7" /></td>
			<td><input type="button" value="객실추가" onClick="addRoom(this.form)" /></td>
		</tr>
	</table>
</form>
<jsp:include page="foot.html" />