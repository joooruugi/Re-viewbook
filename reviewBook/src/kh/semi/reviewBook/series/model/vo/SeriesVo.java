package kh.semi.reviewBook.series.model.vo;

import java.util.ArrayList;

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
	private int fdAccumulate;
	private String fdDeadline;
	private int fdLimit;
	private int fdOX;
	private String adId;
	private int isDonation;
	private double avgDonation;
	
	//게시글 1개 댓글 여러개
	private ArrayList<SeriesReCommentVo> srvolist;
	
	public SeriesVo() {
		super();
	}

	
	public SeriesVo(int wbNo, String wbTitle, String wbContent, int wbCount, String wbDate, String wbWriter,
			String wbCategory, String usId, int reCommentCnt, int fdAccumulate, String fdDeadline, int fdLimit,
			int fdOX, String adId, ArrayList<SeriesReCommentVo> srvolist) {
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
		this.fdAccumulate = fdAccumulate;
		this.fdDeadline = fdDeadline;
		this.fdLimit = fdLimit;
		this.fdOX = fdOX;
		this.adId = adId;
		this.srvolist = srvolist;
	}




	@Override
	public String toString() {
		return "SeriesVo [wbNo=" + wbNo + ", wbTitle=" + wbTitle + ", wbContent=" + wbContent + ", wbCount=" + wbCount
				+ ", wbDate=" + wbDate + ", wbWriter=" + wbWriter + ", wbCategory=" + wbCategory + ", usId=" + usId
				+ ", reCommentCnt=" + reCommentCnt + ", fdAccumulate=" + fdAccumulate + ", fdDeadline=" + fdDeadline
				+ ", fdLimit=" + fdLimit + ", fdOX=" + fdOX + ", adId=" + adId + ", isDonation=" + isDonation
				+ ", avgDonation=" + avgDonation + ", srvolist=" + srvolist + "]";
	}


	public int getWbNo() {
		return wbNo;
	}


	public String getWbTitle() {
		return wbTitle;
	}


	public String getWbContent() {
		return wbContent;
	}


	public int getWbCount() {
		return wbCount;
	}


	public String getWbDate() {
		return wbDate;
	}


	public String getWbWriter() {
		return wbWriter;
	}


	public String getWbCategory() {
		return wbCategory;
	}


	public String getUsId() {
		return usId;
	}


	public int getReCommentCnt() {
		return reCommentCnt;
	}


	public int getFdAccumulate() {
		return fdAccumulate;
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


	public ArrayList<SeriesReCommentVo> getSrvolist() {
		return srvolist;
	}


	public void setWbNo(int wbNo) {
		this.wbNo = wbNo;
	}


	public void setWbTitle(String wbTitle) {
		this.wbTitle = wbTitle;
	}


	public void setWbContent(String wbContent) {
		this.wbContent = wbContent;
	}


	public void setWbCount(int wbCount) {
		this.wbCount = wbCount;
	}


	public void setWbDate(String wbDate) {
		this.wbDate = wbDate;
	}


	public void setWbWriter(String wbWriter) {
		this.wbWriter = wbWriter;
	}


	public void setWbCategory(String wbCategory) {
		this.wbCategory = wbCategory;
	}


	public void setUsId(String usId) {
		this.usId = usId;
	}


	public void setReCommentCnt(int reCommentCnt) {
		this.reCommentCnt = reCommentCnt;
	}


	public void setFdAccumulate(int fdAccumulate) {
		this.fdAccumulate = fdAccumulate;
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


	public void setSrvolist(ArrayList<SeriesReCommentVo> srvolist) {
		this.srvolist = srvolist;
	}


	public int getIsDonation() {
		return isDonation;
	}


	public double getAvgDonation() {
		return avgDonation;
	}


	public void setIsDonation(int isDonation) {
		this.isDonation = isDonation;
	}


	public void setAvgDonation(double avgDonation) {
		this.avgDonation = avgDonation;
	}




	}

	

	
	

