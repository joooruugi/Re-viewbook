DROP TABLE "WRITER_BBS";
DROP TABLE "TIME_PERIOD";
DROP TABLE "ORDER_BOOK";
DROP TABLE "SUBSCRIBE";
DROP TABLE "CART";
DROP TABLE "REVIEW";
DROP TABLE "GENRE";
DROP TABLE "BOOK";
DROP TABLE "RANKING";
DROP TABLE "NOTICE";
DROP TABLE "ADMIN";
DROP TABLE "USER";
DROP TABLE "ORDER";
DROP TABLE "WRITER_BBS_COMMENT";
DROP TABLE "FUNDING_MANAGE";

CREATE TABLE "WRITER_BBS" (
	"WB_NO"	NUMBER	NOT NULL,
	"WB_TITLE"	VARCHAR2(60)	NOT NULL,
	"WB_CONTENT"	VARCHAR2(4000)	NOT NULL,
	"WB_COUNT"	NUMBER DEFAULT 0	NOT NULL	,
	"WB_DATE"	TIMESTAMP DEFAULT SYSTIMESTAMP	NOT NULL	,
	"WB_WRITER"	VARCHAR2(45)	NOT NULL	,
	"WB_CATEGORY"	VARCHAR2(20)	NOT NULL,
	"US_ID"	VARCHAR2(30)	NOT NULL
);



CREATE TABLE "FUNDING_MANAGE" (
	"WB_NO"	NUMBER	NOT NULL,
	"US_ID"	VARCHAR2(30)	NOT NULL,
	"FD_ACCUMULATE"	NUMBER DEFAULT 0	NULL	,
	"FD_DONATION"	NUMBER	NULL,
	"FD_DEADLINE"	DATE DEFAULT sysdate	NOT NULL	,
	"FD_LIMIT"	NUMBER DEFAULT 100000	NOT NULL,
	"FD_OX"	NUMBER DEFAULT 0	NOT NULL	,
	"AD_ID"	VARCHAR2(30)	NOT NULL
);


CREATE TABLE "WRITER_BBS_COMMENT" (
	"WBC_NO"	NUMBER	NOT NULL,
	"WBC_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP NOT NULL	,
	"WBC_CONTENT"	VARCHAR2(1024)	NULL,
	"WBC_RATING"	NUMBER	NULL,
	"WB_NO"	NUMBER	NOT NULL,
	"US_ID"	VARCHAR2(30)	NOT NULL
);


CREATE TABLE "ORDER" (
	"OR_NUM"	NUMBER	NOT NULL,
	"OR_PRICE"	NUMBER	NOT NULL,
	"OR_DATE"	TIMESTAMP DEFAULT SYSTIMESTAMP	NOT NULL	,
	"US_ID"	VARCHAR2(30)	NOT NULL
);


CREATE TABLE "USER" (
	"US_ID"	VARCHAR2(30)	NOT NULL,
	"US_EMAIL"	VARCHAR2(150)	NOT NULL,
	"US_PHONE"	VARCHAR2(30)	NOT NULL,
	"US_NICKNAME"	VARCHAR2(45)	NOT NULL,
	"US_PASSWORD"	VARCHAR2(30)	NOT NULL,
	"US_GENDER"	VARCHAR2(5)	NOT NULL,
	"US_ADDRESS"	VARCHAR2(300)	NOT NULL,
	"US_NAME"	VARCHAR2(10)	NOT NULL,
	"US_BIRTH"	DATE	NOT NULL
);


CREATE TABLE "ADMIN" (
	"AD_ID"	VARCHAR2(30)	NOT NULL,
	"AD_EMAIL"	VARCHAR2(150)	NOT NULL,
	"AD_PHONE"	VARCHAR2(30)	NOT NULL,
	"AD_NICKNAME"	VARCHAR2(45)	NOT NULL,
	"AD_COMPANY"	VARCHAR2(60)	NOT NULL,
	"AD_PASSWORD"	VARCHAR2(30)	NOT NULL,
	"AD_GENDER"	VARCHAR2(5)	NOT NULL
);


