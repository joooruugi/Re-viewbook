package kh.semi.reviewBook.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.user.model.service.UserService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class UserLoginActServlet
 */
@WebServlet("/login.lo")
public class UserLoginActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginActServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usId = request.getParameter("usId");
		String usPassword = request.getParameter("usPassword");
		
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("redirectURI", referer);
		
		UserVo vo = new UserService().login(usId, usPassword);
		if(vo == null) { //로그인 실패하면 다시 로그인
			response.sendRedirect("login");
		}else { //로그인 성공하면 세션에 저장, 메인페이지로 이동
			request.getSession().setAttribute("ssUserVo", vo);
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

}
