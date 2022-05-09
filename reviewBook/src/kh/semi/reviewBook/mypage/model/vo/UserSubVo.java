package kh.semi.reviewBook.mypage.model.vo;

import java.sql.Date;

public class UserSubVo {
//	US_ID       NOT NULL VARCHAR2(30)  
//	SUB_INF    NOT NULL VARCHAR2(50)  
//	SUB_YN              VARCHAR2(10)  
//	SUB_START           TIMESTAMP(6)
	
	private String usId;
	private String subInf;
	private String subYN;
	private Date subStart;
	
	public UserSubVo() {
		super();
	}
	@Override
	public String toString() {
		return "UserSubVo [usId=" + usId + ", subInf=" + subInf + ", subYN=" + subYN + ", subStart=" + subStart + "]";
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
	

}
