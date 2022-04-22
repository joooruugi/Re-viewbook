package kh.semi.reviewBook.series.model.vo;

public class SeriesReCommentVo {

	
//	--WBC_NO      NOT NULL NUMBER         
//	--WBC_DATE    NOT NULL TIMESTAMP(6)   
//	--WBC_CONTENT          VARCHAR2(1024) 
//	--WBC_RATING           NUMBER         
//	--WB_NO       NOT NULL NUMBER         
//	--US_ID       NOT NULL VARCHAR2(30)   
//	--WBC_WRITER  NOT NULL VARCHAR2(45)  
	
	

	private int wbcNo;
	private String wbcDate;
	private String wbcContent;
	private int wbcRating;
	private int wbNo;
	private String usId;
	private String wbcWriter;
	
	public SeriesReCommentVo() {
		super();
	
	}

	public SeriesReCommentVo(int wbcNo, String wbcDate, String wbcContent, int wbcRating, int wbNo, String usId,
			String wbcWriter) {
		super();
		this.wbcNo = wbcNo;
		this.wbcDate = wbcDate;
		this.wbcContent = wbcContent;
		this.wbcRating = wbcRating;
		this.wbNo = wbNo;
		this.usId = usId;
		this.wbcWriter = wbcWriter;
	}

	@Override
	public String toString() {
		return "SeriesReCommentVo [wbcNo=" + wbcNo + ", wbcDate=" + wbcDate + ", wbcContent=" + wbcContent
				+ ", wbcRating=" + wbcRating + ", wbNo=" + wbNo + ", usId=" + usId + ", wbcWriter=" + wbcWriter + "]";
	}

	public int getWbcNo() {
		return wbcNo;
	}

	public void setWbcNo(int wbcNo) {
		this.wbcNo = wbcNo;
	}

	public String getWbcDate() {
		return wbcDate;
	}

	public void setWbcDate(String wbcDate) {
		this.wbcDate = wbcDate;
	}

	public String getWbcContent() {
		return wbcContent;
	}

	public void setWbcContent(String wbcContent) {
		this.wbcContent = wbcContent;
	}

	public int getWbcRating() {
		return wbcRating;
	}

	public void setWbcRating(int wbcRating) {
		this.wbcRating = wbcRating;
	}

	public int getWbNo() {
		return wbNo;
	}

	public void setWbNo(int wbNo) {
		this.wbNo = wbNo;
	}

	public String getUsId() {
		return usId;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public String getWbcWriter() {
		return wbcWriter;
	}

	public void setWbcWriter(String wbcWriter) {
		this.wbcWriter = wbcWriter;
	}

	


	
}
