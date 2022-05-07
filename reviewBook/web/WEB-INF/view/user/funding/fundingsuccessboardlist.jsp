<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/funding/funding.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩성공작</title>
<!-- Swiper -->
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>
	<div id="main_wrap">
		<%@ include file="../../template_header_login.jsp"%>
		<div class="bodyfd">
			<nav class="sidemenu">
				<ul class="sidemenu_funding">
					<li><a class="sidemenu_item sidemenu_topmenu">펀딩</a></li>
					<li><a class="sidemenu_item" href="fundingboardlist">펀딩진행중</a></li>
					<li><a class="sidemenu_item" href="fundingsuccessboardlist">펀딩성공작</a></li>
				</ul>
			</nav>
			<%
			ArrayList<SeriesVo> slistFiction = (ArrayList<SeriesVo>) request.getAttribute("slistFiction");
			ArrayList<SeriesVo> slistInfo = (ArrayList<SeriesVo>) request.getAttribute("slistInfo");
			ArrayList<SeriesVo> slistDaily = (ArrayList<SeriesVo>) request.getAttribute("slistDaily");
			ArrayList<SeriesVo> slistEtc = (ArrayList<SeriesVo>) request.getAttribute("slistEtc");
			if (slistFiction != null || slistInfo != null || slistDaily != null || slistEtc != null) {
			%>
			<div class="contentfd">
				<div class="contentmainfd">

					<!-- TODO 작품 받아와서 슬라이딩으로 구성하기 -->
					<h2 class="fontimportant fdtag">문학게시글 TOP😘</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
						<%
						for (SeriesVo svo : slistFiction) {
						%>
							<div class="swiper-slide">
								<img src="<%=request.getContextPath()%><%=svo.getWbImgPath()%>"
									class="bookimg">
							</div>
						<% } %>
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					
					<h2 class="fontimportant fdtag">정보공유 TOP😘</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
						<%
						for (SeriesVo svo : slistInfo) {
						%>
							<div class="swiper-slide">
								<img src="<%=request.getContextPath() %><%=svo.getWbImgPath()%>"
									class="bookimg">
							</div>
						<% } %>	
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					<h2 class="fontimportant fdtag">일상게시글 TOP😘</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
						<%
						for (SeriesVo svo : slistDaily) {
						%>
							<div class="swiper-slide">
								<img src="<%=request.getContextPath() %><%=svo.getWbImgPath()%>"
									class="bookimg">
							</div>
						<% } %>
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					
					<h2 class="fontimportant fdtag">기타게시글 TOP😘</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
						<%
						for (SeriesVo svo : slistEtc) {
						%>
							<div class="swiper-slide">
								<img src="<%=request.getContextPath() %><%=svo.getWbImgPath()%>"
									class="bookimg">
							</div>
						<% } %>	
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					
					
				</div>
				<% } %>
			</div>
		</div>
		<%@ include file="../../template_footer.jsp"%>
	</div>
	<script>
		var swiper = new Swiper(".mySwiper", {
			slidesPerView : 5,
			spaceBetween : 20,
			slidesPerGroup : 5,
			loop : true,
			loopFillGroupWithBlank : true,
			autoplay : { // 자동 슬라이드 설정 , 비 활성화 시 false
				delay : 10000, // 시간 설정
				disableOnInteraction : false, // false로 설정하면 스와이프 후 자동 재생이 비활성화 되지 않음
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
</body>
</html>