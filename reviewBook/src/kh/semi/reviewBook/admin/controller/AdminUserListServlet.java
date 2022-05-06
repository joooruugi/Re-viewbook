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
 * Servlet implementation class AdminUserListServlet
 */
@WebServlet("/userlist")
public class AdminUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("º≠∫Ì∏¥ »Æ¿Œ");
		ArrayList<UserVo> ulist = service.UserList("usId");
		System.out.println("ulist = "+ulist);
		request.setAttribute("ulist", ulist);
		request.getRequestDispatcher("WEB-INF/view/admin/main/userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
