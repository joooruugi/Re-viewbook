package com.cos.gmail;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EmailCheckAct
 */
@WebServlet("/gmailcheckaction")
public class gmailCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gmailCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getRequestDispatcher("WEB-INF/view/user/signup/gmailcheckaction.jsp").forward(request, response);
		String code = request.getParameter("code");
		boolean rightCode = 
				SHA256.getEncrypt("reviewbook.rvb@gmail.com", "cos").equals(code) ? true : false;
		PrintWriter script = response.getWriter();
		if(rightCode == true){
			script.println("<script>");
			script.println("alert('이메일 인증에 성공하였습니다.')");
			script.println("location.href='login'");
			script.println("</script>");
		} else{
			script.println("<script>");
			script.println("alert('이메일 인증을 실패하였습니다.')");
			script.println("location.href='signup_gmail'");
			script.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
