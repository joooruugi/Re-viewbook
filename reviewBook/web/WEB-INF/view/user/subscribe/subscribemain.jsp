<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/subscribe/subscribe.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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

					<div class="sub_intro">
						<div class="sub_intro_title">
							<p>RVB 에서 준비한 다양한 구독 혜택을 놓치지 마세요!</p>
							<p>베스트셀러, 신작 도서 모두 RVB 구독을 통해서 함께해요👩‍👦‍👦</p>
						</div>
						<div class="sub_intro_content_all">

							<div class="sub_intro_content">
								<div class="sub_intro_content_image">
									<img src="./resources/image/subscribe/1.png">
								</div>
								<div class="sub_intro_content_explain">
									<p>구독자들이 인증한<br> 다양한 후기</p>
								</div>
							</div>
							<div class="sub_intro_content">
								<div class="sub_intro_content_image">
									<img src="./resources/image/subscribe/2.png">
								</div>
								<div class="sub_intro_content_explain">
									<p>2권 이상의 책을 합리적인<br>가격으로 구입!</p>
								</div>
							</div>
							<div class="sub_intro_content">
								<div class="sub_intro_content_image">
									<img src="./resources/image/subscribe/3.png">
								</div>
								<div class="sub_intro_content_explain">
									<p>직접 서점에 방문할 <br>필요 없이 문 앞까지<br> 매달 배송되는 서비스</p>
								</div>
							</div>
						</div>
					</div>
					
					<div class="sub_review_all">
					<h1>RVB 구독자들의 생생한 구독 후기 이곳에서 확인해보세요</h1>
		 			<c:forEach var ="ssvo" items="${sslist}">  
					 <c:if test="${not empty ssvo.subReview}"> 
					<div class="sub_review">
					<!-- 구독권 리뷰 작성하지 않은 경우에 리뷰 보여지면 안되니까 조건문 추가 -->
					 <p>${ssvo.usId}님</p>
					 <p>구독권 종류 : ${ssvo.subInf}</p>
					 <p>${ssvo.subReview}</p>
					</div>
	 				<br><br>
	 			 	</c:if> 
 	 				</c:forEach>   
	 				<a href="updatesubreview">구독 후기를 작성하고싶으면 여기를 클릭해주세요 >></a>
	 				</div>
	 			
					<div class="sub_type">
					<div class="sub_type_title">
					<p>RVB에서 만날 수 있는 구독권 종류</p>
					<p>매달 새로운 도서를 만나보세요!</p>
					<br>
					<small> * 해당 서비스는 동시에 이용이 불가능합니다.</small>
					</div>
					<div class="sub_recommend">
					<h1>RVB 정기 구독 추천 대상</h1>
					<p>서점에 갈 시간적 여유가 적은 학생 또는 직장인 🤦🏻‍♂️</p>
					<p>다양한 장르별  / 추천별 도서를 읽고 싶으신 분 🙋🏻</p>
					<p>신작 도서, 베스트셀러에 관심이 많으신 분 👴🏻</p>
					<p>이외에도 책에 관심이 있는 모든 분들께 추천드립니다 😄</p>
					</div>
					<div class="sub_notice">
					<h1> * 결제 후 나타나는 버튼을 반드시 클릭하여야 정상적으로 구독 신청이 완료됩니다. </h1>
					</div>
					<div class="sub_list1">
					<p>정기구독권</p>
					<p>매월 29,900원 결제(vat 포함가)</p>
					<p>매월 1일 정기배송 출발 및 자동결제</p>
					<p>베스트셀러 도서 + 신간 도서 (월 3권 랜덤)</p>
					<p>제주도 및 도서산간지역은 별도의 배송비가 부과됩니다 </p>
					<p>약관이 적용됩니다. <a href='subscribeterm'>이곳</a>을 클릭하여 확인해주세요</p>
					 <%if(vo != null){%> 
					<div class="sub_payment">
					<button class="button3" id="btn_insert_sub1">정기구독권 신청</button>
					</div>
				 	<%} else { %> 
						<div class="sub_payment">
					<button class="button3"
					onclick="location.href='login'">로그인 후 이용하기</button>
					</div>
		 			<%} %> 
					</div>
					<div class="sub_list2">
					<p>월별 구독권</p>
					<p>매월 19,900원 결제(vat 포함가)</p>
					<p>정기구독이 부담스러운 회원들을 위한 특별 혜택!</p>
					<p>베스트셀러 도서 + 신간 도서 (월 2권 랜덤)</p>
					<p>제주도 및 도서산간지역은 별도의 배송비가 부과됩니다 </p>
					<p>약관이 적용됩니다. <a href='subscribeterm'>이곳</a>을 클릭하여 확인해주세요</p>
			 			<%if(vo != null){%> 
					<div class="sub_payment">
					<button class="button5" id="btn_insert_sub2">월별구독권 신청</button>
					</div>
			 		<%} else { %> 
						<div class="sub_payment">
					<button class="button3"
					onclick="location.href='login'">로그인 후 이용하기</button>
					</div>
					<%} %> 
					</div>
					</div>
					</div>
				
			

		</div>
			</div>
			</div>
<%@ include file="../../template_footer.jsp"%>	
	

 	 	<script>
 	 	
 	 /* 구독권 리뷰 3개만 화면에 보여지게하기*/
 	   $(function(){
        $(".sub_review").slice(0, 3).show(); 
    })
 	 /* 정기구독권 스크립트  */
 	$('#btn_insert_sub1').click(
	function requestPay() {
	  IMP.init('imp81715131'); 
	  IMP.request_pay({
	    pg: 'inicis',
	    pay_method: 'card',
	    merchant_uid : 'merchant_'+new Date().getTime(),
	    name : 'ReviewBook 정기 구독권 결제',
	    amount : 100 //진짜 결제되니까 일단은 100원으로 나중에 29900수정
	  }, function (rsp) { // callback
	      if (rsp.success) {
	    	  msg = '결제에 성공하였습니다.';
              alert(msg);
	    	//성공시 이동할 페이지
              location.href="subscribelong";
	      } else {
	    	    msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="subscribemain";
                alert(msg);
	      }
	  });
	})
	
	/* 월별 구독권 스크립트 */
	 $('#btn_insert_sub2').click(
	function requestPay() {
	  IMP.init('imp81715131'); 
	  IMP.request_pay({
	    pg: 'inicis',
	    pay_method: 'card',
	    merchant_uid : 'merchant_'+new Date().getTime(),
	    name : 'ReviewBook 월별 구독권 결제',
	    amount : 100 //진짜 결제되니까 일단은 100원으로 나중에 19900수정
	  }, function (rsp) { // callback
	      if (rsp.success) {
	    	  msg = '결제에 성공하였습니다.';
              alert(msg);
	    	//성공시 이동할 페이지
              location.href="subscribeshort";
	      } else {
	    	    msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="subscribemain";
                alert(msg);
	      }
	  });
	})
	</script> 


	

</body>
</html>