<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signlogin/signupuser_second.css">
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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>RVB Admin</title>
</head>
<body>
	<%@ include file="../../../view/template_header.jsp"%>
	<div class="signup_body2">
		<nav class="sidemenu">
			<ul class="sidemenu_signup2">
				<li><a class="sidemenu_item sidemenu_topmenu">관리자 회원가입</a></li>
				<li><a class="sidemenu_item">약관동의</a></li>
				<li><a class="sidemenu_item signupuser_second">정보 입력</a></li>
				<li><a class="sidemenu_item">가입 완료</a></li>
			</ul>
		</nav>
		<div class="signupuser_second_content">
			<form name="frmRegisterad" method="post"
				action="<%=request.getContextPath()%>/adsignup_input.lo">
				<table class="singupuser_input_info">
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">아이디</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="adId" class="signup_infoinput" id="adId"
							required="required" placeholder="영문자, 숫자를 사용한 6자이상 20자이하"></td>
						<td class="signupuser_input_btn">
							<button type="submit" id="idCheck" onclick="winopenad()"
								class="signupinfo_idcheck">
								<p class="fontnothing signup_infobtn ">중복확인</p>
							</button>
						</td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">비밀번호</p>
						</td>
						<td class="signupuser_input_input"><input type="password"
							name="adPassword" class="signup_infoinput" id="adPassword"
							required="required" placeholder="영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">닉네임</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="adNickname" class="signup_infoinput" id="adNickname"
							required="required"></td>
						<td class="signupuser_input_btn">
							<button type="submit" id="idCheck" onclick="winopenad2()"
								class="signupinfo_idcheck">
								<p class="fontnothing signup_infobtn ">중복확인</p>
							</button>
						</td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">성별</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="adGender" class="signup_infoinput" id="adGender"
							required="required" placeholder="'F' 또는 'M' 한글자만 입력"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">전화번호</p>
						</td>
						<td class="signupuser_input_input"><input type="tel"
							name="adPhone" class="signup_infoinput" id="adPhone"
							required="required" placeholder="'000-0000-0000' 형식으로 입력"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">이메일</p>
						</td>
						<td class="signupuser_input_input"><input type="email"
							name="adEmail" class="signup_infoinput" id="adEmail"
							required="required"></td>
						<td class="signupuser_input_btn"><button type="submit"
								id="btn_email" class="signupinfo_emailcheck">
								<p class="fontnothing signup_infobtn">이메일 인증하기</p>
							</button></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">인증번호</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="adEmail_chk" class="signup_infoinput" id="adEmail"
							required="required"></td>
						<td class="signupuser_input_btn"><button type="submit"
								id="btn_email_chk" class="signupinfo_emailcheck">
								<p class="fontnothing signup_infobtn">인증확인</p>
							</button></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">회사(소속)</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="adCompany" class="signup_infoinput" id="adCompany"
							required="required"></td>
					</tr>
				</table>
				<div class="sigupsuer_second_signupbtn">
					<button type="submit" id="adbtn_enroll">권한신청</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
	<script>
		$("#adbtn_enroll")
				.click(
						function() {
							console.log("a");
							var usId = $("#adId").val().trim();
							var regExpId = /[A-Za-z0-9]{6,20}$/;
							//var regExpId = /^[A-Za-z][A-Za-z0-9!_]{2,4}$/;   // 첫글자는 영문자, 영문자숫자!_으로 3-5자 입력가능
							if (!regExpId.test(mId)) {
								alert("아이디 입력란에는 영문자, 숫자를 사용한 6자이상 20자이하");
								$("#adId").focus();
								return false;
							}
							//비밀번호 확인 입력칸 삭제 
							/*var password = $("#usPassword").val().trim();
							if(!password || password != $("#usPassword_re").val().trim()){
								alert("패스워드 입력란과 확인란이 같지 않습니다.");
								$("#usPassword").val("");
								$("#usPassword_re").val("");
								$("#usPassword").focus();
								return false;
							}*/
							var regExpPassword = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,16}$/; // 영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자
							if (!regExpPassword.test(password)) {
								alert("패스워드 입력란에는 영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자");
								$("#adPassword").focus();
								return false;
							}

							var phone = $("#adhone").val().trim();
							var regExpPhone = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/; // 숫자3-숫자3,4-숫자4
							if (!regExpPhone.test(phone)) {
								alert("전화번호 입력란에는 000-0000-0000 형식");
								$("#adPhone").focus();
								return false;
							}

							var frm = document.frmRegisterad;
							frm.action = "adsignup_input.lo";
							frm.method = "post";
							frm.submit();
						});

		function winopenad() {
			window.open("adsignup_checkid?adId="
					+ document.frmRegisterad.adId.value, "",
					"width=500, height=150");
		}
		function winopenad2() {
			window.open("adsignup_checknick?adNickname="
					+ document.frmRegisterad.adNickname.value, "",
					"width=500, height=150");
		}
	</script>
</body>
</html>