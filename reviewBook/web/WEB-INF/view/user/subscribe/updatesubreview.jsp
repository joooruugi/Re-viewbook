<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/subscribe/subscribereview.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- ckediter cdn  -->
<script src="//cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
<meta charset="UTF-8">
<title>RVB 구독</title>
</head>
<body>
<%	UserVo vo = (UserVo) session.getAttribute("ssUserVo");
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
		 //out.print(vo);
		// out.print(avo);
		if (vo == null && avo == null) { %>
	<%@ include file="../../../view/template_header.jsp"%>
	<% } else if (vo != null) { %>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<% } else if (avo != null) { %>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<% } %>
		<div id="main_wrap">
		<div class="bodyrvb">
			<nav class="sidemenu">
			<ul class="sidemenu_subscribe">
				<li><a class="sidemenu_item sidemenu_topmenu">구독</a></li>
				<li><a class="sidemenu_item" href="subscribemain">구독권 안내</a></li>
				<li><a class="sidemenu_item" href="subscribecancle">구독 철회</a></li>
				<li><a class="sidemenu_item" href="subscribeqna">QNA</a></li>

			</ul>
		</nav>
			<div class="contentrvb">
				<div class="contentmain">
					<div id="series_update_content">
						<form action="updatesubreview.do" method="post">
							<table id="sub_review_update">
								<tr>
									<td>아이디</td>
									<td colspan="2"><input type="text" id="usId"
										name="usId" value="${ssvo.usId}" required readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>구독정보</td>
									<td colspan="2"><input type="text" id="subInf"
										name="subInf" value="${ssvo.subInf}" required readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>구독현황</td>
									<td colspan="2"><input type="text" id="subYN"
										name="subYN" value="${ssvo.subYN}" required readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>리뷰</td>
									<td colspan="3"><textarea id="subReview" name="subReview"
											required>${ssvo.subReview}</textarea>
									</td>
								</tr>
							</table>
							<table id="sub_rivew_update_btn">
								<tr>
									<td><button type="submit" id="update_btn" class="button2">리뷰작성</button>
										<button type="button" id="update_reset_btn" class="button4"
											onclick="history.back()">작성취소</button></td>

								</tr>

							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>
	<!-- ckediter api 스크립트 -->
	<script>
		CKEDITOR.replace('subReview', {
			height : 200
		});
	</script>
</body>
</body>
</html>