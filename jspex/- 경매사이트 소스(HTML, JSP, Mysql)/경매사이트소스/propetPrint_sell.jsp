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
<script language="javascript">


function load(){
	document.location.reload();
}
</script>
<style text="text/css">
body {
 margin-left: 0px;
 margin-top: 0px;
 margin-right: 0px;
 margin-bottom: 0px;
 overflow-y: hidden;
 overflow-x: hidden;
}
table{
 border-bottom:solid 3px orange;

}
td{border-bottom:solid 1px red; background-color:oragne;}

</style>
<BODY>
<% HttpSession session = request.getSession(false); %>

<% 
	
	request.setCharacterEncoding("utf-8"); 
	String number = request.getParameter("number");
   	String url="jdbc:mysql://localhost:3306/auction";
	String url2="";
	String url3="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String id;
	//mysql url 저장함
	try{
		Class.forName("com.mysql.jdbc.Driver"); //mysql은 결한다.
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "select * from commodity left outer join member_auction on commodity.price = member_auction.price and commodity.number = member_auction.com_number where commodity.number = " + number  + " and cond=1";//sql문 실행
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		%>
		<%  rs.next();
			String src1, src2, src3;
			id = rs.getString("seller");
			if(rs.getString("photo1") == null)
				src1 = "noimage.jpg";
			else src1 = rs.getString("photo1");
			if(rs.getString("photo2") == null)
				src2 = "noimage.jpg";
			else src2 = rs.getString("photo2");
			if(rs.getString("photo3") == null)
				src3 = "noimage.jpg";
			else src3 = rs.getString("photo3");
		%>
		<table align="center"  width="600">
		<tr >
			<td   width="300" height="300"  rowspan="6" colspan="3"><img name="frontimage" width="300" height="300" src="upload/<%=src1%>" /></td>
			<td   colspan="2"><b><%=rs.getString("com_name")%></b></td>
		</tr>
		<tr>
			<td width="100">판매자</td>
			<td width="150"><%=rs.getString("seller")%></td>
		</tr>
		<tr>
			<td>경매가격</td>
			<td><%=rs.getString("price")%>
			<%
				url2= "'com_auction.jsp?price=" + rs.getString("price") + "&com_number=" + rs.getString("number") +"'";
				String com_numbere=rs.getString("number");
				url3= "'sellCom.jsp?price=" + rs.getString("price") + "&com_number=" + rs.getString("number") +"'";
			%>
			</td>
		</tr>
		<tr>
			<td>즉시구매가</td>
			<td><%=rs.getString("imm_price")%></td>
		</tr>
		<tr>
			<td>경매횟수</td>
			<td><%=rs.getString("readcnt")%></td>
		</tr>
		<tr>
			<td>현재 입찰자 : </td>
			<td><%=rs.getString("id")%></td>
		</tr>
		<tr>
		
			<td width="100" height="100"><a onclick="document.frontimage.src='upload/<%=src1%>'"><img border="0" width="100" height="100" src="upload/<%=src1%>" /></a></td>
			<td width="100" height="100"><a onclick="document.frontimage.src='upload/<%=src2%>'"><img border="0"width="100" height="100" src="upload/<%=src2%>" /></a></td>
			<td width="100" height="100"><a onclick="document.frontimage.src='upload/<%=src3%>'"><img border="0" width="100" height="100" src="upload/<%=src3%>" /></a></td>
			<td colspan="2">
			<img onclick="modifycom()" border="0" width="80" height="50" src="image/modifycom.jpg">
			<img onclick="endcom()" border="0"  width="80" height="50" src="image/endcom.jpg">
			</td>
		</tr>
		<tr>
			<td colspan="5"><b>&nbsp;&nbsp;&nbsp;&nbsp;경매 물품 설명 : </b><br /><%=rs.getString("com_context")%></td>
		</tr>
	
		</table>
		</BODY>
		<script language="javascript">
				function modifycom(){
						
						<%  String sessionid= (String)session.getAttribute("login.id");
							if(session.getAttribute("login.id")==null) { %>
							alert("먼저 로그인이 필요합니다!");
						<%}
							
							else if(!(sessionid.equals(id))) { %>
							alert("판매자의 아이디와 다릅니다!");
						<%}
						else { %> 
							t = confirm("상품정보를 수정하겠습니까?"); 
							if(t==true) document.location.href = <%=url2%> ;
						<% }
						%>
				}
				function endcom(){
						<% if(session.getAttribute("login.id")==null) { %>
							alert("먼저 로그인이 필요합니다!");
						<%}
							
							else if(!(sessionid.equals(id))) { %>
							alert("판매자의 아이디와 다릅니다!");
						<%}
						else { %> 
							t = confirm("경매를 마감하겠습니까?"); 
							if(t==true) document.location.href = <%=url3%> ;
						<% }
						%>
				}

		</script>
		<%
		
		rs.close();
		pstmt.close(); //resultset, statement, connection 종료
		con.close();
	}catch(Exception e){
		out.println(e);
		return ;
	}

%>




</HTML>