CREATE TABLE "NOTICE" (
	"NT_NO"	NUMBER	NOT NULL,
	"NT_TITLE"	VARCHAR2(300)	NOT NULL,
	"NT_CONTENT"	VARCHAR2(3000)	NOT NULL,
	"NT_CNT"	NUMBER DEFAULT 0	NOT NULL	,
	"NT_DATE"	TIMESTAMP DEFAULT SYSTIMESTAMP	NOT NULL	,
	"NT_NICKNAME"	VARCHAR2(45)	NOT NULL,
	"AD_ID"	VARCHAR2(30)	NOT NULL
);


CREATE TABLE "RANKING" (
	"BK_RANK"	NUMBER	NOT NULL,
	"BK_WEEKSALES"	NUMBER	NOT NULL,
	"BK_NO"	NUMBER	NOT NULL,
	"BK_TITLE"	VARCHAR2(150)	NOT NULL,
	"BK_IMG"	VARCHAR(255)	NULL,
	"BK_RATING"	NUMBER	NULL,
	"BK_RV"	NUMBER	NULL
);


CREATE TABLE "BOOK" (
	"BK_NO"	NUMBER	NOT NULL,
	"BK_TITLE"	VARCHAR2(150)	NOT NULL,
	"BK_IMG"	VARCHAR(255)	NULL	,
	"BK_PRICE"	NUMBER DEFAULT 0	NOT NULL	,
	"BK_WRITER"	VARCHAR2(30)	NULL,
	"BK_PUBLISHDATE"	DATE	NULL,
	"BK_RATING"	NUMBER	NULL,
	"BK_RV"	NUMBER	NULL,
	"BK_SALES"	NUMBER	NULL,
	"GN_NO"	NUMBER	NOT NULL
);


CREATE TABLE "GENRE" (
	"GN_NO"	NUMBER	NOT NULL,
	"GN_NAME"	VARCHAR2(30)	NOT NULL
);


CREATE TABLE "REVIEW" (
	"RV_NUM"	NUMBER	NOT NULL,
	"RV_DATE"	TIMESTAMP DEFAULT SYSTIMESTAMP	NOT NULL	,
	"RV_TITLE"	VARCHAR2(30)	NOT NULL,
	"RV_RATING"	NUMBER	NOT NULL,
	"RV_CONTENT"	VARCHAR2(300)	NOT NULL,
	"BK_NO"	NUMBER	NOT NULL,
	"US_ID"	VARCHAR2(30)	NOT NULL
);


CREATE TABLE "CART" (
	"US_ID"	VARCHAR2(30)	NOT NULL,
	"BK_NO"	NUMBER	NOT NULL,
	"CA_COUNT"	NUMBER	NULL
);


CREATE TABLE "SUBSCRIBE" (
	"US_ID"	VARCHAR2(30)	NOT NULL,
	"SUB_INF"	VARCHAR2(50)	NULL,
	"SUB_YN"	VARCHAR2(10) DEFAULT 'N'	NOT NULL	,
	"SUB_START"	TIMESTAMP DEFAULT SYSTIMESTAMP	NULL	,
	"SUB_END"	TIMESTAMP DEFAULT SYSTIMESTAMP	NULL	,
	"SUB_REVIEW"	VARCHAR2(500)	NULL,
	"SUB_LIST"	VARCHAR2(30)	NULL
);


CREATE TABLE "ORDER_BOOK" (
	"OR_NUM"	NUMBER	NOT NULL,
	"BK_NO"	NUMBER	NOT NULL,
	"OB_COUNT"	NUMBER DEFAULT 1	NOT NULL	,
	"OB_PRICE"	NUMBER	NOT NULL
);


CREATE TABLE "TIME_PERIOD" (
	"BK_WEEKSALES"	NUMBER	NOT NULL,
	"BK_NO"	NUMBER	NOT NULL
);

ALTER TABLE "WRITER_BBS" ADD CONSTRAINT "PK_WRITER_BBS" PRIMARY KEY (
	"WB_NO"
);

ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "PK_FUNDING_MANAGE" PRIMARY KEY (
	"WB_NO",
	"US_ID"
);

