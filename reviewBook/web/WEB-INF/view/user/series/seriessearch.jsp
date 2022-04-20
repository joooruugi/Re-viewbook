<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연재 게시글</title>
<style>
/* 본문 */
.bodyrvb {
	width: 80%;
	display: flex;
	margin: auto;
}
/* 사이드메뉴  */
.sidemenu {
	width: 200px;
	height: 250px;
	background-color: #eaf4fc;
	display: flex;
	flex-direction: column;
	border: 1px solid #96bff9;
	border-radius: 20px;
	cursor: pointer;
}

.sidemenu_series {
	margin: 20px;
	margin-left: 0px;
}

.sidemenu_series .sidemenu_item {
	font-family: 'SF_HailSnow';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2106@1.1/SF_HailSnow.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.sidemenu_series li {
	list-style: none;
	width: 150px;
	height: 30px;
	line-height: 30px;
}

.sidemenu_series li:hover {
	font-family: 'ROKAFSansMedium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts2201-3@1.0/ROKAFSansMedium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
	background-color: #b6d4ff;
	border-radius: 30px;
}

.sidemenu_series .sidemenu_topmenu {
	font-family: 'ROKAFSansBold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts2201-3@1.0/ROKAFSansBold.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
	font-size: 20px;
}

/* 게시글 리스트 테이블 */
#series_list {
	max-width: 100%;
}

#series_list li {
	list-style: none;
}

/* 게시글 제목 */
.bbs_board {
	display: none;
	border-bottom: 1px solid black;
}

/* 게시글 내용 */
.bbs_content {
	width: 100%;
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
}

/* 더보기 버튼 */
#series_loadmore {
	width: 100%;
	height: 50px;
}

/* 검색창 */
#serise_search {
	margin: auto;
}
/* 검색창 크기 */
#searchText {
	width: 300px;
	height: 30px;
}
/* 검색창 버튼 */
#search_btn {
	height: 35px;
}
/* 옵션 버튼 */
.series_select {
	height: 35px;
}
/* 메인화면 이달의 작가 box  */
.series_main_writer{
    /* position: absolute; */
    /* top: 50%;
    left: 50%; */
    /* transform: translate(-50%,-50%);  */
    margin: auto;
    margin-bottom: 50px;
    width:700px;
    height: 250px;
    background:#f5f5f5;
    padding: 20px 30px;
    border-radius: 50px;
    box-shadow: 5px 10px 5px #ccc;
}

.series_content_all{
    display: flex;
}
/* 메인화면 이달의 작가 컨텐츠영역 */
.series_tab_body{
    padding-top: 40px;
    margin: auto;
    /* display: block;
    border-radius: 50px; */
}

#series_write button{
	transform: translateX(960px);
}
</style>

<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<%
		ArrayList<SeriesVo> slist = (ArrayList<SeriesVo>) request.getAttribute("slist");
		//out.print(slist); 
%>
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_series">
				<li><a class="sidemenu_item sidemenu_topmenu">연재</a></li>
				<li><a class="sidemenu_item">전체</a></li>
				<li><a class="sidemenu_item">문학</a></li>
				<li><a class="sidemenu_item">정보공유</a></li>
				<li><a class="sidemenu_item">일상</a></li>
				<li><a class="sidemenu_item">기타</a></li>
			</ul>
		</nav>
		<div class="contentrvb">
			<div class="contentmain">
				<div class="series_main_writer">
					<div class="series_tab_header">
						<div class="series_main_writer_title">
							<h2>이달의 RVB 작가😘</h2>
						</div>
					</div>
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
				<div id="series_write">
				<button onclick="location.href='seriesinsert';">게시물 작성</button>
				</div>
				<table id="series_list">
					<tr>
						<td>
							<ul>
								<li>
									<%for(SeriesVo svo: slist) {%>
									<div class="bbs_board">
										<div class="bbs_title">
											<a href="seriesread?wbNo=<%=svo.getWbNo()%>"><%=svo.getWbTitle() %>
												[<%=svo.getReCommentCnt() %>]</a> <span><%=svo.getWbWriter() %></span>
										</div>

										<br>
										<div class="bbs_content">
											<p>
												<a href="seriesread?wbNo=<%=svo.getWbNo()%>"><%=svo.getWbContent() %></a>
											</p>
										</div>
										<div class="bbs_date_ctgory"><%=svo.getWbDate().substring(0, 16) %>
											<span><%=svo.getWbCategory() %></span>
										</div>
										<br>
									</div> <%} %>
								</li>
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



	<script>
        
        $(function(){
        $(".bbs_board").slice(0, 3).show(); 
        $("#series_loadmore").click(function(e){
            e.preventDefault();
            $(".bbs_board:hidden").slice(0, 3).show(); 
            if($(".bbs_board:hidden").length == 0){ 
                alert("마지막 페이지 입니다."); 
            }
        });
    });
    </script>
</body>
</html>