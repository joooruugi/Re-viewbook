
# Re-viewbook
KH_정보교육원 세미프로젝트
![001](https://user-images.githubusercontent.com/92707182/168520756-32ebffeb-28fb-4c5a-bbe7-7754b0550ace.png)


### 0️⃣ 개발 주제 / 목표

![002](https://user-images.githubusercontent.com/92707182/168520780-60f45cba-1693-4cf2-a568-a1ba4242ba4a.png)



#### 📖좋아하는 작가의 책을 구매할 수도, 스스로 작가가 될 수도 있는 홈페이지

- 감소하는 성인 독서량 수치에 집중해 구독 서비스를 도입, 편리하게 책과 접할 수 있도록 합니다.
- 개인이 자유롭게 글을 쓸 수 있고, 펀딩을 통해 정식 작가로 성장할 수 있도록 합니다.
- 리뷰작성과 별점등록을 통해 타인과 가치관을 나눌 수 있도록 합니다.





### 1️⃣ 팀소개 / 개발 주안점

![003](https://user-images.githubusercontent.com/92707182/168520915-865de5e7-8767-46fc-a78e-f5b548cee50b.png)

![014](https://user-images.githubusercontent.com/92707182/168520920-779d2593-ec82-443f-a90e-a7144bcc128b.png)



#### 🔎개발 주안점

1. **오류 최소화**

   주기적인 통합 테스트를 통해 나타날 수 있는 오류를 최소화함

2. **높은 접근성**

   집에서 받아볼 수 있는 구독 서비스로 화면 속 뿐만이 아닌 현실에서도 만나볼 수 있도록 함

3. **사용자 편의성**

   간단하고 명료한 UI로 사용자가 홈페이지를 사용함에 있어서 편리함을 느낄 수 있도록 함

   

## 2️⃣ 개발 환경 / 사용 기술

|                                       | Development Environment / Technology Used                   |
| ------------------------------------- | :---------------------------------------------------------- |
| **Language**                          | Java11, Jsp, Servlet, HTML5, CSS3, Javascript, XML           |
| **Web Application Server**            | Apache Tomcat 9.0                                           |
| **Version Management System**         | Git, Github, Github Desktop, Compare Tool(Beyond Compare 4) |
| **DataBase**                          | Oracle 11g Express Edition                                  |
| **FrameWork / OPEN API**              | Ajax, jQeury, WYSIWYG, Iamport, Font-Awesome, Swiper-Slider |
| **Development Tool**                  | SQL Developer, Eclipse, Visual Studio Code                  |
| **OS**                                | Window 10                                                   |
| **Meeting Tool**                      | Notion, Discord                                             |
| **Meeting Log / Troubleshooting Log** | Notion, Discord, KakaoTalk                                  |

##### ✔회의록 및 회고록 노션 링크

https://economic-toque-a9e.notion.site/SEMIPROJECT_-cf35e53816ce49958ab45c76c9ae94ca



## 3️⃣ 주요 기능 / 화면
<details>
    <summary><h3>🖥 메인(서언주)</h3></summary>
	<h5>첫 페이지</h5>
    	<div markdown="1">
	    	<img src="https://user-images.githubusercontent.com/92707182/168934836-c9949909-5c08-4b8d-907e-595f03cb6bc2.gif">
   		</div>
<br>

   | ✔ | details |
|--|--|
| 1 | 교육용 홈페이지 임을 알리기 위해 메인 화면 전 화면 구성 |
| 2 | javascript canvas를 이용하여 벚꽃이 흩날리는 화면 구현 |
| 3 | 하단 img를 a태그에 넣어 클릭시 메인 페이지로 이동하도록 함 |
| ✨ | OpeningServlet.java, opening.jsp |


<h5>메인 화면</h5>
 		<div markdown="2">
		    <img src="https://user-images.githubusercontent.com/92707182/168936840-375a9499-c792-40ec-		a977-ddb0fe137a57.gif">
    	</div>
    	<br>
    	
   | ✔ | details |
|--|--|
| 1 | 상단 드롭다운 메뉴 구현, 클릭시 해당 페이지 이동 |
| 2 | 마우스 호버 효과를 통해 강조하고자 하는 부분 강조 |
| 3 | 배너 및 인기작가, 도서 추천, 구독권의 경우 클릭시 해당 페이지 이동 |
| ✨ | MainController.java, main.jsp |
</details>
<hr>	
<details>
    <summary><h3>🖥 회원가입 / 공지사항(서언주)</h3></summary>
	<details>
        <summary><h4>🙍‍♀️사용자</h4></summary>
		<h5>회원가입</h5>
    			<div markdown="1">
	    		<img src="https://user-images.githubusercontent.com/92707182/168938073-514855a3-ceb3-4dc1-8fa1-8a80f93302ca.gif">
   			</div>
   			
   | ✔ | details |
|--|--|
| 1 | 교육용 홈페이지 임을 알리기 위해 메인 화면 전 "/" 화면 구성 |

<h5>로그인</h5>
 			<div markdown="2">
	    		<img src="https://user-images.githubusercontent.com/92707182/168938124-8ab48eb9-f1d2-4ab2-8239-d65f903911b4.gif">
    			</div>
    			
   | ✔ | details |
|--|--|
| 1 | 교육용 홈페이지 임을 알리기 위해 메인 화면 전 "/" 화면 구성 |
   <h5>로그아웃 / 공지사항</h5>
 			<div markdown="3">
	    		<img src="https://user-images.githubusercontent.com/92707182/168938166-5ef317d2-8ce4-43ef-aba7-3c1f1f84c1cf.gif">
    			</div>

  | ✔ | details |
|--|--|
| 1 | 교육용 홈페이지 임을 알리기 위해 메인 화면 전 "/" 화면 구성 |
</details>
	<details>
    	<summary><h4>👥관리자</h4></summary>
		<h5>회원가입</h5>
    		<div>
	    	<img src="https://user-images.githubusercontent.com/92707182/169694685-fde680d1-e517-495f-b1f9-4c913409ed0f.gif">
   		</div>
		<h5>로그인/로그아웃</h5>
 		<div markdown="2">
	    	<img src="https://user-images.githubusercontent.com/92707182/169694703-bf800b0c-82a0-4be9-b325-5696c35ddab1.gif">
		</div>
		<h5>공지사항</h5>
 		<div markdown="3">
	    	<img src="https://user-images.githubusercontent.com/92707182/169694722-dcbf9acc-e486-4b4f-9a87-7045bd2b0e1b.gif">
    		</div>
		<h5>회원조회</h5>
 		<div markdown="4">
	    	<img src="https://user-images.githubusercontent.com/92707182/169694779-1e6febf8-1d41-4a2d-9782-90ef04e5acc7.gif">
    		</div>
	</details>
</details>
<hr>
<details>
    <summary><h3>🖥 마이페이지(권소정)</h3></summary>
        <h4>🙍‍♀️사용자</h4>
		<h5>마이페이지 메인</h5>
    		<div markdown="1">
	    		<img src="https://im3.ezgif.com/tmp/ezgif-3-9fe45b6531.gif">
   			</div>

| ✔ | details |
|--|--|
| 1 | 로그인 정보가 없으면 로그인 페이지로 이동, 로그인 정보가 있다면 마이페이지 클릭시 마이페이지로 이동|
| 2 | 로그인한 회원의 아이디를 이용해 '000님 반갑습니다!'라는 멘트와 함께 구독중인 구독권 정보, 구독 시작일 정보가 뜸|
| 3 | 구독중인 구독권이 없다면 '구독중인 구독권이 없습니다.'라는 멘트가 뜸|
| 4 | 구매목록 조회 가능|
| 5 | 구매목록에는 주문번호, 주문상품명, 주문날짜, 상품리뷰 작성여부 조회 가능|
| ✨ | MyPageMainServlet.java, mypage_main.jsp|

		<h5>리뷰 작성 / 별점 등록</h5>
 			<div markdown="2">
	    		<img src="https://im3.ezgif.com/tmp/ezgif-3-e9a412f3f0.gif">
    		</div>

| ✔ | details |
|--|--|
| 1 | 구매목록 중 리뷰를 작성한 상품은 상품리뷰란에 '작성 완료'로 뜨며, 리뷰를 작성하지 않은 상품은 '리뷰 작성'이라는 버튼이 활성화 됨|
| 2 | '리뷰 작성'버튼 클릭시, 리뷰를 작성하는 모달창이 뜸|
| 3 | 리뷰작성 모달창에는 리뷰제목, 별점, 리뷰내용 입력 가능. 모두 입력하여야 리뷰 등록 가능|
| 4 | 별점은 별모양을 클릭하여 부여 가능. 1~5점중 선택 가능|
| 5 | 리뷰작성 후 '리뷰 등록'버튼 클릭시, '리뷰 작성이 완료되었습니다'라는 알림창과 함께 리뷰 등록 완료|
| ✨ | InsertReviewServlet.java, mypage_main.jsp|

		<h5>정보 수정</h5>
    		<div markdown="1">
	   		 	<img src="https://im3.ezgif.com/tmp/ezgif-3-a2f967249c.gif">
   			</div>

| ✔ | details |
|--|--|
| 1 | 사이드 메뉴에서 정보수정 클릭 시 정보수정 페이지로 이동|
| 2 | 기존에 회원이 등록한 아이디, 이름, 전화번호, 이메일, 주소가 화면에 나타나서 정보 조회 가능|
| 3 | 아이디와 이름은 disable처리하여 수정 불가하고 조회만 가능|
| 4 | 전화번호, 이메일, 주소는 입력창 클릭시 새로운 정보 입력하여 정보수정 가능|
| 5 | 전화번호 입력창에 마우스 올려놓을시, '000-0000-0000 형식으로 입력 바랍니다.' 라는 가이드 뜸|
| 6 | 정보수정 후 수정완료 버튼 클릭시, '정보 수정이 완료되었습니다.'라는 알림창 띄운 후 정보 수정완료|
| ✨ | MyInformationServlet.java, myInfoUpdate.jsp|

    	<h5>장바구니</h5>
 			<div markdown="3">
	    		<img src="https://im3.ezgif.com/tmp/ezgif-3-2d92921e68.gif">
    		</div>

| ✔ | details |
|--|--|
| 1 | 사이드 메뉴에서 장바구니 클릭 시 장바구니 페이지로 이동|
| 2 | 도서에서 장바구니에 추가한 목록을 조회 가능|
| 3 | 장바구니 목록에서는 상품이미지, 상품제목, 저자, 출판일, 도서번호, 수량, 금액이 조회 가능.|
| 4 | 장바구니 목록 중 수량변경에 있는 +버튼과 -버튼 클릭을 통해, 해당 상품의 수량 변경 가능|
| 5 | +버튼 클릭시, 해당 상품의 수량이 1씩 증가|
| 6 | -버튼 클릭시, 해당 상품의 수량이 1씩 감소, 1보다 작은 숫자로는 내려가지 않음|
| 7 | 삭제하기 버튼 클릭시, '장바구니에서 삭제 완료되었습니다'라는 알림창과 함께 장바구니 목록에서 삭제|
| 8 | 구매하기 버튼 클릭시, 결제창으로 이동|
| ✨ | SelectCartListServlet.java, UpdateCartServlet.java, UpdateDownCartServlet.java, DeleteCartServlet.java, cart_main.jsp|	

		<h5>결제</h5>
 			<div markdown="4">
	    		<img src="https://im3.ezgif.com/tmp/ezgif-3-8d89686dfc.gif">
    		</div>

| ✔ | details |
|--|--|
| 1 | 장바구니 목록에서 구매하기 클릭 시, 결제 api로 이동|
| 2 | 결제창에서 상품명과 상품수량에 해당하는 결제금액 조회|
| 3 | 결제 수단 선택 후 결제 진행|
| 5 | 결제 취소시, '결제에 실패하였습니다'라는 알림창과 함께 장바구니 목록으로 이동|
| 5 | 결제 완료시, '결제 완료되었습니다'라는 알림창과 함께 마이페이지 메인으로 이동|
| 6 | 결제 완료 후, 마이페이지 내 주문목록에서 결제 상품 추가되어 정보 조회 가능 & 장바구니 목록에서는 삭제|
| ✨ | BuyCartServlet.java, cart_main.jsp|	
</details>
<hr>
<details>
    <summary><h3>🖥 도서(조병국)</h3></summary>
	<details>
        <summary><h4>🙍‍♀️사용자</h4></summary>
		<h5>도서 메인</h5>
    		<div markdown="1">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941361-545b2f77-bf13-4b3a-8f29-226276c0625e.gif">
   			</div>
		<h5>리뷰 작성 / 별점 등록</h5>
 			<div markdown="2">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941390-7d92f1fc-1588-45d4-955f-48b500a7d5c5.gif">
    		</div>
	</details>
	<details>
    <summary><h4>👥관리자</h4></summary>
	<h5>도서 등록</h5>
    	<div markdown="1">
	    	<img src="https://user-images.githubusercontent.com/92707182/169694819-5ec5e57a-b033-499e-b0c4-110f8d01e0e3.gif">
   		</div>
	<h5>도서 삭제</h5>
 		<div markdown="2">
	    	<img src="https://user-images.githubusercontent.com/92707182/169694821-40fb594a-2add-46b6-a246-54f043de9eb7.gif">
    	</div>
	</details>
</details>
<hr>
<details>
    <summary><h3>🖥 연재(김도현)</h3></summary>
	<details>
        <summary><h4>🙍‍♀️사용자</h4></summary>
		<h5>연재 메인</h5>
    		<div markdown="1">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941588-b15a0dd8-1d67-4b60-bd71-3b4242ecdc7c.gif">
   			</div>
   			
| ✔ | details |
|--|--|
| 1 | 사이드 메뉴에서 각 카테고리 클릭 시 각 카테고리 별 게시글 목록 확인 가능|
| 2 | 처음엔 메인에 3개 게시물씩 화면에 나타나고, 더보기 버튼 클릭시 3개 게시물씩 더 나타나고 마지막인 경우 alert창과 더 이상 게시물이 없다는 멘트와 함께 더보기 버튼이 사라짐 |
| ✨ | SeriesMainServlet.java , SeriesSearchCategoryFictionServlet.java, SeriesSearchCategoryInfoServlet.java, SeriesSearchCategoryDailyServlet.java, SeriesSearchCategoryEtcServlet.java, seriesmain.jsp, seriescategoryfiction.jsp, seriescategoryinfo.jsp, seriescategorydaily.jsp, seriescategoryetc.jsp|
<h5>댓글 작성 / 별점 등록</h5>
 			<div markdown="2">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941610-7327c28a-9a98-4653-b4fd-3ab908c4152f.gif">
    		</div>
<br>

   | ✔ | details |
|--|--|
| 1 | 댓글 작성 시 별점 입력이 가능하며 별점을 부여하지 않아도 댓글이 등록 가능함 |
| 2 | 댓글 등록 후 본인이 작성한 댓글 수정과 삭제 가능 |
| 3 | 댓글 수정은 css에 display: none;효과를 준 다음 스크립트를 사용하여 click 이벤트를 이용하여 해당 댓글창이 나타나도록 구현|
| 4 | 댓글 삭제버튼 클릭 시 댓글을 삭제하시겠습니까? 라는 알림창과 함께 확인 버튼을 누르면 삭제 후 기존 게시물로 돌아간다.|
| ✨ | SeriesReadServlet.java,SeriesCommentServlet.java, SeriesCommentUpdateServlet.java, SeriesCommentDeleteServlet.java, seriesread.jsp |

<h5>게시글</h5>
 			<div markdown="3">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941616-301fb446-88ae-400d-b5d6-89568e7d64a0.gif">
    		</div>
   
   | ✔ | details |
|--|--|
| 1 | 게시글 작성 시 카테고리 선택 가능 |
| 2 | 게시물은 위지위그 api를 활용하여 옵션 사용할 수 있도록 구현|
| 3 | 본인이 작성한 게시글 수정이 가능하며 게시글 수정 시 '게시글이 수정에 성공하였습니다'라는 alert창이 나타나면서 메인으로 이동함 |
| 4 | cos.jar 라이브러리를 이용하여 파일 업로드 기능 구현 |
| 5 | 게시글 삭제 버튼 클릭 시 '게시글이 삭제되었습니다'라는 alert창이 나타나면서 메인으로 이동함 |
| ✨ |  SeriesInsertServlet.java, SeriesInsertDoServlet.java, SeriesUpdateServlet.java, SeriesUpdateDoServlet.java, SeriesDeleteServlet.java, SeriesReadServlet.java, seriesinsert.jsp, seriesread.jsp, seriesupdate.jsp|
<h5>검색</h5>
 			<div markdown="4">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941623-ec19d0a9-3d94-4a5f-8359-e6f181a9001d.gif">
    		</div>

 | ✔ | details |
|--|--|
| 1 | 해당 작가명, 작품명으로 검색했을때 일치하는 글 목록 리스트 반환 |
| 2 |일치하는 결과가 없는 경우 alert창으로 검색 조건에 일치하는 게시물이 없다고 나타난다.|
| ✨ |   SeriesSearchServlet.java, seriessearch.jsp|
</details>

<details>
    <summary><h4>👥관리자</h4></summary>
	<h5>연재 관리자1</h5>
    	<div markdown="1">
	    	<img src="https://user-images.githubusercontent.com/92707182/168940941-0f31f38e-82f6-4926-9116-06f4e20d023d.gif">
   		</div>
	<h5>연재 관리자2</h5>
 		<div markdown="2">
	    	<img src="https://user-images.githubusercontent.com/92707182/168940941-0f31f38e-82f6-4926-9116-06f4e20d023d.gif">
    	</div>
	</details>
</details>
<hr>
<details>
    <summary><h3>🖥 펀딩(배민수)</h3></summary>
	<details>
        <summary><h4>🙍‍♀️사용자</h4></summary>
		<h5>펀딩 메인</h5>
    		<div markdown="1">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941838-5ccfcb2c-cebd-458c-a501-de7ecf504a1e.gif">
   			</div>
   			
| ✔ | details |
|--|--|
| 1 | swiper-slider를 이용한 카테고리별 작품 이미지 슬라이딩 화면 구현 |
| 2 | img클릭하면 작품 상세페이지 이동 기능 구현 |
| 3 |  jsp태그를 이용해 작품 리스트화 |
| 4 | 사용자의 작품 펀딩유무를 파악하는 컬럼을 이용해 펀딩/철회 버튼 구분 기능 및 화면 구현 |
| ✨ | FundingBoardListServlet.java, FundingSuccessBoardListServlet.java, fundingboardlist.jsp, fundingsuccessboardlist.jsp |


<h5>펀딩 · 철회 기능</h5>
 			<div markdown="2">
	    		<img src="https://user-images.githubusercontent.com/92707182/168941842-d6c58e5a-0b39-4cc2-9037-705228f05f54.gif">
    		</div>
    		
| ✔ | details |
|--|--|
| 1 | ajax를 이용해 작품정보 및 펀딩/철회 모달창 구현|
| 2 | 펀딩하기 모달창에 후원금액 입력 후 펀딩하면 DB에 모인금액 반영해서 진행률 변화 구현|
| 3 | 철회하기 모달창에 ajax로 후원금액 알려주는 기능 구현 |
| 4 | 철회하기 누르면  DB에서 delete하여 모인금액 반영 기능 구현|
| ✨ | FundingDonationServlet.java, FundingWithdrawServlet.java, FundingWithdrawDoServlet.java |

</details>
	<details>
    <summary><h4>👥관리자</h4></summary>
	<h5>펀딩 관리자1</h5>
    	<div markdown="1">
	    	<img src="https://user-images.githubusercontent.com/92707182/168940941-0f31f38e-82f6-4926-9116-06f4e20d023d.gif">
   		</div>
	<h5>펀딩 관리자2</h5>
 		<div markdown="2">
	    	<img src="https://user-images.githubusercontent.com/92707182/168940941-0f31f38e-82f6-4926-9116-06f4e20d023d.gif">
    	</div>
	</details>
</details>

## 4️⃣  관련 산출물

```html
0.3팀
	일정관리.xlsx
	프로젝트정보_기획발표제출.docx

1. 프로젝트 계획서
	기획발표_PPT.pdf
	UseCase.pdf
	1-1. 정의서
		단위업무정의서.xlsx
		요구사항정의서.xlsx

2. UI
	2-1. UI설계보고서
		화면구조도.pdf
		UI메뉴구성.xlsx
		UI설계보고서_초안.pptx

3. DB
	ReviewBook.sql
	3-1.ERD
		ERD 테이블 기술서.xlsx
		ERD Cloud.png

4. 클래스
	클래스 매핑.xlsx
	3팀_classdiagram.mdj

5. 시퀀스다이어그램
	시퀀스다이어그램.pptx

6. 최종발표 산출물
	최종발표 PPT.pdf
	History.xlsx
	TestCase.xlsx
```

##### 💾구글 드라이브 링크

https://drive.google.com/drive/folders/1pbJU-loD0zsMr9vWzFqOOk08bGdj-guq?usp=sharing





## 5️⃣

6️⃣7️⃣

