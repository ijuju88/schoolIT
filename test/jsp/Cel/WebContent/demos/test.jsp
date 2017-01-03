<%@page import="DTO.Celbean"%>
<%@page import="DAO.CelDBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='/js/fullcalendar/fullcalendar.css' />

<link href='../fullcalendar.css' rel='stylesheet' />
<link href='../fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='../lib/moment.min.js'></script>
<script src='../lib/jquery.min.js'></script>
<script src='../fullcalendar.min.js'></script>
<script type='text/javascript'>

	
	$(document).ready(function() {
		
		var date = new Date();
		var h = date.getHours();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		var calendar = $('#calendar').fullCalendar({
			
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			
			selectable: true,
			selectHelper: true,
			
			
			//날짜선택시 등록
			select: function(start, end, allDay, url) {
				/*  var title = prompt('일정을 입력하세요.');  */
				var title = document.getElementById("title").value;
				alert(title.length);
				if ((title.value != "" && title.length !=0 )) {
	
					 var sday=new Date(start).getDate();
					 var st=document.getElementById("starttime").value;
					 var ld=document.getElementById("lastday").value;
					 var lt=document.getElementById("lasttime").value;
					 var totday= parseInt(sday)+ parseInt(ld);
					 var url=document.getElementById("url").value;
					 
					
					 
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							//start: start,
							start:new Date(y, m, sday, st, 0),
							end: new Date(y,m, totday, lt,0),
							allDay: false,
							url:url 
	
						},
						true // make the event "stick"
						);
				
				}else{
					alert("일정은 꼭입력바랍니다");
					false
				}
				calendar.fullCalendar('unselect');
				},
			 
			
				
			 editable : true,
	        eventLimit : true,
			/* events: [
				{
					title: '01 All Day Event',
					start: new Date(y, m, 1)
				},
				{
					title: '02 Long Event',
					start: new Date(y, m, d-5),
					end: new Date(y, m, d-2)
				},
				{
					id: 999,
					title: '03 Repeating Event',
					start: new Date(y, m, d-3, 16, 0),
					allDay: false
				},
				{
					id: 999,
					title: '04 Repeating Event',
					start: new Date(y, m, d+4, 16, 0),
					allDay: false
				},
				{
					title: '05 Meeting',
					start: new Date(y, m, d, 10, 30),
					allDay: false
				},
				{
					title: '06 Lunch',
					start: new Date(y, m, d, 12, 0),
					end: new Date(y, m, d, 14, 0),
					allDay: false
				},
				{
					title: '07 Birthday Party',
					start: new Date(y, m, d+1, 19, 0),
					end: new Date(y, m, d+1, 22, 30),
					allDay: false // 주간의 나타남, true 나타나지않음
				},
				{
					title: '08 Click for Google',
					start: new Date(y, m, 28),
					end: new Date(y, m, 29),
					url: 'http://google.com/'
				}
			] ,*/
			
			//클릭시 이동
			  eventClick:function(event) {
	                if(event.url) {
	                    alert(event.title + "\n" + event.url, "wicked", "width=700,height=600");
	                    window.open(event.url);
	                    return false;
	                }else{
	                	alert(event.title + "\n", "wicked", "width=700,height=600");
	                	return false;
	                }
	            },
	            
	            //x누를시 삭제
	            eventRender: function(event, element) {  
	                element.append( "<span class='closeon'>X</span>" );
	                element.find(".closeon").click(function() {
	                   $('#calendar').fullCalendar('removeEvents',event._id);
	                });
	            }

		});

	});
</script>

<style type='text/css'>
body {
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#calendar {
	width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<table align="center" width="700">
		<tr align="left" style="background-color: #dddddd">
			<td style="width: 20%">일정</td>
			<td><input type="text" name="title" id="title" /></td>
			<td style="width: 20%">URL</td>
			<td><input type="text" name="url" id="url" /></td>
		</tr>
		<tr align="left">
			<td align="left" style="width: 20%">시작시간</td>
			<td align="left" colspan="3"><select name="starttime"
				id="starttime">
					<option value="1">1시</option>
					<option value="2">2시</option>
					<option value="3">3시</option>
					<option value="4">4시</option>
					<option value="5">5시</option>
					<option value="6">6시</option>
					<option value="7">7시</option>
					<option value="8">8시</option>
					<option value="9">9시</option>
					<option value="10">10시</option>
					<option value="11">11시</option>
					<option value="12">12시</option>

					<option value="13">13시</option>
					<option value="14">14시</option>
					<option value="15">15시</option>
					<option value="16">16시</option>
					<option value="17">17시</option>
					<option value="18">18시</option>
					<option value="19">19시</option>
					<option value="20">20시</option>
					<option value="21">21시</option>
					<option value="22">22시</option>
					<option value="23">23시</option>
					<option value="24">24시</option>
			</select> <!-- <input type="text" name="starttime" id="starttime"/> -->
		</tr>
		<tr align="left">
			<td align="left" style="width: 20%">마지막일</td>
			<td align="left"><input type="text" name="lastday" id="lastday" /></td>
			<td align="left" style="width: 20%">마지막시간</td>
			<td align="left"><select name="lasttime" id="lasttime">
					<option value="1">1시</option>
					<option value="2">2시</option>
					<option value="3">3시</option>
					<option value="4">4시</option>
					<option value="5">5시</option>
					<option value="6">6시</option>
					<option value="7">7시</option>
					<option value="8">8시</option>
					<option value="9">9시</option>
					<option value="10">10시</option>
					<option value="11">11시</option>
					<option value="12">12시</option>

					<option value="13">13시</option>
					<option value="14">14시</option>
					<option value="15">15시</option>
					<option value="16">16시</option>
					<option value="17">17시</option>
					<option value="18">18시</option>
					<option value="19">19시</option>
					<option value="20">20시</option>
					<option value="21">21시</option>
					<option value="22">22시</option>
					<option value="23">23시</option>
					<option value="24">24시</option>
			</select> <!-- <input type="text" name="lasttime" id="lasttime" /> --></td>
		</tr>
	</table>

	<hr>

	<div id='calendar' style="width: 80%"></div>
</body>
</html>
