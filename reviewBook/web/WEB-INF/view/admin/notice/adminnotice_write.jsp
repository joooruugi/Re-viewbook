<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/notice/adnoticewrite.css">
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
<title>Notice Admin</title>
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
  <div class="body_adminnotice">
        <div class="adminnotice_name">
            <p class="fontimportant">공지사항 작성</p>
        </div>
        <form name="noticeRegister" method="post" action="<%=request.getContextPath()%>/adminnotice_write.lo">
        <div class="adminnotice_noticewrite">
            <div class="adminnotice_noticewritecontent">
                <div class="adminnotice_writename">
                    <p class="fontimportant2">제목</p>
                    <textarea name="ntTitle" cols="120" rows="2" placeholder="제목을 입력하세요"></textarea>
                </div>
                <div class="adminnotice_writecontent">
                    <p class="fontimportant2">내용</p>
                    <textarea name="ntContent" cols="150" rows="30" placeholder="내용을 입력하세요"></textarea>
                </div>
            </div>
        </div>
        <div class="adminnotice_btn">
            <button type="submit" class="adminnotice_writebtn" >등록하기</button>
        </div>
        </form>
        
    </div>
 <%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>