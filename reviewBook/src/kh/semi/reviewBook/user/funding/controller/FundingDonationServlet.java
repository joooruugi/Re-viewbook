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
 * Servlet implementation class FundingDonationServlet
 */
@WebServlet("/fundingdonation")
public class FundingDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FundingService service = new FundingService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundingDonationServlet() {
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
		System.out.println("doPost : fundingdonation/");
		System.out.println(request.getParameter("wbNo"));
		System.out.println(request.getParameter("fdDonation"));
		int wbNo = 0;
		int fdDonation = 0;
		try {
			wbNo = Integer.parseInt(request.getParameter("wbNo"));
			fdDonation = Integer.parseInt(request.getParameter("fdDonation"));
		} catch (Exception e) {
			System.out.println("숫자 오류");
		}
		System.out.println(wbNo);
		String loginId = "";
		UserVo ssUserVo = (UserVo)request.getSession().getAttribute("ssUserVo");
		if(ssUserVo == null) {
			response.sendRedirect("login");
			return;
		}
		loginId = ssUserVo.getUsId();
		
		FundingVo vo = new FundingVo();
		vo.setWbNO(wbNo);
		vo.setFdDonation(fdDonation);
		vo.setUsId(loginId);
		System.out.println("vo: "+vo);
		int result = service.fundingDonation(vo);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();out.close();
		

	}

}
