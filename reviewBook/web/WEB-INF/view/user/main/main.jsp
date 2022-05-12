<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/main.css">

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
	<div class="bodyrvb">
		<div class="main1_contentrvb">
			<div class="main1_left">
				<p class="fontimportant main1_leftword1">독서 습관의 시작,</p>
				<p class="fontimportant main1_leftword2">RVB와의 동행</p>
				<a class="main1_button1"
					href="<%=request.getContextPath()%>/signup">
					<p class="fontnormal">RVB와 함께하기</p>
				</a> <a class="main1_button2" href="subscribemain">
					<p class="fontnormal">책 구독하기</p>
				</a>
			</div>
			<div class="main1_right">
				<img
					src="<%=request.getContextPath()%>/resources/image/main/앉아있는애기.jpg">
			</div>
		</div>
		<div class="main2_contentrvb">
			<div class="main2_top">
				<div class="main2_top_name">
					<p class="fontevent">RVB 인기 작가</p>
					<img
						src="<%=request.getContextPath()%>/resources/image/main/3.png">
				</div>
				<div class="main2_top_content">
					<div class="main2_top_content1">
						<p class="fontimportant2 main_content1">
							RVB가 키운
							<괴-물> 신인
						</p>
						<p class="fontimportant main_content2">" 마 포 대 교 " 작가</p>
					</div>
					<div class="main2_top_content2">
						<a href="seriesread?wbNo=40">
							<p class="fontnormal main_content1">[ 순정에 관하여.. ]</p>
							<p class="fontnothing main_content2">'화란'에게 수줍게 전한 진심, 그 카리스마
								현장속으로 빨려들어가는 소설</p>
						</a>
					</div>
					<div class="main2_top_content3">
						<a href="seriesread?wbNo=44">
							<p class="fontnormal main_content1">[ 돌아가는 법 ]</p>
							<p class="fontnothing main_content2">'바쁘다 바빠 현대사회, 돌아가는 법을 배울
								때가 되지 않았을까?' ...</p>
						</a>
					</div>

				</div>
			</div>
			<div class="main2_top2">
				<div class="main2_top2_name">
					<p class="fontevent">🔔 RVB둥이들의 연재 후기</p>
				</div>
				<div class="main2_top2_content">
					<div class="main2_top2_content1">
						<img
							src="<%=request.getContextPath()%>/resources/image/main/독자남자.png">
						<p class="fontnormal main2_content1">
							23세, 마포구 대학생<br>
							<br>- 사자 -
						</p>
						<p class="fontnothing main2_content2">
							" 순정에 관하여를 읽고<br>
							<br> 저도 저렇게 애절한 사랑을 해보고싶단 생각을 했습니다.<br>
							<br> 화란이가 그 진심을 받아줄지 궁금해서 밤에 잠이 안오네요 ㅜ-ㅜ <br>
							<br>작가님 최고입니다 ! "
						</p>
					</div>
					<div class="main2_top2_content2">
						<p class="fontnothing main2_content2">
							" 직장인 4년차입니다. <br>
							<br>출근하면서 퇴근생각이 간절하고 <br>
							<br>매일 회의실을 들어갈 때마다 이직이 생각나는 요즘,<br>
							<br> 돌아가는 법을 읽고 <br>
							<br>어디로 가든 내 살길은 있겠구나 생각이 들어 <br>
							<br>큰 마음 먹고 다시 취준생으로 돌아갑니다. 우리 모두 화이팅 "
						</p>
						<p class="fontnormal main2_content1">
							29세, 송파구 직장인<br>
							<br>- 인절미 -
						</p>
						<img
							src="<%=request.getContextPath()%>/resources/image/main/독자여자.png">
					</div>
				</div>
				<div class="main2_top2_content3">
					<p class="fontimportant main2_content3">🥨 둥이들이 남겨준 더 많은 마음들 🥨</p>
					<p class="fontnothing main2_content3">
						🙂 42세 천안시 직장인 양OO <br> " '술맛' 추천해요 ! 혼술할 때 읽기 좋은 연재글이 얼마만인지
						..."
					</p>
					<p class="fontnothing main2_content3">
						😆 24세 뉴욕 대학생 김OO <br>" 줄다리기 이기는 방법 보셨나요? 진짜 줄다리기 치트키입니다!! "
					</p>
					<p class="fontnothing main2_content3">
						😋 18세 노원구 학생 이OO <br>" 초상권 관련해서 궁금한게 많았는데, "초상권을 침해 당했어요"가
						정말 큰 도움이 됐어요. "
					</p>
					<p class="fontnothing main2_content3">
						😶 33세 종로구 자영업자 최OO<br>" 코로나 때문에 힘들었는데... 많은 위로를 받았습니다. "
					</p>
					<p class="fontnothing main2_content3">
						🙃 35세 여의도 직장인 송OO <br>" 아버지의 가르침을 읽고 아버님댁에 방문했는데 너무 좋아하시네요
						고맙습니다. "
					</p>
					<p class="fontimportant2 main2_content3">"RVB" 과 함께하면서 더 많은 후기를
						남기고, 나누고, 즐겨보세요</p>
				</div>
			</div>

		</div>
		<div class="main3_contentrvb">
			<div class="main3_top">
				<div class="main3_top_name">
					<p class="fontevent">추천 도서</p>
				</div>
				<div class="main3_top1_content">
					<div class="main3_top_content1">
						<a href="bookmain">
							<p class="fontimportant2 main3_content1">2022 최대 히트 ☘ 파친코 ☘</p> <img
							src="<%=request.getContextPath()%>/resources/image/main/파친코.jpg">
							<!-- <p class="fontnormal main3_content1">이민진 작가의 역대 히트작!</p>
                            <p class="fontnothing main3_content2">\16,500원 절찬 판매중, 후기도 만나보세요!</p> -->
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="main4_contentrvb">
			<div class="main4_top">
				<div class="main4_top_name">
					<p class="fontimportant">매달 집에서 RVB를 만나는 법</p>
				</div>
				<div class="main4_top_content">
					<a href="subscribemain"> <img class="main4_top_content1"
						src="<%=request.getContextPath()%>/resources/image/main/정기구독권.png"></a>
					<a href="subscribemain"> <img class="main4_top_content2"
						src="<%=request.getContextPath()%>/resources/image/main/월별구독권.png"></a>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="../../../view/template_footer.jsp"%>
</body>
</html>