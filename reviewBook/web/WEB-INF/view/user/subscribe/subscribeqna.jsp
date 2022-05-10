<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/subscribe/subscribe.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB 구독</title>
</head>
<body>
	<%	UserVo vo = (UserVo) session.getAttribute("ssUserVo");
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
		 //out.print(vo);
		// out.print(avo);
		if (vo == null && avo == null) { %>
	<%@ include file="../../../view/template_header.jsp"%>
	<% } else if (vo != null) { %>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<% } else if (avo != null) { %>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<% } %>
	<div id="main_wrap">
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_subscribe">
				<li><a class="sidemenu_item sidemenu_topmenu">구독</a></li>
				<li><a class="sidemenu_item" href="subscribemain">구독권 안내</a></li>
				<li><a class="sidemenu_item" href="subscribecancle">구독 철회</a></li>
				<li><a class="sidemenu_item" href="subscribeqna">QNA</a></li>

			</ul>
		</nav>
		<div class="contentrvb">
			<div class="contentmain">
				<div class="subscribe_qna_all">
					<div class="subscribe_qna_title">
						<h1>자주 묻는 질문</h1>
						<p>자주 묻는 질문은 이곳에서 확인해주세요!</p>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>구독 중 해지가 가능한가요?</p> 
					</div>
					<div class="subscribe_desc">
						<p>다음달부터 결제되지 않도록 언제든지 해지가 가능합니다.</p>
						<p>구독 철회는 [구독] - [구독철회]를 통해서 이용해주세요!</p>
					</div>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>주로 어떤 책이 배송되나요?</p> 
					</div>
					<div class="subscribe_desc">
						<p>주로 배송되는 책은 RVB사이트에서 평점 및 인기순위가 높은 책</p>
						<p>또는 신간도서 및 베스트셀러로 구성됩니다. </p>
					</div>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>책 배송 시간 및 요일을 지정할 수 있나요?</p> 
					</div>
					<div class="subscribe_desc">
						<p>아쉽게도 별도로 배송 시간 및 요일은 지정 불가능합니다. </p>
						<p>매월 1일 배송될 수 있도록 전월 말일에 출고 예정입니다.</p>
					</div>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>받은 책이 마음에 들지 않는데 환불이 가능한가요?</p> 
					</div>
					<div class="subscribe_desc">
						<p>먼저 RVB 서비스 이용에 감사를 드립니다.</p>
						<p>죄송하지만 서비스 구독권으로 받으신 책은 환불이 불가능합니다.</p> 
					</div>
					</div>
				</div>
				<div class="qna_etc">
				<p>RVB 구독 서비스를 이용해주셔서 감사합니다. </p>
				<p>기타 문의사항은 <a href=#>reviewbook.rvb@gmail.com</a>로 남겨주세요</p>
				</div>
			</div>
		</div>

	</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>


	<script>
//qna 제목 클릭시 창 toggle
let eleBtns= document.getElementsByClassName("subscribe_qna");
for (var i = 0; i<eleBtns.length ; i++){
  eleBtns[i].onclick = function(){
      console.log(this); // this = .onclick 앞에 있는 eleBtns[i]
      console.log(this.nextElementSibling);
      var eleNext = this.nextElementSibling;
      var isDisplay = eleNext.style.display;
      console.log(isDisplay);
      if(isDisplay =="" || isDisplay =="none"){
          eleNext.style.display="block" ;

      } else{
          eleNext.style.display="none" ;  
      }
}
}

</script>
</body>
</html>