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

<BODY>
<% HttpSession session = request.getSession(false); %>

<% 
	
	request.setCharacterEncoding("utf-8"); 
	String number = request.getParameter("number");
   	String url="jdbc:mysql://localhost:3306/auction";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String seller, buyer;
	int price;
	//mysql url 저장함
	try{
		Class.forName("com.mysql.jdbc.Driver"); //mysql은 결한다.
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "select * from commodity where number =" + number + " and cond=1";//sql문 실행
		String sql2 = "insert into member_buy(id, price, com_number) values(?,?,?)";
		String sql3 = "insert into member_sell(id, price, com_number) values(?,?,?)";
		String sql4 = "update commodity set cond=0, price=? where number ='" +number + "'";
	
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rs.next();
		 buyer = (String)session.getAttribute("login.id");
		 seller = rs.getString("seller");
		 price =  rs.getInt("imm_price");
		 out.print(buyer);
		 out.print(seller);
		rs.close();
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,buyer);
		pstmt.setInt(2,price);
		pstmt.setInt(3,Integer.parseInt(number));
		pstmt.executeUpdate();
		pstmt = con.prepareStatement(sql3);
		pstmt.setString(1,seller);
		pstmt.setInt(2,price);
		pstmt.setInt(3,Integer.parseInt(number));
		
		pstmt.executeUpdate();
		pstmt = con.prepareStatement(sql4);
		pstmt.setInt(1,price);
		pstmt.executeUpdate();
		pstmt.close(); //resultset, statement, connection 종료
		con.close();
	}catch(Exception e){
		out.println(e);
		return ;
	}
		
	%>
</BODY>
<script language="javascript">
	alert("즉시구입가로 구입햇습니다!");
	location.go(-2);
</script>
</HTML>
