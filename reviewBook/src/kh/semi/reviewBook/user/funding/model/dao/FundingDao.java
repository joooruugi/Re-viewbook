package kh.semi.reviewBook.user.funding.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;

public class FundingDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<FundingVo> fundingBoardlist(Connection conn) {
		ArrayList<FundingVo> volist = null;
//		WB_NO         NOT NULL NUMBER       
//		US_ID         NOT NULL VARCHAR2(30) 
//		FD_ACCUMULATE          NUMBER       
//		FD_DONATION            NUMBER       
//		FD_DEADLINE   NOT NULL DATE         
//		FD_LIMIT      NOT NULL NUMBER       
//		FD_OX         NOT NULL NUMBER       
//		AD_ID         NOT NULL VARCHAR2(30) 
		String sql = "select * from funding_manage order by fd_ox, fd_deadline ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			volist = new ArrayList<FundingVo>();
			while(rs.next()) {
				FundingVo vo = new FundingVo();
				vo.setWbNO(rs.getInt("wb_no"));
				vo.setUsId(rs.getString("us_id"));
				vo.setFdAccumulate(rs.getInt("fd_accumulate"));
				vo.setFdDonation(rs.getInt("fd_donation"));
				vo.setFdDeadline(rs.getString("fd_deadline"));
				vo.setFdLimit(rs.getInt("fd_limit"));
				vo.setFdOX(rs.getInt("fd_ox"));
				vo.setAdId(rs.getString("ad_id"));
				
				volist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return volist;
		
	}
}
