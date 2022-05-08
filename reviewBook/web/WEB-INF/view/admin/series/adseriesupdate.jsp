<link rel="stylesheet"href="<%=request.getContextPath()%>/resources/css/series/adseriesupdate.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">

<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- ckediter cdn  -->
<script src="//cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
<meta charset="UTF-8">
<title>RVB 연재 게시글</title>
</head>
<body>
	<%
		SeriesVo svo = (SeriesVo) request.getAttribute("svo");
	//System.out.println(svo); 
	//out.print(svo);
	%>
		<%	UserVo vo = (UserVo) session.getAttribute("ssUserVo");
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
		// out.print(vo);
		// out.print(avo);
		if (vo == null && avo == null) { %>
	<%@ include file="../../../view/template_header.jsp"%>
	<% } else if (vo != null) { %>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<% } else if (avo != null) { %>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<% } %>
	<div id="main_wrap">
		<div class="series_banner">
			<div id="series_banner_title">
				<h2>
					<a href="seriesmain">연재</a>
				</h2>
				<br><br>
				<p>작가가 되어 자유롭게 글을 작성해보세요</p>
				<img src="./resources/image/series/author3.png"
					class="series_banner_img">
			</div>
		</div>
		<div class="bodyrvb">
			<nav class="sidemenu">
				<ul class="sidemenu_series">
				<li><a class="sidemenu_item sidemenu_topmenu">연재게시판 관리</a></li>
				<li><a class="sidemenu_item" href="adseriesmain">전체</a></li>
				</ul>
			</nav>
			<div class="contentrvb">
				<div class="contentmain">
					<div id="series_update_content">
						<form action="adseriesupdate.do" method="post"
							enctype="multipart/form-data">
							<table id="series_update">
								<!-- 관리자 페이지에서 작업하는 경우에는 카테고리 제외 모두 readonly 옵션 부여 필수  -->
								<tr>
									<td>카테고리</td>
									<td colspan="3"><select name="wbCategory" id="wbCategory"
										required>
											<option value="문학">문학</option>
											<option value="정보공유">정보공유</option>
											<option value="일상">일상</option>
											<option value="기타">기타</option>
									</select></td>
								</tr>
								<tr>
									<td>제목</td>
									<td colspan="3"><input type="text" id="wbTitle"
										name="wbTitle" value="<%=svo.getWbTitle()%>" required readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>내용</td>
									<td colspan="3"><textarea id="wbContent" name="wbContent" readonly="readonly"
											required><%=svo.getWbContent().replace("<br>", "\r\n")%></textarea>
									</td>
								</tr>
								<tr>
									<td>
										<!-- 글번호 타입 : hidden --> <input type="hidden" name="wbNo"
										value="<%=svo.getWbNo()%>">
									</td>
								</tr>


								<!-- 여기서부터 첨부파일 테스트 망하면 빼버림 -->
								<tr>
									<td>첨부파일</td>
									<td colspan="3"><input type="file" id="wbContentFile"
										name="wbContentFile" readonly="readonly"></td>
								</tr>
								</table>
								<div id="series_update_funding">
								<div class="header">
								<p>--- 펀딩관리 --- </p>
								</div>
								<div class="update_funding_ox">
								펀딩 여부  <input type ="radio" name="fdOX" value="0" id="fdX"><label for="fdX"> 펀딩 X</label> &nbsp; &nbsp;
								<input type ="radio" name="fdOX" value="1" id="fdO"> <label for="fdO"> 펀딩 O </label>
								</div>
								<div class="update_fdLimit">
								1인당 제한금액 <input type="text" name ="fdLimit" id = "fdLimit" value="<%=svo.getFdLimit()%>">
								</div>
								<div class="update_fdDeadline">
								펀딩 마감일 <input type="text" name ="fdDeadline" id = "fdDeadline"
								placeholder="날짜 형태로 입력해주세요" value="<%=svo.getFdDeadline()%>">
								</div>
								<div class="update_fdAccumulate">
								목표금액 <input type="text" name ="fdAccumulate" id = "fdAccumulate"
								placeholder="숫자만 입력해주세요" value="<%=svo.getFdAccumulate()%>">
								</div>
								</div>
							<table id="series_update_btn">
								<tr>
									<td><button type="submit" id="update_btn" class="button2">게시글
											수정</button>
										<button type="button" id="update_reset_btn" class="button4"
											onclick="location.href='adseriesread?wbNo=<%=svo.getWbNo()%>';">수정취소</button></td>

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
		CKEDITOR.replace('wbContent', {
			height : 500
		});
	</script>
</body>



</html>