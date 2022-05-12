<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="wrap header">
 <header>
        <div class="navbar">
            <nav class="navbar_left mainlogo">
            <a href="<%=request.getContextPath() %>/main">
                <img src="./resources/image/all/header/RVBlogo.png">
                </a>
            </nav>
            <nav class="navbar_left">
                <div class="dropdownmenu">
                    <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="bookmain">도서</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="booklistth">스릴러</a></li>
                                <li><a class="nav_item" href="booklistheal">힐링</a></li>
                                <li><a class="nav_item" href="booklistro">로맨스</a></li>
                                <li><a class="nav_item" href="booklistself">자기개발</a></li>
                            </ul>
                        </li>
                        </ul>
                        <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="seriesmain">연재</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="seriescategoryfiction">문학</a></li>
                                <li><a class="nav_item" href="seriescategoryinfo">정보공유</a></li>
                                <li><a class="nav_item" href="seriescategorydaily">일상</a></li>
                                <li><a class="nav_item" href="seriescategoryetc">기타</a></li>
                            </ul>
                        </li>
                        </ul>
                        <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="fundingsuccessboardlist">펀딩</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="fundingboardlist">펀딩진행중</a></li>
                                <li><a class="nav_item" href="fundingsuccessboardlist">펀딩 성공작</a></li>
                            </ul>
                        </li>
                        </ul>
                        <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="subscribemain">구독</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="subscribemain">구독권 안내</a></li>
                                <li><a class="nav_item" href="subscribecancle">구독 철회</a></li>
                                <li><a class="nav_item" href="subscribeqna">QNA</a></li>
                                <li><a class="nav_item" href="adsubscribemain">구독회원 관리</a></li>
                            </ul>
                        </li>
                        </ul>
                </div>
            </nav>
            <nav class="navbar_right">
                <a class="navbar_signup" href="<%=request.getContextPath() %>/admain">[관리자 화면]</a>
                <a class="navbar_signup" href="<%=request.getContextPath() %>/logout" onclick="adlogoutpop()">로그아웃</a> 
                <a class="navbar_signup" href="<%=request.getContextPath() %>/adnotice">공지사항</a>
            </nav>
        </div>
    </header>
    <script>
    function adlogoutpop(){
    	alert("로그아웃 되었습니다.");
    }</script>
</div>