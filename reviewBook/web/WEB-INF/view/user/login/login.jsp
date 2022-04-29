<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/signlogin/loginuser.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/footer.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@ include file="../../../view/template_header.jsp" %>
	<div class="loginuser_body">
        <div class="loginuser_content">
            <form action="login.lo" method="post"
            action="<%=request.getContextPath()%>/login.lo">
                <div class="loginuser_text">
                    <p class="fontnormal">아이디</p>
                    <p class="fontnormal">비밀번호</p>
                </div>
                <div class="loginuser_input">
                    <input type="text" name="usId" required="required">
                    <input type="password" name="usPassword" required="required">
                </div>
            </form>
                <div class="loginuser_link_find">
                    <a class="loginuser_link_find_id" href="<%=request.getContextPath() %>/findid">
                        <p class="fontnothing">아이디 찾기</p>
                    </a>
                    <a class="loginuser_link_find_pw" href="<%=request.getContextPath() %>/findpwd">
                        <p class="fontnothing">비밀번호 찾기</p>
                    </a>
                </div>
                <div class="loginuser_btn">
                    <div class="loginuser_signupbtn">
                        <button type="button" id="signup">회원가입</button>
                    </div>
                    <div class="loginuser_loginbtn">
                        <button type="submit" >로그인</button>
                    </div>
                </div>
        </div>
    </div>
    <%@ include file="../../../view/template_footer.jsp" %>
	<script>
		$("#signup").click(function(){
			location.href = "signup";
		});
		/* $("#findId").click(function(){
			location.href = "findId";
		});
		$("#findPwd").click(function(){
			location.href = "findPwd"; */
		});
	</script>
</body>
</html>