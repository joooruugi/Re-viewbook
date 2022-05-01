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
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("redirectURI", referer);
		
		UserVo vo = new UserService().loginUser(usId, usPassword);
		if(vo == null) {  // 로그인실패
			System.out.println("로그인 실패");
			response.sendRedirect("login");
		}else {  // 로그인성공
			request.getSession().setAttribute("ssUserVo", vo);
//			response.sendRedirect("./");  // 상대경로
			System.out.println("로그인 성공");
			response.sendRedirect(request.getContextPath()+"/");  // 절대경로사용시 request.getContextPath() 과 함께 작성해야함.
			//절대하지 마세요.response.sendRedirect("myWeb1"+"/");  // 절대경로사용시 request.getContextPath() 과 함께 작성해야함.
		}
	}

}
