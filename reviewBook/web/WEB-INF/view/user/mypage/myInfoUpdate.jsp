<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/mypage/myinfoupdate.css">
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<div class="infoupdate_body">
		<nav class="sidemenu">
			<ul class="sidemenu_infoupdate">
				<li><a class="sidemenu_item sidemenu_topmenu">회원정보 수정</a></li>
				<li><a class="sidemenu_item">수정 완료</a></li>
			</ul>
		</nav>
		<div class="infoupdate_content">
			<form name="frmRegister" method="post">
				<table class="update_input_info">
					<tr>
						<td class="infoupdate_input_text">
							<p class="fontnormal update_infoname">아이디</p>
						</td>
						<td class="infoupdate_input_input"><input type="text"
							name="usId" class="update_infoinput" id="usId" disabled
							value="${myinfovo.usId}"></td>
					</tr>
					<tr>
						<td class="infoupdate_input_text">
							<p class="fontnormal update_infoname">이름</p>
						</td>
						<td class="infoupdate_input_input"><input type="text"
							name="usName" class="update_infoinput" id="usName" disabled
							value="${myinfovo.usName}"></td>
					</tr>
					<tr>
						<td class="infoupdate_input_text">
							<p class="fontnormal update_infophone">전화번호</p>
						</td>
						<td class="infoupdate_input_input"><input type="tel"
							name="usPhone" class="update_infoinput" id="usPhone" value="${myinfovo.usPhone}"
							required pattern="\d{3}\-\d{4}\-\d{4}" title="000-0000-0000 형식으로 입력 바랍니다."></td>
					</tr>
					<tr>
						<td class="infoupdate_input_text">
							<p class="fontnormal update_infoemail">이메일</p>
						</td>
						<td class="infoupdate_input_input"><input type="email"
							name="usEmail" class="update_infoinput" id="usEmail" value="${myinfovo.usEmail}"
							required="required"></td>
					</tr>
					<tr>
						<td class="infoupdate_input_text">
							<p class="fontnormal update_infoaddress">주소</p>
						</td>
						<td class="infoupdate_input_input"><input type="text"
							name="usAddress" class="update_infoinput" id="usAddress" value="${myinfovo.usAddress}"
							required="required"></td>
					</tr>
				</table>
				<div class="infoupdate_btn">
					<button type="submit" id="btn_update">수정완료</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
	<script>
		// 유효성 검사
		$("#btn_update").click(function() {
			var phone = $("#usPhone").val().trim();
			var regExpPhone = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/; // 숫자3-숫자3,4-숫자4
			if (!regExpPhone.test(phone)) {
				alert("전화번호 입력란에는 000-0000-0000 형식으로 입력해주세요.");
				$("#usPhone").focus();
				return false;
			}

			var frm = document.frmRegister;
			frm.action = "myinfoupdate.lo";
			frm.method = "post";
			frm.submit();
		});
		
		// input박스 클릭했을 때 기존정보 없애줌
		 $("#usPhone").click(function(){
			 $("#usPhone").val("");
		 });
		 $("#usEmail").click(function(){
			 $("#usEmail").val("");
		 });
		 $("#usAddress").click(function(){
			 $("#usAddress").val("");
		 });
	</script>
</body>
</html>