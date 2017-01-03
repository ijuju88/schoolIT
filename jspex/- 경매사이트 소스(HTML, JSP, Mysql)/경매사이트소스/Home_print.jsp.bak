<%@ page contentType="text/html;charset=utf-8"  session="false" import = "java.util.*, java.lang.*, java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> 상품출력 </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
</HEAD>
<style text="text/css">
body {
 margin-left: 0px;
 margin-top: 0px;
 margin-right: 0px;
 margin-bottom: 0px;

 overflow-x: hidden;
}

</style>
<BODY>



<% 
	HttpSession session = request.getSession(false);
	request.setCharacterEncoding("utf-8"); 

   	String url="jdbc:mysql://localhost:3306/auction";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//mysql url 저장함
	try{
		Class.forName("com.mysql.jdbc.Driver"); //mysql은 결한다.
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "select * from commodity where cond=1 order by number desc "; //sql문 실행
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int check=0;
		%>
		<h3>[경매중인 물건]</h3>
		
		<%  while(rs.next())
			{ //result set을 사용하여 출력한다
	
			%>
			<table border=1 width="200" align="left">
			<tr><th align="center" colspan="2" align="Center"><%=rs.getString("com_name")%></th></tr><%
			String link = "propetPrint.jsp?number=" + rs.getString("number")  ;
			%><td colspan="2" align="Center"><img width="80" height="80" src="upload/<%=rs.getString("photo1")%>" /></td></tr><%
			%><td colspan="2" align="Center"> &nbsp;<a href='<%=link%>' target="_self"><%=rs.getString("com_name")%></a></td></tr><%
			%><td>경매가격</td><td align="center"><%=rs.getString("price")%></td></tr><%
			%><td>즉시구입가</td><td align="center"><%=rs.getString("imm_price")%></td></tr><%
			%><td>입찰자수</td><td align="center"><%=rs.getString("readcnt")%></td></tr><%
			%><td>판매자ID</td><td align="center"><%=rs.getString("seller")%></td></tr>
			</table>
			
			<%
				check++;
			if(check==4) {%> <br><br><br><br><br><br><br> <br> <br> <br> <br> <br> <br> <br> <br> <br><% check=0;}
			
		
		}
		rs.close();
		pstmt.close(); //resultset, statement, connection 종료
		con.close();
	}catch(Exception e){
		out.println(e);
		return ;
	}

%>
</table>
</BODY>
</HTML>
