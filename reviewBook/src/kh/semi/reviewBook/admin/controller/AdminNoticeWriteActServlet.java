package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.dao.AdminDao;
import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.admin.vo.AdminVo;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;

@WebServlet("/adminnotice_write.lo")
public class AdminNoticeWriteActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminNoticeWriteActServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ntTitle = request.getParameter("ntTitle");
		String ntContent = request.getParameter("ntContent");
		ntContent = ntContent.replace("\r\n","<br>");
		String ntNickname = "";
		String adId = "";

		AdminVo avo = (AdminVo) request.getSession().getAttribute("ssAdminVo");
		if (avo == null) {
			response.sendRedirect("adlogin");
			return;
		} else {
			adId = avo.getAdId();
			ntNickname = avo.getAdNickname();
			System.out.println(ntNickname);
			System.out.println(adId);
		}
		NoticeVo nvo = new NoticeVo();
		nvo.setAdId(adId);
		nvo.setNtTitle(ntTitle);
		nvo.setNtContent(ntContent);
		nvo.setNtNickname(ntNickname);
		int result = new AdminService().NoticeRegister(nvo);
		if (result == 1) {
			System.out.println("공지사항 작성 완료");
			response.sendRedirect("adnotice");
		} else {
			System.out.println("공지사항 작성 실패");
			response.sendRedirect("adminnotice_write");
		}

	}

}
