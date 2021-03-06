package kh.semi.reviewBook.user.funding.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.series.model.vo.SeriesVo;
import kh.semi.reviewBook.user.funding.model.dao.FundingDao;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;

public class FundingService {
	
	private FundingDao dao = new FundingDao();
	
	// 전체 펀딩진행중 목록 나타내기
	public ArrayList<SeriesVo> fundingBoardlist(String loginId) {
		Connection conn = getConnection();
		ArrayList<SeriesVo> svolist = dao.fundingBoardlist(conn, loginId);
		close(conn);
		return svolist;
	}
	// 게시글에 사용자가 후원한 금액 가져오기
	public FundingVo fundingBoardlistDonation(int wbNo, String loginId) {
		Connection conn = getConnection();
		FundingVo fvo = dao.fundingBoardlistDonation(conn, wbNo, loginId);
		close(conn);
		return fvo;
	}
	
	// 철회하기 기능
	public int fundingWithdraw(FundingVo vo) {
		Connection conn = getConnection();
		int result = dao.fundingWithdraw(conn, vo);
		close(conn);
		return result;
	}
	
	// 펀딩하기 기능
	public int fundingDonation(FundingVo vo) {
		Connection conn = getConnection();
		int result = dao.fundingDonation(conn, vo);
		close(conn);
		return result;
	}
	
}
