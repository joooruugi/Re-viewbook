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
		ArrayList<BookVo> rlist = null;
		String sql = "select * from book order by bk_rank "
				+ ", bk_weeksales"
				;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rlist = new ArrayList<BookVo>();
			while (rs.next()) {
				BookVo bvo = new BookVo();

				bvo.setBkRank(rs.getInt("bk_rank"));
				bvo.setBkWeeksales(rs.getInt("bk_weeksales"));
				bvo.setBkNo(rs.getInt("bk_no"));
				bvo.setBkTitle(rs.getString("bk_title"));
				bvo.setBkRating(rs.getInt("bk_rating"));
				bvo.setBkRv(rs.getInt("bk_rv"));
				rlist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return rlist;
	}
	

	public ArrayList<BookVo> booklist(Connection conn) {
		ArrayList<BookVo> rlist = null;
		String sql = "select * from book order by BK_PUBLISHDATE desc"
//				+ ", bk_weeksales"
				;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rlist = new ArrayList<BookVo>();
			while (rs.next()) {
				BookVo bvo = new BookVo();

				bvo.setBkNo(rs.getInt("BK_NO"));
				bvo.setBkImg(rs.getString("BK_IMG"));
				bvo.setBkTitle(rs.getString("bk_title"));
				bvo.setBkRating(rs.getInt("bk_rating"));
				bvo.setBkRv(rs.getInt("bk_rv"));
				rlist.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return rlist;
	}
	
}