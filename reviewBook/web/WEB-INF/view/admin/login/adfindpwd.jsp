<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signlogin/loginuser_findpwd.css">
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
	<div class="loginuser_findpwd_body">
		<div class="loginuser_findpwd_content">
			<div class="loginuser_findpwd_name">
				<p class="fontimportant2">관리자 비밀번호 찾기</p>
			</div>
			<form action="ad_findpwd.lo" method="post">

				<div class="loginuser_findpwd_text">
					<p class="fontnormal">아이디</p>
					<input type="text" name="adId" required="required">
					<p class="fontnormal">이메일</p>
					<input type="email" name="adEmail" required="required">
					<p class="fontnormal">연락처</p>
					<input type="tel" name="adPhone" required="required"
						placeholder="'000-0000-0000'형식으로 입력">
					<p class="fontnormal">닉네임</p>
					<input type="text" name="adNickname" required="required">
					<p class="fontnormal">회사</p>
					<input type="text" name="adCompany" required="required">
				</div>

				<div class="loginuser_findpwd_btn">
					<div class="loginuser_findpwd_findbtn">
						<button type="submit">비밀번호 확인</button>
					</div>
					<div class="loginuser_findpwd_loginbtn">
						<a href="<%=request.getContextPath()%>/adlogin">로그인</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>