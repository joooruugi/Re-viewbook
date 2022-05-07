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
 * Servlet implementation class AdminNoticeDeleteActServlet
 */
@WebServlet("/adminnotice_content.lo")
public class AdminNoticeDeleteActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDeleteActServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 확인");
		String ntNostr = request.getParameter("ntNo");
		System.out.println("ntNo: "+ntNostr);
		int ntNo = Integer.parseInt(ntNostr);
		
		NoticeVo dnvo = service.ReadNotice(ntNo);
		
		int result = service.NoticeDelete(dnvo);
		if(result<1) {
			response.sendRedirect("adminnotice_content?ntNo="+ntNo);
			return;
		}else {
			System.out.println("게시물 삭제 성공");
			response.sendRedirect("adnotice");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	
//	}

}
