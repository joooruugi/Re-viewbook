<%@page import="kh.semi.reviewBook.series.model.vo.SeriesReCommentVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/series/seriesread.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resources/css/all/all.css">
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연재 게시글</title>
</head>
<body>
	<% SeriesVo svo = (SeriesVo)request.getAttribute("svo"); 
	 	//System.out.println(svo); 
	 	%>

	<div class="series_banner">
		<div id="series_banner_title">
			<h2>
				<a href="seriesmain">연재</a>
			</h2>
			<br>
			<p>작가가 되어 자유롭게 글을 작성해보세요</p>
			<img src="./resources/image/series/author3.png"
				class="series_banner_img">
		</div>
	</div>
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_series">
				<li><a class="sidemenu_item sidemenu_topmenu">연재</a></li>
				<li><a class="sidemenu_item" href="seriesmain">전체</a></li>
				<li><a class="sidemenu_item" href="seriescategoryfiction">문학</a></li>
				<li><a class="sidemenu_item" href="seriescategoryinfo">정보공유</a></li>
				<li><a class="sidemenu_item" href="seriescategorydaily">일상</a></li>
				<li><a class="sidemenu_item" href="seriescategoryetc">기타</a></li>
			</ul>
		</nav>
		<div class="contentrvb">
			<div class="contentmain">
				<div id="series_board_read">
					<div class="series_board_read_all">
						<div class="series_read_title_content">
							<table id="series_read_title">
								<tr>
									<td colspan="3"><h1><%=svo.getWbTitle() %></h1></td>
								</tr>
								<tr>
									<td colspan="2"><p><%=svo.getWbWriter() %></p></td>
									<td colspan="1"><p><%=svo.getWbDate().substring(0, 16) %></p></td>
								</tr>
								<tr>
									<td colspan="3"><span
										style="background-color: rgba(234, 244, 252, 1);"><%=svo.getWbCategory() %></span></td>
								</tr>
							</table>
							<table id="series_read_content">
								<tr>
									<td colspan="3"><%=svo.getWbContent() %></td>
								</tr>
							</table>
						</div>
						<div class="series_board_read_funding">
							<table id="board_read_funding">
								<tr>
									<td>해당 작품을 책으로 만나보고 싶으신가요📚📖 이곳을 클릭해주세요
										<button onclick='' class="button4">펀딩하기👍</button> <br>
									<br> <small>참고 : 목표 금액 이상이 모이면 해당 작품의 펀딩이 성공되며, 펀딩
											마감일까지 목표 금액을 달성하지 못한 경우 결제가 진행되지 않습니다.</small>

									</td>
								</tr>
							</table>
						</div>
						<div class="series_board_recomment_all">
							<table id="board_read_recomment">
								<tr>
									<td colspan="3">댓글 [<%=svo.getReCommentCnt() %>]
										<form action="seriescomment" method="post">
											<div class="star-rating">
												<input type="radio" id="5-stars" name="wbcRating" value="5" />
												<label for="5-stars" class="star">&#9733;</label> <input
													type="radio" id="4-stars" name="wbcRating" value="4" /> <label
													for="4-stars" class="star">&#9733;</label> <input
													type="radio" id="3-stars" name="wbcRating" value="3" /> <label
													for="3-stars" class="star">&#9733;</label> <input
													type="radio" id="2-stars" name="wbcRating" value="2" /> <label
													for="2-stars" class="star">&#9733;</label> <input
													type="radio" id="1-star" name="wbcRating" value="1" /> <label
													for="1-star" class="star">&#9733;</label>
											</div>
											<input type="hidden" name="wbNo" value="<%=svo.getWbNo()%>">
											<input type="text" id="wbcContent" name="wbcContent"
												placeholder="댓글을 입력해주세요">
											<button type="submit" class="button1">등록</button>
										</form>
									</td>
								</tr>

							</table>
							<%
			if(svo.getReCommentCnt()>0){
			//자료형 ArrayList<SeriesReCommentVo>
			for(SeriesReCommentVo srvo : svo.getSrvolist()){
			%>
							<table id="series_read_comment_rist">
								<tr>
									<td colspan="3"><%=srvo.getWbcWriter() %> &nbsp; &nbsp; <span><%=srvo.getWbcDate().substring(0, 16) %></span></td>
								</tr>
								<tr>
									<td colspan="3"><p style="color:#f90;">&#9733;<%=srvo.getWbcRating() %></p></td>
								</tr>
								<tr>
									<td colspan="3"><%=srvo.getWbcContent() %></td>
								</tr>
							</table>
							<%		
			}
		}

%>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>











</body>
</html>