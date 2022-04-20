package kh.semi.reviewBook.series.model.dao;


import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import kh.semi.reviewBook.series.model.vo.SeriesVo;


public class SeriesDao {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//1.전체 게시글 게시글 수 가져오는 메소드
	public int countBoardList(Connection conn) {  
		int result = 0;
		String sql = "select count(*) from writer_bbs";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//단일행 함수 - while문 x 
			if(rs.next()) {
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
	
	
	//2.전체 게시글 목록 나타내는 메소드
	public ArrayList<SeriesVo> listSeries(Connection conn ){
		ArrayList<SeriesVo> slist = null;
		String sql = "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
				+ " FROM WRITER_BBS WB ORDER BY WB_NO DESC";  

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

				slist = new ArrayList<SeriesVo>();
				while(rs.next()) {
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
		}finally {
			close(rs);
			close(pstmt);
		}
		return slist;
	}
	
	
		//3.검색한 단어와 일치하는 단어 검색해주는 메소드
		public ArrayList<SeriesVo> searchlistBoard(Connection conn, String searchText) {
			 ArrayList<SeriesVo> slist= null;
			 
			 String sql =  "SELECT WB.*, (SELECT COUNT(*) FROM WRITER_BBS_COMMENT WBC WHERE WBC.WB_NO = WB.WB_NO) reCommentCnt \r\n"
						+ " FROM WRITER_BBS WB WHERE WB_TITLE LIKE '%"+searchText+"%'"+"OR WB_WRITER like '%"+searchText+"%' ORDER BY WB_NO DESC"; 
				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					slist = new ArrayList<SeriesVo>();
					while(rs.next()) {
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
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rs);
					close(pstmt);
				}
			 
			return slist;
	
		}
		
}

