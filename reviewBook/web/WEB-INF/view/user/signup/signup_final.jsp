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
<title>RVB</title>
</head>
<body>
	<%@ include file="../../../view/template_header.jsp"%>
	<div class="signup_body3">
		<nav class="sidemenu">
			<ul class="sidemenu_signup3">
				<li><a class="sidemenu_item sidemenu_topmenu">회원가입</a></li>
				<li><a class="sidemenu_item">약관동의</a></li>
				<li><a class="sidemenu_item">정보 입력</a></li>
				<li><a class="sidemenu_item signupuser_final">가입 완료</a></li>
			</ul>
		</nav>
		<div class="signupuser_final_content">
			<div class="signupuser_final_left">
				<p class="fontimportant">독서습관의 시작</p>
				<p class="fontimportant">RVB가 동행하겠습니다</p>
				<p class="fontimportant">환영해요 !</p>
			</div>
			<div class="signupuser_final_right">
				<a class="signupuser_final_link final_link_login" href="<%=request.getContextPath() %>/login">
					<p class="fontevent">로그인 하러가기 ></p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/bookmain">
					<p class="fontimportant2">추천 도서 보러가기 ></p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/seriesmain">
					<p class="fontimportant2">추천 연재글 보러가기 ></p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/subscribemain">
					<p class="fontimportant2">구독권 보러가기 ></p>
				</a> <a class="signupuser_final_link" href="<%=request.getContextPath() %>/fundingboardlist">
					<p class="fontimportant2">펀딩 작품 보러가기 ></p>
				</a>
			</div>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>