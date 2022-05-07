package kh.semi.reviewBook.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;
import kh.semi.reviewBook.book.model.vo.*;


public class BookDao {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ArrayList<BookVo> rankinglist(Connection conn) {
		ArrayList<BookVo> blist = null;
		String sql = "select * from book order by bk_rank "
				+ ", bk_weeksales"
				;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			blist = new ArrayList<BookVo>();
			while (rs.next()) {
				BookVo bvo = new BookVo();

				bvo.setBkRank(rs.getInt("bk_rank"));
				bvo.setBkWeeksales(rs.getInt("bk_weeksales"));
				bvo.setBkNo(rs.getInt("bk_no"));
				bvo.setBkTitle(rs.getString("bk_title"));
				bvo.setBkRating(rs.getInt("bk_rating"));
				bvo.setBkRv(rs.getInt("bk_rv"));
				blist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return blist;
	}
	

	public ArrayList<BookVo> booklist(Connection conn) {
		ArrayList<BookVo> blist = null;
		String sql = "select * from book order by BK_PUBLISHDATE desc"
//				+ ", bk_weeksales"
				;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			blist = new ArrayList<BookVo>();
			while (rs.next()) {
				BookVo bvo = new BookVo();

				bvo.setBkNo(rs.getInt("BK_NO"));
				bvo.setBkImg(rs.getString("BK_IMG"));
				bvo.setBkTitle(rs.getString("bk_title"));
				bvo.setBkRating(rs.getInt("bk_rating"));
				bvo.setBkRv(rs.getInt("bk_rv"));
				blist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return blist;
	}
	
	
	// 랭킹 메소드
	
	
	public ArrayList<BookVo> listSeries(Connection conn) {
		
		ArrayList<BookVo> blist = null;
		String sql = "SELECT * FROM BK_RANKING";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			blist = new ArrayList<BookVo>();
			while (rs.next()) {
				BookVo bvo = new BookVo(); 

				bvo.setBkNo(rs.getInt("bK_No"));
				bvo.setBkImg(rs.getString("bK_Img"));
				bvo.setBkRank(rs.getInt("bK_Rank"));
				bvo.setBkTitle(rs.getString("bK_Title"));
				bvo.setBkRating(rs.getInt("bK_Rating"));
				bvo.setBkRv(rs.getInt("bK_Rv"));


				blist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return blist;
	}
	
	
	
	
}