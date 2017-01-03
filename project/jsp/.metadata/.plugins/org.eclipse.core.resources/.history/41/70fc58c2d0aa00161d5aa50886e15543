<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "common.LoginDBbean" %>

<% request.setCharacterEncoding("UTF-8");%>

<%
    String id = request.getParameter("id");
	String passwd  = request.getParameter("passwd");
	
	LoginDBbean manager = LoginDBbean.getInstance();
    int check = manager.userCheck(id,passwd);

	if(check==1){
		session.setAttribute("ultraId",id);
		response.sendRedirect("index.jsp");
	}else if(check==0){%>
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
<%	}else{ %>
	<script>
	  alert("아이디가 맞지 않습니다..");
	  history.go(-1);
	</script>
<%}	%>