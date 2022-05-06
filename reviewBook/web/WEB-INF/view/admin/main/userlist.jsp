<%@page import="java.util.ArrayList"%>
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
            <%
			ArrayList<UserVo> ulist = (ArrayList<UserVo>) request.getAttribute("ulist");
		if (ulist != null) {
		%>
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
                <%
						for (UserVo uvo : ulist) {
					%>
                <tr class="userlist_tr fontnormal">
                    <td><%=uvo.getUsName()%></td>
                    <td><%=uvo.getUsNickname()%></td>
                    <td><%=uvo.getUsGender()%></td>
                    <td><%=uvo.getUsBirth()%></td>
                    <td><%=uvo.getUsPhone()%></td>
                    <td><%=uvo.getUsEmail()%></td>
                    <td><%=uvo.getUsAddress()%></td>
                </tr>
                	<%} }%>

            </table>
        </div>
    </div>
    <div class="userlist_paging">
        <button class="userlist_pagingbtn">아마 페이징</button>
    </div>
    <%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>