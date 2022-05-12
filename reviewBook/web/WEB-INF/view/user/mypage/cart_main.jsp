<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/mypage/cart.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@page import="kh.semi.reviewBook.mypage.model.vo.CartVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<meta charset="UTF-8">
<title>장바구니</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div id="main_wrap">
		<%
			UserVo vo = (UserVo) session.getAttribute("ssUserVo");
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
		//out.print(vo);
		// out.print(avo);
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
	</div>
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_cart">
				<li><a class="sidemenu_item sidemenu_topmenu">장바구니</a></li>
				<li><a class="sidemenu_item" href="myinformation">정보수정</a></li>
				<li><a class="sidemenu_item" href="mypagemain">마이페이지</a></li>
			</ul>
		</nav>
		<div class="contentrvb">
			<div class="contentmain">
				<table class="cartlist">
					<caption class="caption">장바구니 목록</caption>
					<tr class="cartlist_th fontimportant2">
						<th class="cartlistimg">상품이미지</th>
						<th class="cartlisttitle">상품제목</th>
						<th class="cartlistwriter">저자</th>
						<th class="cartlistdate">출판일</th>
						<th class="cartlistbookno">도서번호</th>
						<th class="cartlistcnt">수량</th>
						<th class="cartlistprice">금액</th>
						<th class="cartlistupdate">수량변경</th>
						<th class="cartlistdelete">삭제하기</th>
						<th class="cartlistbuy">구매하기</th>
					</tr>
					<%
						ArrayList<CartVo> volist = (ArrayList<CartVo>) request.getAttribute("cVo");
					if (volist != null && volist.size() != 0) {
					%>
					<%
						for (CartVo cvo : volist) {
					%>
					<tr class="cartlist_td fontnormal">
						<td><img src="<%=request.getContextPath()%><%=cvo.getBkImg()%>" class="bookimg"></td>
						<td class="bktitle"><%=cvo.getBkTitle()%></td>
						<td><%=cvo.getBkWriter()%></td>
						<td><%=cvo.getBkPublishdate()%></td>
						<td class="bkNo"><%=cvo.getBkNo()%></td>
						<td class="bkcnt"><%=cvo.getCaCount()%></td>
						<td class="bkprice"><%=cvo.getBkPrice()%></td>
						<td>
							<form action=updatedown method="post">
								<div class="cart_update_btn_all">
									<button class="btn_cart_update button5" type="submit">-</button>
									<div class="update_cart">
										<input type="hidden" id="bkNo" name="bkNo"
											value="<%=cvo.getBkNo()%>"> <input type="hidden"
											class="downCaCount" id="caCount" name="caCount" value="1">
									</div>
								</div>
							</form>
							<form action="updatecart" method="post">
								<div class="cart_update_btn_all">
									<button class="btn_cart_update button1" type="submit">+</button>
									<div class="update_cart">
										<input type="hidden" id="bkNo" name="bkNo"
											value="<%=cvo.getBkNo()%>"> <input type="hidden"
											class="upCaCount" id="caCount" name="caCount" value="1">
									</div>
								</div>
							</form>
						</td>
						<td><button class="btn_delete button1">삭제하기</button></td>
						<td><button class="btn_buy button1">구매하기</button></td>
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
					<td colspan="9">장바구니에 상품이 없습니다.</td>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>


	<script>
		/* 장바구니 삭제 스크립트  */
		{
			$(".btn_delete").on("click", deletecartHandler);
		}
		function deletecartHandler() {
			console.log(this); // button 엘리먼트
			console.log($(this).parents(".cartlist_td").find(".bkNo").text()); //cvo.getBkNo()
			//$("#bkNo").val($(this).children("span").text());
			var bkNoVal = $(this).parents(".cartlist_td").find(".bkNo").text();
			location.href = "deletecart?bkNo=" + bkNoVal;	//책번호 들고 이동하기
		}

		/* 결제 스크립트  */
		$('.btn_buy').click(function requestPay() {
			var bkNoVal = $(this).parents(".cartlist_td").find(".bkNo").text();		//책번호
			var price = $(this).parents(".cartlist_td").find(".bkprice").text();	//가격
			var bkcnt = $(this).parents(".cartlist_td").find(".bkcnt").text();		//수량
			var title = $(this).parents(".cartlist_td").find(".bktitle").text();	//상품명(책제목)
			IMP.init('imp81715131');
			IMP.request_pay({
				pg : 'inicis',
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : title,	//상품명(책제목)
				amount : price * bkcnt	// 가격 * 수량
			}, function(rsp) { // callback
				if (rsp.success) {
					msg = '결제에 성공하였습니다.';
					alert(msg);
					var URLEncodingVal = "buycart?bktitle="+ title +"&bkNo="+ bkNoVal;	//책제목과 책번호 들고 이동
					// alert(URLEncodingVal);
					//성공시 이동할 페이지
					location.href = URLEncodingVal;
				} else {
					msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
					//실패시 이동할 페이지
					location.href = "cartlist";
					alert(msg);
				}
			});
		})
	</script>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>