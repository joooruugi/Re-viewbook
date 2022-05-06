package kh.semi.reviewBook.subscribe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.service.SubscribeService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class SubscribeUpdateDoServlet
 */
@WebServlet("/updatesubreview.do")
public class SubscribeUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubscribeUpdateDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post : /updatesubreview.do");
		PrintWriter out = response.getWriter();

		String subReview = request.getParameter("subReview");
		String usId = "";
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) { // 로그인이 되지 않은 상황 -> 로그인 해야만 글 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return;
		} else {
			usId = vo.getUsId();
		}

		// 값 확인
		System.out.println("subReview :" + subReview);
		System.out.println("usId :" + usId);

		// set으로 담아줌
		SubscribeVo ssvo = new SubscribeVo();
		ssvo.setSubReview(subReview);
		ssvo.setUsId(usId);

		int result = new SubscribeService().updateSubReview(ssvo);

		if (result < 1) {// 후기 작성 실패한 경우 history.back
			response.setContentType("text/html; charset=utf-8");
			out.print("<script language='javascript'>");
			out.print("alert('후기 작성에 실패하였습니다.'); history.back();");
			out.print("</script>");
			out.flush();
			return;
		} else {// 성공하면 메인..
			response.setContentType("text/html; charset=utf-8");
			out.print("<script language='javascript'>");
			out.print("alert('후기 작성이 완료되었습니다.'); location.href='subscribemain'");
			out.print("</script>");
			out.flush();
		}
	}

}
