/**
 * 
 */
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