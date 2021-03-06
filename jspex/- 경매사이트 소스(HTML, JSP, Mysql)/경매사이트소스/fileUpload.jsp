<%@ page contentType="text/html; charset=utf8" session="false"  pageEncoding="utf-8"  language="java" import="com.oreilly.servlet.*, MyBean.Util, com.oreilly.servlet.multipart.*, java.util.*, java.io.*" import="java.sql.*" %>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
	HttpSession session = request.getSession(false);
   request.setCharacterEncoding("utf-8"); 

   	String url="jdbc:mysql://localhost:3306/auction";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ServletContext context= getServletContext();
	String realFolader = context.getRealPath("upload");
	int maxsize =  1024*1024*8;

	
	try{
		
		MultipartRequest multi = new MultipartRequest(request, realFolader, maxsize, "utf-8", new DefaultFileRenamePolicy());
		String id = (String)session.getAttribute("login.id");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"admin","1234");
		String sql = "insert into commodity(buyer,seller, com_number, com_name , category, com_context, photo1, photo2, photo3, price, imm_price, deliver, deliver_method) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,"no");
		pstmt.setString(2,id);
		pstmt.setInt(3,1);
		pstmt.setString(4, multi.getParameter("com_name"));
		pstmt.setString(5,"no");
		pstmt.setString(6, multi.getParameter("com_context"));
		pstmt.setString(7, multi.getFilesystemName("image1"));
		pstmt.setString(8, multi.getFilesystemName("image2"));
		pstmt.setString(9, multi.getFilesystemName("image3"));
		pstmt.setInt(10, Integer.parseInt(multi.getParameter("startprice")));
		pstmt.setInt(11, Integer.parseInt(multi.getParameter("immprice")));
		pstmt.setString(12, multi.getParameter("deliver"));
		pstmt.setString(13, multi.getParameter("deliver_method"));
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		


	}catch(Exception e){
		
		out.print(e);
		return ;
	}

%>
<script language="javascript">
	alert("상품이 등록되었습니다!");
	history.go(-2);
</script>