ALTER TABLE "WRITER_BBS_COMMENT" ADD CONSTRAINT "PK_WRITER_BBS_COMMENT" PRIMARY KEY (
	"WBC_NO"
);

ALTER TABLE "ORDER" ADD CONSTRAINT "PK_ORDER" PRIMARY KEY (
	"OR_NUM"
);

ALTER TABLE "USER" ADD CONSTRAINT "PK_USER" PRIMARY KEY (
	"US_ID"
);

ALTER TABLE "ADMIN" ADD CONSTRAINT "PK_ADMIN" PRIMARY KEY (
	"AD_ID"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
	"NT_NO"
);

ALTER TABLE "RANKING" ADD CONSTRAINT "PK_RANKING" PRIMARY KEY (
	"BK_RANK"
);

ALTER TABLE "BOOK" ADD CONSTRAINT "PK_BOOK" PRIMARY KEY (
	"BK_NO"
);

ALTER TABLE "GENRE" ADD CONSTRAINT "PK_GENRE" PRIMARY KEY (
	"GN_NO"
);

ALTER TABLE "REVIEW" ADD CONSTRAINT "PK_REVIEW" PRIMARY KEY (
	"RV_NUM"
);

ALTER TABLE "CART" ADD CONSTRAINT "PK_CART" PRIMARY KEY (
	"US_ID",
	"BK_NO"
);

ALTER TABLE "SUBSCRIBE" ADD CONSTRAINT "PK_SUBSCRIBE" PRIMARY KEY (
	"US_ID"
);

ALTER TABLE "ORDER_BOOK" ADD CONSTRAINT "PK_ORDER_BOOK" PRIMARY KEY (
	"OR_NUM",
	"BK_NO"
);

ALTER TABLE "TIME_PERIOD" ADD CONSTRAINT "PK_TIME_PERIOD" PRIMARY KEY (
	"BK_WEEKSALES"
);

ALTER TABLE "WRITER_BBS" ADD CONSTRAINT "FK_USER_TO_WRITER_BBS_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "FK_WRITER_TO_FUNDING_MANAGE_1" FOREIGN KEY (
	"WB_NO"
)
REFERENCES "WRITER_BBS" (
	"WB_NO"
);

ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "FK_USER_TO_FUNDING_MANAGE_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "FK_ADMIN_TO_FUNDING_MANAGE_1" FOREIGN KEY (
	"AD_ID"
)
REFERENCES "ADMIN" (
	"AD_ID"
);

ALTER TABLE "WRITER_BBS_COMMENT" ADD CONSTRAINT "FK_WRITER_BBS_COMMENT" FOREIGN KEY (
	"WB_NO"
)
REFERENCES "WRITER_BBS" (
	"WB_NO"
);

ALTER TABLE "WRITER_BBS_COMMENT" ADD CONSTRAINT "FK_USER_WRITER_BBS_COMMENT" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "ORDER" ADD CONSTRAINT "FK_USER_TO_ORDER_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "FK_ADMIN_TO_NOTICE_1" FOREIGN KEY (
	"AD_ID"
)
REFERENCES "ADMIN" (
	"AD_ID"
);

ALTER TABLE "RANKING" ADD CONSTRAINT "FK_TIME_PERIOD_TO_RANKING_1" FOREIGN KEY (
	"BK_WEEKSALES"
)
REFERENCES "TIME_PERIOD" (
	"BK_WEEKSALES"
);

ALTER TABLE "RANKING" ADD CONSTRAINT "FK_TIME_PERIOD_TO_RANKING_2" FOREIGN KEY (
	"BK_NO"
)
REFERENCES "BOOK" (
	"BK_NO"
);

ALTER TABLE "BOOK" ADD CONSTRAINT "FK_GENRE_TO_BOOK_1" FOREIGN KEY (
	"GN_NO"
)
REFERENCES "GENRE" (
	"GN_NO"
);

