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
 * Servlet implementation class UserLoginFindIdActServlet
 */
@WebServlet("/us_findid.lo")
public class UserLoginFindIdActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginFindIdActServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usName = request.getParameter("usName");
		String usEmail = request.getParameter("usEmail");
		PrintWriter script = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		UserVo vo = new UserService().findidUser(usName, usEmail);
		if (vo == null) { // 아이디 찾기 실패
			System.out.println("아이디 찾기 실패");
			script.println("<script>");
			//usId띄워주고 싶은데 어떻게 넣어야하지?
			script.println("alert('없는 정보입니다.')");
			script.println("location.href='findid'");
			script.println("</script>");
//			response.sendRedirect("findid");
		}else {//아이디 찾기 성공
			script.println("<script>");
			script.println("location.href='foundid'");
			script.println("</script>");
		}

	}
}
