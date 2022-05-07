package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class AdminDeleteUserServlet
 */
@WebServlet("/userlist.lo")
public class AdminDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원삭제 서블릿 확인");
		String usName = request.getParameter("usName");
		System.out.println("usName : "+usName);
		int result = service.DeleteUser(usName);
		if(result <1) {
			System.out.println("회원삭제 실패");
			response.sendRedirect("userlist");
			return;
		}else {
			System.out.println("회원 삭제 성공");
			response.sendRedirect("userlist");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
