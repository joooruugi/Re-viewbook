package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.admin.vo.AdminVo;

/**
 * Servlet implementation class AdminSignupInputActServlet
 */
@WebServlet("/adsignup_input.lo")
public class AdminSignupInputActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignupInputActServlet() {
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
//		private String adId;
//		private String adEmail;
//		private String adPhone;
//		private String adNickname;
//		private String adCompany;
//		private String adPassword;
//		private String adGender;
		
		String adId = request.getParameter("adId");
		String adEmail = request.getParameter("adEmail");
		String adPhone = request.getParameter("adPhone");
		String adNickname = request.getParameter("adNickname");
		String adCompany = request.getParameter("adCompany");
		String adPassword = request.getParameter("adPassword");
		String adGender = request.getParameter("adGender");
		
		AdminVo avo = new AdminVo();
		avo.setAdId(adId);
		avo.setAdEmail(adEmail);
		avo.setAdPhone(adPhone);
		avo.setAdNickname(adNickname);
		avo.setAdCompany(adCompany);
		avo.setAdPassword(adPassword);
		avo.setAdGender(adGender);
		
		int result = new AdminService().insertAdmin(avo);
		if(result <1) {
			response.sendRedirect("adsignup_input");
		}else {
			response.sendRedirect("adsignup_final");
		}
		
	}

}
