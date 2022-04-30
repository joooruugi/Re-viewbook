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
<title>RVB</title>
</head>
<body>
<%@ include file="../../../view/template_header.jsp" %>
 <div class="loginuser_findid_body">
        <div class="loginuser_findid_content">
            <div class="loginuser_findid_name">
                <p class="fontimportant2">아이디 찾기</p>
            </div>
			<form action="<%=request.getContextPath()%>/us_findid.lo" method="post">

				<div class="loginuser_findid_text">
					<p class="fontnormal">이름</p>
					<p class="fontnormal">이메일</p>
				</div>
				<div class="loginuser_findid_input">
					<input type="text" name="usName" required="required"> 
					<input type="text" name="usEmail" required="required">
				</div>
				<div class="loginuser_findid_btn">
					<div class="loginuser_findid_findbtn">
						<button type="submit">아이디 확인</button>
					</div>
					<div class="loginuser_findid_findpwbtn">
						<a href="<%=request.getContextPath() %>/findpwd">비밀번호 찾기</a>
					</div>
					<div class="loginuser_findid_loginbtn">
						<a href="<%=request.getContextPath() %>/login">로그인</a>
					</div>
				</div>
			</form>
		</div>
    </div>
    <%@ include file="../../../view/template_footer.jsp" %>
</body>
</html>