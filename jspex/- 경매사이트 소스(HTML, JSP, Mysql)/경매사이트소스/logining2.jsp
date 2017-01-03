<%@ page contentType="text/html; charset=euc-kr" session="false" import="java.sql.*" session="false" %>

<HTML>
<style text="Text/css">
body {
 margin-left: 0px;
 margin-top: 0px;
 margin-right: 0px;
 margin-bottom: 0px;
 overflow-y: hidden;
 overflow-x: hidden;
}
</style>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%
	String url="jdbc:mysql://localhost:3306/auction";
	HttpSession session = request.getSession(false);
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =  null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"admin","1234");
	
		stmt = con.createStatement();
		
	}catch(Exception e){
	
	}
%>
<script language="javascript">
function outcome(){
	location.href("logout.jsp");
}
</script>
<HEAD>
<TITLE><%=(String)session.getAttribute("login.id") %>¥‘ æ»≥Á«œººø‰</TITLE>
</HEAD>
<BODY>
<table width="170" border="0">
  <tr>
    <td width="170" height="108" bgcolor="#FFD9EC"> <p>&nbsp;</p>    
      <form name="login" method="post" action="WEB-INF/gologin.jsp">
        <p align="center">
		<b><% out.print((String)session.getAttribute("login.id")); %></b>
		&nbsp; ¥‘ <br />
&nbsp;&nbsp;æ»≥Á«œººø‰. »Øøµ«’¥œ¥Ÿ! </p>
        <p align="center">
          <input name="login" type="button" id="login" value="∑Œ±◊æ∆øÙ" onclick="outcome()">
&nbsp;
  
        </p>
    </form></td>
  </tr>
</table>
</BODY>
</HTML>
