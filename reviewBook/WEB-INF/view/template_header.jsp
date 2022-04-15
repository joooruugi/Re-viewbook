<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap header">
    <header>
<%
	UserVo ssmvo = (UserVo)session.getAttribute("ssUserVo");
	if(ssmvo == null){
%>
	<br><button id="login">로그인</button><br>
<%
	} else {
%>
	<!--<button id="mypage">마이페이지</button><br>  -->
	<button id="logout">로그아웃</button><br>
<%
	}
%>
	<p>ReViewBook RVB!RVB!RVB!</p>
	</header>
<script>
	$("#login").click(function(){
		location.href = "login";   // a href 동일 get 방식
	});
	$("#logout").click(function(){
		location.href = "logout";
	});
	/* $("#mypage").click(function(){
		location.href = "mypage";
	}); */
</script>
</div>