ALTER TABLE "REVIEW" ADD CONSTRAINT "FK_BOOK_TO_REVIEW_1" FOREIGN KEY (
	"BK_NO"
)
REFERENCES "BOOK" (
	"BK_NO"
);

ALTER TABLE "REVIEW" ADD CONSTRAINT "FK_USER_TO_REVIEW_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "CART" ADD CONSTRAINT "FK_USER_TO_CART_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "CART" ADD CONSTRAINT "FK_BOOK_TO_CART_1" FOREIGN KEY (
	"BK_NO"
)
REFERENCES "BOOK" (
	"BK_NO"
);

ALTER TABLE "SUBSCRIBE" ADD CONSTRAINT "FK_USER_TO_SUBSCRIBE_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
);

ALTER TABLE "ORDER_BOOK" ADD CONSTRAINT "FK_ORDER_TO_ORDER_BOOK_1" FOREIGN KEY (
	"OR_NUM"
)
REFERENCES "ORDER" (
	"OR_NUM"
);

ALTER TABLE "ORDER_BOOK" ADD CONSTRAINT "FK_BOOK_TO_ORDER_BOOK_1" FOREIGN KEY (
	"BK_NO"
)
REFERENCES "BOOK" (
	"BK_NO"
);

ALTER TABLE "TIME_PERIOD" ADD CONSTRAINT "FK_BOOK_TO_TIME_PERIOD_1" FOREIGN KEY (
	"BK_NO"
)
REFERENCES "BOOK" (
	"BK_NO"
);

-- 수정사항

-- 1. 제약조건 변경
-- US_ID FK에 ON DELETE CASCADE 옵션 추가 (총 7개)

-- WRITER_BBS 테이블
ALTER TABLE WRITER_BBS DROP CONSTRAINT FK_USER_TO_WRITER_BBS_1;

ALTER TABLE "WRITER_BBS" ADD CONSTRAINT "FK_USER_TO_WRITER_BBS_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE ;

-- FUNDING_MANAGE 테이블
ALTER TABLE FUNDING_MANAGE DROP CONSTRAINT FK_USER_TO_FUNDING_MANAGE_1;

ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "FK_USER_TO_FUNDING_MANAGE_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE ;

-- WRITER_BBS_COMMENT 테이블
ALTER TABLE WRITER_BBS_COMMENT DROP CONSTRAINT FK_USER_WRITER_BBS_COMMENT;

ALTER TABLE "WRITER_BBS_COMMENT" ADD CONSTRAINT "FK_USER_WRITER_BBS_COMMENT" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE;

-- ORDER 테이블
ALTER TABLE "ORDER" DROP CONSTRAINT FK_USER_TO_ORDER_1;

ALTER TABLE "ORDER" ADD CONSTRAINT "FK_USER_TO_ORDER_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE;

-- REVIEW 테이블
ALTER TABLE REVIEW DROP CONSTRAINT FK_USER_TO_REVIEW_1;

ALTER TABLE "REVIEW" ADD CONSTRAINT "FK_USER_TO_REVIEW_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE ;

-- CART 테이블
ALTER TABLE CART DROP CONSTRAINT FK_USER_TO_CART_1;
ALTER TABLE "CART" ADD CONSTRAINT "FK_USER_TO_CART_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE ;

-- SUBSCRIBE 테이블
ALTER TABLE SUBSCRIBE DROP CONSTRAINT FK_USER_TO_SUBSCRIBE_1;
ALTER TABLE "SUBSCRIBE" ADD CONSTRAINT "FK_USER_TO_SUBSCRIBE_1" FOREIGN KEY (
	"US_ID"
)
REFERENCES "USER" (
	"US_ID"
) ON DELETE CASCADE;

-- AD_ID FK에 ON DELETE CASCADE 옵션 추가 (총 3개)

-- FUNDING_MANAGE 테이블
ALTER TABLE FUNDING_MANAGE DROP CONSTRAINT FK_ADMIN_TO_FUNDING_MANAGE_1;
ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "FK_ADMIN_TO_FUNDING_MANAGE_1" FOREIGN KEY (
	"AD_ID"
)
REFERENCES "ADMIN" (
	"AD_ID"
)ON DELETE CASCADE;

