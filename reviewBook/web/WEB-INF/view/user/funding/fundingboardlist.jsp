<%@page import="kh.semi.reviewBook.user.funding.model.vo.FundingVo"%>
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@page import="java.util.ArrayList"%>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩진행중</title>
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
		<%
			ArrayList<SeriesVo> slist = (ArrayList<SeriesVo>) request.getAttribute("slist");
		if (slist != null) {
		%>
		<div class="contentfd">
			<div class="contentmainfd">
				<table class="fdlist">
					<tr class="fdlist_th fontimportant2">
						<td class="fdlistno">No.</td>
						<td class="fdlistname">책제목</td>
						<td class="fdlistprocess">상태</td>
						<td class="fdlistdeadline">펀딩마감일</td>
						<td class="fdlistfunding">펀딩철회</td>
					</tr>

					<%
						for (SeriesVo svo : slist) {
					%>
					<tr class="fdlist_tb fontnormal">
						<td class="wbNo"><%=svo.getWbNo()%></td>
						<td><%=svo.getWbTitle()%></td>
						<td><%=svo.getAvgDonation()%></td>
						<td><%=svo.getFdDeadline()%></td>
						<%
							if (svo.getIsDonation() == 1) {
						%>
						<td><button class="btn_funding_withdraw button1">철회하기</button>
							<div class="modal">
								<div class="modal_content">
									<div id="modal_funding_content">
										<p><span>작품번호 :</span><span class="wbNo"><%=svo.getWbNo()%></span></p>
										<p>
											작품명 :
											<%=svo.getWbTitle()%></p>
										<p>
											작가 :
											<%=svo.getWbWriter()%></p>
										<p>
											카테고리 :
											<%=svo.getWbCategory()%></p>
										<p><%=svo.getFdLimit()%>원 후원하셨습니다.</p>
									</div>
									<div class="btn_funding_move_close">
										<button class="button2 btn_withdraw">철회하기</button>
										<button class="button4 btn_funding_close">닫기</button>
									</div>
								</div>
							</div>
						</td>
						
						<%
							} else {
						%>
						<td><button class="btn_funding_donation button1">펀딩하기</button>
							<div class="modal">
								<div class="modal_content">
									<div id="modal_funding_content">
										<p><span>작품번호 :</span><span class="wbNo"><%=svo.getWbNo()%></span></p>
										<p>
											작품명 :
											<%=svo.getWbTitle()%></p>
										<p>
											작가 :
											<%=svo.getWbWriter()%></p>
										<p>
											카테고리 :
											<%=svo.getWbCategory()%></p>
										<p><input type="text" name="fdDonation" class="fdDonation" placeholder="<%=svo.getFdLimit()%>원 이하로 펀딩해주세요"></p>
									</div>
									<div class="btn_funding_move_close">
										<button class="button2 btn_funding">펀딩하기</button>
										<button class="button4 btn_funding_close">닫기</button>
									</div>
								</div>
							</div>
						</td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<%
				} else {
			%>
			<div>게시글이 없습니다.</div>
			<%
				}
			%>
			<div class="contentpgfd">페이징</div>
		</div>
		<%@ include file="../../template_footer.jsp"%>
	</div>
	<script>
		// 철회하기 버튼 누르면 후원금액 얼마했는지 모달창 띄우고 펀딩관리에서 delete하기()
		$(".btn_withdraw").click(funding_withdraw);
		function funding_withdraw() {
			console.log(this);
			var wbNoVal = $(this).parents(".fdlist_tb").children(".wbNo")
					.text();
			console.log(wbNoVal);
			//location.href='fundingwithdraw?wbNo='+wbNoVal;
			$.ajax({
				url : "fundingwithdraw",
				type : "post",
				data : {
					wbNo : wbNoVal
				},
				success : function(result) {
					console.log(result);
					if (result == 0) {

					} else {

					}
					location.reload();
				}
			});
		}
		// 펀딩하기 버튼 누르면 얼마 후원할지를 넣는 모달창 띄우고 게시글에 총후원금액 +하기
		$(".btn_funding").click(funding_donation);
		function funding_donation() {
			console.log(this);
			var wbNoVal = $(this).parents(".modal").children(".wbNo").text();
			var fdDonationVal = $(this).parents(".modal").children(".fdDonation").text();
			console.log(wbNoVal);
			console.log(fdDonationVal);
			alert("sdfsd");
			//location.href='fundingdonation?wbNo='+wbNoVal;
			$.ajax({
				url : "fundingdonation",
				type : "post",
				data : {
					wbNo : wbNoVal, 
					fdDonation : fdDonationVal
				},
				success : function(result) {
					console.log(result);
					if (result == 0) {

					} else {

					}
					location.reload();
				}
			})
		}
		//모달창 스크립트 
		//버튼 누르면 펀딩 모달창 on
		$(".btn_funding_donation").click(function(){
			console.log(this);
			openModal(this);
		});
		//버튼 누르면 철회 모달창 on
		$(".btn_funding_withdraw").click(function(){
			console.log(this);
			openModal(this);
		});
				
		//close 버튼 누르면 펀딩 모달창 close
		$(".btn_funding_close").click(function(){
			console.log(this);
			closeModal(this);
		});

		// openModal
		function openModal(thisEle) {
			console.log(thisEle);
			console.log($(thisEle).next());// $(".modal")
			$(thisEle).next().show();
		}
		// closeModal
		function closeModal(thisEle) {
			console.log(thisEle);
			console.log($(thisEle).parents(".modal"));// $(".modal")
			$(thisEle).parents(".modal").hide();
		}

	</script>
</body>
</html>