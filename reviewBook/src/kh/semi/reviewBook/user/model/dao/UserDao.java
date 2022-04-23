package kh.semi.reviewBook.user.model.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kh.semi.reviewBook.user.model.vo.UserVo;


public class UserDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertMember(Connection conn, UserVo vo) {
//		US_ID       NOT NULL VARCHAR2(30)  
//		US_EMAIL    NOT NULL VARCHAR2(150) 
//		US_PHONE    NOT NULL VARCHAR2(30)  
//		US_NICKNAME NOT NULL VARCHAR2(45)  
//		US_PASSWORD NOT NULL VARCHAR2(30)  
//		US_GENDER   NOT NULL VARCHAR2(5)   
//		US_ADDRESS  NOT NULL VARCHAR2(300) 
//		US_NAME     NOT NULL VARCHAR2(10)  
//		US_BIRTH    NOT NULL DATE         
		int result =0;
		String sql = "insert into member (US_ID, US_EMAIL, US_PHONE, phoUS_NICKNAME, US_PASSWORD, US_GENDER, US_ADDRESS, US_NAME, US_BIRTH) values (?,?,?,?,?,?,?,?,?)";
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
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return result;
	}
	public UserVo login(Connection conn, String usId, String usPassword){
		UserVo result = null;
		String sql = "select * from member where us_id=? and us_password=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usId);
			pstmt.setString(2, usPassword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new UserVo();
				result.setUsEmail(rs.getString("us_email"));
				result.setUsId(rs.getString("us_id"));
				result.setUsNickname(rs.getString("us_nickname"));
				result.setUsPassword(rs.getString("us_password"));
				result.setUsPhone(rs.getString("us_phone"));
				result.setUsGender(rs.getString("us_gender"));
				result.setUsAddress(rs.getString("us_address"));
				result.setUsName(rs.getString("us_name"));
				result.setUsBirth(rs.getString("us_birth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rs);
			close(pstmt);
		}
		return result;
	}

}