-- NOTICE 테이블

ALTER TABLE NOTICE DROP CONSTRAINT FK_ADMIN_TO_NOTICE_1;
ALTER TABLE "NOTICE" ADD CONSTRAINT "FK_ADMIN_TO_NOTICE_1" FOREIGN KEY (
	"AD_ID"
)
REFERENCES "ADMIN" (
	"AD_ID"
) ON DELETE CASCADE;


-- SUBSCRIBE 테이블에 AD_ID FK로 묶기 위해서 컬럼 추가 
ALTER TABLE SUBSCRIBE ADD AD_ID VARCHAR2(30) NOT NULL;

ALTER TABLE "SUBSCRIBE" ADD CONSTRAINT "FK_ADMIN_TO_SUBSCRIBE_1" FOREIGN KEY (
	"AD_ID"
)
REFERENCES "ADMIN" (
	"AD_ID"
) ON DELETE CASCADE;



-- WRITER_BBS_COMMENT 테이블
ALTER TABLE WRITER_BBS_COMMENT DROP CONSTRAINT FK_WRITER_BBS_COMMENT;

ALTER TABLE "WRITER_BBS_COMMENT" ADD CONSTRAINT "FK_WRITER_BBS_COMMENT" FOREIGN KEY (
	"WB_NO"
)
REFERENCES "WRITER_BBS" (
	"WB_NO"
) ON DELETE CASCADE;

-- FUNDING_MANAGE 테이블
ALTER TABLE FUNDING_MANAGE DROP CONSTRAINT FK_WRITER_TO_FUNDING_MANAGE_1;
ALTER TABLE "FUNDING_MANAGE" ADD CONSTRAINT "FK_WRITER_TO_FUNDING_MANAGE_1" FOREIGN KEY (
	"WB_NO"
)
REFERENCES "WRITER_BBS" (
	"WB_NO"
) ON DELETE CASCADE;

--2. 시퀀스 생성
--DROP SEQUENCE SEQ_OR_NUM;
--DROP SEQUENCE SEQ_RV_NUM;
--DROP SEQUENCE SEQ_WB_NO;
--DROP SEQUENCE SEQ_WBC_NO;
--DROP SEQUENCE SEQ_NT_NO;
--DROP SEQUENCE SEQ_BK_NO;

CREATE SEQUENCE SEQ_OR_NUM
START WITH 1
INCREMENT BY 1
NOCYCLE 
NOCACHE;

CREATE SEQUENCE SEQ_RV_NUM
START WITH 1
INCREMENT BY 1
NOCYCLE 
NOCACHE;

CREATE SEQUENCE SEQ_WB_NO
START WITH 1
INCREMENT BY 1
NOCYCLE 
NOCACHE;

CREATE SEQUENCE SEQ_WBC_NO
START WITH 1
INCREMENT BY 1
NOCYCLE 
NOCACHE;

CREATE SEQUENCE SEQ_NT_NO
START WITH 1
INCREMENT BY 1
NOCYCLE 
NOCACHE;

CREATE SEQUENCE SEQ_BK_NO
START WITH 1
INCREMENT BY 1
NOCYCLE 
NOCACHE;

-- 3. 빠진 컬럼 추가 (연재 게시글 댓글 작성자)
ALTER TABLE WRITER_BBS_COMMENT ADD WBC_WRITER VARCHAR2(45) NOT NULL;

--INSERT문
DESC ADMIN;
DESC NOTICE;
DESC USER;
DESC GENRE;
DESC BOOK;
DESC TIME_PERIOD;
DESC RANKING;
DESC REVIEW;
DESC ORDER;
DESC ORDER_BOOK;
DESC CART;
DESC SUBSCRIBE;
DESC WRITER_BBS;
DESC WRITER_BBS_COMMENT;
DESC FUNDING_MANAGE;
-- 관리자 ADMIN

