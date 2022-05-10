package kh.semi.reviewBook.book.model.vo;

import java.sql.Date;

public class BookVo {
//	1	BK_NO	NUMBER	✔	PK		도서번호
//	2	BK_TITLE	TIMESTAMP	✔			도서이름
//	3	BK_IMG					도서이미지
//	4	BK_PRICE	VARCHAR2(30)	✔			가격
//	5	BK_WRITER	NUMBER				작가
//	6	BK_PUBLISHDATE	VARCHAR2(300)				출판일
//	7	BK_RATING	NUMBER				별점
//	8	BK_RV	NUMBER				리뷰개수
//	9	BK_SALES	NUMBER				판매량
//	10	GN_NO	NUMBER	✔	FK		장르번호
//	11	BK_CONTENT	VARCHAR2(4000)	✔		책 줄거리
//	12	BK_INDEX	VARCHAR2(1000)	✔		책 목차
	private int bkNo;
	private String bkTitle;
	private String bkImg;
	private int bkPrice;
	private String bkWriter;
	private String bkPublishdate;
	private int bkRating;
	private int bkRv;
	private int bkSales;
	private int gnNo;
	private String bkContent;
	private String bkIndex;
	private String gnName;
	
	

	@Override
	public String toString() {
		return "BookVo [bkNo=" + bkNo + ", bkTitle=" + bkTitle + ", bkImg=" + bkImg + ", bkPrice=" + bkPrice
				+ ", bkWriter=" + bkWriter + ", bkPublishdate=" + bkPublishdate + ", bkRating=" + bkRating + ", bkRv="
				+ bkRv + ", bkSales=" + bkSales + ", gnNo=" + gnNo + ", bkContent=" + bkContent + ", bkIndex=" + bkIndex
				+ ", gnName=" + gnName + "]";
	}

	public int getBkNo() {
		return bkNo;
	}

	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}

	public String getBkTitle() {
		return bkTitle;
	}

	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}

	public String getBkImg() {
		return bkImg;
	}

	public void setBkImg(String bkImg) {
		this.bkImg = bkImg;
	}

	public int getBkPrice() {
		return bkPrice;
	}

	public void setBkPrice(int bkPrice) {
		this.bkPrice = bkPrice;
	}

	public String getBkWriter() {
		return bkWriter;
	}

	public void setBkWriter(String bkWriter) {
		this.bkWriter = bkWriter;
	}

	public String getBkPublishdate() {
		return bkPublishdate;
	}

	public void setBkPublishdate(String bkPublishdate) {
		this.bkPublishdate = bkPublishdate;
	}

	public int getBkRating() {
		return bkRating;
	}

	public void setBkRating(int bkRating) {
		this.bkRating = bkRating;
	}

	public int getBkRv() {
		return bkRv;
	}

	public void setBkRv(int bkRv) {
		this.bkRv = bkRv;
	}

	public int getBkSales() {
		return bkSales;
	}

	public void setBkSales(int bkSales) {
		this.bkSales = bkSales;
	}

	public int getGnNo() {
		return gnNo;
	}

	public void setGnNo(int gnNo) {
		this.gnNo = gnNo;
	}

	public String getBkContent() {
		return bkContent;
	}

	public void setBkContent(String bkContent) {
		this.bkContent = bkContent;
	}

	public String getBkIndex() {
		return bkIndex;
	}

	public void setBkIndex(String bkIndex) {
		this.bkIndex = bkIndex;
	}

	public String getGnName() {
		return gnName;
	}

	public void setGnName(String gnName) {
		this.gnName = gnName;
	}
	

}
