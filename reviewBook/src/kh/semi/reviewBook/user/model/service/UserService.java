package kh.semi.reviewBook.user.model.service;

import java.sql.Connection;

import kh.semi.reviewBook.user.model.dao.UserDao;
import kh.semi.reviewBook.user.model.vo.UserVo;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

public class UserService {
	private UserDao dao = new UserDao();

	//회원가입
	public int insertUser(UserVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertUser(conn, vo);
		close(conn);
		return result;
	}
	//아이디 중복확인
		public int SignupIdCheck(String usId) {
			int result;
			Connection conn = getConnection();
			result = dao.SignupIdCheck(conn, usId);
			close(conn);
			return result;
		}
		//닉네임 중복확인
		public int SignupNicknameCheck(String usNickname) {
			int result;
			Connection conn = getConnection();
			result = dao.SignupNicknameCheck(conn, usNickname);
			close(conn);
			return result;
		}
	//로그인
	public UserVo loginUser(String usId, String usPassword) {
		UserVo result = null;
		Connection conn = getConnection();
		result = dao.loginUser(conn, usId, usPassword);
		close(conn);
		return result;
	}
	//아이디 찾기
	public UserVo findidUser(String usName, String usEmail) {
		UserVo result = null;
		Connection conn = getConnection();
		result = dao.findidUser(conn, usName, usEmail);
		close(conn);
		return result;
	}
	//비밀번호 찾기
	public UserVo findpwdUser(String usName, String usId, String usEmail, String usPhone, String usNickname	) {
		UserVo result = null;
		Connection conn = getConnection();
		result = dao.findpwdUser(conn, usName, usId, usEmail, usPhone, usNickname);
		close(conn);
		return result;
	}
	
}
