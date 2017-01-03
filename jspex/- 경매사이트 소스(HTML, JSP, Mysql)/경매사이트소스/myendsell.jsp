<%@ page contentType="text/html;charset=utf-8"  session="false" import = "java.util.*, java.lang.*, java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>
<style text="text/css">
body {
 margin-left: 0px;
 margin-top: 0px;
 margin-right: 0px;
 margin-bottom: 0px;
 overflow-y: hidden;
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
	try{
		Class.forName("com.mysql.jdbc.Driver"); //mysql은 결한다.
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "select * from commodity where (seller='" + session.getAttribute("login.id") + "' and cond=0) or( seller='" + session.getAttribute("login.id") + "' and cond=2)  order by number desc " ; //sql문 실행
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery(); 
			%>
		<table border=1 width="800" align="center">
		<tr height="30" valign="center" bgcolor="pink"><th width="50">주문번호</th><th width="80">사진</th><th width="400">상품이름</th><th width="80">경매가격</th><th width="80">입찰자수</th><th width="100">판매자</th>
		<%  while(rs.next()){ //result set을 사용하여 출력한다
			%><tr><td align="center"><%=rs.getString("number")%></td><%
			String link = "propetPrint_endsell.jsp?number=" + rs.getString("number")  ;
			%><td><img width="80" height="80" src="upload/<%=rs.getString("photo1")%>" /></td><%
			%><td> &nbsp;<a href='<%=link%>' target="_self"><%=rs.getString("com_name")%></a>
			<%if(rs.getInt("cond")==0) out.print("[경매완료상품]");
			  else if  (rs.getInt("cond")==2) out.print("[배송예정상품]"); %>
			</td><%
			%><td align="center"><%=rs.getString("price")%></td><%
			%><td align="center"><%=rs.getString("readcnt")%></td><%
			%><td align="center"><%=rs.getString("seller")%></td></tr><%
			
		
		}
		rs.close();
		pstmt.close(); //resultset, statement, connection 종료
		con.close();
	}catch(Exception e){
		out.println(e);
		return ;
	}

%>
<table>

</table>
</BODY>
</HTML>
