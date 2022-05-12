<%@page import="kh.semi.reviewBook.book.model.vo.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/bookgenre.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB Book</title>
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
					<li><a class="sidemenu_item sidemenu_menu" href="booklistth">스릴러</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="booklistheal">힐링</a></li>
					<li><a class="sidemenu_item sidemenu_nowmenu"
						href="booklistro">로맨스</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="booklistself">자기개발</a></li>
				</ul>
			</nav>
			<div class="contentrvb">
				<div class="contentmain">
					<div class="bookmainname">
						<p class="fontimportant">로맨스 💘💘</p>
					</div>
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
													src="<%=request.getContextPath()%><%=bvo.getBkImg()%>"></a>
											</div>
											<div class="book_content">
												<br>
												<div class="bookgenre_title fontimportant">
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkTitle()%></a>
												</div>
												<br>
												<div>
													<p><%=bvo.getGnName()%></p>
												</div>
												<p>
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkWriter()%></a>
												</p>
												<p>
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkPublishdate().substring(0, 10)%></a>
												</p>
												<p>
													<a href="bookcontent?bkNo=<%=bvo.getBkNo()%>"><%=bvo.getBkPrice()%>원</a>
												</p>
												<div class="book_cart">
													<form method="post" action="bookaddcart">
														<select name="caCount" id="caCount" required>
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
														</select> <input type="hidden" name="bkNo" id="bkNo"
															value="<%=bvo.getBkNo()%>">
														<button type="submit" class="button2 cartbtn"
															onclick="addToCart()">장바구니 담기</button>
													</form>
												</div>
											</div>
										</div>
									</li>
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
<%@ include file="../../template_footer.jsp"%>
	<script type="text/javascript">
		function addToCart() {
			// 확인 true
			if (alert("상품을 장바구니에 추가하시겠습니까?")) { // 확인
			}
		}
	</script>
</body>
</html>