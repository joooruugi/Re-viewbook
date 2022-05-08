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
 * Servlet implementation class AdminLoginFindPwdActServlet
 */
@WebServlet("/ad_findpwd.lo")
public class AdminLoginFindPwdActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginFindPwdActServlet() {
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
		
		String adId = request.getParameter("adId");
		String adEmail = request.getParameter("adEmail");
		String adPhone = request.getParameter("adPhone");
		String adNickname = request.getParameter("adNickname");
		String adCompany = request.getParameter("adCompany");
		PrintWriter script = response.getWriter();
		
		AdminVo vo = new AdminService().findqwdAdmin(adId, adEmail, adPhone, adNickname, adCompany);

		if(vo == null) {
			System.out.println("비밀번호 찾기 실패");
			script.println("<script>");
			//usId띄워주고 싶은데 어떻게 넣어야하지?
			script.println("alert('없는 정보입니다.')");
			script.println("location.href='adfindpwd'");
			script.println("</script>");
		}else {//아이디 찾기 성공
			request.setAttribute("adPassword", vo.getAdPassword());
			String adfindpwd = vo.getAdPassword();
			System.out.println(adNickname);
			script.println("<script>");
			script.println("alert('"+adNickname+"님의 비밀번호는 "+adfindpwd+"입니다.')");
			script.println("location.href='adlogin'");
			script.println("</script>");
		
		}
	}

}
