<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/book/bookregister.css">
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
<title>Book Admin</title>
</head>
<body>
<%-- <%@ include file="../../../view/template_header.jsp"%> --%>
<%AdminVo vo = (AdminVo)session.getAttribute("ssAdminVo");
 //out.print(vo);
if(vo == null){
%>
<%@ include file="../../template_header.jsp" %>
	<%} else { %>
<%@ include file="../../template_header_login.jsp" %>
	<%} %>	
  <div class="body_bookregister">
        <div class="bookregister_name">
            <p class="fontimportant">책 등록</p>
        </div>
        <form name="bookRegister" method="post" action="<%=request.getContextPath()%>/book_register.lo">
        <div class="bookregister_bookwrite">
            <div class="bookregister_bookregistercontent">
            
                <div class="bookregister_bookregistername">
                    <p class="fontimportant2">제목</p>
                    <textarea name="bkTitle" cols="60" rows="2" placeholder="제목을 입력하세요"></textarea>
                </div>
                <div class="bookregister_bookregistername">
                    <p class="fontimportant2">작가</p>
                    <textarea name="bkWriter" cols="60" rows="2" placeholder="작가를 입력하세요"></textarea>
                </div>
                <div class="bookregister_bookregistername">
                    <p class="fontimportant2">이미지 경로</p>
                    <textarea name="bkImg" cols="120" rows="2" placeholder="이미지 경로를 입력하세요"></textarea>
                </div>
                <div class="bookregister_bookregistername">
                    <p class="fontimportant2">가격</p>
                    <textarea name="bkPrice" cols="120" rows="2" placeholder="가격을 입력하세요"></textarea>
                </div>
                    <div class="bookregister_bookregistername">
                    <p class="fontimportant2">출판일</p>
                    <textarea name="bkPublishdate" cols="120" rows="2" placeholder="출판일을 날짜 형태로 입력하세요"></textarea>
                </div> 
                <div class="bookregister_bookregistername">
                    <p class="fontimportant2">장르 번호</p>
                    <textarea name="gnNo" cols="120" rows="2" placeholder="장르번호를 입력하세요"></textarea>
                </div>
                <div class="bookregister_bookregistername">
                    <p class="fontimportant2">목차</p>
                    <textarea name="bkIndex" cols="120" rows="10" placeholder="목차를 입력하세요"></textarea>
                </div>
                <div class="bookregister_bookregistercontent">
                    <p class="fontimportant2">내용</p>
                    <textarea name="bkContent" cols="150" rows="30" placeholder="내용을 입력하세요"></textarea>
                </div>
            </div>
        </div>
        <div class="bookregister_btn">
            <button type="submit" class="bookregister_registerbtn" >등록하기</button>
            <button type="button" class="bookregister_registerbtn"
            onclick ="history.back();">등록취소</button>
        </div>
        </form>
        
    </div>
 <%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>