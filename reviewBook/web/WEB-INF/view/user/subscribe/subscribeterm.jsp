<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/subscribe/subscribe.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main/main.css">
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
		 out.print(vo);
		// out.print(avo);
		if (vo == null && avo == null) { %>
	<%@ include file="../../../view/template_header.jsp"%>
	<% } else if (vo != null) { %>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<% } else if (avo != null) { %>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<% } %>
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
			<div class="subscribe_term">
			<div class="subscribe_term_title">
			<p>구독자 일반 약정</p>
			</div>
		<div class="subscribe_term_title_content">
		<h1>1. 개요</h1>
		<p>RVB은 RVB 서비스 및 지원을 이용할 수 있는 기회를 드리고, 리워드와 혜택을 제공하고, 새로운 기능과 제품을 선보이기 위해 마련되었습니다. 
		RVB에서는 특정 RVB구독권에 대한 고객 지원 및 기타 혜택 등을 지원합니다. 
		추가적인 RVB 제품 또는 서비스를 사용하는 경우 해당 제품 또는 서비스 관련 약관이 적용됩니다. 일부 지역에서는 혜택이 제공되지 않을 수 있습니다. 
		자세한 내용은 RVB 고객센터를 참조하시기 바랍니다.</p>
		</div>
		<div class="subscribe_term_title_content">
		<h1>2. 결제, 구독, 환불</h1>
		<p>결제. RVB 회원만이 RVB 구독권을 신청, 철회 할 수 있습니다. RVB은 구매 전에 명시되는 기타 결제 수단을 통해 결제를 수락합니다.</p>

		<p>구독 철회. 매월 1일  자동으로 결제를 처리하며, 구독이 철회될 때까지 RVB 구독이 자동으로 갱신됩니다. 구독은 언제든지 취소할 수 있습니다. </p>
		구독을 취소하는 경우 다음달 결제일부터 적용됩니다. 

		<p>환불. 추가적인 환불 권리는구매한 제공업체의 관련 정책을 참조하시기 바랍니다. RVB에서 구매한 경우 관련 법규에서 요구하는 경우를 제외하고, 
		청구 기간에 해당하는 금액에 대한 환불은 처리되지 않으며 일할 조정된 환불도 제공되지 않습니다.
		RVB 외의 제공업체로부터 구매한 경우(예: iPhone 또는 iPad를 사용하거나 App Store 또는 다른 타사 제공업체를 통해 ) 
		제공업체의 환불 정책이 적용됩니다. 환불을 요청하려면 해당 타사(예: Apple 지원팀)에 문의해야 합니다.</p>

		<p>가격 변경. RVB 요금은 변경될 수 있으며, 이러한 변경사항은 사용자에게 사전 고지됩니다. 
		변경된 요금은 현재 결제 기간이 끝난 후(고지 후 다음 결제부터) 적용됩니다. 요금 인상에 관한 사전 고지는 요금이 청구되기 최소 30일 전에 이루어지며, 
		30일 미만이 남은 상태에서 사전 고지를 받은 경우 다음 결제일 이후의 결제일부터 변경사항이 적용됩니다. 
		새로운 요금으로RVB을 계속 사용하기를 원하지 않는 경우 구독 철회에서 언제든지 서비스를 취소할 수 있습니다.
		구독 취소는 관련 결제 플랫폼 약관에 명시되지 않은 한 현재 서비스 기간 이후 다음 번 결제 기간부터 적용됩니다. 
		요금이 인상되고 동의가 필요한 경우, 귀하가 새로운 요금에 동의하지 않으면 구독이 취소될 수 있습니다. 
		구독 취소 후 나중에 다시 구독하는 경우에는 해당 시점의 구독 요금이 청구됩니다.</p>
		</div>
		
		<div class="subscribe_term_title_content">
		<h1>3. 고객 지원</h1>
		<p>RVB은 여러 RVB 제품 및 서비스에 걸쳐 고객 지원(이하 '고객 지원') 액세스를 제공합니다. 
		고객 지원팀이 지원 요청을 도울 수 없는 경우 귀하를 해당 RVB 제품의 고객 지원 서비스팀으로 안내할 수 있습니다. 
		여기에는 요청된 특정 RVB 제품 또는 서비스에 대해 RVB에서 고객 지원을 제공하지 않는 경우도 포함됩니다. 
		RVB 구독이 취소되거나 정지되는 경우 해결되지 않은 고객 지원 문제 또한 정지될 수 있으며 구독이 복구된 후 새로 문의를 제출해야 할 수 있습니다.</p>
		</div>
		
		<div class="subscribe_term_title_content">
		<h1>4. 개인 정보 보호</h1>
		<p>RVB은 본 약관에 설명된 것과 같이 RVB 서비스를 제공하기 위해 귀하가 제공한 정보를 RVB 개인정보처리방침에 따라 수집하고 사용합니다. 
		RVB은 RVB 서비스를 제공하거나, 거래를 처리하거나, RVB을 유지관리하고 개선하기 위해 귀하의 RVB 사용과 관련된 정보를 수집하고 사용할 수 있습니다. 
		또한 RVB은 RVB 서비스를 개선하거나, 혜택을 제공하거나, RVB을 마케팅하기 위해 귀하의 다른 RVB 서비스 사용과 관련된 정보를 사용할 수 있습니다. </p>
		</div>
		
		<div class="subscribe_term_title_content">
		<h1>5. 변경사항</h1>
		<p>RVB은 RVB 구독 서비스를 변경할 권리를 보유하며 추가 기능이나 다른 기능을 제공하기 위해  RVB 구독 서비스를 수정할 수 있습니다. 
		귀하는 RVB 서비스 구독이 구독 당시 제공되는 형태를 대상으로 하는 데 동의합니다. </p>
		</div>
		
		<div class="subscribe_term_title_content">
		<h1>6. 해지</h1>
		<p>RVB은 본 약관의 위반 등을 포함한 사유로 언제든지 RVB의 제공을 중지할 수 있습니다. 
		 RVB은 귀하에게 합당한 고지를 제공한 후 언제든지 RVB구독 을 정지 또는 해지할 권리를 보유합니다.</p>
		</div>

			
			</div>
			</div>	
			</div>
		
		</div>
		<%@ include file="../../template_footer.jsp"%>

</body>
</html>