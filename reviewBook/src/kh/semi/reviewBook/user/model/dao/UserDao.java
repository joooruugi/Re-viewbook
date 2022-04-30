package kh.semi.reviewBook.user.model.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.reviewBook.user.model.vo.UserVo;

public class UserDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

//	회원가입 
	public int insertUser(Connection conn, UserVo vo) {
//		US_ID       NOT NULL VARCHAR2(30)  
//		US_EMAIL    NOT NULL VARCHAR2(150) 
//		US_PHONE    NOT NULL VARCHAR2(30)  
//		US_NICKNAME NOT NULL VARCHAR2(45)  
//		US_PASSWORD NOT NULL VARCHAR2(30)  
//		US_GENDER   NOT NULL VARCHAR2(5)   
//		US_ADDRESS  NOT NULL VARCHAR2(300) 
//		US_NAME     NOT NULL VARCHAR2(10)  
//		US_BIRTH    NOT NULL DATE         
		int result = 0;
		String sql = "insert into JKBS.\"USER\" (US_ID, US_EMAIL, US_PHONE, US_NICKNAME, US_PASSWORD, US_GENDER, US_ADDRESS, US_NAME, US_BIRTH) values (?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUsId());
			pstmt.setString(2, vo.getUsEmail());
			pstmt.setString(3, vo.getUsPhone());
			pstmt.setString(4, vo.getUsNickname());
			pstmt.setString(5, vo.getUsPassword());
			pstmt.setString(6, vo.getUsGender());
			pstmt.setString(7, vo.getUsAddress());
			pstmt.setString(8, vo.getUsName());
			pstmt.setString(9, vo.getUsBirth());
			// 성공일 경우 0이상의 숫자가 반환됨
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	//로그인
	public UserVo loginUser(Connection conn, String usId, String usPassword) {
		UserVo result = null;
		String sql = "select us_password from \"USER\" where us_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserVo();
				result.setUsEmail(rs.getString("US_EMAIL"));
				result.setUsId(rs.getString("US_ID"));
				result.setUsNickname(rs.getString("US_NICKNAME"));
				result.setUsPassword(rs.getString("US_PASSWORD"));
				result.setUsPhone(rs.getString("US_PHONE"));
				result.setUsGender(rs.getString("US_GENDER"));
				result.setUsName(rs.getString("US_NAME"));
				result.setUsBirth(rs.getString("US_BIRTH"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//아이디 찾기
	public UserVo findidUser(Connection conn, String usName, String usEmail) {
		UserVo result = null;
		String sql = "select us_id from \"USER\" where us_name=? and us_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usName);
			pstmt.setString(2, usEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new UserVo();
				//정보가 일치하면 아이디를 띄워줘야하는데 어캐 띄워주지 ! 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	// 로그인
//	public int loginUser(Connection conn, String usId, String usPassword) {
//		String sql = "select us_password from \"USER\" where us_id=?;";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, usId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				if(rs.getString(1).equals(usPassword)) {
//					return 1; //로그인 성공
//				}else {
//					return 0; //비밀번호 불일치
//				}
//			}
//			return -1; //아이디가 없음
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return -2; //데이터베이스 오류
//	}

//	public boolean check(Connection conn, String usId) {
//		String sql = "select usId form \"USER\"";
//		try {
//			pstmt  = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				if(rs.getString("usId").equals("usId")) {
//					return true;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

////	회원 수정 
//	public int updateUser(Connection conn, UserVo vo) {
//		int result = 0;
//		String sql = "";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
////	회원삭제 
//	public int deleteUser(Connection conn, UserVo vo) {
//		int result = 0;
//		String sql = "";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}

//	회원 목록 
	public ArrayList<UserVo> listUser(Connection conn) {
		ArrayList<UserVo> result = null;
		String sql = "select * from user";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<UserVo>();
			while (rs.next()) {
				UserVo vo = new UserVo();
				vo.setUsEmail(rs.getString("US_EMAIL"));
				vo.setUsPhone(rs.getString("US_PHONE"));
				vo.setUsNickname(rs.getString("US_NICKNAME"));
				vo.setUsGender(rs.getString("US_GENDER"));
				vo.setUsAddress(rs.getString("US_ADDRESS"));
				vo.setUsName(rs.getString("US_NAME"));
				vo.setUsBirth(rs.getString("US_BIRTH"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

//	회원 조회
	public UserVo readUser(Connection conn, String usId) {
		UserVo result = null;
		String sql = "";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

//	public int loginUser(Connection conn, String usId, String usPassword) {
//		String sql = "select US_PASSWORD from user where US_ID =?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, usId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				if (rs.getString(1).equals(usPassword)) {
//					return 1; // 로그인 성공
//				} else {
//					return 0; // 비밀번호 불일치
//				}
//			}
//			return -1; // 아이디가 없음
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -2; //데이터베이스 오류
//	}
}
