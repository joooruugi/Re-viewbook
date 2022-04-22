<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/signlogin/signupuser_second.css">
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
<title>회원가입</title>
<script src="/resources/js/signlogin/js_signup.js"></script>
</head>
<body>
	 <div class="signup_body2">
        <nav class="sidemenu">
            <ul class="sidemenu_signup2">
                <li><a class="sidemenu_item sidemenu_topmenu">회원가입</a></li>
                <li><a class="sidemenu_item">약관동의</a></li>
                <li><a class="sidemenu_item signupuser_second">정보 입력</a></li>
                <li><a class="sidemenu_item">가입 완료</a></li>
            </ul>
        </nav>
        <div class="signupuser_second_content">
            <form name="frmRegister">
                <div class="singupuser_input_info">
                    <div class="signupuser_input_text">
                        <p class="fontnormal signup_infoname">아이디</p>
                        <p class="fontnormal signup_infoname">비밀번호</p>
                        <p class="fontnormal signup_infoname">비밀번호 확인</p>
                        <p class="fontnormal signup_infoname">닉네임</p>
                        <p class="fontnormal signup_infoname">이름</p>
                        <p class="fontnormal signup_infoname">성별</p>
                        <p class="fontnormal signup_infoname">생년월일</p>
                        <p class="fontnormal signup_infoname">전화번호</p>
                        <p class="fontnormal signup_infoname">이메일</p>
                        <p class="fontnormal signup_infoname">주소</p>
                    </div>
                    <div class="signupuser_input_input">
                        <input type="text" name="usId" class="signup_infoinput" id="usId" required="required"
                            placeholder="영문자, 숫자를 사용한 6자이상 20자이하">
                        <input type="password" name="usPassword" class="signup_infoinput" id="usPassword"
                            required="required" placeholder="영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자">
                        <input type="password" name="usPassword_re" class="signup_infoinput" id="usPassword_re"
                            required="required">
                        <input type="text" name="usNickname" class="signup_infoinput" id="usNickname"
                            required="required">
                        <input type="text" name="usName" class="signup_infoinput" id="usName" required="required">
                        <input type="text" name="usGender" class="signup_infoinput" id="usGender" required="required">
                        <input type="text" name="usBirth" class="signup_infoinput" id="usBirth" required="required">
                        <input type="tel" name="usPhone" class="signup_infoinput" id="usPhone" required="required">
                        <input type="email" name="usEmail" class="signup_infoinput" id="usEmail" required="required">
                        <input type="text" name="usAddress" class="signup_infoinput" id="usAddress" required="required">
                    </div>
                    <div class="signupuser_input_btn">
                        <button type="button" id="idCheck" class="signupinfo_idcheck">
                            <p class="fontnothing signup_infobtn ">중복확인</p>
                        </button>
                        <button type="button" id="btn_email" class="signupinfo_emailcheck">
                            <p class="fontnothing signup_infobtn">이메일 인증하기</p>
                        </button>
                    </div>
                </div>
                <div class="sigupsuer_second_signupbtn">
                    <button type="button" id="btn_enroll">회원가입</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>