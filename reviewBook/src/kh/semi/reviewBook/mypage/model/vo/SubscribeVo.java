package kh.semi.reviewBook.mypage.model.vo;

import java.sql.Date;

public class SubscribeVo {

//	US_ID      NOT NULL VARCHAR2(30)  
//	SUB_INF             VARCHAR2(50)  
//	SUB_YN     NOT NULL VARCHAR2(10)  
//	SUB_START           TIMESTAMP(6)  
//	SUB_END             TIMESTAMP(6)  
//	SUB_REVIEW          VARCHAR2(500) 
//	SUB_LIST            VARCHAR2(30)  
//	AD_ID      NOT NULL VARCHAR2(30)  
	private String usId;
	private String subInf;
	private String subYN;
	private Date subStart;
	private Date subEnd;
	private String subReview;
	private String subList;
	private String adId;
	
	@Override
	public String toString() {
		return "SubscribeVo [usId=" + usId + ", subInf=" + subInf + ", subYN=" + subYN + ", subStart=" + subStart
				+ ", subEnd=" + subEnd + ", subReview=" + subReview + ", subList=" + subList + ", adId=" + adId + "]";
	}

	public String getUsId() {
		return usId;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public String getSubInf() {
		return subInf;
	}

	public void setSubInf(String subInf) {
		this.subInf = subInf;
	}

	public String getSubYN() {
		return subYN;
	}

	public void setSubYN(String subYN) {
		this.subYN = subYN;
	}

	public Date getSubStart() {
		return subStart;
	}

	public void setSubStart(Date subStart) {
		this.subStart = subStart;
	}

	public Date getSubEnd() {
		return subEnd;
	}

	public void setSubEnd(Date subEnd) {
		this.subEnd = subEnd;
	}

	public String getSubReview() {
		return subReview;
	}

	public void setSubReview(String subReview) {
		this.subReview = subReview;
	}

	public String getSubList() {
		return subList;
	}

	public void setSubList(String subList) {
		this.subList = subList;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}
	
	
}
