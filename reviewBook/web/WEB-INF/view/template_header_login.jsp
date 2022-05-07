<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<div class="wrap header">
 <header>
        <div class="navbar">
            <nav class="navbar_left mainlogo">
            <a href="<%=request.getContextPath() %>/">
                <img src="./resources/image/all/header/RVBlogo.png">
                </a>
            </nav>
            <nav class="navbar_left">
                <div class="dropdownmenu">
                    <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="naver.com">도서</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="naver.com">스릴러</a></li>
                                <li><a class="nav_item" href="#">힐링</a></li>
                                <li><a class="nav_item" href="#">로맨스</a></li>
                                <li><a class="nav_item" href="#">자기계발</a></li>
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
                            </ul>
                        </li>
                        </ul>
                        <ul class="nav_dropdownmenu1">
                        <li>
                            <a class="nav_item" href="mypagemain">마이페이지</a>
                            <ul class="nav_dropdownmenu2">
                                <li><a class="nav_item" href="myinformation">정보수정</a></li>
                                <li><a class="nav_item" href="cartlist">장바구니</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <nav class="navbar_right">
                <input class="searchBox"><%-- 
                <a class="navbar_signup" href="<%=request.getContextPath() %>/signup">회원가입</a>--%>
                <a class="navbar_signup" href="<%=request.getContextPath() %>/logout" onclick="logoutpop()">로그아웃</a> 
                <a class="navbar_signup" href="<%=request.getContextPath() %>/notice">공지사항</a>
            </nav>
        </div>
    </header>
    <script>
    function logoutpop(){
    	alert("로그아웃 되었습니다.");
    }
    </script>
    
</div>