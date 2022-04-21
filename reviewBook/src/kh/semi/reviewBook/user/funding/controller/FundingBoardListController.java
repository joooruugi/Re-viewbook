package kh.semi.reviewBook.user.funding.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.user.funding.model.service.FundingService;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;


/**
 * Servlet implementation class FundingBoardListController
 */
@WebServlet("/fundingboardlist")
public class FundingBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FundingService service = new FundingService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundingBoardListController() {
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
		System.out.println("servlet확인");
		ArrayList<FundingVo> volist = service.fundingBoardlist();
		System.out.println(volist);
		
		request.setAttribute("fundingVolist", volist);
		request.getRequestDispatcher("WEB-INF/view/user/funding/fundingboardlist.jsp").forward(request, response);
	}

}
