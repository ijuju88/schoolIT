<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/register.js" type="text/javascript"></script>

<div id="regForm" class="box">
<ul>
	<li><label for="id">아이디</label>
	<input id="id" name="id" size=20 maxlength=50>
	<button id="checkId">아이디 중복확인</button>
	<li><label for="passwd">비밀번호</label>
	<input id="passwd" name="passwd" maxlength=16>
	<li><label for="repass">비밀번호 재입력</label>
	<input id="repass" name="repass" maxlength=16>
	<li><label for="name">이름</label>
	<input id="name" name="name" maxlength=50>
	<li><label for="address">주소</label>
	<input id="address" name="address" maxlength=50>
	<li><label for="tel">전화번호</label>
	<input id="tel" name="tel" maxlength=20>
	<li class="label2">
	<button id="process">가입하기</button>
	<button id="cancle">취소</button>
</ul>
</div>