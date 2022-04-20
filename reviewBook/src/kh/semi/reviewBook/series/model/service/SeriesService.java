package kh.semi.reviewBook.series.model.service;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;


import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.reviewBook.series.model.dao.SeriesDao;
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

	


}
