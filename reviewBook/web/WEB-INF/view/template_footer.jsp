<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="wrap footer">
     <footer>
        <div class="footerrvb">
            <div class="footer_left">
                <p>주식(하고싶은)회사 ReViewBook RVB</p>
                <p>Since 2022.03.30 / 서울특별시 리뷱구 리뷱동 리뷱빌라 1-8층 리뷱</p>
                <p>사업(하고싶은 대표)자 등록번호 : 010-3328-7786 (장난전화 금지)</p>
                <p>리뷱의 모든 저작권은 법에 의해 보호...받고싶습니다</p>
            </div>
            <div class="footer_right">
                <a class="recrument" href ="#" onclick="serviceready()">입사지원</a>
                <a class="footerqna" href="#" onclick="serviceready2()">QnA문의</a>
                <a class="footerqna" href="<%=request.getContextPath() %>/adlogin">관리자로그인</a>
            </div>
        </div>
    </footer>
    <script>
    function serviceready(){
    	alert("서비스 준비중입니다. 1:1 문의 이메일 \"reviewbook.rvb@gmail.com\"");
    }
    function serviceready2(){
    	alert("1:1 문의 이메일 \"reviewbook.rvb@gmail.com\"");
    }
    </script>
</div>