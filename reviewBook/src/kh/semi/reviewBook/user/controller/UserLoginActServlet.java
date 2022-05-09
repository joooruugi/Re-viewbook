package kh.semi.reviewBook.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter script = response.getWriter();
		
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("redirectURI", referer);
		
		UserVo vo = new UserService().loginUser(usId, usPassword);
		if(vo == null) {  // 로그인실패
			script.println("<script>");
			script.println("alert('아이디 혹은 비밀번호가 틀렸습니다.')");
			script.println("location.href='login'");
			script.println("</script>");
			System.out.println("로그인 실패");
		}else {  // 로그인성공
			request.getSession().setAttribute("ssUserVo", vo);
			System.out.println("로그인 성공");
			script.println("<script>");
			script.println("alert('"+usId+"님 환영합니다.')");
			script.println("location.href='notice'");
			script.println("</script>");
		}
	}

}
