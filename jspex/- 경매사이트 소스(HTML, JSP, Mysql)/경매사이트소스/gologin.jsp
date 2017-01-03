<%@ page contentType="text/html; charset=utf-8"  import="java.sql.*" session="false" %>

<%
	request.setCharacterEncoding("utf-8");
	HttpSession session = request.getSession(true);
	Connection con = null;
 	Statement stmt = null;
	ResultSet rs = null;
	String id = request.getParameter("id");
	String pwd = request.getParameter("password");
	String url="jdbc:mysql://localhost:3306/auction";
	try{
	 	Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "select * from member where id='"+id+"'and password='"+pwd+"'";
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			session.setAttribute("login.id",id);
			session.setAttribute("login.password",pwd);
			response.sendRedirect("logining.jsp");
		 }
		else {%><script language="javascript">alert("아이디 또는 비밀번호를 잘못 입력하셨습니다"); history.back();</script>
		<%
		}
		
	}catch(Exception e){
		out.print(e);
		return ;
	}

%>