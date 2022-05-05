package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;

/**
 * Servlet implementation class AdminNoticeServlet
 */
@WebServlet("/adnotice")
public class AdminNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminNoticeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어오냐서블릿에");

		ArrayList<NoticeVo> nlist = service.Noticelist("adId");
		System.out.println("nlist = " + nlist);
		request.setAttribute("nlist", nlist);

		request.getRequestDispatcher("WEB-INF/view/admin/notice/adnotice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("servlet 들어오냐!");
//		NoticeVo vo = (NoticeVo)request.getAttribute("NoticeVo");
////		ArrayList<NoticeVo> nlist = AdminService().NoticeView(NoticeVo);
//		request.getRequestDispatcher("WEB-INF/view/admin/notice/adnotice.jsp").forward(request, response);
//	}

}
