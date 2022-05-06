package kh.semi.reviewBook.admin.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.reviewBook.admin.vo.AdminVo;
import kh.semi.reviewBook.user.model.vo.UserVo;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;

public class AdminDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//관리자 회원가입
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
	//관리자 로그인
	public AdminVo loginAdmin(Connection conn, String adId, String adPassword) {
		AdminVo result = null;
		String sql = "select * from \"ADMIN\" where ad_id=? and ad_password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			pstmt.setString(2, adPassword);
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
	//관리자 아이디 중복체크
	public int SignupIdCheckAdmin(Connection conn, String adId) {
		int result = -1;
		String sql = "select ad_id from \"ADMIN\" where ad_id=?";
//		System.out.println(usId);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 0;
				System.out.println(rs.getString("adId"));
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
	//관리자 닉네임 중복체크
	public int SignupNicknameCheckAdmin(Connection conn, String adNickname) {
		int result = -1;
		String sql = "select ad_nickname from \"ADMIN\" where ad_nickname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adNickname);
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
	//관리자 아이디 찾기
	public AdminVo findidAdmin(Connection conn, String adNickname, String adEmail) {
		AdminVo result = null;
		String sql = "select ad_id from \"ADMIN\" where ad_nickname=? and ad_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adNickname);
			pstmt.setString(2, adEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new AdminVo();
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
	//관리자 공지사항 등록
	public int NoticeRegister(Connection conn, NoticeVo nvo) {
		int result = 0;
		String sql = "INSERT INTO NOTICE (NT_NO, NT_TITLE, NT_CONTENT, NT_CNT, NT_DATE, NT_NICKNAME, AD_ID)"
				+ "VALUES (SEQ_NT_NO.nextval, ? , ? , DEFAULT, SYSTIMESTAMP,"
				+ "(SELECT AD_NICKNAME FROM \"ADMIN\" WHERE AD_ID =?),?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getNtTitle());
			pstmt.setString(2, nvo.getNtContent());
			pstmt.setString(3, nvo.getAdId());
			pstmt.setString(4, nvo.getAdId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs); 
			close(pstmt);
		}
		return result;
	}
	//공지사항 목록 나타내기 (공지사항 갯수 10개 안 넘을 예정 > 페이징 처리 x
	public ArrayList<NoticeVo> Noticelist(Connection conn, String usId){
		ArrayList<NoticeVo> nlist = null;
//		NT_NO	NUMBER	✔	PK	
//		NT_TITLE	VARCHAR2(300)	✔		
//		NT_CONTENT	VARCHAR2(3000)	✔		
//		NT_CNT	NUMBER	✔		0
//		NT_DATE	TIMESTAMP	✔		SYSTIMESTAMP
//		NT_NICKNAME	VARCHAR2(45)	✔		
//		AD_ID	VARCHAR2(30)	✔	FK	
		String sql="select * from notice";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			nlist = new ArrayList<NoticeVo>();
			while(rs.next()) {
				NoticeVo nvo = new NoticeVo();
				nvo.setNtNo(rs.getInt("nt_no"));
				nvo.setNtTitle(rs.getString("nt_title"));
				nvo.setNtNickname(rs.getString("nt_nickname"));
				nvo.setNtDate(rs.getString("nt_date"));
				
				nlist.add(nvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return nlist;
	}
	//공지사항 삭제
	public int NoticeDelete(Connection conn, NoticeVo dnvo) {
		int result = 0;
		String sql ="";
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//회원 목록 조회
	public ArrayList<UserVo> Userlist(Connection conn, String usId){
		ArrayList<UserVo> ulist = null;
		String sql = "select * from \"USER\"";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ulist = new ArrayList<UserVo>();
			while(rs.next()) {
				UserVo uvo = new UserVo();
				uvo.setUsId(rs.getString("us_id"));
				uvo.setUsEmail(rs.getString("us_email"));
				uvo.setUsPhone(rs.getString("us_phone"));
				uvo.setUsNickname(rs.getString("us_nickname"));
				uvo.setUsPassword(rs.getString("us_password"));
				uvo.setUsGender(rs.getString("us_gender"));
				uvo.setUsAddress(rs.getString("us_address"));
				uvo.setUsName(rs.getString("us_name"));
				uvo.setUsBirth(rs.getString("us_birth"));
				ulist.add(uvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return ulist;
	}
}
