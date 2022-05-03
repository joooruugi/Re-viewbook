package kh.semi.reviewBook.user.funding.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.vo.SeriesVo;
import kh.semi.reviewBook.user.funding.model.service.FundingService;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;
import kh.semi.reviewBook.user.model.vo.UserVo;


/**
 * Servlet implementation class FundingBoardListServlet
 */
@WebServlet("/fundingboardlist")
public class FundingBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FundingService service = new FundingService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundingBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet확인");
//		String loginId = request.getParameter("usId") - 로그인한 사용자의 아이디
		String loginId = "";
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo");
		if(vo == null) {
			response.sendRedirect("login");
			return;
		}
		loginId = vo.getUsId();
		System.out.println("fundingboardlist loginId: "+ loginId);
		ArrayList<SeriesVo> slist = service.fundingBoardlist(loginId);
		System.out.println("slist: " + slist);
		
		request.setAttribute("slist", slist);
		request.getRequestDispatcher("WEB-INF/view/user/funding/fundingboardlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
