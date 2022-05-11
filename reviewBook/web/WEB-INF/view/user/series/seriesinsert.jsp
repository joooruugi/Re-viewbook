<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/series/seriesinsert.css">
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>
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
<% SeriesVo svo = (SeriesVo)request.getAttribute("svo"); 
	 	//System.out.println(svo); 
	 	%>
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
    <div class="series_banner">
        <div id="series_banner_title">    
        <h2><br><a href="seriesmain">연재 <글쓰기></a></h2>
        <br><br><br>
        <p>작가가 되어 자유롭게 글을 작성해보세요</p>
    <img src="./resources/image/series/author3.png" class="series_banner_img">
    </div>
	</div>
	<div class="bodyrvb">
		<nav class="sidemenu">
			<ul class="sidemenu_series">
				<li><a class="sidemenu_item sidemenu_topmenu">연재</a></li>
				<li><a class="sidemenu_item sidemenu_menu" href="seriesmain">전체</a></li>
				<li><a class="sidemenu_item sidemenu_menu" href="seriescategoryfiction">문학</a></li>
				<li><a class="sidemenu_item sidemenu_menu" href="seriescategoryinfo">정보공유</a></li>
				<li><a class="sidemenu_item sidemenu_menu" href="seriescategorydaily">일상</a></li>
				<li><a class="sidemenu_item sidemenu_menu" href="seriescategoryetc">기타</a></li>
			</ul>
		</nav>
		<div class="contentrvb">
			<div class="contentmain">
				<div id="series_insert_content">
					<form action="seriesinsert.do" method="post"
						enctype="multipart/form-data">
						<table id="series_insert">
							<tr>
								<td>카테고리</td>
                                <td colspan="3">
                                    <select name="wbCategory" id="wbCategory" required>
										<option value="문학">문학</option>
										<option value="정보공유">정보공유</option>
										<option value="일상">일상</option>
										<option value="기타">기타</option>
								</select>
                            </td>
							</tr>
							<tr>
								<td>제목</td>  
                                <td colspan="3">
                                    <input type="text" id="wbTitle" name="wbTitle"
									placeholder="제목을 입력해주세요" required>
                                </td>
							</tr>
							<tr>
								<td>내용</td>
                                <td colspan="3"> 
                                	<textarea id="wbContent" name="wbContent" placeholder="내용을 입력해주세요" required>
                                	</textarea>
                                </td>
							</tr>


							<!-- 여기서부터 첨부파일 테스트 망하면 빼버림 -->
                            <tr>
							<td>첨부파일</td>
                            <td colspan="3"><input type="file" id="wbContentFile" 
								name="wbContentFile">
                            </td>
							</tr>
                        </table>
                            <table id="series_insert_btn">
							<tr>
								<td><button type="submit" id="insert_btn" class="button2">게시글등록</button>
                             <button type="button" id="insert_reset_btn" class="button4" onclick="history.back();">작성취소</button></td>

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
 CKEDITOR.replace( 'wbContent' 
		 , {height: 500                                                  
 });
</script>

</body>
</html>