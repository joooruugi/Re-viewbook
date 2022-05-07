<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/admain.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/footer.css">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB Admin</title>
</head>
<body>
<%@ include file="../../../view/template_header_adlogin.jsp"%>
  <div class="body_adminmain">
        <div class="adminmain_profile">
            <div class="adminmain_profile_pic">
                <img src="<%=request.getContextPath()%>/resources/image/signuplogin/회원가입개인.png">
                <p class="fontimportant">관리자님 환영합니다!</p>
            </div>
            <%AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
            ArrayList<AdminVo> alist = (ArrayList<AdminVo>)request.getAttribute("alist");%>
           
            <div class="adminmain_profile_text">
                <p class="fontnormal">1:1 문의 이메일<br>reviewbook.rvb@gmail.com</p><br><br>
                <p class="fontnormal">총괄관리자 연락처<br><strong>010-3328-7786</strong></p><br><br>
                <p class="fontnormal">시스템 이상 문의<br>reviewbook.rvb@gmail.com</p>
            </div>
            
        </div>
        <div class="adminmain_notice">
            <a class="adminmain_notice_link" href="adnotice">
                <div class="adminmain_notice_link_text">
                    <p class="fontnormal">공지사항 목록</p>
                    <p class="fontnormal">바로가기</p>
                </div>
            </a>
            <div class="adminmain_div"></div>
            <a class="adminmain_series_link" href="#">
                <div class="adminmain_series_link_text">
                    <p class="fontnormal">연재 관리</p>
                    <p class="fontnormal">바로가기</p>
                </div>
            </a>
        </div>
        <div class="adminmain_userlist">
            <a class="adminmain_userlist_link" href="userlist">
                <div class="adminmain_userlist_link_text">
                    <p class="fontnormal">회원 목록</p>
                    <p class="fontnormal">바로가기</p>
                </div>
            </a>
            <div class="adminmain_div"></div>
            <a class="adminmain_funding_link" href="#">
                <div class="adminmain_funding_link_text">
                    <p class="fontnormal">펀딩 관리</p>
                    <p class="fontnormal">바로가기</p>
                </div>
            </a>
        </div>
    </div>
    <%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>