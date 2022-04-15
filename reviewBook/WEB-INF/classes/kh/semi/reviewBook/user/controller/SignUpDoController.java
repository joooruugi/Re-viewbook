package kh.semi.reviewBook.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpDoController
 */
@WebServlet("/signup.lo")
public class SignUpDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpDoController() {
        super();
        // TODO Auto-generated constructor stub
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
		String usGender = request.getParameter("usGender");
		String usAddress = request.getParameter("usAddress");
		String usName = request.getParameter("usName");
		String usBirth = request.getParameter("usBirth");
	}

}
