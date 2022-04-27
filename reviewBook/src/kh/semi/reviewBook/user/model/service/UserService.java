package kh.semi.reviewBook.user.model.service;

import java.sql.Connection;

import kh.semi.reviewBook.user.model.dao.UserDao;
import kh.semi.reviewBook.user.model.vo.UserVo;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

public class UserService {
	private UserDao dao = new UserDao();
	
	public int insertMember(UserVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertMember(conn, vo);
		close(conn);
		return result;
	}
	
	public UserVo login(String usId, String usPassword){
		UserVo result = null;
		Connection conn = getConnection();
		result = dao.loginUser(conn, usId, usPassword);
		close(conn);
		return result;
	}
	
	
}
