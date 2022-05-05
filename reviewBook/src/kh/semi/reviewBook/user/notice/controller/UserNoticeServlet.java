package kh.semi.reviewBook.user.notice.controller;

import java.io.IOException;


import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.admin.vo.AdminVo;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;


/**
 * Servlet implementation class UserNoticeServlet
 */
@WebServlet("/notice")
public class UserNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("들어오냐서블릿에");
		
		ArrayList<NoticeVo> nlist = service.Noticelist("adId");
		System.out.println("nlist = "+nlist);
		request.setAttribute("nlist", nlist);
		
		request.getRequestDispatcher("WEB-INF/view/user/notice/notice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		private int ntNo;
//		private String ntTitle;
//		private String ntContent;
//		private int ntCnt;
//		private Date ntDate;
//		private String ntNickname;
//		private String adId;
//		
//		int ntNo = Integer.parseInt(request.getParameter("ntNo"));
//		String ntTitle = request.getParameter("ntTitle");
//		String ntNickname = request.getParameter("ntNickname");
//		String ntDate = request.getParameter("ntDate");
////		
//		NoticeVo vo = new NoticeVo();
////		vo.setNtNo(ntNo);
//		vo.setNtTitle(ntTitle);
//		vo.setNtNickname(ntNickname);
////		vo.getNtDate(ntDate);
		
//	}

}
