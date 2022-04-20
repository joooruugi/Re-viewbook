package kh.semi.reviewBook.series.model.vo;

public class SeriesVo {
	
//	WB_NO       NOT NULL NUMBER         
//	WB_TITLE    NOT NULL VARCHAR2(60)   
//	WB_CONTENT  NOT NULL VARCHAR2(4000) 
//	WB_COUNT    NOT NULL NUMBER         
//	WB_DATE     NOT NULL TIMESTAMP(6)   
//	WB_WRITER   NOT NULL VARCHAR2(45)   
//	WB_CATEGORY NOT NULL VARCHAR2(20)   
//	US_ID       NOT NULL VARCHAR2(30)  
	
	private int wbNo;
	private String wbTitle;
	private String wbContent;
	private int wbCount;
	private String wbDate;
	private String wbWriter;
	private String wbCategory;
	private String usId;
	private int reCommentCnt;
	
	public SeriesVo() {
		super();
	}

	public SeriesVo(int wbNo, String wbTitle, String wbContent, int wbCount, String wbDate, String wbWriter,
			String wbCategory, String usId, int reCommentCnt) {
		super();
		this.wbNo = wbNo;
		this.wbTitle = wbTitle;
		this.wbContent = wbContent;
		this.wbCount = wbCount;
		this.wbDate = wbDate;
		this.wbWriter = wbWriter;
		this.wbCategory = wbCategory;
		this.usId = usId;
		this.reCommentCnt = reCommentCnt;
	}

	@Override
	public String toString() {
		return "SeriesVo [wbNo=" + wbNo + ", wbTitle=" + wbTitle + ", wbContent=" + wbContent + ", wbCount=" + wbCount
				+ ", wbDate=" + wbDate + ", wbWriter=" + wbWriter + ", wbCategory=" + wbCategory + ", usId=" + usId
				+ ", reCommentCnt=" + reCommentCnt + "]";
	}

	public int getWbNo() {
		return wbNo;
	}

	public void setWbNo(int wbNo) {
		this.wbNo = wbNo;
	}

	public String getWbTitle() {
		return wbTitle;
	}

	public void setWbTitle(String wbTitle) {
		this.wbTitle = wbTitle;
	}

	public String getWbContent() {
		return wbContent;
	}

	public void setWbContent(String wbContent) {
		this.wbContent = wbContent;
	}

	public int getWbCount() {
		return wbCount;
	}

	public void setWbCount(int wbCount) {
		this.wbCount = wbCount;
	}

	public String getWbDate() {
		return wbDate;
	}

	public void setWbDate(String wbDate) {
		this.wbDate = wbDate;
	}

	public String getWbWriter() {
		return wbWriter;
	}

	public void setWbWriter(String wbWriter) {
		this.wbWriter = wbWriter;
	}

	public String getWbCategory() {
		return wbCategory;
	}

	public void setWbCategory(String wbCategory) {
		this.wbCategory = wbCategory;
	}

	public String getUsId() {
		return usId;
	}

	public void setUsId(String usId) {
		this.usId = usId;
	}

	public int getReCommentCnt() {
		return reCommentCnt;
	}

	public void setReCommentCnt(int reCommentCnt) {
		this.reCommentCnt = reCommentCnt;
	}

	

	
	

}
