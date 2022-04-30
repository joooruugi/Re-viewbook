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
	
	// 전체 펀딩진행중 목록 나타내기
	public ArrayList<FundingVo> fundingBoardlist(Connection conn) {
		ArrayList<FundingVo> flist = null;
//		WB_NO         NOT NULL NUMBER       
//		US_ID         NOT NULL VARCHAR2(30) 
//		FD_ACCUMULATE          NUMBER       
//		FD_DONATION            NUMBER       
//		FD_DEADLINE   NOT NULL DATE         
//		FD_LIMIT      NOT NULL NUMBER       
//		FD_OX         NOT NULL NUMBER       
//		AD_ID         NOT NULL VARCHAR2(30) 
		String sql = "select * from funding_manage order by fd_ox, fd_deadline";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			flist = new ArrayList<FundingVo>();
			while(rs.next()) {
				FundingVo fvo = new FundingVo();
				fvo.setWbNO(rs.getInt("wb_no"));
				fvo.setUsId(rs.getString("us_id"));
				fvo.setFdAccumulate(rs.getInt("fd_accumulate"));
				fvo.setFdDonation(rs.getInt("fd_donation"));
				fvo.setFdDeadline(rs.getString("fd_deadline"));
				fvo.setFdLimit(rs.getInt("fd_limit"));
				fvo.setFdOX(rs.getInt("fd_ox"));
				fvo.setAdId(rs.getString("ad_id"));
				
				flist.add(fvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return flist;
		
	}
	// 철회하기 기능 (완성되면 SET FD_OX = 1 로 바꾸는 펀딩하기 기능 추가)
	public int fundingWithdraw(Connection conn, int wbNo) {
		int result = 0;
		String sql = "UPDATE FUNDING_MANAGE SET FD_OX = 0 WHERE wb_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wbNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 펀딩하기 기능 (완성되면 SET FD_OX = 1 로 바꾸는 펀딩하기 기능 추가)
	public int fundingDonation(Connection conn, int wbNo) {
		int result = 0;
		String sql = "UPDATE FUNDING_MANAGE SET FD_OX = 1 WHERE wb_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wbNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
