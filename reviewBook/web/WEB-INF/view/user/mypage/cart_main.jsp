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
			<ul class="sidemenu_mypage">
				<li><a class="sidemenu_item sidemenu_topmenu">장바구니</a></li>
				<li><a class="sidemenu_item" href="#">정보수정</a></li>
				<li><a class="sidemenu_item" href="#">마이페이지</a></li>
			</ul>
		</nav>
	</div>
	<div>
		<table class="cartlist">
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
				<td><%=vo.getBkImg() %></td>
				<td><%=vo.getBkTitle()%></td>
				<td><%=vo.getBkWriter() %></td>
				<td><%=vo.getBkPublishdate() %></td>
				<td class="bkNo"><%=vo.getBkNo()%></td>
				<td><%=vo.getCaCount()%></td>
				<td><%=vo.getBkPrice() %>
				<td><button class="btn_delete button1">삭제하기
					</button></td>
				<td><button class="btn_buy button1">구매하기
					</button></td>
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
		$(".btn_buy").on("click", buycartHandler);
	}
	function deletecartHandler() {
		console.log(this); // <button 엘리먼트
		console.log($(this).parents(".cartlisy_td").find(".bkNo").text()); // span태그
		//$("#bkNo").val($(this).children("span").text());
		var bkNoVal= $(this).parents(".cartlisy_td").find(".bkNo").text();
		location.href = "deletecart?bkNo="+bkNoVal;
	}
	function buycartHandler() {
		alert("서비스 준비중입니다.");
	}
	
	</script>
	
${cVo }
<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>