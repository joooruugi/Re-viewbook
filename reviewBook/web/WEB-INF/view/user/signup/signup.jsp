<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
	<script>
	// TODO 나머지도 유효성체크해주기
		$("#btn_enroll").click(function(){
			var usId = $("#usId").val().trim();
			var regExpId = /[A-Za-z0-9]{6,20}$/; 
			//var regExpId = /^[A-Za-z][A-Za-z0-9!_]{2,4}$/;   // 첫글자는 영문자, 영문자숫자!_으로 3-5자 입력가능
			if(!regExpId.test(mId)){
				alert("아이디 입력란에는 영문자, 숫자를 사용한 6자이상 20자이하");
				$("#usId").focus();
				return false;
			}
			
			var password = $("#usPassword").val().trim();
			if(!password || password != $("#usPassword_re").val().trim()){
				alert("패스워드 입력란과 확인란이 같지 않습니다.");
				$("#usPassword").val("");
				$("#usPassword_re").val("");
				$("#usPassword").focus();
				return false;
			}
			var regExpPassword = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,16}$/; // 영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자
			if(!regExpPassword.test(password)){
				alert("패스워드 입력란에는 영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자");
				$("#usPassword").focus();
				return false;
			}
			
			var phone = $("#usPhone").val().trim();
			var regExpPhone = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/; // 숫자3-숫자3,4-숫자4
			if(!regExpPhone.test(phone)){
				alert("전화번호 입력란에는 000-0000-0000 형식");
				$("#usPhone").focus();
				return false;
			}
			
			var frm = document.frmRegister;
			frm.action = "signup.lo";
			frm.method = "post";
			frm.submit();
		});
	</script>
</body>
</html>