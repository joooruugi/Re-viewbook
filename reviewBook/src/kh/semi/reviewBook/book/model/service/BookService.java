package kh.semi.reviewBook.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.book.model.dao.BookDao;
import kh.semi.reviewBook.book.model.vo.BookVo;

public class BookService {

	
	public ArrayList<BookVo> rankinglist() {
		ArrayList<BookVo> rlist = null;
		Connection conn = getConnection();
		rlist = new BookDao().rankinglist(conn);
		close(conn);
		return rlist;
	}

	public ArrayList<BookVo> booklist() {
		ArrayList<BookVo> rlist = null;
		Connection conn = getConnection();
		rlist = new BookDao().booklist(conn);
		close(conn);
		return rlist;
	}
	
}
