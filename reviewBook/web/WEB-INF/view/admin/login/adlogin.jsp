<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signlogin/loginadmin.css">
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
 <div class="loginadmin_body">
        <div class="loginadmin_content">
            <div class="loginadmin_notice">
                <p class="fontimportant2">관리자 로그인</p>
            </div>
			<form action="<%=request.getContextPath()%>/login.lo" method="post">
				<div class="loginadmin_text">
					<p class="fontnormal">아이디</p>
					<p class="fontnormal">비밀번호</p>
				</div>
				<div class="loginadmin_input">
					<input type="text" name="adId" required="required"> <input
						type="password" name="adPassword" required="required">
				</div>
				<div class="loginadmin_link_find">
					<a class="loginadmin_link_find_id"
						href="<%=request.getContextPath() %>/adfindid">
						<p class="fontnothing">아이디 찾기</p>
					</a> <a class="loginadmin_link_find_pw"
						href="<%=request.getContextPath() %>/adfindpwd">
						<p class="fontnothing">비밀번호 찾기</p>
					</a>
				</div>
				<div class="loginadmin_btn">
					<div class="loginadmin_signupbtn">
						<button type="button" id="signupad">권한신청</button>
					</div>
					<div class="loginadmin_loginbtn">
						<button type="submit">로그인</button>
					</div>
				</div>
			</form>
		</div>
    </div>
    <%@ include file="../../../view/template_footer.jsp"%>
    <script>
    $("#signupad").click(function(){
    	location.href="singup";
    });
    </script>
</body>
</html>