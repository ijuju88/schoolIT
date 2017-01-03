<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	String id="";
 	try{
 		id=(String)session.getAttribute("id");
 		if(id==null||id.equals("")){
 %>
 <div id="status">
 	<ul>
 		<li><label for="id">아 이 디</label>
 		<input type="email" name="id" id="id" maxlength=50 size=20 
 				placeholder="example@naver.com">
 		<li><label for="passwd">비밀번호</label>
 		<input type="password" name="passwd" id="passwd">
 		<li class="label2">
 		<button id="login">로그인</button>
 		<button id="register">회원가입</button>
 	</ul>

 </div>
 
 <%
 		}else{
 %>
 	<div id="status">
 	<ul>
 	<li><b><%=id %></b>님이 로그인 하였습니다.
 	<li class="label2">
 	<button id="logout">로그아웃</button>
 	<button id="update">회원정보 변경</button>
 	</ul>
 	</div>
 <% 			
 		}
 	}catch(Exception e){e.printStackTrace();}
 %>
