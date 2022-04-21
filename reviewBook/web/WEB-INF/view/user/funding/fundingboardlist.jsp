<%@page import="kh.semi.reviewBook.user.funding.model.vo.FundingVo"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main/main.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>funding</title>
</head>
<body>
	<div id="main_wrap">
<%-- <%@ include file="../../template_header.jsp" %> --%>
		<div class="bodyfd">
			<nav class="navbar_fd">
				<ul class="nav_item">
					<li><a class="nav_item">펀딩진행중</a></li>
					<li><a class="nav_item">펀딩성공작</a></li>
				</ul>
			</nav>
		</div>
		<div>
			<%
ArrayList<FundingVo> volist = (ArrayList<FundingVo>)request.getAttribute("fundingVolist");
if(volist != null){
%>
<%-- <%=volist.size()%> --%>
	<div>
		<table border="1">
			<tr>
				<td>No.</td>
				<td>책제목</td>
				<td>상태</td>
				<td>펀딩마감일</td>
				<td>펀딩철회</td>
			</tr>
<%for(FundingVo vo : volist) { %>
			<tr>
				<td><%=vo.getWbNO() %></td>
				<td><%=vo.getFdLimit() %></td>
				<td><%=vo.getFdDonation() %></td>
				<td><%=vo.getFdDeadline() %></td>
				<td><%=vo.getFdOX()%></td>
			</tr>
<% } %>
		</table>
		<p>
<%  %>
		</p>
	</div>
<% } else { %>
	<div>
		게시글이 없습니다.
	</div>
<% }  %>
		</div>

<%@ include file="../../template_footer.jsp" %>
    </div>
</body>
</html>