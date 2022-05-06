package kh.semi.reviewBook.user.funding.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;
import kh.semi.reviewBook.user.funding.model.service.FundingService;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;


/**
 * Servlet implementation class FundingBoardListServlet
 */
@WebServlet("/fundingsuccessboardlist")
public class FundingSuccessBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FundingService service = new FundingService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundingSuccessBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet확인");
		ArrayList<SeriesVo> slistFiction = new SeriesService().listSeriesFictionRank();
		ArrayList<SeriesVo> slistInfo = new SeriesService().listSeriesInfoRank();
		ArrayList<SeriesVo> slistDaily = new SeriesService().listSeriesDailyRank();
		ArrayList<SeriesVo> slistEtc = new SeriesService().listSeriesEtcRank();
		System.out.println(slistFiction);
		System.out.println(slistInfo);
		System.out.println(slistDaily);
		System.out.println(slistEtc);
		
		request.setAttribute("slistFiction",slistFiction);
		request.setAttribute("slistInfo",slistInfo);
		request.setAttribute("slistDaily",slistDaily);
		request.setAttribute("slistEtc",slistEtc);
		request.getRequestDispatcher("WEB-INF/view/user/funding/fundingsuccessboardlist.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
