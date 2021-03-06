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
<title>RVB</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%@ include file="../../../view/template_header.jsp"%>
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
			<form name="frmRegister" method="post"
				action="<%=request.getContextPath()%>/signup_input.lo">
				<table class="singupuser_input_info">
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">아이디</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usId" class="signup_infoinput" id="usId"
							required="required" placeholder="영문자, 숫자를 사용한 6자이상 20자이하"></td>
						<td class="signupuser_input_btn">
							<button type="submit" id="idCheck" class="signupinfo_idcheck"
								onclick="winopen()">
								<p class="fontnothing signup_infobtn ">중복확인</p>
							</button>
						</td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">비밀번호</p>
						</td>
						<td class="signupuser_input_input"><input type="password"
							name="usPassword" class="signup_infoinput" id="usPassword"
							required="required" placeholder="영문자, 숫자, 특수문자가 적어도 1개이상, 8~16글자"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">닉네임</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usNickname" class="signup_infoinput" id="usNickname"
							required="required"></td>
						<td class="signupuser_input_btn">
							<button type="submit" id="nickCheck" class="signupinfo_idcheck"
								onclick="winopen2()">
								<p class="fontnothing signup_infobtn ">중복확인</p>
							</button>
						</td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">이름</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usName" class="signup_infoinput" id="usName"
							required="required"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">성별</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usGender" class="signup_infoinput" id="usGender"
							required="required" placeholder="'F' 또는 'M' 한글자만 입력"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">생년월일</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usBirth" class="signup_infoinput" id="usBirth"
							required="required" placeholder="'YY/MM/DD' 형식으로 입력"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">전화번호</p>
						</td>
						<td class="signupuser_input_input"><input type="tel"
							name="usPhone" class="signup_infoinput" id="usPhone"
							required="required" placeholder="'000-0000-0000' 형식으로 입력"></td>
					</tr>
					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">주소</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usAddress" class="signup_infoinput" id="usAddress"
							required="required"></td>
					</tr>

					<tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">이메일</p>
						</td>
						<td class="signupuser_input_input"><input type="email"
							name="usEmail" class="signup_infoinput" id="usEmail"
							required="required"></td>
						<!-- <td class="signupuser_input_btn"><button type="submit"
								id="btn_email" class="signupinfo_emailcheck">
								<p class="fontnothing signup_infobtn">이메일 인증하기</p>
							</button></td> -->
					</tr>
					<!-- <tr>
						<td class="signupuser_input_text">
							<p class="fontnormal signup_infoname">인증번호</p>
						</td>
						<td class="signupuser_input_input"><input type="text"
							name="usEmail_chk" class="signup_infoinput" id="usEmail"
							required="required"></td>
						<td class="signupuser_input_btn"><button type="submit"
								id="btn_email_chk" class="signupinfo_emailcheck">
								<p class="fontnothing signup_infobtn">인증확인</p>
							</button></td>
					</tr> -->

				</table>
				<div class="sigupsuer_second_signupbtn">
					<button type="submit" id="btn_enroll">회원가입</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
	<script>
		// TODO 나머지도 유효성체크해주기
		$("#btn_enroll")
				.click(
						function() {
							console.log("a");
							var usId = $("#usId").val().trim();
							var regExpId = /[A-Za-z0-9]{6,20}$/;
							//var regExpId = /^[A-Za-z][A-Za-z0-9!_]{2,4}$/;   // 첫글자는 영문자, 영문자숫자!_으로 3-5자 입력가능
							if (!regExpId.test(mId)) {
								alert("아이디 입력란에는 영문자, 숫자를 사용한 6자이상 20자이하");
								$("#usId").focus();
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
								$("#usPassword").focus();
								return false;
							}

							var phone = $("#usPhone").val().trim();
							var regExpPhone = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/; // 숫자3-숫자3,4-숫자4
							if (!regExpPhone.test(phone)) {
								alert("전화번호 입력란에는 000-0000-0000 형식");
								$("#usPhone").focus();
								return false;
							}

							var frm = document.frmRegister;
							frm.action = "signup_input.lo";
							frm.method = "post";
							frm.submit();
						});

		function winopen() {
			window.open("signup_check?usId=" + document.frmRegister.usId.value,
					"", "width=500, height=150");
			/* function result(){
		    	//팝업창의 아이디정보를 회원가입창에 아이디정보로 전달
		    	//팝업창은 기존창과 종속관계를 가지고 있으므로 opener를 이용하면 된다.
		    	//alert("팝업창의 id값"+document.wfr.userid.value + ", 회원가입창의 id값 : " +opener.document.fr.id.value)
		    	//6-1. 회원가입페이지의 id값에 아이디중복으로 선택된 id값을 대입.
		    	opener.document.frmRegister.usId.value = document.wfr.usId.value;
		    	
		    	//6-3. 회원가입창 제어
		    	//readonly 속성제어(커멜표기가 아닐때는 제어가 안됨 신기하네 ㅋㅋㅋ)
		    	opener.document.fr.id.readOnly=true;
		    	
		    	//6-2. 창닫기
		    	window.close();
		    } */
		}
		function winopen2() {
			window.open("signup_checknick?usNickname="
					+ document.frmRegister.usNickname.value, "",
					"width=500, height=300");
		}
		/* function winopen3() {
			window.open("gmailsendaction?usEmail="
					+ document.frmRegister.usEmail.value, "",
					"width=500, height=300")
		}
		function winopen4() {
			window.open("gmailcheckaction", "", "width=500, height=300")
		} */
	</script>
</body>
</html>