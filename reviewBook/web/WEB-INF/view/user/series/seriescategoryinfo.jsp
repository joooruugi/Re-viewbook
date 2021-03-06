<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/series/seriesmain.css">
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB 연재 게시글</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- xeicon cdn -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<%
		ArrayList<SeriesVo> slist = (ArrayList<SeriesVo>) request.getAttribute("slist");
	//out.print(slist);
	%>
	<%
		UserVo vo = (UserVo) session.getAttribute("ssUserVo");
	AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
	//out.print(vo);
	// out.print(avo);
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
		 <div class="series_banner">
        <div id="series_banner_title">    
        <h2><br><a href="seriesmain">연재 <정보공유></a></h2>
        
        <br><br><br>
        <p>작가가 되어 자유롭게 글을 작성해보세요</p>
    <img src="./resources/image/series/author3.png" class="series_banner_img">
    </div>
	</div>
		<div class="bodyrvb">
			<nav class="sidemenu">
				<ul class="sidemenu_series">
					<li><a class="sidemenu_item sidemenu_topmenu">연재</a></li>
					<li><a class="sidemenu_item sidemenu_menu" href="seriesmain">전체</a></li>
					<li><a class="sidemenu_item sidemenu_menu"
						href="seriescategoryfiction">문학</a></li>
					<li><a class="sidemenu_item sidemenu_nowmenu"
						href="seriescategoryinfo">정보공유</a></li>
					<li><a class="sidemenu_item sidemenu_menu"
						href="seriescategorydaily">일상</a></li>
					<li><a class="sidemenu_item sidemenu_menu"
						href="seriescategoryetc">기타</a></li>
				</ul>
			</nav>
			<div class="contentrvb">
				<div class="contentmain">
					<div class="series_main_writer">
						<div class="series_tab_header">
							<div class="series_main_writer_title">
								<h2>이달의 RVB BEST작가😘</h2>
							</div>
						</div>
						<div class="series_content_all">
							<div class="series_tab_body">
								<div class="series_main_image">
									<img src="./resources/image/series/1.png">
								</div>
								<div class="series_main_content">
									<h3>윈터이즈커밍</h3>
									<h3>드래곤과의 춤</h3>
								</div>
							</div>
							<div class="series_tab_body">
								<div class="series_main_image">
									<img src="./resources/image/series/2.png">
								</div>
								<div class="series_main_content">
									<h3>harry</h3>
									<h3>해리와 법사의 돌</h3>
								</div>
							</div>
							<div class="series_tab_body">
								<div class="series_main_image">
									<img src="./resources/image/series/3.png">
								</div>
								<div class="series_main_content">
									<h3>마포대교</h3>
									<h3>순정에 관하여...</h3>
								</div>
							</div>
						</div>
					</div>
					
					<div id="series_board_write">
						<button onclick="location.href='seriesinsert';">게시물 작성</button>
					</div>
					<div class="series_series_hashtag">
						<div class="series_hastag">
							<div class="tag">#컴퓨터·IT</div>
							<div class="tag">#레시피</div>
							<div class="tag">#뷰티</div>
							<div class="tag">#주식</div>
						</div>
					</div>
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
												<span><%=svo.getWbCategory()%></span> &nbsp; &nbsp; <span><i
													class="xi-eye-o"></i>&nbsp;<%=svo.getWbCount()%></span>
											</div>
											<br>

										</div>
									</li>
									<%
										}
									%>
								</ul>
							</td>
						</tr>
						<tr>
							<td>
								<ul>
									<li>
										<button type="button" id="series_loadmore">더보기</button>

									</li>
								</ul>
							</td>
						</tr>

					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>
	<script>
		$(function() {
			$(".bbs_board").slice(0, 3).show();
			$("#series_loadmore").click(function(e) {
				e.preventDefault();
				$(".bbs_board:hidden").slice(0, 3).show();
				if ($(".bbs_board:hidden").length == 0) {
					alert("다음 페이지는 마지막 페이지 입니다.");
					$("#series_loadmore").hide(); //마지막 페이지에서 더보기 버튼 x
				}
			});
		});
	</script>
</body>
</html>