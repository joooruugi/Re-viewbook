package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/updatecart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post : updatecart");
		String bkNostr = request.getParameter("bkNo");
		System.out.println("bkNo : " + bkNostr);
		int bkNo = 0;
		try {
			bkNo = Integer.parseInt(bkNostr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (bkNo < 1) {
			// 읽어올 책번호가 이상할 경우 그냥 메인으로 보냄
			response.sendRedirect("bookcontent?bkNo=" + bkNo);
			// 콘솔에서 확인
			System.out.println("bkNo < 1");
		}

		String caCountstr = request.getParameter("caCount");
		System.out.println("caCountstr : " + caCountstr);
		int caCount = 0;
		try {
			caCount = Integer.parseInt(caCountstr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		// 로그인 정보 읽어오기
		String usId = "";
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) { // 로그인이 되지 않은 상황
			response.sendRedirect("login");
			return;
		} else {
			usId = vo.getUsId();
			System.out.println(usId);
		}

		CartVo cvo = new CartVo();

		cvo.setUsId(usId);
		cvo.setCaCount(caCount);
		cvo.setBkNo(bkNo);

		int result = new MyPageService().updateCart(cvo);
		if (result < 1) {
			System.out.println("실패");
			return;
		} else {
			System.out.println("성공");
			response.sendRedirect("cartlist");
		}

	}

}
