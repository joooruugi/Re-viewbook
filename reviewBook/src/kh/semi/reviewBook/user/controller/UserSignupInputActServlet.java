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
 * Servlet implementation class UserSignupInputActServlet
 */
@WebServlet("/signup_input.lo")
public class UserSignupInputActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignupInputActServlet() {
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
//		US_ID       NOT NULL VARCHAR2(30)  
//		US_EMAIL    NOT NULL VARCHAR2(150) 
//		US_PHONE    NOT NULL VARCHAR2(30)  
//		US_NICKNAME NOT NULL VARCHAR2(45)  
//		US_PASSWORD NOT NULL VARCHAR2(30)  
//		US_GENDER   NOT NULL VARCHAR2(5)   
//		US_ADDRESS  NOT NULL VARCHAR2(300) 
//		US_NAME     NOT NULL VARCHAR2(10)  
//		US_BIRTH    NOT NULL DATE          
//		private String usId;
//		private String usEmail;
//		private String usPhone;
//		private String usNickname;
//		private String usPassword;
//		private String usGender;
//		private String usAddress;
//		private String usName;
//		private String usBirth;
		
		String usId = request.getParameter("usId");
		String usEmail = request.getParameter("usEmail");
		String usPhone = request.getParameter("usPhone");
		String usNickname = request.getParameter("usNickname");
		String usPassword = request.getParameter("usPassword");
		String usGender= request.getParameter("usGender");
		String usAddress = request.getParameter("usAddress");
		String usName = request.getParameter("usName");
		String usBirth	= request.getParameter("usBirth");
		
		UserVo uvo = new UserVo();
		uvo.setUsId(usId);
		uvo.setUsEmail(usEmail);
		uvo.setUsPhone(usPhone);
		uvo.setUsNickname(usNickname);
		uvo.setUsPassword(usPassword);
		uvo.setUsGender(usGender);
		uvo.setUsAddress(usAddress);
		uvo.setUsName(usName);
		uvo.setUsBirth(usBirth);
		
		int result = new UserService().insertUser(uvo);
//		request.getRequestDispatcher("WEB-INF/view/user/signup/signup_final.jsp").forward(request, response);
//		response.sendRedirect("signup_terms");
		if(result <1) {
			response.sendRedirect("signup_input");
		}else {
			response.sendRedirect("signup_final");
		}
////		
	}

}
