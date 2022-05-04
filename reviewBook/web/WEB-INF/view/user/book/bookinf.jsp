
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
	href="<%=request.getContextPath()%>/resources/css/book/bookinformation.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"d
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmain</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
   <div class="bookinf_total">
        <div class="bookinf_title">
            <div class="bookinf_title_img">
                <img class="bookinf_real_img" src="black.jpeg">
            </div>
            <div class="bookinf_title_detail">
                <div class="bookinf_title_real"><h1>책제목잡아넣기</h1></div>
                <div class="bookinf_title_writer">작가/출판사</div>
                <div class="bookinf_title_grade">평균별점</div>
                <div class="bookinf_title_eva">별점평가</div>
                <div class="bookinf_title_review">리뷰개수(5738)</div>
                <div class="bookinf_title_buy">
                    <div class="bookinf_title_count">수량(120개)</div>
                    <div class="bookinf_title_price">가격(39,800원)</div>
                    <div class="bookinf_title_cart">장바구니담기</div>
                </div>
            </div>
        </div>

        <div class="bookinf_content">
            <div class="bookinf_content_detail">
                <h2>기본정보</h2>
                <p>동해물과 백두산이 마르고 닳도록
                    하느님이 보우하사 우리나라 만세
                    무궁화 삼천리 화려강산
                    대한사람 대한으로 길이 보전하세
                </p>
            </div>
            <div class="bookinf_content_index">
                <h2>목차</h2>
                <ul>
                    <li>애국가 1절</li>
                    <li>애국가 2절</li>
                    <li>애국가 3절</li>
                    <li>애국가 4절</li>
                </ul>
            </div>
            <div class="bookinf_content_writer">
                <h2>작가</h2>
                <p>조병국</p>
            </div>



        </div>
    </div>








</body>
</html>