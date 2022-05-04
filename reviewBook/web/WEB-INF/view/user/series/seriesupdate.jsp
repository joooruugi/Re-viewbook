<link rel="stylesheet"href="<%=request.getContextPath()%>/resources/css/series/seriesupdate.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main/main.css">
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RVB 연재 게시글</title>
</head>
<!-- ckediter cdn  -->
<script src="//cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
<body>
	<%
		SeriesVo svo = (SeriesVo) request.getAttribute("svo");
	//System.out.println(svo); 
	//out.print(svo);
	%>
	<div id="main_wrap">
	 <%UserVo vo = (UserVo)session.getAttribute("ssUserVo");
 out.print(vo);
if(vo == null){
%>
<%@ include file="../../template_header.jsp" %>
	<%} else { %>
<%@ include file="../../template_header_login.jsp" %>
	<%} %>	
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
					<li><a class="sidemenu_item sidemenu_topmenu">연재</a></li>
					<li><a class="sidemenu_item" href="seriesmain">전체</a></li>
					<li><a class="sidemenu_item" href="seriescategoryfiction">문학</a></li>
					<li><a class="sidemenu_item" href="seriescategoryinfo">정보공유</a></li>
					<li><a class="sidemenu_item" href="seriescategorydaily">일상</a></li>
					<li><a class="sidemenu_item" href="seriescategoryetc">기타</a></li>
				</ul>
			</nav>
			<div class="contentrvb">
				<div class="contentmain">
					<div id="series_update_content">
						<form action="seriesupdate.do" method="post"
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
										name="wbTitle" value="<%=svo.getWbTitle()%>" required >
									</td>
								</tr>
								<tr>
									<td>내용</td>
									<td colspan="3"><textarea id="wbContent" name="wbContent"
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
										name="wbContentFile"></td>
								</tr>
							</table>
							<table id="series_update_btn">
								<tr>
									<td><button type="submit" id="update_btn" class="button2">게시글
											수정</button>
										<button type="button" id="update_reset_btn" class="button4"
											onclick="location.href='seriesread?wbNo=<%=svo.getWbNo()%>';">수정취소</button></td>

								</tr>

							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../../template_footer.jsp"%>
	</div>

	<!-- ckediter api 스크립트 -->
	<script>
		CKEDITOR.replace('wbContent', {
			height : 500
		});
	</script>
</body>



</html>