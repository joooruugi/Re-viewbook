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
	<%@ include file="../../../view/template_header.jsp"%>
	<div class="body_usernotice">
		<div class="usernotice_name">
			<p class="fontimportant">공지사항</p>
		</div>
		<div class="usernotice_noticecontent">
			<div class="usernotice_noticelist">
				<table class="notice">
					<thead class="notice_thead fontimportant2">
						<td>NO.</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
					</thead>
					<tr class="notice_line">
						<td>1</td>
						<td>첫번째공지사항입니다. 지금은 새벽3시</td>
						<td>쥬르기</td>
						<td>2022.04.23</td>
					</tr>
					<tr class="notice_line">
						<td>2</td>
						<td>두번째공지사항입니다. 지금은 새벽3시</td>
						<td>쥬르기</td>
						<td>2022.04.23</td>
					</tr>
					<tr class="notice_line">
						<td>3</td>
						<td>세번째공지사항입니다. 지금은 새벽3시</td>
						<td>쥬르기</td>
						<td>2022.04.23</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="usernotice_paging">페이지가 넘어가요</div>
	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>