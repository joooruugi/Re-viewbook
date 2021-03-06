package kh.semi.reviewBook.book.model.service;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import kh.semi.reviewBook.admin.vo.AdminVo;
import kh.semi.reviewBook.book.model.dao.BookDao;
import kh.semi.reviewBook.book.model.vo.BookVo;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;
import kh.semi.reviewBook.series.model.dao.SeriesDao;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

public class BookService {

//	private BookDao bdao = new BookDao();

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
	// 책 목록
	public ArrayList<BookVo> bookList() {
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookList(conn);
		close(conn);
		return blist;
	}

	// 책 상세조회
	public BookVo bookContent(int bkNo) {
		Connection conn = getConnection();
		BookVo bvo = new BookDao().bookContent(conn, bkNo);
		close(conn);
		return bvo;
	}

	// 리뷰 리스트
	public ArrayList<ReviewVo> reviewlist(int bkNo) {
		Connection conn = getConnection();
		ArrayList<ReviewVo> rlist = new BookDao().reviewlist(conn, bkNo);
		close(conn);
		return rlist;
	}

	// 책- 판매순 조회
	public ArrayList<BookVo> bookListOrder() {
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListOrder(conn);
		close(conn);
		return blist;
	}

	// 책- 별점순 조회
	public ArrayList<BookVo> bookListRating() {
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListRating(conn);
		close(conn);
		return blist;
	}

	// 책- 별점순 조회
	public ArrayList<BookVo> bookListReview() {
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListReview(conn);
		close(conn);
		return blist;
	}

	// 장바구니 담기

	public int insertCart(CartVo cvo) {
		Connection conn = getConnection();
		int result = new BookDao().insertCart(conn, cvo);
		close(conn);
		return result;
	}
	
	// 스릴러
	public ArrayList<BookVo> bookListTh(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListTh(conn);
		close(conn);
		return blist;	
	}
	
	//힐링
	public ArrayList<BookVo> bookListHeal(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListHeal(conn);
		close(conn);
		return blist;
	}
	// 로먄스
	public ArrayList<BookVo> bookListRo(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListRo(conn);
		close(conn);
		return blist;
	}

	//자기개발
	public ArrayList<BookVo> bookListSelf(){
		Connection conn = getConnection();
		ArrayList<BookVo> blist = new BookDao().bookListSelf(conn);
		close(conn);
		return blist;
		
	}
	
	//리뷰삭제
	public int bookDelete(int bkNo) {
	Connection conn = getConnection();
	int result = new BookDao().bookDelete(conn, bkNo);
	close(conn);
	return result;
}
}



















