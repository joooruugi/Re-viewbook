package kh.semi.reviewBook.admin.vo;

public class AdminVo {
//	AD_ID	VARCHAR2(30)	✔	PK
//	AD_EMAIL	VARCHAR2(150)	✔	
//	AD_PHONE	VARCHAR2(30)	✔	
//	AD_NICKNAME	VARCHAR2(45)	✔	
//	AD_COMPANY	VARCHAR2(60)	✔	
//	AD_PASSWORD	VARCHAR2(30)	✔	
//	AD_GENDER	VARCHAR2(5)	✔	
	
	private String adId;
	private String adEmail;
	private String adPhone;
	private String adNickname;
	private String adCompany;
	private String adPassword;
	private String adGender;
	
	@Override
	public String toString() {
		return "AdminVo [adId=" + adId + ", adEmail=" + adEmail + ", adPhone=" + adPhone + ", adNickname=" + adNickname
				+ ", adCompany=" + adCompany + ", adPassword=" + adPassword + ", adGender=" + adGender + "]";
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getAdEmail() {
		return adEmail;
	}

	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}

	public String getAdPhone() {
		return adPhone;
	}

	public void setAdPhone(String adPhone) {
		this.adPhone = adPhone;
	}

	public String getAdNickname() {
		return adNickname;
	}

	public void setAdNickname(String adNickname) {
		this.adNickname = adNickname;
	}

	public String getAdCompany() {
		return adCompany;
	}

	public void setAdCompany(String adCompany) {
		this.adCompany = adCompany;
	}

	public String getAdPassword() {
		return adPassword;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}

	public String getAdGender() {
		return adGender;
	}

	public void setAdGender(String adGender) {
		this.adGender = adGender;
	}
	
	
}
