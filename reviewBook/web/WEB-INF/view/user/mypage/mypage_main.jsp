<%@page import="kh.semi.reviewBook.mypage.model.vo.BuyListVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<input type="button" value="회원정보조회" onclick="location.href='memberinfo.jsp'">

<%
ArrayList<BuyListVo> volist = (ArrayList<BuyListVo>)request.getAttribute("bLVo");
if(volist != null){
%>
	<div>
		<table border="1">
			<tr>
				<td>주문상품</td>
				<td>주문번호</td>
				<td>주문날짜</td>
				<td>상품리뷰</td>
			</tr>
<%for(BuyListVo vo : volist) { %>
			<tr>
				<td><%=vo.getBkTitle() %></td>
				<td><%=vo.getOrNum() %></td>
				<td><%=vo.getOrDate() %></td>
				<td><%=vo.getRvNum() %></td>
			</tr>
<% } %>
		</table>
		<p>
<%  %>
		</p>
	</div>
<% } else { %>
	<div>
		주문 상품이 없습니다.
	</div>
<% }  %>


[[${sVo }]]
[[${bLVo }]]
[[${myOrderlist }]]
</body>
</html>