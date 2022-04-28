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
<%@ include file="../../../view/template_header.jsp"%>
 <div class="body_adminmain">
        <div class="adminmain_profile">
            <div class="adminmain_profile_pic">
                관리자 프로필 이미지
            </div>
            <div class="adminmain_profile_text">
                관리자 정보
            </div>
        </div>
        <div class="adminmain_notice">
            <a class="adminmain_notice_link" href="#">
                <div class="adminmain_notice_link_text">
                    <p class="fontnormal">공지사항 목록</p>
                    <p class="fontnormal">바로가기</p>
                </div>
            </a>
        </div>
        <div class="adminmain_userlist">
            <a class="adminmain_userlist_link" href="#">
                <div class="adminmain_userlist_link_text">
                    <p class="fontnormal">회원 목록</p>
                    <p class="fontnormal">바로가기</p>
                </div>
            </a>
        </div>
    </div>
    <%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>