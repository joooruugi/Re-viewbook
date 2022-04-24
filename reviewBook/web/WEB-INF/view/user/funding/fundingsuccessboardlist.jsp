<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/series/seriesmain.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩성공작</title>
</head>
<body>
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
		<div class="contentfd">
			<div class="contentmainfd">
				<div class="serise_search_all">
					<form method="post" action="seriessearch">
						<table id="serise_search">
							<tr>
								<td><input type="text" id="searchText"
									placeholder="작가명 또는 작품명을 입력해주세요" name="searchText"
									maxlength="100"></td>
								<td><button type="submit" id="search_btn">검색</button></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="series_main_writer">
					<div class="series_tab_header">
						<div class="series_main_writer_title">
							<h2>최근에 펀딩에 성공했어요😘</h2>
						</div>
					</div>
					<!-- TODO 작품 받아와서 슬라이딩으로 구성하기 -->
					<div class="series_content_all">
						<div class="series_tab_body">
							<div class="series_main_image">
								<img src="#">
							</div>
							<div class="series_main_content">
								<h3>작가명1</h3>
								<h3>작품명1</h3>
							</div>
						</div>
						<div class="series_tab_body">
							<div class="series_main_image">
								<img src="#">
							</div>
							<div class="series_main_content">
								<h3>작가명2</h3>
								<h3>작품명2</h3>
							</div>
						</div>
						<div class="series_tab_body">
							<div class="series_main_image">
								<img src="#">
							</div>
							<div class="series_main_content">
								<h3>작가명3</h3>
								<h3>작품명3</h3>
							</div>
						</div>
					</div>
				</div>
				<!-- 요걸 슬라이딩 하는 구조로 구현해서 태그별로 for문 돌리기?  -->
				<%
					ArrayList<SeriesVo> slist = (ArrayList<SeriesVo>) request.getAttribute("slist");
				//out.print(slist);
				%>
				<table id="series_list">
					<tr>
						<td>
							<ul>
								<%
									for (SeriesVo svo : slist) {
								%>
								<li>
									<div class="bbs_board">
										<div class="bbs_title">
											<a href="seriesread?wbNo=<%=svo.getWbNo()%>"><%=svo.getWbTitle()%>
												[<%=svo.getReCommentCnt()%>]</a> <span><%=svo.getWbWriter()%></span>

										</div>

										<br>
										<div class="bbs_content">
											<p>
												<a href="seriesread?wbNo=<%=svo.getWbNo()%>"><%=svo.getWbContent()%></a>
											</p>
										</div>
										<div class="bbs_date_ctgory"><%=svo.getWbDate().substring(0, 16)%>
											<span><%=svo.getWbCategory()%></span>
										</div>
										<br>
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
</body>
</html>