<%@page import="kh.semi.reviewBook.book.model.vo.BookVo"%>
<%@page import="java.util.ArrayList"%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/bookmain.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB Book</title>
<!-- Swiper -->
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>
	<%
		UserVo vo = (UserVo) session.getAttribute("ssUserVo");
	AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
	// out.print(vo);
	if (vo == null && avo == null) {
	%>
	<%@ include file="../../../view/template_header.jsp"%>
	<%
		} else if (vo != null) {
	%>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<%
		} else if (avo != null) {
	%>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<%
		}
	%>
	<div id="main_wrap">
		<div class="bodyfd">
			<nav class="sidemenu">
				<ul class="sidemenu_funding">
					<li><a class="sidemenu_item sidemenu_topmenu">도서</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="booklistth">스릴러</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="booklistheal">힐링</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="booklistro">로맨스</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="booklistself">자기개발</a></li>
				</ul>
			</nav>
			<%
				ArrayList<BookVo> blistOrderBest = (ArrayList<BookVo>) request.getAttribute("blistOrderBest");
			ArrayList<BookVo> blistRating = (ArrayList<BookVo>) request.getAttribute("blistRating");
			ArrayList<BookVo> blistReview = (ArrayList<BookVo>) request.getAttribute("blistReview");
			%>
			<div class="contentfd">
				<div class="bookmainname">
					<p class="fontimportant">🎈 도서 랭킹 🎈</p>
				</div>
				<div class="contentmainfd">

					<%
						if (blistOrderBest != null && blistOrderBest.size() > 0) {
					%>
					<!-- TODO 작품 받아와서 슬라이딩으로 구성하기 -->
					<h2 class="fontimportant fdtag">판매 순위✔</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
							<%
								for (BookVo svo : blistOrderBest) {
							%>
							<div class="swiper-slide">
								<a href="bookcontent?bkNo=<%=svo.getBkNo()%>"> <img
									src="<%=request.getContextPath()%><%=svo.getBkImg()%>"
									class="bookimg">
									<div class="fontnormal bookname"><%=svo.getBkTitle()%></div>
								</a>
							</div>
							<%
								}
							%>
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					<%
						}
					%>
					<%
						if (blistRating != null && blistRating.size() > 0) {
					%>
					<h2 class="fontimportant fdtag">별점 순위⭐</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
							<%
								for (BookVo svo : blistRating) {
							%>
							<div class="swiper-slide">
								<a href="bookcontent?bkNo=<%=svo.getBkNo()%>"> <img
									src="<%=request.getContextPath()%><%=svo.getBkImg()%>"
									class="bookimg">
									<div class="fontnormal bookname"><%=svo.getBkTitle()%></div>
								</a>
							</div>
							<%
								}
							%>
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					<%
						}
					%>
					<%
						if (blistReview != null && blistReview.size() > 0) {
					%>
					<h2 class="fontimportant fdtag">리뷰 순위🎉</h2>
					<!-- Swiper -->
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
							<%
								for (BookVo svo : blistReview) {
							%>
							<div class="swiper-slide">
								<a href="bookcontent?bkNo=<%=svo.getBkNo()%>"> <img
									src="<%=request.getContextPath()%><%=svo.getBkImg()%>"
									class="bookimg">
									<div class="fontnormal bookname"><%=svo.getBkTitle()%></div>
								</a>
							</div>
							<%
								}
							%>
						</div>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
					<%
						}
					%>

				</div>

			</div>
		</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>
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