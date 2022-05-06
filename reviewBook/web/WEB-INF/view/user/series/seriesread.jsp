<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/series/seriesread.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/all/all.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/reset.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/all/footer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main/main.css">
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesReCommentVo"%>
<%@page import="kh.semi.reviewBook.series.model.vo.SeriesVo"%>
<%@page import="kh.semi.reviewBook.user.model.vo.UserVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- xeicon cdn -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<title>RVB 연재 게시글</title>
</head>
<body>
	<% SeriesVo svo = (SeriesVo)request.getAttribute("svo"); 
	 	//System.out.println(svo); 
	 	String msg = (String)session.getAttribute("msg");
		if(msg==null){
	 	%>
	 <div id="main_wrap">
	<%	UserVo vo = (UserVo) session.getAttribute("ssUserVo");
		AdminVo avo = (AdminVo) session.getAttribute("ssAdminVo");
		 out.print(vo);
		// out.print(avo);
		if (vo == null && avo == null) { %>
	<%@ include file="../../../view/template_header.jsp"%>
	<% } else if (vo != null) { %>
	<%@ include file="../../../view/template_header_login.jsp"%>
	<% } else if (avo != null) { %>
	<%@ include file="../../../view/template_header_adlogin.jsp"%>
	<% } %>
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
				<div id="series_board_read">
					<div class="series_board_read_all">
						<div class="series_read_title_content">
							<table id="series_read_title">
								<tr>
									<td colspan="4"><h1><%=svo.getWbTitle() %></h1></td>
								</tr>
								<tr>
									<td colspan="2"><p><%=svo.getWbWriter() %></p></td>
									<td><p><%=svo.getWbDate().substring(0, 16) %></p></td>
									<td><p><i class="xi-eye-o"></i>&nbsp;<%=svo.getWbCount() %></p></td>
								</tr>
								<tr>
									<td colspan="4"><span
										style="background-color: rgba(234, 244, 252, 1);"><%=svo.getWbCategory() %></span></td>
								</tr>
							</table>
							<table id="series_read_content">
								<tr>
									<td colspan="4"><%=svo.getWbContent() %></td>
								</tr>
							</table>
						</div>
						<!-- 로그인 한 회원 = 게시물 작성자 일치하는 경우에만 게시물 수정 삭제 버튼 표시 -->
						<% if(vo.getUsId().equals(svo.getUsId())){%>
						<div class="series_board_up_de_btn">
						<button id="btn_series_update" class="button2"
						 onclick="location.href='seriesupdate?wbNo=<%=svo.getWbNo()%>';">게시물 수정</button>
						<button id="btn_series_delete" class="button4">게시물 삭제</button>
						</div>
						<%} %>
						<div class="series_board_read_funding">
							<table id="board_read_funding">
								<tr>
									<td>해당 작품을 책으로 만나보고 싶으신가요📚📖 자세한 정보는 이곳을 클릭해주세요
										<button id="btn_funding" class="button4">펀딩하기👍</button> <br>
										<div class="modal">
										<div class="modal_content">
										<div id ="modal_funding_content">
										<p> 작품번호 : <%=svo.getWbNo() %></p>
										<p> 작품명 : <%=svo.getWbTitle() %></p>
										<p> 작가 : <%=svo.getWbWriter() %></p>
										<p> 카테고리 : <%=svo.getWbCategory() %></p>
										<p> 후원금액 및 마감일 등 자세한 사항은 펀딩 탭에서 확인 가능합니다 </p>
										<p> 이동하기 버튼을 클릭하여 지금 바로 확인해보세요!💸 </p>
										</div>
										<div class="btn_funding_move_close">
										<button id="btn_funding_move" class="button2">이동하기</button>
										<button id="btn_funding_close" class="button4">닫기</button>
										
										</div>
										</div>
										</div>
									<br><br><small>참고 : 목표 금액 이상이 모이면 해당 작품의 펀딩이 성공되며, 펀딩
											마감일까지 목표 금액을 달성하지 못한 경우 결제가 진행되지 않습니다.</small>

									</td>
								</tr>
							</table>
						</div>
						<div class="series_board_recomment_all">
							<table id="board_read_recomment">
								<tr>
									<td colspan="3">댓글 [<%=svo.getReCommentCnt() %>]
										<form action="seriescomment" method="post">
											<div class="star-rating">
												<input type="radio" id="5-stars" name="wbcRating" value="5" />
												<label for="5-stars" class="star">&#9733;</label> <input
													type="radio" id="4-stars" name="wbcRating" value="4" /> <label
													for="4-stars" class="star">&#9733;</label> <input
													type="radio" id="3-stars" name="wbcRating" value="3" /> <label
													for="3-stars" class="star">&#9733;</label> <input
													type="radio" id="2-stars" name="wbcRating" value="2" /> <label
													for="2-stars" class="star">&#9733;</label> <input
													type="radio" id="1-star" name="wbcRating" value="1" /> <label
													for="1-star" class="star">&#9733;</label>
											</div>
									
											<input type="hidden" name="wbNo" value="<%=svo.getWbNo()%>">
											<input type="text" id="wbcContent" name="wbcContent"
												placeholder="댓글을 입력해주세요. 한번 등록한 별점은 수정이 불가능합니다." 
												required="required">
											<button type="submit" id="btn_submit_comment" class="button1">등록</button>
											
										</form>
									</td>
								</tr>

							</table>
							<%
			if(svo.getReCommentCnt()>0){
			//자료형 ArrayList<SeriesReCommentVo>
			for(SeriesReCommentVo srvo : svo.getSrvolist()){
			%>				
							<div id="series_read_comment">
							<!-- 로그인 한 회원 = 댓글 작성자 일치하는 경우에만 댓글 수정 삭제 버튼 표시 -->
							<% if(vo.getUsId().equals(srvo.getUsId())){%>
							<div class="series_board_comment_up_de_btn" >
							<button class="btn_board_comment_update">댓글 수정</button>
							<div class="update_board_comment">
								<form action="seriescommentupdate" method="post">
									<input type ="text" value="<%=srvo.getWbcContent() %>" id = "wbcContent" name="wbcContent">
									<input type="hidden" name="wbNo" value="<%=svo.getWbNo()%>">
									<input type="hidden" name="wbcNo" value="<%=srvo.getWbcNo()%>">
									<button type="submit" id="btn_update_submit_comment" class="button2">수정</button>
									<button id="btn_update_reset" class="button4">취소</button>
								</form> 
								</div>
							<button class="btn_board_comment_delete"
							onclick="location.href='seriescommentdelete?wbNo=<%=svo.getWbNo()%>&wbcNo=<%=srvo.getWbcNo()%>';">댓글 삭제</button>
							</div>
							<%} %>
							<table id="series_read_comment_rist">
								<tr>
									<td colspan="3"><%=srvo.getWbcWriter() %> &nbsp; &nbsp; <span><%=srvo.getWbcDate().substring(0, 16) %></span></td>
								</tr>
								<tr>
									<td colspan="3"><p style="color:#f90;">&#9733;<%=srvo.getWbcRating() %></p></td>
								</tr>
								<tr>
									<td colspan="3"><%=srvo.getWbcContent() %></td>
								</tr>
							
								</table>
							
							</div>
							<%		
			}
		}

%>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>
</div>
<%} else{ %>
<script>
 	var msgVal = '<%= session.getAttribute("msg") %>';
	if(msgVal !='' || msgVal != false){
		alert(msgVal);
	} 
</script>
<% session.removeAttribute("msg"); %>
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
				<div id="series_board_read">
					<div class="series_board_read_all">
						<div class="series_read_title_content">
							<table id="series_read_title">
								<tr>
									<td colspan="4"><h1><%=svo.getWbTitle() %></h1></td>
								</tr>
								<tr>
									<td colspan="2"><p><%=svo.getWbWriter() %></p></td>
									<td><p><%=svo.getWbDate().substring(0, 16) %></p></td>
									<td><i class="xi-eye-o"></i>&nbsp;<%=svo.getWbCount() %></td>
								</tr>
								<tr>
									<td colspan="4"><span
										style="background-color: rgba(234, 244, 252, 1);"><%=svo.getWbCategory() %></span></td>
								</tr>
							</table>
							<table id="series_read_content">
								<tr>
									<td colspan="4"><%=svo.getWbContent() %></td>
								</tr>
							</table>
						</div>
						<!-- 로그인 한 회원 = 게시물 작성자 일치하는 경우에만 게시물 수정 삭제 버튼 표시 -->
						<% if(vo.getUsId().equals(svo.getUsId())){%>
						<div class="series_board_up_de_btn">
						<button id="btn_series_update" class="button2"
						 onclick="location.href='seriesupdate?wbNo=<%=svo.getWbNo()%>';">게시물 수정</button>
						<button id="btn_series_delete" class="button4">게시물 삭제</button>
						</div>
						<%} %>
						<div class="series_board_read_funding">
							<table id="board_read_funding">
								<tr>
									<td>해당 작품을 책으로 만나보고 싶으신가요📚📖 자세한 정보는 이곳을 클릭해주세요
										<button id="btn_funding" class="button4">펀딩하기👍</button> <br>
										<div class="modal">
										<div class="modal_content">
										<div id ="modal_funding_content">
										<p> 작품번호 : <%=svo.getWbNo() %></p>
										<p> 작품명 : <%=svo.getWbTitle() %></p>
										<p> 작가 : <%=svo.getWbWriter() %></p>
										<p> 카테고리 : <%=svo.getWbCategory() %></p>
										<p> 후원금액 및 마감일 등 자세한 사항은 펀딩 탭에서 확인 가능합니다 </p>
										<p> 이동하기 버튼을 클릭하여 지금 바로 확인해보세요!💸 </p>
										</div>
										<div class="btn_funding_move_close">
										<button id="btn_funding_move" class="button2">이동하기</button>
										<button id="btn_funding_close" class="button4">닫기</button>
										
										</div>
										</div>
										</div>
									<br><br><small>참고 : 목표 금액 이상이 모이면 해당 작품의 펀딩이 성공되며, 펀딩
											마감일까지 목표 금액을 달성하지 못한 경우 결제가 진행되지 않습니다.</small>

									</td>
								</tr>
							</table>
						</div>
						<div class="series_board_recomment_all">
							<table id="board_read_recomment">
								<tr>
									<td colspan="3">댓글 [<%=svo.getReCommentCnt() %>]
										<form action="seriescomment" method="post">
											<div class="star-rating">
												<input type="radio" id="5-stars" name="wbcRating" value="5" />
												<label for="5-stars" class="star">&#9733;</label> <input
													type="radio" id="4-stars" name="wbcRating" value="4" /> <label
													for="4-stars" class="star">&#9733;</label> <input
													type="radio" id="3-stars" name="wbcRating" value="3" /> <label
													for="3-stars" class="star">&#9733;</label> <input
													type="radio" id="2-stars" name="wbcRating" value="2" /> <label
													for="2-stars" class="star">&#9733;</label> <input
													type="radio" id="1-star" name="wbcRating" value="1" /> <label
													for="1-star" class="star">&#9733;</label>
											</div>									
											<input type="hidden" name="wbNo" value="<%=svo.getWbNo()%>">
											<input type="text" id="wbcContent" name="wbcContent"
												placeholder="댓글을 입력해주세요. 한번 등록한 별점은 수정이 불가능합니다."
												required="required">
											<button type="submit" id="btn_submit_comment" class="button1">등록</button>
										</form>
									</td>
								</tr>

							</table>
							<%
			if(svo.getReCommentCnt()>0){
			//자료형 ArrayList<SeriesReCommentVo>
			for(SeriesReCommentVo srvo : svo.getSrvolist()){
			%>
							<div id="series_read_comment">
							<!-- 로그인 한 회원 = 댓글 작성자 일치하는 경우에만 댓글 수정 삭제 버튼 표시 -->
							<% if(vo.getUsId().equals(srvo.getUsId())){%>
							<div class="series_board_comment_up_de_btn" >
							<button class="btn_board_comment_update">댓글 수정</button>
							<div class="update_board_comment">
								<form action="seriescommentupdate" method="post">
									<input type ="text" value="<%=srvo.getWbcContent() %>" id = "wbcContent" name="wbcContent">
									<input type="hidden" name="wbNo" value="<%=svo.getWbNo()%>">
									<input type="hidden" name="wbcNo" value="<%=srvo.getWbcNo()%>">
									<button type="submit" id="btn_update_submit_comment" class="button2">수정</button>
									<button id="btn_update_reset" class="button4">취소</button>
								</form> 
								</div>
							<button class="btn_board_comment_delete"
							onclick="location.href='seriescommentdelete?wbNo=<%=svo.getWbNo()%>&wbcNo=<%=srvo.getWbcNo()%>';">댓글 삭제</button>
							</div>
							<%} %>
							<table id="series_read_comment_rist">
								<tr>
									<td colspan="3"><%=srvo.getWbcWriter() %> &nbsp; &nbsp; <span><%=srvo.getWbcDate().substring(0, 16) %></span></td>
								</tr>
								<tr>
									<td colspan="3"><p style="color:#f90;">&#9733;<%=srvo.getWbcRating() %></p></td>
								</tr>
								<tr>
									<td colspan="3"><%=srvo.getWbcContent() %></td>
								</tr>
							
								</table>
							
							</div>
							<%		
			}
		}

%>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="../../template_footer.jsp"%>
</div>
<%} %>

