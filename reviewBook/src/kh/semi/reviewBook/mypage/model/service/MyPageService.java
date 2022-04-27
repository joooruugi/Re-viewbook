package kh.semi.reviewBook.mypage.model.service;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;
import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.reviewBook.mypage.model.dao.MyPageDao;
import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;

public class MyPageService {
	private MyPageDao dao = new MyPageDao();
	public SubscribeVo selectSubscribe(String usId) {
		SubscribeVo result = null;
		Connection conn = getConnection();
		result = dao.selectSubscribe(conn, usId);
		close(conn);
		return result;
	}
	
	public ArrayList<BuyListVo> selectBuyList(String usId) {
		ArrayList<BuyListVo> result = null;
		Connection conn = getConnection();
		result = dao.selectBuyList(conn, usId);
		close(conn);
		return result;
	}
}
