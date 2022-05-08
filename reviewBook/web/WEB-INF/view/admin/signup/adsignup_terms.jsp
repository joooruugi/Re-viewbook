<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/signlogin/signupuser_first.css">
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
<title>RVB Admin</title>
<script src="http://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../../../view/template_header.jsp" %>
	<div class="signup_body1">
		<nav class="sidemenu">
			<ul class="sidemenu_signup1">
				<li><a class="sidemenu_item sidemenu_topmenu">관리자 회원가입</a></li>
				<li><a class="sidemenu_item signupuser_first">약관동의</a></li>
				<li><a class="sidemenu_item">정보 입력</a></li>
				<li><a class="sidemenu_item">가입 완료</a></li>
			</ul>
		</nav>
		<div class="signupuser_first_content">
			<div class="firstterms terms_signup">
				<div class="firstterms_content">
					<p class="fontnormal">개인정보 수집 이용 동의서<br><br>

- ReviewBook은 회원가입시 <br>사용자의 원활한 서비스 이용을 위해 사용자의 성함, 연락처 등 9개 항목에 대해 개인정보를 수집합니다.<br>

- 수집 항목 : 성함,  연락처, 이메일, 닉네임, 비밀번호, 성별, 주소, 생년월일, 아이디 등 (결제 서비스를 위해서는 결제정보 또한 수집합니다.)<br>

- 수집 목적 : 전반적인 서비스 이용 및 구매, 배송, 결제 처리<br>

- 수집 기간 : 회원가입시 부터 회원탈퇴시<br>

- 수집 담당자 : ReViewBook RVB 배민수 부장<br>

- 관리자로 등록하시는 경우, 소속 관리를 위해 회사 정보도 수집합니다.<br>

- 관리자 개인정보 수집 항목은 아이디, 이메일, 연락처, 닉네임, 소속회사, 비밀번호, 성별입니다.<br>

- 목적 및 기간은 사용자 처리규정과 동일합니다.<br>
				</div>

			</div>
			<!-- <div class="secondterms terms_signup">
				<div class="secondterms_content">
					<p class="fontnormal">약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야
						하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요
						약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이
						들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고
						쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고
						내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데
						뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요
						약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이
						들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고
						쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고
						내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데
						뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요
						약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이
						들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고
						쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고
						내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데
						뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요 약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요
						약관어쩌고 내용이 들어가야 하는데 뭐라고 쓸까요</p>
				</div>

			</div> -->

			<div class="thirdterms terms_signup">
				<div class="thirdterms_content">
					<p class="fontnormal">저작권 관련 약관<br><br>

- ReviewBook의 모든 저작권은 법적으로 보호받고 있습니다.<br>
- ReviewBook에 연재되는 모든 게시글의 저작권은 작성자에게 귀속됩니다.<br>
- 무단으로 수집, 복사 하거나 타 사이트에 배포, 사칭의 경우 법적 대응됨을 알려드립니다.<br>
- 연재되는 게시글 중 펀딩이 진행되는 작품에 대한 저작권 및 금액적 분쟁은 별도로 안내드릴 예정입니다. <br>(안내 및 문의 메일 : reviewbook.rvb@gmail.com)<br></p>
				</div>

			</div>
			<div class="allterms_checkbox">
				<input type="checkbox" value="1" name="agree_all">
				<p class="fontimportant2">동의</p>
			</div>
		</div>
		<div class="nextto_signupsuer">
			<a id="signup_nextbtn"
				href="#">
				<p class="fontnormal">다음으로</p>
			</a>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp" %>
	<script>
	// 동의 모두선택 / 해제
	const agreeChkAll = document.querySelector('input[name=agree_all]');
	    agreeChkAll.addEventListener('change', (e) => {
	    let agreeChk = document.querySelectorAll('input[name=agree]');
	    for(let i = 0; i < agreeChk.length; i++){
	      agreeChk[i].checked = e.target.checked;
	    }
	});
	    $("#signup_nextbtn").click(function(){
	    	if($("input:checkbox[name=agree_all]").is(":checked")==false) {  
		    	//작업 
	    		 alert('모든 항목에 동의하셔야 회원가입이 가능합니다.');
		    	}else{
		    		($("#signup_nextbtn").attr("href","http://localhost:8090/reviewBook/adsignup_input"));
		    	}
		});
	   
	    //체크여부 확인 
	    //if($("input:checkbox[name=agree_all]").is(":unchecked")) {  
	    	//작업 }
    </script>
</body>
</html>