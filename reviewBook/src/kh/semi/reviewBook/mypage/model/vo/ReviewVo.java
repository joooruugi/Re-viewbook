package kh.semi.reviewBook.mypage.model.vo;

import java.sql.Date;

public class ReviewVo {
//	RV_NUM     NOT NULL NUMBER        
//	RV_DATE    NOT NULL TIMESTAMP(6)  
//	RV_TITLE   NOT NULL VARCHAR2(30)  
//	RV_RATING  NOT NULL NUMBER        
//	RV_CONTENT NOT NULL VARCHAR2(300) 
//	BK_NO      NOT NULL NUMBER        
//	US_ID      NOT NULL VARCHAR2(30)  
	
	private int rvNum;
	private Date rvDate;
	private String rvTitle;
	private int rvRating;
	private String rvContent;
	private int bkNo;
	private String usId;
	@Override
	public String toString() {
		return "ReviewVo [rvNum=" + rvNum + ", rvDate=" + rvDate + ", rvTitle=" + rvTitle + ", rvRating=" + rvRating
				+ ", rvContent=" + rvContent + ", bkNo=" + bkNo + ", usId=" + usId + "]";
	}
	public int getRvNum() {
		return rvNum;
	}
	public void setRvNum(int rvNum) {
		this.rvNum = rvNum;
	}
	public Date getRvDate() {
		return rvDate;
	}
	public void setRvDate(Date rvDate) {
		this.rvDate = rvDate;
	}
	public String getRvTitle() {
		return rvTitle;
	}
	public void setRvTitle(String rvTitle) {
		this.rvTitle = rvTitle;
	}
	public int getRvRating() {
		return rvRating;
	}
	public void setRvRating(int rvRating) {
		this.rvRating = rvRating;
	}
	public String getRvContent() {
		return rvContent;
	}
	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}
	public int getBkNo() {
		return bkNo;
	}
	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}
	public String getUsId() {
		return usId;
	}
	public void setUsId(String usId) {
		this.usId = usId;
	}
	


}
