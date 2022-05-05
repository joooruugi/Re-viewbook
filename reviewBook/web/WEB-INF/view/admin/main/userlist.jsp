<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/userlist.css">
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
<%
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
		// out.print(vo);
		if (avo == null) {
		%>
		<%@ include file="../../../view/template_header.jsp"%>
		<%
			} else {
		%>
		<%@ include file="../../../view/template_header_adlogin.jsp"%>
		<%
			}
		%>
  <div class="userlist">
        <div class="userlist_content">
            <div class="userlist_name">
                <p class="fontimportant">회원정보 조회</p>
            </div>
            <table class="userlisttable">
                <thead class="userlist_thead fontimportant2">
                    <td>이름</td>
                    <td>닉네임</td>
                    <td>성별</td>
                    <td>생년월일</td>
                    <td>연락처</td>
                    <td>이메일</td>
                    <td>주소</td>
                </thead>
                <tr class="userlist_tr fontnormal">
                    <td>쥬르기</td>
                    <td>쥬르기</td>
                    <td>F</td>
                    <td>98.08.01</td>
                    <td>010-2342-2323</td>
                    <td>adsfd@asdfa.com</td>
                    <td>어쩌구</td>
                </tr>
                <tr class="userlist_tr fontnormal">
                    <td>이름 들어감</td>
                    <td>닉네임 들어감</td>
                    <td>성별 들어감</td>
                    <td>생년월일 들어감</td>
                    <td>연락처 들어감</td>
                    <td>이메일 들어감</td>
                    <td>주소들어감</td>
                </tr>

            </table>
        </div>
    </div>
    <div class="userlist_paging">
        <button class="userlist_pagingbtn">아마 페이징</button>
    </div>
    <%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>