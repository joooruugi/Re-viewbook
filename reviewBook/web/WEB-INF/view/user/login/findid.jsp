<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/signlogin/loginuser_findid.css">
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
<title>Insert title here</title>
</head>
<body>
 <div class="loginuser_findid_body">
        <div class="loginuser_findid_content">
            <div class="loginuser_findid_name">
                <p class="fontimportant2">아이디 찾기</p>
            </div>
            <form action="us_findid.lo" method="post">

            <div class="loginuser_findid_text">
                <p class="fontnormal">이름</p>
                <p class="fontnormal">이메일</p>
            </div>
            <div class="loginuser_findid_input">
                <input type="text" name="name" required="required">
                <input type="text" name="email" required="required">
            </div>
            </form>
            <div class="loginuser_findid_btn">
                <div class="loginuser_findid_findbtn">
                    <button type="submit">아이디 확인</button>
                </div>
                <div class="loginuser_findid_findpwbtn">
                    <a href="#">비밀번호 찾기</a>
                </div>
                <div class="loginuser_findid_loginbtn">
                    <a href="#">로그인</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>