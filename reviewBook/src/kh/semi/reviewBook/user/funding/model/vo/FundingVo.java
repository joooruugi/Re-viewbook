package kh.semi.reviewBook.user.funding.model.vo;

public class FundingVo {
//	WB_NO         NOT NULL NUMBER       
//	US_ID         NOT NULL VARCHAR2(30) 
//	FD_ACCUMULATE          NUMBER       
//	FD_DONATION            NUMBER       
//	FD_DEADLINE   NOT NULL DATE         
//	FD_LIMIT      NOT NULL NUMBER       
//	FD_OX         NOT NULL NUMBER       
//	AD_ID         NOT NULL VARCHAR2(30) 
	private int wbNO;
	private String usId;
	private int fdDonation;

	
	public FundingVo() {
		super();
	}


	@Override
	public String toString() {
		return "FundingVo [wbNO=" + wbNO + ", usId=" + usId + ", fdDonation=" + fdDonation + "]";
	}


	public FundingVo(int wbNO, String usId, int fdDonation) {
		super();
		this.wbNO = wbNO;
		this.usId = usId;
		this.fdDonation = fdDonation;
	}


	public int getWbNO() {
		return wbNO;
	}


	public String getUsId() {
		return usId;
	}


	public int getFdDonation() {
		return fdDonation;
	}


	public void setWbNO(int wbNO) {
		this.wbNO = wbNO;
	}


	public void setUsId(String usId) {
		this.usId = usId;
	}


	public void setFdDonation(int fdDonation) {
		this.fdDonation = fdDonation;
	}

	
}
