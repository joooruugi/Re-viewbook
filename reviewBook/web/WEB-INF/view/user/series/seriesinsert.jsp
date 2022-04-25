<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/series/seriesinsert.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연재 게시글</title>
</head>
<body>
    <div class="series_banner">
		<div id="series_banner_title">
			<h2>
				<a href="seriesmain">연재</a>
			</h2>
			<br>
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
                                    <textarea id="wbContent" name="wbContent"
										placeholder="내용을 입력해주세요" required></textarea>
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
								<td><button type="submit" id="insert_btn" class="button4">게시글등록</button>
                             <button type="reset" id="insert_reset_btn" class="button2">작성취소</button></td>

							</tr>
        
						</table>
					</form>
		
                </div>
			</div>
		</div>
	</div>




</body>
</body>
</html>