<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/subscribe/subscribe.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">
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
			<div class="subscribe_cancle">
			<div class="circle"></div>
			<div class="subscribe_cancle_title">
			GoodBye RVB Subscribe!
			</div>
			<div class="subscribe_cancle_content">
			<form action="subscribecancle" method="post">
			<p><%=vo.getUsId() %>님 ! </p>
			<p> 구독을 철회하게 되면 더 이상 RVB 구독 서비스를 이용할 수 없습니다. </p>
			<p> 구독을 철회하는 경우 다음달 결제일부터 요금이 부과되지 않습니다.</p>
			<p> 구독 철회 후 다음날 오후 1시 이후부터 구독 서비스 재 이용이 가능합니다</p>
			<p> 자세한 사항은 <a href='subscribeterm'>약관</a>을 참고해주세요</p>
			<p> 반드시 아래의 구독 철회 버튼을 눌러주세요! </p>
			
			<button type="submit" class="button5">구독철회</button>
			</form>
			</div>
			</div>
			</div>	
			</div>
		
		</div>
		</div>
		<%@ include file="../../template_footer.jsp"%>

</body>
</html>