<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap header">
 <header>
        <div class="navbar">
            <nav class="navbar_left mainlogo">
                <img src="./resources/image/RVBlogo.png">
            </nav>
            <nav class="navbar_left">
                <div class="dropdownmenu">
                    <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="#">도서</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="#">스릴러</a></li>
                                <li><a class="nav_item" href="#">힐링</a></li>
                                <li><a class="nav_item" href="#">로맨스</a></li>
                                <li><a class="nav_item" href="#">자기계발</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav_item" href="#">연재</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="#">문학</a></li>
                                <li><a class="nav_item" href="#">정보공유</a></li>
                                <li><a class="nav_item" href="#">일상</a></li>
                                <li><a class="nav_item" href="#">기타</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav_item" href="#">펀딩</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="#">나의펀딩</a></li>
                                <li><a class="nav_item" href="#">펀딩진행중</a></li>
                                <li><a class="nav_item" href="#">펀딩 성공작</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav_item" href="#">구독</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="#">구독권 안내</a></li>
                                <li><a class="nav_item" href="#">구독 철회</a></li>
                                <li><a class="nav_item" href="#">QNA</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav_item" href="#">마이페이지</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="#">정보수정</a></li>
                                <li><a class="nav_item" href="#">구독권 조회</a></li>
                                <li><a class="nav_item" href="#">장바구니</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <nav class="navbar_right">
                <input class="searchBox">
                <a class="navbar_signup" href="#">회원가입</a>
                <a class="navbar_signup" href="#">로그인</a>
                <a class="navbar_signup" href="#">공지사항</a>
            </nav>
        </div>
    </header>
     <div class="bodyrvb">
        <div class="main1_contentrvb">
            <div class="main1_left">
                <p class="fontimportant main1_leftword1">
                    독서 습관의 시작,
                </p>
                <p class="fontimportant main1_leftword2">
                    RVB와의 동행
                </p>
                <a class="main1_button1" href="#">
                    <p class="fontnormal">Join with us</p>
                </a>
                <a class="main1_button2" href="#">
                    <p class="fontnormal">Subscribe</p>
                </a>
            </div>
            <div class="main1_right">
                <img src="./resources/image/앉아있는애기.jpg">
            </div>
        </div>
        <div class="main2_contentrvb">
            <div class="main2_top">
                <div class="main2_top_name">
                    <p class="fontevent">이번주 추천 도서</p>
                </div>
                <div class="main2_top_content">
                    <span class="main2_top_content1">
                        <p class="fontnothing">이러쿵저러쿵 책추천 소개</p>
                        <p class="fontnothing">이러쿵저러쿵 책추천 소개</p>
                    </span>
                    <span class="main2_top_content2">
                        <p class="fontnothing">이러쿵저러쿵 책추천 소개</p>
                        <p class="fontnothing">이러쿵저러쿵 책추천 소개</p>
                    </span>
                </div>
            </div>
        </div>
        <div class="main3_contentrvb">
            <div class="main3_top">
                <div class="main3_top_name">
                    <p class="fontimportant2">앗챠차 ! 지난주 추천 도서</p>
                </div>
                <div class="main3_top_content">
                    <p class="fontnothing">대충 책 슬라이드 쫘라라락</p>
                </div>
            </div>
        </div>
    </div>
</div>