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
	<form name="frmRegister">
		아이디:<input type="text" name="usId" id="usId" required="required" placeholder="영문자, 숫자를 사용한 6자이상 20자이하"> 
		<button type="button" id="idCheck">중복체크</button><br>
		패스워드:<input type="password" name="usPassword" id="usPassword" required="required" placeholder="영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자"><br>
		패스워드확인:<input type="password" name="usPassword_re" id="usPassword_re" required="required"><br>
 		닉네임:<input type="text" name="usNickname" id="usNickname" required="required"><br>
 		이름:<input type="text" name="usName" id="usName" required="required"><br>
 		성별:<input type="text" name="usGender" id="usGender" required="required"><br>
 		생일:<input type="text" name="usBirth" id="usBirth" required="required"><br>
		전화번호:<input type="tel" name="usPhone" id="usPhone" required="required"><br>  
		이메일:<input type="email" name="usEmail" id="usEmail" required="required">
		<button type="button" id="btn_email">이메일 인증</button><br>
 		주소:<input type="text" name="usAddress" id="usAddress" required="required"><br>
 		<button type="button" id="btn_enroll">회원가입</button>
	</form>

</body>
</html>