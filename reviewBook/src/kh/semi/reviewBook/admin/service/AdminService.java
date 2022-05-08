package kh.semi.reviewBook.admin.service;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.reviewBook.admin.dao.AdminDao;
import kh.semi.reviewBook.admin.vo.AdminVo;
import kh.semi.reviewBook.book.model.vo.BookVo;
import kh.semi.reviewBook.user.model.vo.UserVo;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;

import static kh.semi.reviewBook.common.jdbc.JdbcDBCP.*;

public class AdminService {
	private AdminDao dao = new AdminDao();
	
	//관리자 회원가입
	public int insertAdmin(AdminVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertAdmin(conn, vo);
		close(conn);
		return result;
	}
	//관리자 아이디 중복확인
	public int SignupIdCheckAdmin(String adId) {
		int result;
		Connection conn = getConnection();
		result = dao.SignupIdCheckAdmin(conn, adId);
		close(conn);
		return result;
	}
	//관리자 닉네임 중복확인
	public int SignupNicknameCheckAdmin(String adNickname) {
		int result;
		Connection conn = getConnection();
		result = dao.SignupNicknameCheckAdmin(conn, adNickname);
		close(conn);
		return result;
	}
	//관리자 로그인
	public AdminVo loginAdmin(String adId, String adPassword) {
		AdminVo result = null;
		Connection conn = getConnection();
		result = dao.loginAdmin(conn, adId, adPassword);
		close(conn);
		return result;
	}
	//관리자 아이디 찾기
	public AdminVo findidAdmin(String adNickname, String adEmail) {
		AdminVo result = null;
		Connection conn = getConnection();
		result = dao.findidAdmin(conn, adNickname, adEmail);
		close(conn);
		return result;
	}
	//관리자 비밀번호 찾기
	public AdminVo findqwdAdmin(String adId, String adEmail, String adPhone, String adNickname, String adCompany) {
		AdminVo result = null;
		Connection conn= getConnection();
		result = dao.findpwdAdmin(conn, adId, adEmail, adPhone, adNickname, adCompany);
		close(conn);
		return result;
	}
	//관리자 리스트
	public ArrayList<AdminVo> AdminList(String adId){
		Connection conn = getConnection();
		ArrayList<AdminVo> alist = dao.AdminList(conn, adId);
		close(conn);
		return alist;
	}
	//관리자 공지사항 목록 조회
	public ArrayList<NoticeVo> Noticelist(String adId){
		Connection conn = getConnection();
		ArrayList<NoticeVo> nlist = dao.Noticelist(conn, adId);
		close(conn);
		return nlist;
	}
	//공지사항 내용 조회
	public NoticeVo ReadNotice(int ntNo) {
		Connection conn = getConnection();
		NoticeVo nvo = dao.ReadNotice(conn, ntNo);
		close(conn);
		return nvo;
	}
	
	//관리자 공지사항 등록
	public int NoticeRegister(NoticeVo nvo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.NoticeRegister(conn, nvo);
		close(conn);
		return result;
	}
	//관리자 공지사항 삭제
	public int NoticeDelete(NoticeVo dnvo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.NoticeDelete(conn, dnvo);
		close(conn);
		return result;
	}
	//관리자 회원 조회
	public ArrayList<UserVo> UserList(String usId){
		Connection conn = getConnection();
		ArrayList<UserVo> ulist = dao.Userlist(conn, usId);
		close(conn);
		return ulist;
	}
	//관리자 회원 삭제
	public int DeleteUser(String usName) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.DeleteUser(conn, usName);
		close(conn);
		return result;
	}
	//관리자 회원 검색
	public ArrayList<UserVo> SearchUser(String searchUser){
		Connection conn = getConnection();
		ArrayList<UserVo> ulist = dao.SearchUser(conn, searchUser);
		close(conn);
		return ulist;
	}
//	public int NoticeRegister(NoticeVo nvo) {
//		int result = 0;
//		Connection conn = getConnection();
//		result = dao.NoticeRegister(conn, nvo);
//		close(conn);
//		return result;
//	}
	//관리자 도서 게시
	public int BookRegister(BookVo bvo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.BookRegister(conn, bvo);
		close(conn);
		return result;
	}
	
}
