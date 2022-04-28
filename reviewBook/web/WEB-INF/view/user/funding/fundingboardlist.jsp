<%@page import="kh.semi.reviewBook.user.funding.model.vo.FundingVo"%>
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
</head>
<body>
	<% FundingVo fvo = (FundingVo)request.getAttribute("fvo"); 
	 	%>
	<div id="main_wrap">
		<%@ include file="../../template_header.jsp"%>
		<div class="bodyfd">
			<nav class="sidemenu">
				<ul class="sidemenu_funding">
					<li><a class="sidemenu_item sidemenu_topmenu">펀딩</a></li>
					<li><a class="sidemenu_item">펀딩진행중</a></li>
					<li><a class="sidemenu_item">펀딩성공작</a></li>
				</ul>
			</nav>
		</div>
		<%
			ArrayList<FundingVo> flist = (ArrayList<FundingVo>) request.getAttribute("flist");
		if (flist != null) {
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
						for (FundingVo vo : flist) {
					%>
					<tr class="fdlist_tb fontnormal">
						<td><%=fvo.getWbNO()%></td>
						<td><%=fvo.getFdLimit()%></td>
						<td><%=fvo.getFdDonation()%></td>
						<td><%=fvo.getFdDeadline()%></td>
						<% if(fvo.getFdOX() == 1) { %>
						<button id="btn_funding_withdraw" class="button2"
							onclick="location.href='fundingwithdraw?wbNo=<%=fvo.getWbNO()%>';">철회하기</button>
						<!-- <td><a class="fdwithdraw" href="#">철회하기</a></td> -->
						<!-- TODO 1, 0에 따라 펀딩하기, 철회하기 버튼 구현 -->
						<% } else {%>
						<button id="btn_funding_donation" class="button2"
							onclick="location.href='fundingdonation?wbNo=<%=fvo.getWbNO()%>';">펀딩하기</button>
						<!-- <td><a class="fddonation" href="#">펀딩하기</a></td> -->
						<!-- TODO 1, 0에 따라 펀딩하기, 철회하기 버튼 구현 -->
						<% } %>
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
</body>
</html>