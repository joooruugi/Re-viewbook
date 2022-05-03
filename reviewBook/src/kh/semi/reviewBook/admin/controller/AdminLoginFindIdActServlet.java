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
 * Servlet implementation class AdminLoginFindIdActServlet
 */
@WebServlet("/ad_findid.lo")
public class AdminLoginFindIdActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginFindIdActServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adNickname = request.getParameter("adNickname");
		String adEmail = request.getParameter("adEmail");
		PrintWriter script = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		AdminVo vo = new AdminService().findidAdmin(adNickname, adEmail);
		if (vo == null) { // 아이디 찾기 실패
			System.out.println("아이디 찾기 실패");
			response.sendRedirect("adfindid");
		}else {//아이디 찾기 성공
			script.println("<script>");
			//usId띄워주고 싶은데 어떻게 넣어야하지?
			script.println("alert('adId')");
			script.println("location.href='login'");
			script.println("</script>");
		}
	}

}
