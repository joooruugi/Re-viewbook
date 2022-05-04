package kh.semi.reviewBook.mypage.model.vo;

import java.sql.Date;

public class CartVo {
//	US_ID    NOT NULL VARCHAR2(30) 
//	BK_NO    NOT NULL NUMBER       
//	CA_COUNT          NUMBER
//	BK_TITLE       NOT NULL VARCHAR2(150) 
//	BK_IMG                  VARCHAR2(255) 
//	BK_PRICE       NOT NULL NUMBER        
//	BK_WRITER               VARCHAR2(30)  
//	BK_PUBLISHDATE          DATE         
	
	private String usId;
	private int bkNo;
	private int caCount;
	private String bkTitle;
	private String bkImg;
	private int bkPrice;
	private String bkWriter;
	private Date bkPublishdate;
	@Override
	public String toString() {
		return "CartVo [usId=" + usId + ", bkNo=" + bkNo + ", caCount=" + caCount + ", bkTitle=" + bkTitle + ", bkImg="
				+ bkImg + ", bkPrice=" + bkPrice + ", bkWriter=" + bkWriter + ", bkPublishdate=" + bkPublishdate + "]";
	}
	public String getUsId() {
		return usId;
	}
	public void setUsId(String usId) {
		this.usId = usId;
	}
	public int getBkNo() {
		return bkNo;
	}
	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}
	public int getCaCount() {
		return caCount;
	}
	public void setCaCount(int caCount) {
		this.caCount = caCount;
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
	public Date getBkPublishdate() {
		return bkPublishdate;
	}
	public void setBkPublishdate(Date bkPublishdate) {
		this.bkPublishdate = bkPublishdate;
	}
	
}
