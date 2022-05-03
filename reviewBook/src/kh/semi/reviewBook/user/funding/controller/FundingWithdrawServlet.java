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
    	System.out.println("doPost : fundingwithdraw/");
    	System.out.println(request.getParameter("wbNo"));
		int wbNo = Integer.parseInt(request.getParameter("wbNo"));
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
		vo.setUsId(loginId);
		System.out.println("vo: "+vo);
		// 철회하기 버튼을 누르면 여기로 들어와서 글번호와 사용자아이디를 가지고 서비스로 간다.
		int result = service.fundingWithdraw(vo);
		
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();out.close();

	}

}
