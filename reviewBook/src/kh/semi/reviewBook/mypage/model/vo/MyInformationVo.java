package kh.semi.reviewBook.mypage.model.vo;

public class MyInformationVo {
	
//		US_ID       NOT NULL VARCHAR2(30)  
//		US_EMAIL    NOT NULL VARCHAR2(150) 
//		US_PHONE    NOT NULL VARCHAR2(30)  
//		US_NICKNAME NOT NULL VARCHAR2(45)
//		US_ADDRESS  NOT NULL VARCHAR2(300) 
//		US_NAME     NOT NULL VARCHAR2(10)  

	private String usId;
	private String usEmail;
	private String usPhone;
	private String usNickname;
	private String usAddress;
	private String usName;

	@Override
	public String toString() {
		return "MyinformationVo [usId=" + usId + ", usEmail=" + usEmail + ", usPhone=" + usPhone + ", usNickname="
				+ usNickname + ", usAddress=" + usAddress + ", usName=" + usName + "]";
	}

	public String getUsId() {
		return usId;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public String getUsEmail() {
		return usEmail;
	}

	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}

	public String getUsPhone() {
		return usPhone;
	}

	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}

	public String getUsNickname() {
		return usNickname;
	}

	public void setUsNickname(String usNickname) {
		this.usNickname = usNickname;
	}

	public String getUsAddress() {
		return usAddress;
	}

	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

}
