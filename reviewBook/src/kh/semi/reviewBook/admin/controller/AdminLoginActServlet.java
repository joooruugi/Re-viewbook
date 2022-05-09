package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.admin.vo.AdminVo;

/**
 * Servlet implementation class AdminLoginActServlet
 */
@WebServlet("/adlogin.lo")
public class AdminLoginActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginActServlet() {
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
		String adId = request.getParameter("adId");
		String adPassword = request.getParameter("adPassword");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter script = response.getWriter();
		
		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("redirectURI", referer);
		
		AdminVo vo = new AdminService().loginAdmin(adId, adPassword);
		
		if(vo == null) {
			script.println("<script>");
			script.println("alert('아이디 혹은 비밀번호가 틀렸습니다.')");
			script.println("location.href='adlogin'");
			script.println("</script>");
			System.out.println("로그인 실패");
		}else {
			request.getSession().setAttribute("ssAdminVo", vo);
			script.println("<script>");
			script.println("alert('"+adId+"관리자님 환영합니다.')");
			script.println("location.href='admain'");
			script.println("</script>");
			
		}
		
	}

}
