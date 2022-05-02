package kh.semi.reviewBook.admin.service;

import java.sql.Connection;

import kh.semi.reviewBook.admin.dao.AdminDao;
import kh.semi.reviewBook.admin.vo.AdminVo;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

public class AdminService {
	private AdminDao dao = new AdminDao();
	
	public int insertAdmin(AdminVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertAdmin(conn, vo);
		close(conn);
		return result;
	}
	
	public AdminVo loginAdmin(String adId, String adPassword) {
		AdminVo result = null;
		Connection conn = getConnection();
		result = dao.loginAdmin(conn, adId, adPassword);
		close(conn);
		return result;
	}

	public int SignupIdCheckAdmin(String adId) {
		int result;
		Connection conn = getConnection();
		result = dao.SignupIdCheckAdmin(conn, adId);
		close(conn);
		return result;
	}
	public int SignupNicknameCheckAdmin(String adNickname) {
		int result;
		Connection conn = getConnection();
		result = dao.SignupNicknameCheckAdmin(conn, adNickname);
		close(conn);
		return result;
	}
	public AdminVo findidAdmin(String adNickname, String adEmail) {
		AdminVo result = null;
		Connection conn = getConnection();
		result = dao.findidAdmin(conn, adNickname, adEmail);
		close(conn);
		return result;
	}
}
