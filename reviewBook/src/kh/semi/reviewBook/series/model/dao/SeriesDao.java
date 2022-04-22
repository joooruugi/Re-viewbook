package kh.semi.reviewBook.series.model.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


public class SeriesDao {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 1.전체 게시글 게시글 수 가져오는 메소드
	public int countBoardList(Connection conn) {
		int result = 0;
		String sql = "select count(*) from writer_bbs";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 단일행 함수 - while문 x
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 2.전체 게시글 목록 나타내는 메소드
	public ArrayList<SeriesVo> listSeries(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();

				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
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

	// 3.검색한 단어와 일치하는 단어 검색해주는 메소드
	public ArrayList<SeriesVo> searchlistBoard(Connection conn, String searchText) {
		ArrayList<SeriesVo> slist = null;

		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_TITLE LIKE '%" + searchText + "%'" + "OR WB_WRITER like '%" + searchText
				+ "%' ORDER BY WB_NO DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
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

	// 4-1.카테고리별 게시글 목록 나타내는 메소드(문학)
	public ArrayList<SeriesVo> listSeriesFiction(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "문학" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
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

	// 4-2.카테고리별 게시글 목록 나타내는 메소드(정보공유)
	public ArrayList<SeriesVo> listSeriesInfo(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "정보공유" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
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

	// 4-3.카테고리별 게시글 목록 나타내는 메소드(일상)
	public ArrayList<SeriesVo> listSeriesDaily(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "일상" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
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

	// 4-4.카테고리별 게시글 목록 나타내는 메소드(기타)
	public ArrayList<SeriesVo> listSeriesEtc(Connection conn) {
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB WHERE WB_CATEGORY =" + "'" + "기타" + "'" + "ORDER BY WB_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			slist = new ArrayList<SeriesVo>();
			while (rs.next()) {
				SeriesVo svo = new SeriesVo();
				svo.setWbNo(rs.getInt("wb_No"));
				svo.setWbTitle(rs.getString("wb_Title"));
				svo.setWbContent(rs.getString("wb_Content"));
				svo.setWbCount(rs.getInt("wb_Count"));
				svo.setWbDate(rs.getString("wb_Date"));
				svo.setWbWriter(rs.getString("wb_Writer"));
				svo.setWbCategory(rs.getString("wb_Category"));
				svo.setUsId(rs.getString("us_Id"));
				svo.setReCommentCnt(rs.getInt("reCommentCnt"));
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
	

	//5. 게시글 읽기
	public SeriesVo readSeries (Connection conn, int wbNo) {
		SeriesVo svo = null;
	String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WB_NO=?) reCommentCnt\r\n"
			+ "FROM WRITER_BBS WB WHERE WB_NO = ?";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, wbNo);
		pstmt.setInt(2, wbNo);
		rs = pstmt.executeQuery();
		svo = new SeriesVo();
		
		if(rs.next()) {
			svo.setWbNo(rs.getInt("wb_No"));
			svo.setWbTitle(rs.getString("wb_Title"));
			svo.setWbContent(rs.getString("wb_Content"));
			svo.setWbCount(rs.getInt("wb_Count"));
			svo.setWbDate(rs.getString("wb_Date"));
			svo.setWbWriter(rs.getString("wb_Writer"));
			svo.setWbCategory(rs.getString("wb_Category"));
			svo.setUsId(rs.getString("us_Id"));
			svo.setReCommentCnt(rs.getInt("reCommentCnt"));
		
		}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}		
		return svo;
	}
	
	//6. 게시글에 달린 댓글 읽기
//	--WBC_NO      NOT NULL NUMBER         
//	--WBC_DATE    NOT NULL TIMESTAMP(6)   
//	--WBC_CONTENT          VARCHAR2(1024) 
//	--WBC_RATING           NUMBER         
//	--WB_NO       NOT NULL NUMBER         
//	--US_ID       NOT NULL VARCHAR2(30)   
//	--WBC_WRITER  NOT NULL VARCHAR2(45) 
	public ArrayList<SeriesReCommentVo> readSeriesComments(Connection conn, int wbNo) {
		ArrayList<SeriesReCommentVo> srlist = null;

		String sql = "SELECT * FROM WRITER_BBS_COMMENT WHERE WB_NO = ? ORDER BY WBC_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wbNo);
			rs = pstmt.executeQuery();

			srlist = new ArrayList<SeriesReCommentVo>();
			while (rs.next()) {
				SeriesReCommentVo srvo = new SeriesReCommentVo(rs.getInt("WBC_NO"), rs.getString("WBC_DATE"),
						rs.getString("WBC_CONTENT"), rs.getInt("WBC_RATING"), rs.getInt("WB_NO"), rs.getString("US_ID"),
						rs.getString("WBC_WRITER"));
				// (int rNo, int bNo, String rWriter, Timestamp rWriteDate, String rContent,
				// String mId)
				srlist.add(srvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return srlist;
	}
	
	
	//7. 댓글 작성
	public int insertSeriesComment(Connection conn, SeriesReCommentVo srvo) {
		String usId = "us111"; //member 로그인 구현 후 srvo.getUsId()수정 예정 
		String wbcWriter = "사자"; //member 로그인 구현 후 srvo.setWbcWriter()수정 예정 
		int result = 0;
		String sql = "INSERT INTO WRITER_BBS_COMMENT VALUES((SELECT NVL(MAX(WBC_NO),0)+1 FROM WRITER_BBS_COMMENT),"
				+ "SYSDATE, ? , ? ,?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			//제일 중요한 글번호 맨 앞으로 가져옴
			pstmt.setInt(3,srvo.getWbNo());
			//나머지 채워줌
			pstmt.setString(1, srvo.getWbcContent());
			pstmt.setInt(2, srvo.getWbcRating());
			pstmt.setString(4, usId); 
			pstmt.setString(5, wbcWriter);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
