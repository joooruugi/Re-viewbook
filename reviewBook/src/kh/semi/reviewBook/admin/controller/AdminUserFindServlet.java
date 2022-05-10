package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class AdminUserFindServlet
 */
@WebServlet("/userlist_find.lo")
public class AdminUserFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUserFindServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchuser = request.getParameter("searchuser_input");
		System.out.println(searchuser);
		PrintWriter script = response.getWriter();

		ArrayList<UserVo> ulistid = service.SearchUserId(searchuser);
		if (ulistid.size() != 0) {
			script.println("<script>");
			script.println("alert('검색하신 이름: " + searchuser + "의 회원정보는" + ulistid + "입니다.')");
			script.println("location.href='userlist'");
			script.println("</script>");
		} else {
			script.println("<script>");
			script.println("alert('검색하신 정보 : " + searchuser + "와 일치하는 회원이 없습니다.')");
			script.println("location.href='userlist'");
			script.println("</script>");

		}

		System.out.println("회원 검색 완료");

	}

}
