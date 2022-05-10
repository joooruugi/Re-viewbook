<%@page import="kh.semi.reviewBook.book.model.vo.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/bookgenre.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<BookVo> blist = (ArrayList<BookVo>) request.getAttribute("blist");

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
	<div id="main_wrap">
		<div class="bodyfd">
			<nav class="sidemenu">
				<ul class="sidemenu_funding">
					<li><a class="sidemenu_item sidemenu_topmenu">도서</a></li>
					<li><a class="sidemenu_item" href="booklistth">스릴러</a></li>
					<li><a class="sidemenu_item" href="booklistheal">힐링</a></li>
					<li><a class="sidemenu_item" href="booklistro">로맨스</a></li>
					<li><a class="sidemenu_item" href="booklistself">자기계발</a></li>
				</ul>
			</nav>
			<div class="contentrvb">
				<div class="contentmain">
					<table id="book_list">
						<tr>
							<td>
								<ul>

									<%
										for (BookVo bvo : blist) {
									%>
									<li>
										<div class="book_board">
											<div class="book_img">
												<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"> <img
													src="<%=request.getContextPath()%><%=bvo.getBkImg()%>">
											</div>
											<div class="book_content">
												<br>
												<div class="bookgenre_title fontimportant">
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkTitle()%></a>
												</div>
												<br>
												<div><%=bvo.getGnName()%></div>
												<p>
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkWriter()%></a>
												</p>
												<p>
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkPublishdate().substring(0, 10)%></a>
												</p>
												<p>
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkPrice()%>원</a>
												</p>
												<br>
												<br>
												<br>
												<br>
												<br>
												<br>
												<br>
												<br>
												<div class="book_cart">
													<form method="post" action="bookaddcart">
														<select name="caCount" id="caCount" required>
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
														</select> <input type="hidden" name="bkNo" id="bkNo"
															value="<%=bvo.getBkNo()%>">
														<button type="submit" class="button2"
															onclick="addToCart()">장바구니</button>
													</form>
												</div>
											</div>
										</div> <br>
									</li>
									</div>
									<%
										}
									%>
								</ul>
							</td>
						</tr>

					</table>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		function addToCart() {
			// 확인 true
			if (alert("상품을 장바구니에 추가하시겠습니까?")) { // 확인
			}
		}
	</script>
</body>
</html>