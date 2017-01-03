<%@ page contentType="text/html; charset=utf8"  pageEncoding="utf-8" session="true"   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>상품등록</TITLE>
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
<script language="javascript">

</script>
<%
	
if(!(session.isNew())){
		
	if(session.getAttribute("login.id") != null){
%>
</HEAD>

<BODY>
<style type="text/css">
.style1{font-size:12px;}

</style>
<div class="style1">
<form id="regist" name="regist" method="post" action="fileUpload.jsp" enctype="multipart/form-data">
<table width="908" height="236" border="0" align="center">
  <tr>
    <td width="902" align="center" bgcolor="#FFCCFF"> <img src="image/commdity_regist.jpg" width="250" height="45" /></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#FFE8FF"><p>
     
       <table width="500" border="0" align="center" bgcolor="#FFFFFF">
	  <tr>
		<td width="80" align="center" bgcolor="#E0E0E0">판매자 ID</td>
		<td width="410" align="left" > <%=(String)session.getAttribute("login.id") %></td>
	  </tr>
      <tr>
        <td width="80" align="center" bgcolor="#E0E0E0">상품명 </td>
        <td width="410"  >
        
            <input type="text" name="com_name" id="com_name" />
        
      </td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0">카테고리</td>
        <td align="left">대 :
          <select name="category1" id="category1">
            <option>교육/학문</option>
            <option>4</option>
          </select>
          중 :
          <select name="category2" id="category2">
            <option>자격증/수험서</option>
            <option>4</option>
          </select>
          소 :
          <select name="category3" id="category3">
            <option>워드프로세서</option>
            <option>4</option>
          </select></td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0"><p>상품설명</p>
          <p>(500자이내)</p></td>
        <td >
            <textarea name="com_context" id="com_context" cols="45" rows="8"></textarea>
          </td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0">이미지</td>
        <td >그림 1:
          <input type="file" name="image1" value="이미지1" />
          <br />
          그림 2:
         <input type="file" name="image2" value="이미지2"/>
          <br />
          그림 3:
          <input type="file" name="image3" value="이미지3"/>
		  </td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0">경매마감날짜</td>
        <td ><p>
          <select name="select2" id="select2">
            <option>2011</option>
            <option>4</option>
          </select>
          년
          <select name="select" id="select">
            <option>3</option>
            <option>4</option>
          </select>
          월
          <select name="select3" id="select3">
            <option>14</option>
            <option>15</option>
            <option>16</option>
            <option>17</option>
            <option>18</option>
          </select>
          일
          <select name="select6" id="select6">
            <option>오전</option>
          </select>
          <select name="select4" id="select4">
            <option>1</option>
          </select>
          시
          <select name="select5" id="select5">
            <option>35</option>
            <option>15</option>
            <option>16</option>
            <option>17</option>
            <option>18</option>
          </select>
          분 </p></td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0">시작 입찰가</td>
        <td align="left"><input name="startprice" type="text" id="startprice" size="10" />
          원</td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0">즉시 구입가</td>
        <td align="left"><input name="immprice" type="text" id="immprice" size="10" />
          원</td>
      </tr>
      <tr>
        <td align="center" bgcolor="#E0E0E0">배송방법</td>
        <td align="left">
		<select name="deliver_method" id="deliver">
          <option value="착불">착불</option>
          <option value="후불">후불</option>
        </select> 
          / 
          <select name="deliver" id="deliver_method">
            <option value="한진택배">한진택배</option>
            <option value="우체국">우체국</option>
          </select></td>
      </tr>

      <tr>
        <td align="center" bgcolor="#E0E0E0">&nbsp;</td>
        <td >
		 <input type="submit" name="button4" id="button4" value="등록" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </label>
        <input type="submit" name="button5" id="button5" value="취소" />
		</td>
      </tr>
    </table>
     
</tr>
</table>
        
</form>

</BODY>
</html>
<%		}
	
	else{
%>
<script>
alert("로그인부터 해주세요!");
document.location.href="login2.jsp";
	</script>
	<% }
	
}%>
