<%@ page contentType="text/html;charset=utf-8"  session="false" import = "java.util.*, java.lang.*, java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
</HEAD>
<BODY>
<%
	HttpSession session = request.getSession(false);
	request.setCharacterEncoding("utf-8"); 

   	String url="jdbc:mysql://localhost:3306/auction";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String id = (String)session.getAttribute("login.id");
	int price = Integer.parseInt(request.getParameter("price")) + 1000;
	int com_number = Integer.parseInt(request.getParameter("com_number"));
try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"admin","1234");
		String sql0 = "select * from member_auction where id='"+id+"' and com_number=" + request.getParameter("com_number");
		pstmt = con.prepareStatement(sql0);
		rs = pstmt.executeQuery();
		if(!(rs.next())){
		String sql = "insert into member_auction(id, price, com_number) values(?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setInt(2,price);
		pstmt.setInt(3,com_number );
		pstmt.executeUpdate();
		
		}
		else{
		String sql3 = "update member_auction set  price=" + price + " where com_number = "+ com_number;
		pstmt = con.prepareStatement(sql3);
		pstmt.executeUpdate();
		}
		String sql4 = "select * from commodity where number=" + request.getParameter("com_number");
		pstmt = con.prepareStatement(sql4);
		rs = pstmt.executeQuery();
		rs.next();
		int cnt = rs.getInt("readcnt") + 1;
		String sql2 = "update commodity set  readcnt =" + cnt + ", price=" + price + " where number =" + com_number;
		pstmt = con.prepareStatement(sql2);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		


	}catch(Exception e){
		out.print(e);
		return ;
	}

%>
<script language="javascript">
	history.back();
</script>
</BODY>
</HTML>
