<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="common.CommonAction"
%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="room" class="reservation.RoomBean">
	<jsp:setProperty name="room" property="*" />
</jsp:useBean>
<%
	CommonAction action = CommonAction.getInstance();
	String type = request.getParameter("type");
	String rname = null;
	if( type.equals("add") || type.equals("reset") ){
		rname = new String(request.getParameter("rname"));
		room.setRname(rname);
	}
	
	if( type.equals("add") ){	// 추가
		action.insertRoom(room);
	}else if( type.equals("reset") ){	// 수정
		action.updateRoom(room);
	}else if( type.equals("del") ){	// 제거
		action.deleteRoom(room);
	}
%>
<script language="javascript">
	location.href="room.jsp";
</script>