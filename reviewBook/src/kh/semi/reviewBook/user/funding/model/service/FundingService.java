package kh.semi.reviewBook.user.funding.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.user.funding.model.dao.FundingDao;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;

public class FundingService {
	
	private FundingDao dao = new FundingDao();
	
	public ArrayList<FundingVo> fundingBoardlist() {
		Connection conn = getConnection();
		ArrayList<FundingVo> volist = dao.fundingBoardlist(conn);
		close(conn);
		return volist;
	}


}