INSERT INTO ADMIN VALUES('ad111', 'asdf@jkbs.com', '01055555555', '쥬르기', 'KH', 'adaaa', 'F');
-- 공지사항 NOTICE

INSERT INTO NOTICE VALUES (SEQ_NT_NO.nextval, '첫 공지사항', '첫인서트문', 0, to_char(sysdate,'yyyy.mm.dd hh24:mi'), '쥬르기', 'ad111');
--사용자 USER

INSERT INTO "USER" VALUES ('us111','aaa@jkbs.com','01011111111','사자','usaaa','F','서울특별시','김유저','97/01/01');
INSERT INTO "USER" VALUES ('us222','bbb@jkbs.com','01011111111','호랑이','usbbb','M','경기도','박유저','95/02/02');
-- 장르 GENRE

INSERT INTO GENRE VALUES (1,'스릴러');
INSERT INTO GENRE VALUES (2,'힐링');
INSERT INTO GENRE VALUES (3,'로맨스');
INSERT INTO GENRE VALUES (4,'자기개발');
-- 도서 BOOK
       
INSERT INTO BOOK VALUES (SEQ_BK_NO.nextval, '좀비', '이미지', 19800, '이작가', '2019-07-07', '3', '5','400', '1');
INSERT INTO BOOK VALUES (SEQ_BK_NO.nextval, 'KH정보교육원', '이미지', 39800, '조병국', '1993-08-07', '5', '18','1800', '2');
-- 주차별 판매량 TIME_PERIOD

INSERT INTO TIME_PERIOD VALUES ('173', '1');
INSERT INTO TIME_PERIOD VALUES ('2890', '2');
-- 랭킹 RANKING

INSERT INTO RANKING VALUES ('1', '2890', '2', 'kh정보교육원', '이미지', '5', '18');
INSERT INTO RANKING VALUES ('2', '173', '1', '좀비', '이미지', '3', '5');
-- 리뷰 REVIEW

INSERT INTO REVIEW VALUES (SEQ_RV_NUM.nextval, SYSDATE, '리뷰제목 입니다', 5,'리뷰 내용입니다요',1,'us111');
-- 주문 ORDER

INSERT INTO "ORDER" VALUES (SEQ_OR_NUM.nextval, 19800, SYSDATE,'us111');
-- 주문_책 ORDER_BOOK

INSERT INTO ORDER_BOOK VALUES (1, 1, 1,19800);
 
INSERT INTO CART VALUES ('us111',2,1);
-- 구독권 SUBSCRIBE
 
INSERT INTO SUBSCRIBE VALUES ('us111','정기 구독권','y',SYSTIMESTAMP,null,null,null,'ad111');
-- 연재 게시글 WRITER_BBS 

