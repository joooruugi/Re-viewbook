package kh.semi.reviewBook.series.model.service;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;


import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.reviewBook.series.model.dao.SeriesDao;
import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;
import kh.semi.reviewBook.series.model.vo.SeriesVo;




public class SeriesService {
	
	
	private SeriesDao dao = new SeriesDao();
	
	//1.전체 게시글 게시글 수 가져오는 메소드
	public int countBoardList() {
		Connection conn = getConnection();
		int result = dao.countBoardList(conn);
		close(conn);
		return result;
	}
	
	//2.전체 게시글 목록 나타내는 메소드
	public ArrayList<SeriesVo> listBoard() {
		Connection conn = getConnection();
		ArrayList<SeriesVo> slist = dao.listSeries(conn);
		close(conn);
		return slist;	
		
	}
	
	//3.검색한 단어와 일치하는 단어 검색해주는 메소드
	public ArrayList<SeriesVo> searchlistBoard(String searchText) {
		Connection conn = getConnection();
		ArrayList<SeriesVo> slist = dao.searchlistBoard(conn,searchText);
		close(conn);
		return slist;
	}

	
	//4-1.카테고리별 게시글 목록 나타내는 메소드(문학)
		public ArrayList<SeriesVo> listSeriesFiction () {
			Connection conn = getConnection();
			ArrayList<SeriesVo> slist = dao.listSeriesFiction(conn);
			close(conn);
			return slist;
	}
	//4-2.카테고리별 게시글 목록 나타내는 메소드(정보공유)
		public ArrayList<SeriesVo> listSeriesInfo () {
			Connection conn = getConnection();
			ArrayList<SeriesVo> slist = dao.listSeriesInfo(conn);
			close(conn);
			return slist;
		}
	//4-3.카테고리별 게시글 목록 나타내는 메소드(일상)
		public ArrayList<SeriesVo> listSeriesDaily () {
			Connection conn = getConnection();
			ArrayList<SeriesVo> slist = dao.listSeriesDaily(conn);
			close(conn);
			return slist;
		}
	//4-4.카테고리별 게시글 목록 나타내는 메소드(기타)
		public ArrayList<SeriesVo> listSeriesEtc () {
			Connection conn = getConnection();
			ArrayList<SeriesVo> slist = dao.listSeriesEtc(conn);
			close(conn);
			return slist;
		}
	
		
	//5-6. 게시글 읽기와 댓글 목록을 동시에 나타내는 메소드
	public SeriesVo readBoardAndReComment(int wbNo) {
		Connection conn = getConnection();
		SeriesVo svo = dao.readSeries(conn, wbNo);
		svo.setSrvolist(dao.readSeriesComments(conn, wbNo));
		close(conn);
			
		return svo;
		}
	
	//7. 댓글 작성
	public int insertSeriesComment(SeriesReCommentVo srvo) {
		Connection conn = getConnection();
		int result = dao.insertSeriesComment(conn, srvo);
		close(conn);
		return result;
	}
		
}
