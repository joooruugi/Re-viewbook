package kh.semi.reviewBook.mypage.model.vo;

import java.sql.Date;

public class BuyListVo {
//	BK_TITLE       NOT NULL VARCHAR2(150) 
//	BK_NO          NOT NULL NUMBER    히든    
//	OR_NUM   NOT NULL NUMBER       
//	OR_PRICE NOT NULL NUMBER       
//	OR_DATE  NOT NULL TIMESTAMP(6) 
//	US_ID    NOT NULL VARCHAR2(30)    히든
//	RV_NUM     NOT NULL NUMBER 

	private String bkTitle;
	private int bkNo;
	private int orNum;
	private int orPrice;
	private Date orDate;
	private String usId;
	private int rvNum;
	
	//생성자
	public BuyListVo() {
		super();
	}
	
	public BuyListVo(String bkTitle, int bkNo, int orNum, int orPrice, Date orDate, String usId, int rvNum) {
	super();
	this.bkTitle = bkTitle;
	this.bkNo = bkNo;
	this.orNum = orNum;
	this.orPrice = orPrice;
	this.orDate = orDate;
	this.usId = usId;
	this.rvNum = rvNum;
	}
	
	
	@Override
	public String toString() {
		return "BuyListVo [bkTitle=" + bkTitle + ", bkNo=" + bkNo + ", orNum=" + orNum + ", orPrice=" + orPrice
				+ ", orDate=" + orDate + ", usId=" + usId + ", rvNum=" + rvNum + "]";
	}
	public String getBkTitle() {
		return bkTitle;
	}
	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}
	public int getBkNo() {
		return bkNo;
	}
	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}
	public int getOrNum() {
		return orNum;
	}
	public void setOrNum(int orNum) {
		this.orNum = orNum;
	}
	public int getOrPrice() {
		return orPrice;
	}
	public void setOrPrice(int orPrice) {
		this.orPrice = orPrice;
	}
	public Date getOrDate() {
		return orDate;
	}
	public void setOrDate(Date orDate) {
		this.orDate = orDate;
	}
	public String getUsId() {
		return usId;
	}
	public void setUsId(String usId) {
		this.usId = usId;
	}
	public int getRvNum() {
		return rvNum;
	}
	public void setRvNum(int rvNum) {
		this.rvNum = rvNum;
	}
	
	
	
	
}
