package kh.semi.reviewBook.user.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.user.notice.vo.NoticeVo;

/**
 * Servlet implementation class UserNoticeContentServlet
 */
@WebServlet("/noticecontent")
public class UserNoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNoticeContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do Get /notice");
		
		String ntNostr = request.getParameter("ntNo");
		System.out.println("ntNo: "+ntNostr);
		int ntNo = 0;
		try {
			ntNo = Integer.parseInt(ntNostr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(ntNo <1) {
			response.sendRedirect("notice");
			System.out.println("ntNo <1");
		}
		NoticeVo nvo = new AdminService().ReadNotice(ntNo);
		System.out.println(nvo);
		if(nvo == null) {
			response.sendRedirect("notice");
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/view/user/notice/noticecontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
