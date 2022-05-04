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
	href="<%=request.getContextPath()%>/resources/css/all/body.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/funding/funding.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/series/seriesmain.css">

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
		</div>
		<div class="contentfd">
			<div class="contentmainfd">

				<!-- TODO 작품 받아와서 슬라이딩으로 구성하기 -->
				<h2 class="fontimportant fdtag">최근에 펀딩에 성공했어요😘</h2>
				<!-- Swiper -->
				<div class="swiper mySwiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter1.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter2.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter3.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter4.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter5.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter6.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter7.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter1.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter2.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter3.jpg" class="bookimg">
						</div>
					</div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
					<div class="swiper-pagination"></div>
				</div>
				<h2 class="fontimportant fdtag">판매량 TOP</h2>
				<!-- Swiper -->
				<div class="swiper mySwiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter1.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter2.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter3.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter4.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter5.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter6.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter7.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter1.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter2.jpg" class="bookimg">
						</div>
						<div class="swiper-slide">
							<img src="./resources/image/funding/harrypotter3.jpg" class="bookimg">
						</div>
					</div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
					<div class="swiper-pagination"></div>
				</div>
				<!-- Initialize Swiper -->
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
				<%-- <!-- 요걸 슬라이딩 하는 구조로 구현해서 태그별로 for문 돌리기?  -->
				<%
					ArrayList<SeriesVo> slist = (ArrayList<SeriesVo>) request.getAttribute("slist");
				//out.print(slist);
				%>
				<table id="series_list">
					<tr>
						<td>
							<ul>
								<%
									for (SeriesVo svo : slist) {
								%>
								<li>
									<div class="bbs_board">
										<div class="bbs_title">
											<a href="seriesread?wbNo=<%=svo.getWbNo()%>"><%=svo.getWbTitle()%>
												[<%=svo.getReCommentCnt()%>]</a> <span><%=svo.getWbWriter()%></span>

										</div>

										<br>
										<div class="bbs_content">
											<p>
												<a href="seriesread?wbNo=<%=svo.getWbNo()%>"><%=svo.getWbContent()%></a>
											</p>
										</div>
										<div class="bbs_date_ctgory"><%=svo.getWbDate().substring(0, 16)%>
											<span><%=svo.getWbCategory()%></span>
										</div>
										<br>
								</li>
								</div>
								<%
									}
								%>
							</ul>
						</td>
					</tr>
				</table> --%>
			</div>
		</div>
</body>
</html>