<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.user.notice.vo.NoticeVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/notice/adnotice.css">
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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
	<div class="body_adminnotice">
		<div class="adminnotice_name">
			<p class="fontimportant">공지사항</p>
		</div>
		<%
			ArrayList<NoticeVo> nlist = (ArrayList<NoticeVo>) request.getAttribute("nlist");
		if (nlist != null) {
		%>
		<div class="adminnotice_noticecontent">
			<div class="adminnotice_noticelist">
				<table class="notice">
					<tr class="notice_thead fontimportant2">
						<td>NO.</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
					</tr>
					<%
						for (NoticeVo nvo : nlist) {
					%>
					<tr class="notice_line">
						<td><%=nvo.getNtNo()%></td>
						<td><%=nvo.getNtTitle()%></td>
						<td><%=nvo.getNtNickname()%></td>
						<td><%=nvo.getNtDate()%></td>
					</tr>
					<%
						}
					}
					%>
				</table>
			</div>
		</div>
		<div class="adminnotice_btn">
			<button class="adminnotice_writebtn"
				onclick="location.href='adminnotice_write'">공지사항 작성</button>
		</div>

	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>