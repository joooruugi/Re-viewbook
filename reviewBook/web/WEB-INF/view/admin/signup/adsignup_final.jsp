<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signlogin/signupuser_final.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB Admin</title>
</head>
<body>
	<%@ include file="../../../view/template_header.jsp"%>
	<div class="signup_body3">
		<nav class="sidemenu">
			<ul class="sidemenu_signup3">
				<li><a class="sidemenu_item sidemenu_topmenu">관리자 회원가입</a></li>
				<li><a class="sidemenu_item">약관동의</a></li>
				<li><a class="sidemenu_item">정보 입력</a></li>
				<li><a class="sidemenu_item signupuser_final">가입 완료</a></li>
			</ul>
		</nav>
		<div class="signupuser_final_content">
			<div class="signupuser_final_left">
				<p class="fontimportant">RVB와 동행하는</p>
				<p class="fontimportant">관리자가 되신 걸</p>
				<p class="fontimportant">환영해요 !</p>
			</div>
			<div class="signupuser_final_right">
				<a class="signupuser_final_link final_link_login" href="<%=request.getContextPath() %>/adlogin">
					<p class="fontevent">로그인</p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/admain">
					<p class="fontimportant2">메인페이지 ></p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/userlist">
					<p class="fontimportant2">회원정보 ></p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/adnotice">
					<p class="fontimportant2">공지사항 ></p>
				</a> 
			</div>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>