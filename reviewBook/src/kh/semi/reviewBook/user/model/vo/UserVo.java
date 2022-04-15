package kh.semi.reviewBook.user.model.vo;

public class UserVo {

//	US_ID       NOT NULL VARCHAR2(30)  
//	US_EMAIL    NOT NULL VARCHAR2(150) 
//	US_PHONE    NOT NULL VARCHAR2(30)  
//	US_NICKNAME NOT NULL VARCHAR2(45)  
//	US_PASSWORD NOT NULL VARCHAR2(30)  
//	US_GENDER   NOT NULL VARCHAR2(5)   
//	US_ADDRESS  NOT NULL VARCHAR2(300) 
//	US_NAME     NOT NULL VARCHAR2(10)  
//	US_BIRTH    NOT NULL DATE          
	private String usId;
	private String usEmail;
	private String usPhone;
	private String usNickname;
	private String usPassword;
	private String usGender;
	private String usAddress;
	private String usName;
	private String usBirth;
	
	public UserVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserVo [usId=" + usId + ", usEmail=" + usEmail + ", usPhone=" + usPhone + ", usNickname=" + usNickname
				+ ", usPassword=" + usPassword + ", usGender=" + usGender + ", usAddress=" + usAddress + ", usName="
				+ usName + ", usBirth=" + usBirth + "]";
	}

	public String getUsId() {
		return usId;
	}
	public String getUsEmail() {
		return usEmail;
	}
	public String getUsPhone() {
		return usPhone;
	}
	public String getUsNickname() {
		return usNickname;
	}
	public String getUsPassword() {
		return usPassword;
	}
	public String getUsGender() {
		return usGender;
	}
	public String getUsAddress() {
		return usAddress;
	}
	public String getUsName() {
		return usName;
	}
	public String getUsBirth() {
		return usBirth;
	}
	public void setUsId(String usId) {
		this.usId = usId;
	}
	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}
	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}
	public void setUsNickname(String usNickname) {
		this.usNickname = usNickname;
	}
	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}
	public void setUsGender(String usGender) {
		this.usGender = usGender;
	}
	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public void setUsBirth(String usBirth) {
		this.usBirth = usBirth;
	}
	
}
