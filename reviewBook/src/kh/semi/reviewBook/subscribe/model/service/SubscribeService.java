package kh.semi.reviewBook.subscribe.model.service;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;
import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.dao.SubscribeDao;



public class SubscribeService {

	
	private SubscribeDao dao = new SubscribeDao();
	
	//1. 구독권 목록 나타내는 메소드
		public ArrayList<SubscribeVo> listSubscribe() {
			Connection conn = getConnection();
			ArrayList<SubscribeVo> sslist = dao.listSubscribe(conn);
			close(conn);
			return sslist;	
			
		}
		
	//2. 구독 리뷰 작성 전 기존 구독 정보 가져오기 
		public SubscribeVo readSubscribe(String usId) {
			SubscribeVo ssvo = null;
			Connection conn = getConnection();
			ssvo = dao.readSubscribe(conn, usId);
			return ssvo;
		}
		
		
	//3. 구독 리뷰 작성 
	public int updateSubReview(SubscribeVo ssvo) {
		Connection conn = getConnection();
		int result = dao.updateSubReview(conn, ssvo);
		close(conn);
		return result;
	}
	
	//4. 정기 구독 신청
	public int insertSubscribeLong(String usId) {
		Connection conn = getConnection();
		int result = dao.insertSubscribeLong(conn, usId);
		close(conn);
		return result;
	}
	
	//5. 월별 구독 신청
	public int insertSubscribeShort(String usId) {
		Connection conn = getConnection();
		int result = dao.insertSubscribeShort(conn, usId);
		close(conn);
		return result;
		}
	
	//6. 현재 이용중인 구독 철회 
	public int updateSubscribeCancle(String usId) {
		Connection conn = getConnection();
		int result = dao.updateSubscribeCancle(conn, usId);
		close(conn);
		return result;
		}
}
