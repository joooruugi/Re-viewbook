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
	public int insertSubscribeLong(SubscribeVo ssvo) {
		Connection conn = getConnection();
		int result = dao.insertSubscribeLong(conn, ssvo);
		close(conn);
		return result;
	}
	
	//5. 월별 구독 신청
	public int insertSubscribeShort(SubscribeVo ssvo) {
		Connection conn = getConnection();
		int result = dao.insertSubscribeShort(conn, ssvo);
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
	
	//7-1. 관리자 - 구독 y 회원 조회 
	public ArrayList<SubscribeVo> checkSubscribe() {
		Connection conn = getConnection();
		ArrayList<SubscribeVo> sslist = dao.checkSubscribe(conn);
		close(conn);
		return sslist;	
				
	}
	
	//7-2. 관리자 - 구독 y 회원 조회 
	public ArrayList<SubscribeVo> checkSubscribeDel() {
		Connection conn = getConnection();
		ArrayList<SubscribeVo> sslist = dao.checkSubscribeDel(conn);
		close(conn);
		return sslist;	
				
	}
	
	//8. 관리자 구독 n 회원 삭제
	public int deleteSubscribe(String usId) {
		Connection conn = getConnection();
		int result = dao.deleteSubscribe(conn, usId);
		close(conn);
		return result;
		}
	
	}
