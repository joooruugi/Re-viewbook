package kh.semi.reviewBook.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.book.model.dao.BookDao;
import kh.semi.reviewBook.book.model.vo.BookVo;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;
import kh.semi.reviewBook.series.model.dao.SeriesDao;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

public class BookService {

	private BookDao bdao = new BookDao();
	
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
	public ArrayList<BookVo> bookList(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookList(conn);
		close(conn);
		return blist;
	}
	//책 상세조회
	public BookVo bookContent(int bkNo) {
		Connection conn = getConnection();
		BookVo bvo = new BookDao().bookContent(conn, bkNo);
		close(conn);
		return bvo;
	}
	//리뷰 리스트
	public ArrayList<ReviewVo> reviewlist(int bkNo) {
		Connection conn = getConnection();
		ArrayList<ReviewVo> rlist = new BookDao().reviewlist(conn, bkNo);
		close(conn);
		return rlist;
	}
	//책- 판매순 조회
	public ArrayList<BookVo> bookListOrder(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListOrder(conn);
		close(conn);
		return blist;
	}
	//책- 별점순 조회
	public ArrayList<BookVo> bookListRating(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListRating(conn);
		close(conn);
		return blist;
	}
	//책- 별점순 조회
	public ArrayList<BookVo> bookListReview(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListReview(conn);
		close(conn);
		return blist;
	}
	
	//장바구니 담기
	/*
	 * public int insertCart(CartVo cvo) { Connection conn = getConnection(); int
	 * result = bdao.insertCart(conn, cvo); close(conn); return result; }
	 */
}
