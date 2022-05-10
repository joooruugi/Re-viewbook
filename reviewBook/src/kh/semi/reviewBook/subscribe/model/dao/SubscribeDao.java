package kh.semi.reviewBook.subscribe.model.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

public class SubscribeDao {

	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
//	US_ID      NOT NULL VARCHAR2(30)  
//	SUB_INF             VARCHAR2(50)  
//	SUB_YN     NOT NULL VARCHAR2(10)  
//	SUB_START           TIMESTAMP(6)  
//	SUB_END             TIMESTAMP(6)  
//	SUB_REVIEW          VARCHAR2(500) 
//	SUB_LIST            VARCHAR2(30)  
//	AD_ID      NOT NULL VARCHAR2(30) 
//	SUB_PRICE           NUMBER 
	
	//1. 구독권 전체 나타내는 메소드 
	public ArrayList<SubscribeVo> listSubscribe(Connection conn) {
		ArrayList<SubscribeVo> sslist = null;
		String sql = "SELECT * FROM SUBSCRIBE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sslist = new ArrayList<SubscribeVo>();
			while (rs.next()) {
			SubscribeVo ssvo = new SubscribeVo(); 
			
			ssvo.setUsId(rs.getString("us_Id"));
			ssvo.setSubInf(rs.getString("sub_Inf"));
			ssvo.setSubYN(rs.getString("sub_YN"));
			ssvo.setSubStart(rs.getDate("sub_Start"));
			ssvo.setSubEnd(rs.getDate("sub_End"));
			ssvo.setSubReview(rs.getString("sub_Review"));
			ssvo.setSubList(rs.getString("sub_List"));
			ssvo.setAdId(rs.getString("ad_Id"));
			ssvo.setSubPrice(rs.getInt("sub_Price"));
			sslist.add(ssvo);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}

		System.out.println("dao result: "+sslist);
		
		return sslist;
	}
	
	//2. 구독 리뷰 작성 전 기존 구독 정보 가져오기 (구독권 결제시에도 사용)
	//후기 작성 시 구독권 종류 나타내기, 구독 y인 사람만 리뷰 작성 가능하도록 하기 위해서
	public SubscribeVo readSubscribe(Connection conn, String usId) {
		SubscribeVo ssvo = null;
		String sql ="select us_id, sub_inf, sub_yn, sub_review, sub_price from subscribe where us_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			ssvo = new SubscribeVo();
			ssvo.setUsId(rs.getString("us_Id"));
			ssvo.setSubInf(rs.getString("sub_Inf"));
			ssvo.setSubYN(rs.getString("sub_YN"));
			ssvo.setSubReview(rs.getString("sub_Review"));
			ssvo.setSubPrice(rs.getInt("sub_Price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return ssvo;
	}
	
	//3. 구독 리뷰 작성 
	//기존 구독하지 않던 회원은 insert로 테이블에 추가해줌 insert시 리뷰는 null로 채워주기때문에 update문으로 작성
	
	public int updateSubReview(Connection conn, SubscribeVo ssvo) {
		int result = 0;
		String sql = "update subscribe set sub_review = ? where us_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			//제일 중요한 US_ID 맨 앞으로 가져옴
			pstmt.setString(2, ssvo.getUsId());
			//나머지 채워줌
			pstmt.setString(1, ssvo.getSubReview());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//4. 정기 구독 신청
	public int insertSubscribeLong(Connection conn, SubscribeVo ssvo) {
		int result = 0;
		String usId = ssvo.getUsId();
		String sql = "INSERT INTO SUBSCRIBE (US_ID,SUB_INF,SUB_YN,SUB_START,AD_ID,SUB_PRICE)"
				+ "VALUES(?,?,DEFAULT,SYSTIMESTAMP,DEFAULT,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			pstmt.setString(2,ssvo.getSubInf());
			pstmt.setInt(3, ssvo.getSubPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}	
	
	//5. 월별 구독 신청
	public int insertSubscribeShort(Connection conn,  SubscribeVo ssvo) {
		int result = 0;
		String usId = ssvo.getUsId();
		String sql = "INSERT INTO SUBSCRIBE (US_ID,SUB_INF,SUB_YN,SUB_START,AD_ID,SUB_PRICE)"
				+ "VALUES(?,?,DEFAULT,SYSTIMESTAMP,DEFAULT,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			pstmt.setString(2,ssvo.getSubInf());
			pstmt.setInt(3, ssvo.getSubPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	//6. 현재 이용중인 구독 철회 (delete 말고 update로 구독정보 n로 변경 -> db기록용으로 14일 이후에 관리자가 삭제)
	public int updateSubscribeCancle(Connection conn, String usId) {
		int result = 0;
		String sql = "UPDATE SUBSCRIBE SET SUB_YN = 'n' , SUB_END = SYSTIMESTAMP WHERE US_ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//7-1. 관리자 - 구독 y 회원 조회 
	public ArrayList<SubscribeVo> checkSubscribe(Connection conn) {
		ArrayList<SubscribeVo> sslist = null;
		String sql = "SELECT * FROM SUBSCRIBE WHERE SUB_YN = 'y' ORDER BY SUB_INF DESC , SUB_START DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sslist = new ArrayList<SubscribeVo>();
			while (rs.next()) {
			SubscribeVo ssvo = new SubscribeVo(); 
			
			ssvo.setUsId(rs.getString("us_Id"));
			ssvo.setSubInf(rs.getString("sub_Inf"));
			ssvo.setSubYN(rs.getString("sub_YN"));
			ssvo.setSubStart(rs.getDate("sub_Start"));
			ssvo.setSubEnd(rs.getDate("sub_End"));
			ssvo.setSubReview(rs.getString("sub_Review"));
			ssvo.setSubList(rs.getString("sub_List"));
			ssvo.setAdId(rs.getString("ad_Id"));
			ssvo.setSubPrice(rs.getInt("sub_Price"));
			sslist.add(ssvo);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}

		System.out.println("dao result: "+sslist);
		
		return sslist;
	}
	
	//7-2. 관리자 - 구독 n 회원 조회 
	public ArrayList<SubscribeVo> checkSubscribeDel(Connection conn) {
		ArrayList<SubscribeVo> sslist = null;
		String sql = "SELECT * FROM SUBSCRIBE WHERE SUB_YN = 'n' ORDER BY SUB_INF DESC ,SUB_START DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sslist = new ArrayList<SubscribeVo>();
			while (rs.next()) {
			SubscribeVo ssvo = new SubscribeVo(); 
			
			ssvo.setUsId(rs.getString("us_Id"));
			ssvo.setSubInf(rs.getString("sub_Inf"));
			ssvo.setSubYN(rs.getString("sub_YN"));
			ssvo.setSubStart(rs.getDate("sub_Start"));
			ssvo.setSubEnd(rs.getDate("sub_End"));
			ssvo.setSubReview(rs.getString("sub_Review"));
			ssvo.setSubList(rs.getString("sub_List"));
			ssvo.setAdId(rs.getString("ad_Id"));
			ssvo.setSubPrice(rs.getInt("sub_Price"));
			sslist.add(ssvo);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}

		System.out.println("dao result: "+sslist);
		
		return sslist;
	}
	
	//8. 관리자 구독 n 회원 삭제
	public int deleteSubscribe(Connection conn, String usId) {
		int result = 0;
		String sql = "DELETE FROM SUBSCRIBE WHERE SUB_YN='n' and US_ID = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