<script>


	//모달창 스크립트 
 	//버튼 누르면 펀딩 모달창 on
	document.getElementById("btn_funding").addEventListener('click',openModal); 
	//close 버튼 누르면 펀딩 모달창 close
	document.getElementById("btn_funding_close").addEventListener('click',closeModal);
	//펀딩 모달창 바깥 부분 클릭시 close
	document.getElementsByClassName("modal")[0].addEventListener('click',closeModalWindow); 

	// openModal
    function openModal(){
        document.getElementsByClassName("modal")[0].style.display = "block";
        
    }
    // closeModal
    function closeModal(){
        document.getElementsByClassName("modal")[0].style.display = "none";
    }
    // closeModalWindow
    function closeModalWindow(){
        if(event.target == document.getElementsByClassName("modal")[0]) {  
            document.getElementsByClassName("modal")[0].style.display = "none";  
            }
        }   
    
    
    //펀딩 탭으로 이동시키는 스크립트 (제이쿼리 방식)
    $('#btn_funding_move').click(function(){
      location.href="fundingboardlist";
      })
      
      
      
     //게시물 삭제 스크립트(제이쿼리 방식)
    $('#btn_series_delete').click(function(){
    	if(confirm("해당 게시글을 삭제하시겠습니까?")){
    		location.href="seriesdelete?wbNo=<%=svo.getWbNo()%>";
    	}
    })
    
	//댓글 수정 클릭시 댓글 창 block
	 let eleBtns= document.getElementsByClassName("btn_board_comment_update");
     for (var i = 0; i<eleBtns.length ; i++){
       eleBtns[i].onclick = function(){
           console.log(this); // this = .onclick 앞에 있는 eleBtns[i]
           console.log(this.nextElementSibling);
           var eleNext = this.nextElementSibling;
           var isDisplay = eleNext.style.display;
           console.log(isDisplay);
           if(isDisplay =="" || isDisplay =="none"){
               eleNext.style.display="block" ;

           } else{
               eleNext.style.display="none" ;  
           }
    }
    }

</script>



</body>
</html>