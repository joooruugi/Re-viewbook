package kh.semi.reviewBook.user.funding.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.user.funding.model.service.FundingService;
import kh.semi.reviewBook.user.funding.model.vo.FundingVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

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
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	System.out.println("doPost : fundingwithdraw/");
//    	System.out.println(request.getParameter("wbNo"));
		int wbNo = Integer.parseInt(request.getParameter("wbNo"));
//		System.out.println(wbNo);
		String loginId = "";
		UserVo ssUserVo = (UserVo)request.getSession().getAttribute("ssUserVo");
		if(ssUserVo == null) {
			response.sendRedirect("login");
			return;
		}
		loginId = ssUserVo.getUsId();
		
		// 글번호와 사용자 아이디를 가지고 후원금액 알아오기
		FundingVo fvo = new FundingService().fundingBoardlistDonation(wbNo, loginId);
//		System.out.println("fvo:" + fvo);
		PrintWriter out = response.getWriter();
		out.print(fvo);
		out.flush();out.close();
		
		if(fvo==null) {
			//query문 실행 중 오류 발생한 경우 메인으로 보냄 
			response.sendRedirect("fundingboardlist");
			return ;
		}
		
		request.setAttribute("fvo", fvo); //이동할 jsp파일의 getAttribute와 같은 이름인지 확인 
		request.getRequestDispatcher("WEB-INF/view/user/funding/fundingboardlist.jsp").forward(request, response);
	}

}
