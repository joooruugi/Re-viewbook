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
		String sql = "select * from \"USER\" where us_id=? and us_password = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			pstmt.setString(2, usPassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserVo();
				result.setUsId(rs.getString("us_Id"));
				result.setUsEmail(rs.getString("us_Email"));
				result.setUsPhone(rs.getString("us_Phone"));
				result.setUsNickname(rs.getString("us_Nickname"));
				result.setUsPassword(rs.getString("us_Password"));
				result.setUsGender(rs.getString("us_Gender"));
				result.setUsAddress(rs.getString("us_Address"));
				result.setUsName(rs.getString("us_Name"));
				result.setUsBirth(rs.getString("us_Birth"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//아이디 중복확인
	public int SignupIdCheck(Connection conn, String usId) {
		int result = -1;
		String sql = "select us_id from \"USER\" where us_id=?";
//		System.out.println(usId);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 0;
				System.out.println(rs.getString("usId"));
			}else {
				result = 1;
			}
			System.out.println("아이디 중복체크 결과 :" +result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//닉네임 중복확인
	public int SignupNicknameCheck(Connection conn, String usNickname) {
		int result = -1;
		String sql = "select us_nickname from \"USER\" where us_nickname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usNickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
			System.out.println("닉네임 중복체크 결과 : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
				result.setUsId(rs.getString("us_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//비밀번호 찾기
	public UserVo findpwdUser(Connection conn, String usName, String usId, String usEmail, String usPhone, String usNickname) {
		UserVo result = null;
		String sql = "select us_password from \"USER\" where us_name=? and us_Id=? and us_Email=? and us_phone=? and us_nickname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usName);
			pstmt.setString(2, usId);
			pstmt.setString(3, usEmail);
			pstmt.setString(4, usPhone);
			pstmt.setString(5, usNickname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new UserVo();
				result.setUsPassword(rs.getString("us_password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

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
