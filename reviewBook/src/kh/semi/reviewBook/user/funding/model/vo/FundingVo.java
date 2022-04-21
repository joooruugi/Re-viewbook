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
	private int fdAccumulate;
	private int fdDonation;
	private String fdDeadline;
	private int fdLimit;
	private int fdOX;
	private String adId;
	
	public FundingVo() {
		super();
	}

	@Override
	public String toString() {
		return "FundingVo [wbNO=" + wbNO + ", usId=" + usId + ", fdAccumulate=" + fdAccumulate + ", fdDonation="
				+ fdDonation + ", fdDeadline=" + fdDeadline + ", fdLimit=" + fdLimit + ", fdOX=" + fdOX + ", adId="
				+ adId + "]";
	}

	public int getWbNO() {
		return wbNO;
	}

	public String getUsId() {
		return usId;
	}

	public int getFdAccumulate() {
		return fdAccumulate;
	}

	public int getFdDonation() {
		return fdDonation;
	}

	public String getFdDeadline() {
		return fdDeadline;
	}

	public int getFdLimit() {
		return fdLimit;
	}

	public int getFdOX() {
		return fdOX;
	}

	public String getAdId() {
		return adId;
	}

	public void setWbNO(int wbNO) {
		this.wbNO = wbNO;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public void setFdAccumulate(int fdAccumulate) {
		this.fdAccumulate = fdAccumulate;
	}

	public void setFdDonation(int fdDonation) {
		this.fdDonation = fdDonation;
	}

	public void setFdDeadline(String fdDeadline) {
		this.fdDeadline = fdDeadline;
	}

	public void setFdLimit(int fdLimit) {
		this.fdLimit = fdLimit;
	}

	public void setFdOX(int fdOX) {
		this.fdOX = fdOX;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	
	
}
