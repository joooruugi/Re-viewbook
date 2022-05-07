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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/main.css">
<%@page import="kh.semi.reviewBook.mypage.model.vo.CartVo"%>
<%@page import="java.util.ArrayList"%>
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
	<%@ include file="../../../view/template_header_login.jsp"%>
	<%
		ArrayList<CartVo> volist = (ArrayList<CartVo>) request.getAttribute("cVo");
	if (volist != null) {
	%>
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_cart">
				<li><a class="sidemenu_item sidemenu_topmenu">장바구니</a></li>
				<li><a class="sidemenu_item" href="myinformation">정보수정</a></li>
				<li><a class="sidemenu_item" href="mypagemain">마이페이지</a></li>
			</ul>
		</nav>
	</div>
	<div>
		<table class="cartlist">
			<caption>장바구니 목록</caption>
			<tr class="cartlist_th fontimportant2">
				<th class="cartlistimg">상품이미지</th>
				<th class="cartlisttitle">상품제목</th>
				<th class="cartlistwriter">저자</th>
				<th class="cartlistdate">출판일</th>
				<th class="cartlistbookno">도서번호</th>
				<th class="cartlistcnt">수량</th>
				<th class="cartlistprice">금액</th>
				<th class="cartlistdelete">삭제하기</th>
				<th class="cartlistbuy">구매하기</th>
			</tr>
			<%
				for (CartVo vo : volist) {
			%>
			<tr class="cartlisy_td fontnormal">
				<td><%=vo.getBkImg()%></td>
				<td><%=vo.getBkTitle()%></td>
				<td><%=vo.getBkWriter()%></td>
				<td><%=vo.getBkPublishdate()%></td>
				<td class="bkNo"><%=vo.getBkNo()%></td>
				<td><%=vo.getCaCount()%></td>
				<td><%=vo.getBkPrice()%></td>
				<td><button class="btn_delete button1">삭제하기</button></td>
				<td><button class="btn_buy button1">구매하기</button></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
			<%
				
			%>
		</p>
	</div>
	<%
		} else {
	%>
	<div>주문 상품이 없습니다.</div>
	<%
		}
	%>

	<script>
		{
			$(".btn_delete").on("click", deletecartHandler);
			//$(".btn_buy").on("click", buycartHandler);
		}
		function deletecartHandler() {
			console.log(this); // <button 엘리먼트
			console.log($(this).parents(".cartlisy_td").find(".bkNo").text()); // span태그
			//$("#bkNo").val($(this).children("span").text());
			var bkNoVal = $(this).parents(".cartlisy_td").find(".bkNo").text();
			location.href = "deletecart?bkNo=" + bkNoVal;
		}
		//function buycartHandler() {
		//	alert("서비스 준비중입니다.");
		//}
		/* 결제 스크립트  */
		$('.btn_buy').click(function requestPay() {
			IMP.init('imp81715131');
			IMP.request_pay({
				pg : 'inicis',
				pay_method : 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : 'ReviewBook 도서 결제',
				amount : 17800	//도서에서 금액넘어와야함. test결제라 구현어려울듯
			}, function(rsp) { // callback
				if (rsp.success) {
					msg = '결제에 성공하였습니다.';
					alert(msg);
					//성공시 이동할 페이지
					location.href = "cartlist";
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