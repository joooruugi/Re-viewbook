package kh.semi.reviewBook.book.model.vo;

import java.sql.Date;

public class BookInfVo {


//"BK_TITLE" VARCHAR2(150 BYTE) NOT NULL ENABLE, 
//"BK_IMG" VARCHAR2(255 BYTE), 
//"BK_PRICE" NUMBER DEFAULT 0 NOT NULL ENABLE, 
//"BK_WRITER" VARCHAR2(30 BYTE), 
//"BK_PUBLISHDATE" DATE, 
//"BK_RATING" NUMBER, 
//"BK_RV" NUMBER, 
//"BK_SALES" NUMBER, 
//"GN_NO" NUMBER NOT NULL ENABLE, 
//"BK_CONTENT" VARCHAR2(4000 BYTE), 
//"BK_INDEX" VARCHAR2(1000 BYTE),

	private int bkNo;
	private String bkTitle;
	private String bkImg;
	private int bkPrice;
	private String bkWrither;
	private Date bkPublishdate;
	private int bkRating;
	private int bkRv;
	private int gnNo;
	private String bkContent;
	private String bkIndex;

	
	
	public BookInfVo() {
		super();
	}

	public BookInfVo(int bkNo, String bkTitle) {
		super();
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
	}

	public BookInfVo(int bkNo, String bkTitle, String bkImg, int bkPrice, String bkWrither, Date bkPublishdate,
			int bkRating, int bkRv, int gnNo, String bkContent, String bkIndex) {
		super();
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkImg = bkImg;
		this.bkPrice = bkPrice;
		this.bkWrither = bkWrither;
		this.bkPublishdate = bkPublishdate;
		this.bkRating = bkRating;
		this.bkRv = bkRv;
		this.gnNo = gnNo;
		this.bkContent = bkContent;
		this.bkIndex = bkIndex;
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

	public String getBkWrither() {
		return bkWrither;
	}

	public void setBkWrither(String bkWrither) {
		this.bkWrither = bkWrither;
	}

	public Date getBkPublishdate() {
		return bkPublishdate;
	}

	public void setBkPublishdate(Date bkPublishdate) {
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
	
	
	
	
}
	