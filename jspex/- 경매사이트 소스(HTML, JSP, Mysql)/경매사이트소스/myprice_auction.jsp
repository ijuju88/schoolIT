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
<script language="javascript">

function price(){
		var price = <%=request.getParameter("price")%>
		var price2 =  document.getElementById("price").value;

		if(parseInt(price2)<=parseInt(price)){
			alert("현재 가격보다는 비싸야 합니다!");
			
		}
		else {
			var url2= "com_auction2.jsp?price=" + document.getElementById("price").value + "&com_number=" + <%=request.getParameter("number")%>
		    document.location.href = url2;
		}
}
</script>
<BODY bgcolor="#FFD9EF">
<h4>원하시는 가격을 입력하세요</h4>
현재가격 : <%=request.getParameter("price")%> <br />
<input type="text" size="8" maxlength="8" name="price" id="price"><input type="button" onclick="price()" value="입력">
</BODY>
</HTML>
