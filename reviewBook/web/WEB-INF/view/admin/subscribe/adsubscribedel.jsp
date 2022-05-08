<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/subscribe/adsubscribe.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title></title>
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
				<li><a class="sidemenu_item" href="adsubscribemain">구독 회원 조회</a></li>
				<li><a class="sidemenu_item" href="adsubscribedel">철회 회원 조회</a></li>
			</ul>
		</nav>
		<div class="contentrvb">
			<div class="contentmain">
			<div class="adsubscribe_title">
			<h1>RVB 구독 철회 회원 조회</h1>
			</div>
			<table id="subscribe_member">
			<tr class="subscribe_member_th">
			<th class="subscribeid">구독자 ID</th>
			<th class="subscribetype">구독권 종류</th>
			<th class="subscribestart">구독 종료일</th>
			<th class="subscribeprice">가격</th>
			<th class="subscribedelete">삭제</th>
			</tr>
			<c:forEach var ="ssvo" items="${sslist}">  
			<tr class="subscribe_member_td">
			<td>${ssvo.usId}</td>
			<td>${ssvo.subInf}</td>
			<td>${ssvo.subEnd}</td>
			<td>${ssvo.subPrice}</td>
			<td><button type="button" class="button3" 
			onClick="location.href='adsubscribedelete?usId=${ssvo.usId}'">내역삭제</button></td>
			</tr>
			</c:forEach>
			</table>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>



</body>
</html>