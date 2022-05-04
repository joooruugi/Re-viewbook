<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.admin.vo.NoticeVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/notice/noticecontent.css">
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
<title>RVB</title>
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
	  <div class="body_notice">
        <div class="adminnotice_name">
            <p class="fontimportant">공지사항</p>
        </div>
        <div class="notice_noticecontent">
            <div class="notice_noticecontenthead">
                <div class="notice_noticecontentname">
                    <p class="fontimportant2">제목들어감</p>
                </div>
            </div>
            <div class="notice_contentright">
                <div class="notice_noticecontentnick">
                    <p class="fontnormal noticecontentname">작성자</p>
                    <p class="fontnothing noticecontentname2">닉네임들어감</p>
                </div>
                <div class="notice_content_div"></div>
                <div class="notice_noticecontentcnt">
                    <p class="fontnormal noticecontentname">조회수</p>
                    <p class="fontnothing noticecontentname2">숫자들어감</p>
                </div>
                <div class="notice_content_div"></div>
                <div class="notice_noticecontentdate">
                    <p class="fontnormal noticecontentname">작성일</p>
                    <p class="fontnothing noticecontentname2">작성일들어감</p>
                </div>
            </div>

            <div class="notice_noticecontentbody">
                <div class="notice_noticecontent_content">
                    <p class="fontnothing noticecontentcontent">내용들어감</p>
                </div>
            </div>
        </div>
        <div class="adminnotice_btn">
            <button type="submit" class="notice_listbtn">목록으로</button>
            
        </div>

    </div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>