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
 * Servlet implementation class LoginDoController
 */
@WebServlet("/login.lo")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 인자 확인
		String usId = request.getParameter("id");
		String usPassword = request.getParameter("pwd");
				
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("redirectURI", referer);
		
		System.out.println("referer: "+referer);
		// DB 확인
		UserVo vo = new UserService().login(usId, usPassword);
		if(vo == null) {  // 로그인실패
			System.out.println("로그인 실패");
			response.sendRedirect("login");
		}else {  // 로그인성공
			request.getSession().setAttribute("ssUserVo", vo);
//			response.sendRedirect("./");  // 상대경로
			response.sendRedirect(request.getContextPath()+"/");  // 절대경로사용시 request.getContextPath() 과 함께 작성해야함.
			//절대하지 마세요.response.sendRedirect("myWeb1"+"/");  // 절대경로사용시 request.getContextPath() 과 함께 작성해야함.
		}
		
	}

}
