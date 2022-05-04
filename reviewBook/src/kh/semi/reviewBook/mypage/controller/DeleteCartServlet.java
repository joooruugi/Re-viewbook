package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/deletecart")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do get /deletecart");
		String usId = "";
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) {
			response.sendRedirect("login");
			return;
		} else {
			usId = vo.getUsId();
			System.out.println(usId);
		}
		
		// string 형태에서 number 형태로 파싱 (NumberFormatException 주의)
		String bknostr = request.getParameter("bkNo");
		System.out.println("bkNo : " + bknostr);
		int bkNo = 0;
		try {
			bkNo = Integer.parseInt(bknostr);
			System.out.println(bkNo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (bkNo < 1) {
			// 읽어올 도서번호가 이상할 경우 그냥 장바구니 메인으로 보냄
			response.sendRedirect("cartlist");
			// 콘솔에서 확인
			System.out.println("bkNo < 1");
		}

		// 장바구니 삭제 메소드
		int result = new MyPageService().deleteCart(usId, bkNo);

		if (result < 1) { // 장바구니 삭제에 실패한 경우 메인으로 보냄
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>");
			out.print("alert('장바구니 삭제에 실패하였습니다.'); history.back();");
			out.print("</script>");
			out.flush();
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>");
			out.print("alert('장바구니 삭제가 완료되었습니다.'); location.href='" + request.getContextPath() + "'");
			out.print("</script>");
			out.flush();
		}
		System.out.println("deleteCart 서블릿 result: " + result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
