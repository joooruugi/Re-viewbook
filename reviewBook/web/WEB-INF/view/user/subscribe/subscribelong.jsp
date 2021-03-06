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
			<div class="welcome_subscribe">
			<div class="circle"></div>
			<div class="welcome">
			Welcome RVB Subscribe!
			</div>
			<div class="welcome_content">
			<form action="subscribelong" method="post">
			<p><%=vo.getUsId() %>님 ! </p>
			<p> RVB 정기 구독을 이용해주셔서 감사합니다. </p>
			<p> 매월 1일 RVB와 함께 만나요 </p>
			<p> 반드시 아래의 정기 구독 신청 완료 버튼을 눌러주세요! </p>
			<input type="hidden" name="subInf" id="subInf"value="정기구독권">
			<input type="hidden" name ="subPrice" id="subPrice" value="29900">
			<button type="submit" class="button5">정기 구독 신청 완료</button>
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