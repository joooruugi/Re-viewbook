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
import kh.semi.reviewBook.admin.vo.NoticeVo;

/**
 * Servlet implementation class AdminNoticeWriteActServlet
 */
@WebServlet("/adminnotice_write.lo")
public class AdminNoticeWriteActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeWriteActServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//    private int ntNo;
//	private String ntTitle;
//	private String ntContent;
//	private int ntCnt;
//	private Date ntDate;
//	private String ntNickname;
//	private String adId;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ntTitle = request.getParameter("ntTitle");
		String ntContent = request.getParameter("ntContent");
		String ntNickname ="";
		String adId = "";
		
		AdminVo avo = (AdminVo)request.getSession().getAttribute("ssAdminVo");
		if(avo == null) {
			response.sendRedirect("adlogin");
			return;
		}else {
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
		if(result == 1) {
			System.out.println("작성완료");
			response.sendRedirect("adnotice");
		}else {
			System.out.println("실패하지마");
			response.sendRedirect("adminnotice_write");
		}
		
	}

}
