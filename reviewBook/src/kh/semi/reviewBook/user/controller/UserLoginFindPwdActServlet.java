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
 * Servlet implementation class UserLoginFindPwdActServlet
 */
@WebServlet("/us_findpwd.lo")
public class UserLoginFindPwdActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginFindPwdActServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String usName = request.getParameter("usName");
		String usId = request.getParameter("usId");
		String usEmail = request.getParameter("usEmail");
		String usPhone = request.getParameter("usPhone");
		String usNickname = request.getParameter("usNickname");
		PrintWriter script = response.getWriter();
		
		UserVo vo = new UserService().findpwdUser(usName, usId, usEmail, usPhone, usNickname);
		
		if(vo == null) {
			System.out.println("비밀번호 찾기 실패");
			script.println("<script>");
			//usId띄워주고 싶은데 어떻게 넣어야하지?
			script.println("alert('없는 정보입니다.')");
			script.println("location.href='findpwd'");
			script.println("</script>");
		}else {//아이디 찾기 성공
			request.setAttribute("usPassword", vo.getUsPassword());
			String findpwd = vo.getUsPassword();
			System.out.println(usName);
			script.println("<script>");
			script.println("alert('"+usName+"님의 비밀번호는 "+findpwd+"입니다.')");
			script.println("location.href='login'");
			script.println("</script>");
		
		}
	}

}
