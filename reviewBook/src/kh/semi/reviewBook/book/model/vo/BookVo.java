package kh.semi.reviewBook.book.model.vo;

public class BookVo {

	private int bkRank;
	private int bkWeeksales;
	private int bkNo;
	private String bkTitle;
	private String bkImg;
	private int bkRating;
	private int bkRv;
	public BookVo() {
		super();
	}
	public BookVo(int bkRank, int bkNo) {
		super();
		this.bkRank = bkRank;
		this.bkNo = bkNo;
	}
	public BookVo(int bkRank, int bkWeeksales, int bkNo, String bkTitle, String bkImg, int bkRating, int bkRv) {
		super();
		this.bkRank = bkRank;
		this.bkWeeksales = bkWeeksales;
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkImg = bkImg;
		this.bkRating = bkRating;
		this.bkRv = bkRv;
	}
	public int getBkRank() {
		return bkRank;
	}
	public void setBkRank(int bkRank) {
		this.bkRank = bkRank;
	}
	public int getBkWeeksales() {
		return bkWeeksales;
	}
	public void setBkWeeksales(int bkWeeksales) {
		this.bkWeeksales = bkWeeksales;
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







}
