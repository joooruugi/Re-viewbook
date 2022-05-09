<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/bookmain.css">
<%@ page import="kh.semi.reviewBook.book.model.vo.BookVo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmain</title>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


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
	<%
		ArrayList<BookVo> blist = (ArrayList<BookVo>) request.getAttribute("blist");
	//out.print(slist);
	%>


	  <div class="bookmain_total">

        <nav class="book_sidemenu">
            <ul class="book_sidemenu_main">
                <li><a class="book_sidemenu_detail">스릴러</a></li>
                <li><a class="book_sidemenu_detail">힐링</a></li>
                <li><a class="book_sidemenu_detail">로맨스</a></li>
                <li><a class="book_sidemenu_detail">자기계발</a></li>

            </ul>
        </nav>


        <div class="bookmain_rank">
            <h1 class="fontimportant fdtag">판매순위</h1>
            <div class="swiper mySwiper">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <p class="grade">별점</p>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>

                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>

                </div>
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-pagination"></div>
            </div>
            <h1 class="fontimportant fdtag">별점순위</h1>
            <div class="swiper mySwiper">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>

                </div>
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-pagination"></div>
            </div>
            <h1 class="fontimportant fdtag">리뷰순위</h1>
            <div class="swiper mySwiper">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>
                    <div class="swiper-slide">
                        <img src="./book-g30e5fd525_1920.jpg" class="bookimg">
                        <h2 class="fontnormal">책제목</h2>
                        <div class="grade">별점</div>
                        <p class="fontnormal">리뷰(58)</p>
                    </div>

                </div>
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </div>

	<%@ include file="../../../view/template_footer.jsp"%>
	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper(".mySwiper", {
			slidesPerView : 4,
			spaceBetween : 30,
			slidesPerGroup : 4,
			loop : true,
			loopFillGroupWithBlank : true,
			autoplay : { // 자동 슬라이드 설정 , 비 활성화 시 false
				delay : 5000, // 시간 설정
				disableOnInteraction : false, // false로 설정하면 스와이프 후 자동 재생이 비활성화 되지 않음
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
</body>
</html>