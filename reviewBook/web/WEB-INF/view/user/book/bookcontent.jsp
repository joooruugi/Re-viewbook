<%@page import="kh.semi.reviewBook.book.model.vo.BookVo"%>
<%@page import="kh.semi.reviewBook.mypage.model.vo.ReviewVo"%>
<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.user.notice.vo.NoticeVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/bookcontent.css">
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
</head>
<body>
	<%
		UserVo vo = (UserVo) session.getAttribute("ssUserVo");
	AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
	// out.print(vo);
	if (vo == null && avo == null) {
	%>
	<%@ include file="../../../view/template_header.jsp"%>
	<%
		} else if (vo != null) {
	%>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<%
		} else if (avo != null) {
	%>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<%
		}
	%>
	<div class="body_bookcontent">
		<div class="bookcontent_name">
			<p class="fontimportant">책 상세조회</p>
		</div>
<%
	BookVo bvo = (BookVo) request.getAttribute("bvo");
	if (bvo != null) {
%>
		<div class="book_bookcontent">
			<div class="book_bookcontenthead">
				<div class="book_bookcontentname">
					<p class="fontimportant2"><%=bvo.getBkTitle()%></p>
				</div>
			</div>
			<div class="book_bookcontentright">
				<div class="book_bookcontentnick">
					<p class="fontnormal bookcontentname">작가</p>
					<p class="fontnothing bookcontentname2"><%=bvo.getBkWriter()%></p>
				</div>
				<div class="book_bookcontent_div"></div>
				<div class="book_bookcontentcontentprice">
					<p class="fontnormal bookcontentname">가격</p>
					<p class="fontnothing bookcontentname2"><%=bvo.getBkPrice()%></p>
				</div>
				<br>
				<div class="book_bookcontentcontentcart">
					<form name="addForm" method="post"
						action="addCart.jsp?id=${product.productId}">
						<a href="cartlist" class="fontnormal" onclick="addToCart()"> 장바구니
							&raquo;</a>
					</form>
				</div>
				<div class="book_bookcontent_div"></div>
				<div class="book_bookcontentpublishdate">
					<p class="fontnormal bookcontentname">출판일</p>
					<p class="fontnothing bookcontentname2"><%=bvo.getBkPublishdate()%></p>
				</div>
				<div class="book_bookcontent_div"></div>
				<div class="book_bookcontentindex">
					<p class="fontnormal bookcontentname">목차</p>
					<p class="fontnothing bookcontentname2"><%=bvo.getBkIndex()%></p>
				</div>
			</div>

			<div class="book_bookcontentbody">
				<div class="book_bookcontent_content">
					<p class="fontnothing bookcontentcontent"><%=bvo.getBkContent()%></p>
				</div>
			</div>
		</div>
	
		<div class="bookreview">
			<div class="bookreview_content">
				<div class="bookreview_name">
					<p class="fontimportant">Review</p>
				</div>
				<br>

	<%
	ArrayList<ReviewVo> rvlist = (ArrayList<ReviewVo>) request.getAttribute("rvlist");
	if (rvlist != null && rvlist.size() != 0) {
	%>
				<table class="bookreviewtable">
					<thead class="bookreview_thead fontimportant2">
						<td>리뷰번호</td>
						<td>리뷰제목</td>
						<td>UserID</td>
						<td>별점</td>
					</thead>
		<%
		for (ReviewVo rvo : rvlist) {
		%>
					<tr class="bookreview_tr fontnormal book_board">
						<td><%=rvo.getRvNum()%></td>
						<td><%=rvo.getRvTitle()%></td>
						<td><%=rvo.getUsId()%></td>
						<td><%=rvo.getRvRating()%></td>
					</tr>
		<%
		}
		%>

				</table>
	<%
	}
	%>
			</div>
		</div>
<%
}  // bvo 가 있다면
%>
		<div class="booklist_btn">
			<button type="submit" class="booklist_listbtn"
				onclick="location.href='booklist'">목록으로</button>
		</div>

	</div>
	    <script type="text/javascript">

        function addToCart(){
            // 확인 true 취소 false
            if(confirm("상품을 장바구니에 추가하시겠습니까?")){ // 확인
                document.addForm.submit();
            }else{ // 취소
                document.addForm.reset();
            }
        }
    </script>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>