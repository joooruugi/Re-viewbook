package kh.semi.reviewBook.admin.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kh.semi.reviewBook.admin.vo.AdminVo;

public class AdminDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertAdmin(Connection conn, AdminVo vo) {
//		AD_ID	VARCHAR2(30)	✔	PK
//		AD_EMAIL	VARCHAR2(150)	✔	
//		AD_PHONE	VARCHAR2(30)	✔	
//		AD_NICKNAME	VARCHAR2(45)	✔	
//		AD_COMPANY	VARCHAR2(60)	✔	
//		AD_PASSWORD	VARCHAR2(30)	✔	
//		AD_GENDER	VARCHAR2(5)	✔	
		int result = 0;
		String sql = "insert into JKBS.\"ADMIN\" (AD_ID, AD_EMAIL, AD_PHONE, AD_NICKNAME, AD_COMPANY, AD_PASSWORD, AD_GENDER) values (?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAdId());
			pstmt.setString(2, vo.getAdEmail());
			pstmt.setString(3, vo.getAdPhone());
			pstmt.setString(4, vo.getAdNickname());
			pstmt.setString(5, vo.getAdCompany());
			pstmt.setString(6, vo.getAdPassword());
			pstmt.setString(7, vo.getAdGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public AdminVo loginAdmin(Connection conn, String adId, String adPassword) {
		AdminVo result = null;
		String sql = "select ad_password from \"ADMIN\" where ad_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new AdminVo();
				result.setAdId(rs.getString("AD_ID"));
				result.setAdEmail(rs.getString("AD_EMAIL"));
				result.setAdPhone(rs.getString("AD_PHONE"));
				result.setAdNickname(rs.getString("AD_NICKNAME"));
				result.setAdCompany(rs.getString("AD_COMPANY"));
				result.setAdPassword(rs.getString("AD_PASSWORD"));
				result.setAdGender(rs.getString("AD_GENDER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
