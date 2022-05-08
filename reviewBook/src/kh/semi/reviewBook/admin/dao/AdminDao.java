package kh.semi.reviewBook.admin.dao;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.reviewBook.admin.vo.AdminVo;
import kh.semi.reviewBook.book.model.vo.BookVo;
import kh.semi.reviewBook.user.model.vo.UserVo;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;

public class AdminDao {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 관리자 회원가입
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
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 관리자 로그인
	public AdminVo loginAdmin(Connection conn, String adId, String adPassword) {
		AdminVo result = null;
		String sql = "select * from \"ADMIN\" where ad_id=? and ad_password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			pstmt.setString(2, adPassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 관리자 아이디 중복체크
	public int SignupIdCheckAdmin(Connection conn, String adId) {
		int result = -1;
		String sql = "select ad_id from \"ADMIN\" where ad_id=?";
//		System.out.println(usId);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 0;
				System.out.println(rs.getString("adId"));
			} else {
				result = 1;
			}
			System.out.println("아이디 중복체크 결과 :" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 관리자 닉네임 중복체크
	public int SignupNicknameCheckAdmin(Connection conn, String adNickname) {
		int result = -1;
		String sql = "select ad_nickname from \"ADMIN\" where ad_nickname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adNickname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 0;
			} else {
				result = 1;
			}
			System.out.println("닉네임 중복체크 결과 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 관리자 아이디 찾기
	public AdminVo findidAdmin(Connection conn, String adNickname, String adEmail) {
		AdminVo result = null;
		String sql = "select ad_id from \"ADMIN\" where ad_nickname=? and ad_email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adNickname);
			pstmt.setString(2, adEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new AdminVo();
				result.setAdId(rs.getString("ad_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	//관리자 비밀번호 찾기
	public AdminVo findpwdAdmin(Connection conn, String adId, String adEmail, String adPhone, String adNickname, String adCompany) {
		AdminVo result = null;
		String sql = "select ad_password from \"ADMIN\" where ad_id=? and ad_email=? and ad_phone=? and ad_nickname=? and ad_company=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			pstmt.setString(2, adEmail);
			pstmt.setString(3, adPhone);
			pstmt.setString(4, adNickname);
			pstmt.setString(5, adCompany);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new AdminVo();
				result.setAdPassword(rs.getString("ad_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 관리자 리스트

	public ArrayList<AdminVo> AdminList(Connection conn, String adId) {
		ArrayList<AdminVo> alist = null;
		String sql = "select * from \"ADMIN\" where ad_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adId);
			rs = pstmt.executeQuery();
			alist = new ArrayList<AdminVo>();
			while (rs.next()) {
				AdminVo avo = new AdminVo();
				avo.setAdId(rs.getString("ad_id"));
				avo.setAdEmail(rs.getString("ad_email"));
				avo.setAdPhone(rs.getString("ad_phone"));
				avo.setAdNickname(rs.getString("ad_nickname"));
				avo.setAdPassword(rs.getString("ad_password"));
				avo.setAdGender(rs.getString("ad_gender"));
				avo.setAdCompany(rs.getString("ad_company"));
				alist.add(avo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return alist;
	}

	// 관리자 공지사항 등록
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
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 공지사항 목록 나타내기 (공지사항 갯수 10개 안 넘을 예정 > 페이징 처리 x
	public ArrayList<NoticeVo> Noticelist(Connection conn, String usId) {
		ArrayList<NoticeVo> nlist = null;
//		NT_NO	NUMBER	✔	PK	
//		NT_TITLE	VARCHAR2(300)	✔		
//		NT_CONTENT	VARCHAR2(3000)	✔		
//		NT_CNT	NUMBER	✔		0
//		NT_DATE	TIMESTAMP	✔		SYSTIMESTAMP
//		NT_NICKNAME	VARCHAR2(45)	✔		
//		AD_ID	VARCHAR2(30)	✔	FK	
		String sql = "select * from notice";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			nlist = new ArrayList<NoticeVo>();
			while (rs.next()) {
				NoticeVo nvo = new NoticeVo();
				nvo.setNtNo(rs.getInt("nt_no"));
				nvo.setNtTitle(rs.getString("nt_title"));
				nvo.setNtNickname(rs.getString("nt_nickname"));
				nvo.setNtDate(rs.getString("nt_date"));

				nlist.add(nvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return nlist;
	}

	// 공지사항 삭제
	public int NoticeDelete(Connection conn, NoticeVo dnvo) {
		int result = 0;
		String sql = "delete from \"NOTICE\" where nt_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dnvo.getNtNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	// 공지사항 내용 조회
	public NoticeVo ReadNotice(Connection conn, int ntNo) {
		NoticeVo nvo = null;
		String sql = "select * from notice where NT_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ntNo);
			rs = pstmt.executeQuery();
			nvo = new NoticeVo();
			if (rs.next()) {
				nvo.setAdId(rs.getString("ad_id"));
				nvo.setNtCnt(rs.getInt("nt_cnt"));
				nvo.setNtContent(rs.getString("nt_content"));
				nvo.setNtDate(rs.getString("nt_date"));
				nvo.setNtNickname(rs.getString("nt_nickname"));
				nvo.setNtNo(rs.getInt("nt_no"));
				nvo.setNtTitle(rs.getString("nt_title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return nvo;
	}

	// 회원 목록 조회
	public ArrayList<UserVo> Userlist(Connection conn, String usId) {
		ArrayList<UserVo> ulist = null;
		String sql = "select * from \"USER\"";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ulist = new ArrayList<UserVo>();
			while (rs.next()) {
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
		} finally {
			close(rs);
			close(pstmt);
		}
		return ulist;
	}
	//회원 삭제
	public int DeleteUser(Connection conn, String usName) {
		int result = 0;
		String sql = "delete from \"USER\" where us_name=?";
		System.out.println("여기 들어오긴 하나?");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usName);
			System.out.println("여긴 들어와?");
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("여긴 들어와?2");
			close(rs);
			close(pstmt);
		}
		System.out.println("여긴 33들어와?");
		return result;
	}

	// 관리자 회원 검색
	public ArrayList<UserVo> SearchUser(Connection conn, String searchUser) {
		ArrayList<UserVo> ulist = null;
		String sql = "";
		try {
			pstmt = conn.prepareCall(sql);
			rs = pstmt.executeQuery();
			ulist = new ArrayList<UserVo>();
			while (rs.next()) {
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
		} finally {
			close(rs);
			close(pstmt);
		}
		return ulist;
	}
//	public int NoticeRegister(Connection conn, NoticeVo nvo) {
//		int result = 0;
//		String sql = "INSERT INTO NOTICE (NT_NO, NT_TITLE, NT_CONTENT, NT_CNT, NT_DATE, NT_NICKNAME, AD_ID)"
//				+ "VALUES (SEQ_NT_NO.nextval, ? , ? , DEFAULT, SYSTIMESTAMP,"
//				+ "(SELECT AD_NICKNAME FROM \"ADMIN\" WHERE AD_ID =?),?)";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, nvo.getNtTitle());
//			pstmt.setString(2, nvo.getNtContent());
//			pstmt.setString(3, nvo.getAdId());
//			pstmt.setString(4, nvo.getAdId());
//			result = pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return result;
//	}
	//관리자 도서 게시
	//Publishdate sql에 자료형 변경 필요 TODO
	public int BookRegister(Connection conn, BookVo bvo) {
		int result = 0;
		String sql = "insert into book (bk_no, bk_title, bk_content, bk_img, bk_price, bk_writer, gn_no, bk_index) values (seq_bk_no.nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bvo.getBkNo());
			pstmt.setString(2, bvo.getBkTitle());
			pstmt.setString(3, bvo.getBkContent());
			pstmt.setString(4, bvo.getBkImg());
			pstmt.setInt(5, bvo.getBkPrice());
			pstmt.setString(6, bvo.getBkWriter());
			pstmt.setInt(7, bvo.getGnNo());
			pstmt.setString(8, bvo.getBkIndex());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
}
