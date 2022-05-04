package kh.semi.reviewBook.mypage.model.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.mypage.model.vo.MyInformationVo;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;
import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;

public class MyPageDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public SubscribeVo selectSubscribe(Connection conn, String usId) {
		System.out.println("dao usId: "+usId);
		SubscribeVo result = null;
		String sql = "select * from subscribe where us_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new SubscribeVo();
//				US_ID      NOT NULL VARCHAR2(30)  
//				SUB_INF             VARCHAR2(50)  
//				SUB_YN     NOT NULL VARCHAR2(10)  
//				SUB_START           TIMESTAMP(6)  
//				SUB_END             TIMESTAMP(6)  
//				SUB_REVIEW          VARCHAR2(500) 
//				SUB_LIST            VARCHAR2(30)  
//				AD_ID      NOT NULL VARCHAR2(30) 
				result.setAdId(rs.getString("ad_Id"));
				result.setSubEnd(rs.getDate("sub_End"));
				result.setSubInf(rs.getString("sub_Inf"));
				result.setSubList(rs.getString("Sub_List"));
				result.setSubReview(rs.getString("SUB_REVIEW"));
				result.setSubStart(rs.getDate("sub_Start"));
				result.setSubYN(rs.getString("sub_yn"));
				result.setUsId(rs.getString("ad_id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("dao result: "+result);
		
		return result;
	}
	
	public ArrayList<BuyListVo> selectBuyList(Connection conn, String usId) {
		System.out.println("dao usId: "+usId);
		ArrayList<BuyListVo> volist = null;
		String sql = "select * from order_book ob join (select * from \"ORDER\" where us_id=?) o using (or_num) join book using (bk_no) left outer join review using (bk_no) order by or_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			volist = new ArrayList<BuyListVo>();
			while(rs.next()) {
				BuyListVo vo = new BuyListVo();
//				BK_TITLE       NOT NULL VARCHAR2(150) 
//				BK_NO          NOT NULL NUMBER    히든    
//				OR_NUM   NOT NULL NUMBER       
//				OR_PRICE NOT NULL NUMBER       
//				OR_DATE  NOT NULL TIMESTAMP(6) 
//				US_ID    NOT NULL VARCHAR2(30)    히든
//				RV_NUM     NOT NULL NUMBER 
				
				vo.setBkNo(rs.getInt("bk_No"));
				vo.setBkTitle(rs.getString("bk_Title"));
				vo.setOrDate(rs.getDate("or_Date"));
				vo.setOrNum(rs.getInt("or_Num"));
				vo.setOrPrice(rs.getInt("or_Price"));
				vo.setUsId(rs.getString("us_Id"));
				vo.setRvNum(rs.getInt("rv_Num"));
				volist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao volist: "+volist);
		return volist;
	}
	
	public MyInformationVo selectMyInformation(Connection conn, String usId) {
		System.out.println("dao usId: "+usId);
		MyInformationVo result = null;
		String sql = "select us_id, us_name, us_nickname, us_email, us_phone, us_address from \"USER\" where us_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MyInformationVo();
//				US_ID       NOT NULL VARCHAR2(30)  
//				US_EMAIL    NOT NULL VARCHAR2(150) 
//				US_PHONE    NOT NULL VARCHAR2(30)  
//				US_NICKNAME NOT NULL VARCHAR2(45)
//				US_ADDRESS  NOT NULL VARCHAR2(300) 
//				US_NAME     NOT NULL VARCHAR2(10)
				
				result.setUsAddress(rs.getString("us_Address"));
				result.setUsEmail(rs.getString("us_Email"));
				result.setUsId(rs.getString("us_Id"));
				result.setUsName(rs.getString("us_Name"));
				result.setUsNickname(rs.getString("us_Nickname"));
				result.setUsPhone(rs.getString("us_Phone"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao result: "+result);
		return result;
	}
	public int updateMyInformation(Connection conn, MyInformationVo iVo) {
		System.out.println("dao iVo: "+iVo);
		int result = 0;
		String sql = "UPDATE \"USER\" SET US_Email=?, US_PHONE=?, US_ADDRESS=? WHERE US_ID= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, iVo.getUsId());
//			pstmt.setString(1, iVo.getUsNickname());
			pstmt.setString(1, iVo.getUsEmail());
			pstmt.setString(2, iVo.getUsPhone());
			pstmt.setString(3, iVo.getUsAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("dao result: "+result);
		return result;
	}
	public int insertReview(Connection conn, ReviewVo rVo) {
		System.out.println("dao rVo: "+rVo);
		int result = 0;
		String sql = "INSERT INTO REVIEW(RV_NUM, RV_DATE, RV_TITLE, RV_RATING, RV_CONTENT, BK_NO, US_ID) VALUES(SEQ_RV_NUM.nextval,default,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rVo.getRvTitle());
			pstmt.setInt(2, rVo.getRvRating());
			pstmt.setString(3, rVo.getRvContent());
			pstmt.setInt(4, rVo.getBkNo());
			pstmt.setString(5, rVo.getUsId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("dao result: "+result);
		return result;
	}
	public ArrayList<CartVo> selectCartList(Connection conn, String usId) {
		System.out.println("dao usid: "+usId);
		ArrayList<CartVo> volist = null;
		String sql = "select * from cart join book using (bk_no) where us_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			volist = new ArrayList<CartVo>();
			while(rs.next()) {
				CartVo vo = new CartVo();
//				US_ID    NOT NULL VARCHAR2(30) 
//				BK_NO    NOT NULL NUMBER       
//				CA_COUNT          NUMBER  
//				BK_TITLE       NOT NULL VARCHAR2(150) 
//				BK_IMG                  VARCHAR2(255) 
//				BK_PRICE       NOT NULL NUMBER        
//				BK_WRITER               VARCHAR2(30)  
//				BK_PUBLISHDATE          DATE     
				vo.setBkNo(rs.getInt("bk_No"));
				vo.setCaCount(rs.getInt("ca_Count"));
				vo.setUsId(rs.getString("us_Id"));
				vo.setBkImg(rs.getString("bk_Img"));
				vo.setBkPrice(rs.getInt("bk_price"));
				vo.setBkPublishdate(rs.getDate("bk_publishdate"));
				vo.setBkTitle(rs.getString("bk_Title"));
				vo.setBkWriter(rs.getString("bk_Writer"));
				volist.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("dao volist: "+volist);
		return volist;
	}

}
