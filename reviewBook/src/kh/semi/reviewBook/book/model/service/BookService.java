package kh.semi.reviewBook.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.book.model.dao.BookDao;
import kh.semi.reviewBook.book.model.vo.BookVo;

public class BookService {

	
	public ArrayList<BookVo> rankinglist() {
		ArrayList<BookVo> blist = null;
		Connection conn = getConnection();
		blist = new BookDao().rankinglist(conn);
		close(conn);
		return blist;
	}

//	public ArrayList<BookVo> booklist() {
//		ArrayList<BookVo> blist = null;
//		Connection conn = getConnection();
//		blist = new BookDao().booklist(conn);
//		close(conn);
//		return blist;
//	}
	//책 목록
	public ArrayList<BookVo> BookList(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().BookList(conn);
		close(conn);
		return blist;
	}
	//책 상세조회
	public BookVo BookContent(int bkNo) {
		Connection conn = getConnection();
		BookVo bvo = new BookDao().BookContent(conn, bkNo);
		close(conn);
		return bvo;
	}
	
}
