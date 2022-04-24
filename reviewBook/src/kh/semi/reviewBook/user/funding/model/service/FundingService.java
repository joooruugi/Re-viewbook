package kh.semi.reviewBook.user.funding.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.user.funding.model.dao.FundingDao;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;

public class FundingService {
	
	private FundingDao dao = new FundingDao();
	
	// 전체 펀딩진행중 목록 나타내기
	public ArrayList<FundingVo> fundingBoardlist() {
		Connection conn = getConnection();
		ArrayList<FundingVo> fvolist = dao.fundingBoardlist(conn);
		close(conn);
		return fvolist;
	}
	
	// 철회하기 기능
	public ArrayList<FundingVo> fundingWithdraw(int wbNo) {
		Connection conn = getConnection();
		ArrayList<FundingVo> fvolist = dao.fundingWithdraw(conn, wbNo);
		close(conn);
		return fvolist;
	}
	

}
