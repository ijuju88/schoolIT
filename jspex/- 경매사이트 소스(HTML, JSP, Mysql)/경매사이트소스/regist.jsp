<%@ page contentType="text/html;charset=utf-8"  pageEncoding="utf-8" import="My.*" import = "java.util.*,  java.sql.*" %>


<% 
	request.setCharacterEncoding("utf-8"); /**엔코딩 설정**/
	
	String url="jdbc:mysql://localhost:3306/auction";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "insert into member(id, password, name, jumin1, jumin2, gender, address1, address2, postnum, email, phonenumber, cellurphone, intro, habit, account_name, account_bank, account) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,request.getParameter("id"));
		pstmt.setString(2,request.getParameter("password"));
		pstmt.setString(3,request.getParameter("name"));
		pstmt.setInt(4,Integer.parseInt(request.getParameter("jumin1")));
		pstmt.setInt(5,Integer.parseInt(request.getParameter("jumin2")));
		pstmt.setString(6,request.getParameter("sex"));
		pstmt.setString(7,request.getParameter("add1"));
		pstmt.setString(8,request.getParameter("add2"));
		String post = request.getParameter("zipcode1") + request.getParameter("zipcode2");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String phonenumber = request.getParameter("phone1") + request.getParameter("phone2") + request.getParameter("phone3");
		String cellnumber = request.getParameter("cell1") + request.getParameter("cell2") + request.getParameter("cell3");
		pstmt.setInt(9,Integer.parseInt(post));
		pstmt.setString(10,email);
		pstmt.setString(14,"");
		pstmt.setString(11,phonenumber);
		pstmt.setString(12,cellnumber);
		pstmt.setString(13,request.getParameter("intro"));
		pstmt.setString(15,request.getParameter("account_name"));
		pstmt.setString(16,request.getParameter("bank"));
		pstmt.setString(17,request.getParameter("account"));
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		


	}catch(Exception e){
		out.print(e);
		return ;
	}
	
%>
