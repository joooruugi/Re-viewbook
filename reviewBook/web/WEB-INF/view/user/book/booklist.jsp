<%@page import="kh.semi.reviewBook.book.model.vo.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/booklist.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB Book</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<%
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
	// out.print(vo);
	if (avo == null) {
	%>
	<%@ include file="../../../view/template_header.jsp"%>
	<%
		} else {
	%>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<%
		}
	%>
	<div class="booklist">
		<div class="booklist_content">
			<div class="booklist_name">
				<p class="fontimportant">Book</p>
			</div>
			<%
				ArrayList<BookVo> blist = (ArrayList<BookVo>) request.getAttribute("blist");
			if (blist != null) {
			%>
			<table class="booklisttable">
				<thead class="booklist_thead fontimportant2">
					<td>책 번호</td>
					<td>책 제목</td>
					<td>작가</td>
					<td>순위</td>
					<td>장르</td>
					<td>가격</td>
				</thead>
				<%
					for (BookVo bvo : blist) {
				%>
				<tr class="booklist_tr fontnormal book_board">
					<td><a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkNo()%></a></td>
					<td><a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkTitle()%></a></td>
					<td><%=bvo.getBkWriter()%></td>
					<td><%=bvo.getBkRating()%></td>
					<td><%=bvo.getGnName()%></td>
					<td><%=bvo.getBkPrice()%></td>
				</tr>
				<%
					}
				}
				%>

			</table>
		</div>
	</div>
	<div class="booklist_paging">
		<button type="button" id="booklist_loadmore"
			class="booklist_pagingbtn">더보기</button>

	</div>

	<%@ include file="../../../view/template_footer.jsp"%>
	<script>
/*     $(function(){
        $(".book_board").slice(0, 2).show(); 
        $("#booklist_loadmore").click(function(e){
            e.preventDefault();
            $(".book_board:hidden").slice(0, 2).show(); 
            if($(".book_board:hidden").length == 0){ 
            	 alert("다음 페이지는 마지막 페이지 입니다."); 
            }
        });
    }); */
   <%--  <%UserVo uvo = (UserVo)request.getAttribute("uvo");%>
    $(function(){
    	if($("#deleteUserchk").is(":checked")){
    		if($("#user_delete").click(function(){
    			location.href="'userlist.lo?usName=<%=uvo.getUsName()%>'";
    		})
    	}
    }; --%>
    
    </script>
</body>
</html>