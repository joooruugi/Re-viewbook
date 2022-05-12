<%@page import="kh.semi.reviewBook.mypage.model.vo.UserSubVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/mypage/mypagemain.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@page import="kh.semi.reviewBook.mypage.model.vo.BuyListVo"%>
<%@page import="kh.semi.reviewBook.mypage.model.vo.SubscribeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>

	<%@ include file="../../../view/template_header_login.jsp"%>
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_mypage">
				<li><a class="sidemenu_item sidemenu_topmenu">마이페이지</a></li>
				<li><a class="sidemenu_item" href="myinformation">정보수정</a></li>
				<li><a class="sidemenu_item" href="cartlist">장바구니</a></li>
			</ul>
		</nav>

		<%
			UserVo vo = (UserVo) session.getAttribute("ssUserVo");
		UserSubVo usVo = (UserSubVo) request.getAttribute("usVo");
		%>
		<div class="contentrvb">
			<div class="contentmain">
				<div class="mypage_main">
					<div class="mypage_tab_header">
						<div class="mypage_main_welcome_title">
							<h2><%=vo.getUsId()%>님 반갑습니다!😘
							</h2>
						</div>
					</div>
					<%
						if (usVo == null || usVo.getSubYN().charAt(0) == 'n') {
					%>
					<div class="mypage_content_all">
						<div class="mypage_tab_body">
							<div class="mypage_main_image">
								<img src="./resources/image/mypage/mypage1.png">
							</div>
							<div class="mypage_main_content">
								<h3>구독중인 구독권이 없습니다.</h3>
							</div>
						</div>
					</div>

					<%
						} else {
					%>
					<div class="mypage_content_all">
						<div class="mypage_tab_body">
							<div class="mypage_main_image">
								<img src="./resources/image/mypage/mypage1.png">
							</div>
							<div class="mypage_main_content">
								<h3>
									구독중인 구독권 :
									<%=usVo.getSubInf()%></h3>
								<h3>
									구독 시작일 :
									<%=usVo.getSubStart()%></h3>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>




				<div class="buylist_wrap">
					<table class="buylist">
						<caption class="caption">구매목록</caption>
						<tr class="buylist_th fontimportant2">
							<th class="buylistno">주문번호</th>
							<th class="buylistname">주문상품</th>
							<th class="buylistdate">주문날짜</th>
							<th class="buylistreview">상품리뷰</th>
						</tr>
						<%
							ArrayList<BuyListVo> volist = (ArrayList<BuyListVo>) request.getAttribute("bLVo");
						if (volist != null && volist.size() != 0) {
						%>
						<%
							for (BuyListVo bvo : volist) {
						%>
						<tr class="buylist_td fontnormal">
							<td><%=bvo.getOrNum()%></td>
							<td><%=bvo.getBkTitle()%></td>
							<td><%=bvo.getOrDate()%></td>
							<%
								if (bvo.getRvNum() == 0) {
							%>
							<td><button class="btn_modal button1">
									<span style="display: none;"><%=bvo.getBkNo()%></span>리뷰작성
								</button></td>
							<%
								} else {
							%>
							<td>작성 완료</td>
							<%
								}
							%>
						</tr>
						<%
							}
						%>
					<p>
						<%
							
						%>
					</p>

					<%
						} else {
					%>
					<td colspan="4">주문 상품이 없습니다.</td>
					<%
						}
					%>
					</table>
				</div>
			</div>
		</div>
	</div>



	<div id="modal_wrap">
		<div class="modal">
			<!-- 여기에는 아무 내용 적지 않음. - 대체로 -->
			<div class="modal_content">
				<!-- 여기에 내용 작성 -->
				<div class="close">&#9932;</div>
				<div class="buyreivew">
					<form action="insertreview" method="post">
						<br> <input type="text" id="rvTitle" name="rvTitle"
							placeholder="제목을 입력해주세요." required="required">
						<div class="star-rating">
							<input type="radio" id="5-stars" name="rvRating" value="5" /> <label
								for="5-stars" class="star">&#9733;</label> <input type="radio"
								id="4-stars" name="rvRating" value="4" /> <label for="4-stars"
								class="star">&#9733;</label> <input type="radio" id="3-stars"
								name="rvRating" value="3" /> <label for="3-stars" class="star">&#9733;</label>
							<input type="radio" id="2-stars" name="rvRating" value="2" /> <label
								for="2-stars" class="star">&#9733;</label> <input type="radio"
								id="1-star" name="rvRating" value="1" /> <label for="1-star"
								class="star">&#9733;</label>
						</div>
						<textarea id="rvContent" name="rvContent"
							placeholder="리뷰를 입력해주세요. 한번 등록한 별점은 수정이 불가능합니다."
							required="required"></textarea>
						<input type="hidden" name="bkNo" id="bkNo" value="">
						<button type="submit" id="btn_submit_review" class="button1">리뷰등록</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		//window.onload = pageLoadedHandler;
		//function pageLoadedHandler()
		{
			$(".btn_modal").on("click", openModalHandler);
			$(".close").on("click", closeModalHandler);
			//$(".modal").on("click", closeModalWindowHandler);
		}
		function openModalHandler() {
			console.log(this); // <button 엘리먼트
			console.log($(this).children("span")); // span태그
			console.log($(this).children("span").text());
			$("#bkNo").val($(this).children("span").text());
			$(".modal").slideDown(200);
		}
		function closeModalHandler() {
			$(".modal").slideUp();
		}
		function closeModalWindowHandler() {
			if (event.target == $(".modal").get(0)
					|| event.target == $(".close").get(0)) {
				$(".modal").slideUp(300);
			}
		}
	</script>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>