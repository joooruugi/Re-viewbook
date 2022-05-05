<%@page import="kh.semi.reviewBook.admin.service.AdminService"%>
<%@page import="kh.semi.reviewBook.admin.vo.AdminVo"%>
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.reviewBook.user.notice.vo.NoticeVo"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/notice/notice.css">
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
	<div class="body_usernotice">
		<div class="usernotice_name">
			<p class="fontimportant">공지사항</p>
		</div>
		<%
			ArrayList<NoticeVo> nlist = (ArrayList<NoticeVo>) request.getAttribute("nlist");
		if (nlist != null) {
		%>
		<div class="usernotice_noticecontent">
			<div class="usernotice_noticelist">
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
					<%} }%>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>