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
 * Servlet implementation class FundingWithdrawServlet
 */
@WebServlet("/fundingwithdraw")
public class FundingWithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FundingService service = new FundingService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundingWithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : fundingwithdraw/");
		int wbNo = Integer.parseInt(request.getParameter("wbNo"));
		ArrayList<FundingVo> flist = service.fundingWithdraw(wbNo);
		// 철회하기 버튼을 누르면 여기로 들어와서 버튼을 누른 글번호를 가지고 서비스로 간다.
		
//		request.setAttribute("flist", flist);
		request.getRequestDispatcher("WEB-INF/view/user/funding/fundingboardlist.jsp").forward(request, response);

	}

}
