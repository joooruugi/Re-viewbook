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
						<p>질문1ㅇㅇㅇ </p> 
					</div>
					<div class="subscribe_desc">
						<p>질문에 들어갈내용 대충 답변 뭐라써야하지....하하하하</p>
					</div>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>질문2ㅇㅇㅇ </p> 
					</div>
					<div class="subscribe_desc">
						<p>질문에 들어갈내용 대충 답변 뭐라써야하지....하하하하</p>
					</div>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>질문3ㅇㅇㅇ </p> 
					</div>
					<div class="subscribe_desc">
						<p>질문에 들어갈내용 대충 답변 뭐라써야하지....하하하하</p>
					</div>
					</div>
					<div class="qna">
					<div class="subscribe_qna">
						<p>질문4ㅇㅇㅇ </p> 
					</div>
					<div class="subscribe_desc">
						<p>질문에 들어갈내용 대충 답변 뭐라써야하지....하하하하</p> 
					</div>
					</div>
				</div>
				<div class="qna_etc">
				기타 문의사항은 <a href=#>ReviewBook@gmail.com</a>로 남겨주세요
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