package kh.semi.reviewBook.user.funding.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;

import kh.semi.reviewBook.series.model.vo.SeriesVo;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;

public class FundingDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 전체 펀딩진행중 목록 나타내기
	public ArrayList<SeriesVo> fundingBoardlist(Connection conn, String loginId) {
		ArrayList<SeriesVo> slist = null;
//		WB_NO         NOT NULL NUMBER       
//		US_ID         NOT NULL VARCHAR2(30) 
//		FD_ACCUMULATE          NUMBER       
//		FD_DONATION            NUMBER       
//		FD_DEADLINE   NOT NULL DATE         
//		FD_LIMIT      NOT NULL NUMBER       
//		FD_OX         NOT NULL NUMBER       
//		AD_ID         NOT NULL VARCHAR2(30) 
//		String sql = "select wb_no, wb_title, fd_accumulate, fd_deadline, fd_ox from funding_manage join writer_bbs using(wb_no) order by fd_ox, fd_deadline";
		String sql = "select tb_wbbs.*, round(nvl(total_donation, 0)/fd_accumulate, 4)*100   avg_donation"
				+ "    , (select count(*)  from funding_manage tb_f2 where tb_f2.wb_no = tb_wbbs.wb_no and us_id=?) is_donation"
				+ "    from writer_bbs tb_wbbs left outer join (select wb_no, sum(fd_donation) total_donation from funding_manage group by wb_no)  tb_f1 on tb_wbbs.wb_no = tb_f1.wb_no"
				+ "    where fd_ox=1 order by is_donation desc, tb_wbbs.fd_limit, tb_wbbs.wb_no";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			
			slist = new ArrayList<SeriesVo>();
			while(rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_no"));
				svo.setWbTitle(rs.getString("wb_title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setFdAccumulate(rs.getInt("fd_accumulate"));
				svo.setFdDeadline(rs.getString("fd_deadline"));
				svo.setFdLimit(rs.getInt("fd_limit"));
				svo.setFdOX(rs.getInt("fd_ox"));
				svo.setAdId(rs.getString("ad_id"));
				svo.setIsDonation(rs.getInt("is_donation"));
				svo.setAvgDonation(rs.getDouble("avg_donation"));
				
				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return slist;
		
	}
	// 철회하기 기능 (완성되면 SET FD_OX = 1 로 바꾸는 펀딩하기 기능 추가)
	public int fundingWithdraw(Connection conn, FundingVo vo) {
		int result = 0;
		String sql = "delete from funding_manage (where wb_no=? and us_id=?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getWbNO());
			pstmt.setString(2, vo.getUsId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	// 펀딩하기 기능 (완성되면 SET FD_OX = 1 로 바꾸는 펀딩하기 기능 추가)
	public int fundingDonation(Connection conn, FundingVo vo) {
		System.out.println("fundingDonation:"+vo);
		int result = 0;
		String sql = "insert into  FUNDING_MANAGE values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getWbNO());
			pstmt.setString(2, vo.getUsId());
			pstmt.setInt(3, vo.getFdDonation());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
