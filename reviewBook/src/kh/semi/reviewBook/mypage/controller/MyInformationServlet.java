package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.MyInformationVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class MyInformationServlet
 */
@WebServlet({ "/myinformation", "/myinfoupdate.lo" })
public class MyInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyInformationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/myinformation doGet");
		// 로그인
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) { // 로그인이 되지 않은 상황 -> 로그인 해야만 리뷰 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return;
		} else {
			String usId = vo.getUsId();
			MyInformationVo myinfovo = new MyPageService().selectMyInformation(usId);
			System.out.println("myinfovo: " + myinfovo);
			request.setAttribute("myinfovo", myinfovo);
			request.getRequestDispatcher("/WEB-INF/view/user/mypage/myInfoUpdate.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/myinfoupdate.lo ");

		String usEmail = request.getParameter("usEmail");
		String usPhone = request.getParameter("usPhone");
		String usNickname = request.getParameter("usNickname");
		String usAddress = request.getParameter("usAddress");
		String usName = request.getParameter("usName");

		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) { // 로그인이 되지 않은 상황 -> 로그인 해야만 리뷰 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return;
		} else {
			String usId = vo.getUsId();
			MyInformationVo iVo = new MyInformationVo();
			iVo.setUsAddress(usAddress);
			iVo.setUsEmail(usEmail);
			iVo.setUsName(usName);
			iVo.setUsNickname(usNickname);
			iVo.setUsPhone(usPhone);
			iVo.setUsId(usId);
			System.out.println("/myinfoupdate.lo" + iVo);
			int result = new MyPageService().updateMyInformation(iVo);
			System.out.println("result:" + result);

			// 정보수정 버튼 눌렀을 때 알림창 띄우기
			if (result == 1) {
				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>");
				out.print("alert('정보 수정이 완료되었습니다.'); location.href='" + request.getContextPath() + "/myinformation'");
				out.print("</script>");
				out.flush();
			} else {
				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>");
				out.print("alert('정보 수정에 실패하였습니다.'); history.back();");
				out.print("</script>");
				out.flush();
			}

		}

	}

}