INSERT INTO WRITER_BBS VALUES(SEQ_WB_NO.nextval,'메밀꽃 필 무렵','여름 장이란 애시당초에 글러서, 해는 아직 중천에 있건만 장판은 벌써 쓸쓸하고 더운 햇발이 벌여놓은 전 휘장 밑으로 등줄기를 훅훅 볶는다. 마을 사람들은 거지 반 돌아간 뒤요, 팔리지 못한 나무꾼 패가 길거리에 궁싯거리고 있으나, 석유병이나 받고 고깃마리나 사면 족할 이 축들을 바라고 언제까지든지 버티고 있을 법은 없다. 춥춥스럽게 날아드는 파리 떼도, 장난꾼 각다귀들도 귀찮다. 얼금뱅이요, 왼손잡이인 드팀전(온갖 피륙을 팔던 가게)의 허생원은 기어코 동업의 조선달에게 나꾸어보았다. 
 드팀전의 허 생원과 조 선달이 장을 거두고 술집에 들렀을때 벌써 먼저 온 동업의 젊은 녀석 동이가 계집을 가로채고 농탕치고있었다. 허 생원은 괜히 화가 나서 기어코 그를 야단쳐서 쫓아내고 말았다. 장돌뱅이의 망신을 시킨다고 말이다. 그런데 뜻밖에 그는 얼마 후 되돌아와서 허 생원의 나귀가 발광을 하고 있다고 일러 주는 것이었다. 허 생원은 어이가 없었다. 얽음뱅이요 왼손잡이인 허 생원은 계집과는 인연이 멀었다. 때문에 장돌림을 시작한 지 20년이 넘었건만 아직 홀몸이었다. 그러므로, 자신과 늘 함께하는 나귀의 신세가 느꺼웠던 것이다.
 밤이 들어 허 생원은 조 선달과 동이와 함께 나귀를 몰고 다음 장으로 발을 옮겼다. 봉평장으로 가기 위해서다. 달이 환히 밝았다. 달밤이면 으례, 허 생원은 젊었을 때 봉평에서 겪었던 옛일을 애기하는 것이었다.',default,SYSTIMESTAMP,'사자','문학','us111');
 
INSERT INTO WRITER_BBS VALUES (SEQ_WB_NO.nextval,'애국가','동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려 강산 대한 사람 대한으로 길이 보전하세 
남산 위에 저 소나무 철갑을 두른 듯 바람 서리 불변함은 우리 기상일세 무궁화 삼천리 화려 강산 대한 사람 대한으로 길이 보전하세',default,SYSTIMESTAMP,'호랑이','기타','us222');
-- 연재 게시글 댓글 WRITER_BBS_COMMENT
  
INSERT INTO WRITER_BBS_COMMENT VALUES(SEQ_WBC_NO.nextval,SYSTIMESTAMP,'메밀꽃 필 무렵 한컴 타자연습으로 타자 연습함',5,1,'us222','호랑이');
INSERT INTO WRITER_BBS_COMMENT VALUES(SEQ_WBC_NO.nextval,SYSTIMESTAMP,'애국가 1절 4절',5,1,'us111','사자');
-- 펀딩관리 FUNDING_MANAGE

INSERT INTO FUNDING_MANAGE VALUES (1,'us222',10000000,30000,default,100000,default,'ad111');

-- 테이블 JOIN

-- 1. 유저,  장바구니  , 도서 
SELECT U.US_ID 유저아이디 , C.CA_COUNT 수량 , B.BK_NO 도서번호, B.BK_TITLE 도서명, B.BK_PRICE 도서가격
FROM "USER" U JOIN CART C
ON U.US_ID = C.US_ID 
JOIN BOOK B
ON B.BK_NO = C.BK_NO;

-- 2. 유저, 주문, 주문_책 
SELECT U.US_ID 유저아이디 , O.OR_NUM 주문번호, O.OR_PRICE 가격, OB.BK_NO 도서번호, OB.OB_COUNT 주문수량
FROM "USER" U JOIN "ORDER" O 
ON U.US_ID = O.US_ID 
JOIN ORDER_BOOK OB
ON O.OR_NUM = OB.OR_NUM;

-- 3. 장르,도서,주간 판매량, 순위
SELECT G.GN_NAME 장르명, B.BK_TITLE 도서명, B.BK_PRICE 도서가격, B.BK_WRITER 작가 ,
R.BK_RANK 랭킹 , TP.BK_WEEKSALES 주차별판매량
FROM GENRE G JOIN BOOK B
ON G.GN_NO = B.GN_NO 
JOIN TIME_PERIOD TP
ON  TP.BK_NO = B.BK_NO
JOIN RANKING R
ON B.BK_NO = R.BK_NO;
-- 4. 연재게시글, 연재게시글 댓글, 펀딩

SELECT WB.WB_WRITER 작성자 , WB.WB_TITLE 연재게시글, WBC.WBC_CONTENT 댓글내용, WBC_WRITER 댓글작성자,
F.FD_ACCUMULATE 펀딩모인금액, F.FD_DONATION 후원금액,  F.FD_DEADLINE 펀딩마감일
FROM WRITER_BBS WB JOIN WRITER_BBS_COMMENT WBC
ON WB.WB_NO = WBC.WBC_NO
JOIN FUNDING_MANAGE F
ON WB.WB_NO = F.WB_NO;

