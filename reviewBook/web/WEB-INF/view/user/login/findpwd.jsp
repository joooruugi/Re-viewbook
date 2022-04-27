<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/signlogin/loginuser_findpwd.css">
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
</head>
<body>
<%@ include file="../../../view/template_header.jsp" %>
<div class="loginuser_findpwd_body">
        <div class="loginuser_findpwd_content">
            <div class="loginuser_findpwd_name">
                <p class="fontimportant2">비밀번호 찾기</p>
            </div>
            <form action="us_findpwd.lo" method="post">

            <div class="loginuser_findpwd_text">
                <p class="fontnormal">이름</p>
                <p class="fontnormal">아이디</p>
                <p class="fontnormal">이메일</p>
            </div>
            <div class="loginuser_findpwd_input">
                <input type="text" name="name" required="required">
                <input type="text" name="id" required="required">
                <input type="text" name="email" required="required">
            </div>
            </form>
            <div class="loginuser_findpwd_btn">
                <div class="loginuser_findpwd_findbtn">
                    <button type="submit">비밀번호 재전송</button>
                </div>
                <div class="loginuser_findpwd_loginbtn">
                    <a href="<%=request.getContextPath() %>/login">로그인</a>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="../../../view/template_footer.jsp" %>
</body>
</html>