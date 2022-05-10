package kh.semi.reviewBook.mypage.model.service;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.reviewBook.mypage.model.dao.MyPageDao;
import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.mypage.model.vo.MyInformationVo;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;
import kh.semi.reviewBook.mypage.model.vo.UserSubVo;

public class MyPageService {
	private MyPageDao dao = new MyPageDao();

	// 구독권 조회
	public UserSubVo selectSubscribe(String usId) {
		UserSubVo result = null;
		Connection conn = getConnection();
		result = dao.selectSubscribe(conn, usId);
		close(conn);
		return result;
	}

	// 구매목록 조회
	public ArrayList<BuyListVo> selectBuyList(String usId) {
		ArrayList<BuyListVo> result = null;
		Connection conn = getConnection();
		result = dao.selectBuyList(conn, usId);
		close(conn);
		return result;
	}
	
	//주문목록 추가
	public int insertOrder(BuyListVo bVo) {
		Connection conn = getConnection();
		setAutoCommit(conn, false);
		
		int nextVal = dao.selectSeqOrNumNextVal(conn);
		
		int result = dao.insertOrder(conn, bVo, nextVal);
		
		if(result > 0 && bVo != null) {	//구매하면 구매목록에 추가
			result = dao.insertOrderBook(conn, bVo, nextVal);
		}
		
		if(result >0) {	//구매하면 장바구니에서는 삭제
			result = dao.deleteCart(conn, bVo.getUsId(), bVo.getBkNo());
		}
		
		if(result >0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}	

	// 내정보 수정 전 기존 정보 가져오기
	public MyInformationVo selectMyInformation(String usId) {
		MyInformationVo result = null;
		Connection conn = getConnection();
		result = dao.selectMyInformation(conn, usId);
		close(conn);
		return result;
	}

	// 내 정보 수정
	public int updateMyInformation(MyInformationVo iVo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.updateMyInformation(conn, iVo);
		close(conn);
		return result;
	}

	// 리뷰 쓰기
	public int insertReview(ReviewVo rVo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertReview(conn, rVo);
		close(conn);
		return result;
	}

	// 장바구니 목록 조회
	public ArrayList<CartVo> selectCartList(String usId) {
		ArrayList<CartVo> result = null;
		Connection conn = getConnection();
		result = dao.selectCartList(conn, usId);
		close(conn);
		return result;
	}

	// 장바구니 삭제
	public int deleteCart(String usId, int bkNo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.deleteCart(conn, usId, bkNo);
		close(conn);
		return result;
	}
	
}
