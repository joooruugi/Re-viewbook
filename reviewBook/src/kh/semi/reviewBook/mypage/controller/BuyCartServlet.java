package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class BuyCartServlet
 */
@WebServlet("/buycart")
public class BuyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyCartServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//// cart_main_jsp jquery로 받아온값들
		String bkNoStr= request.getParameter("bkNo");
		String bktitle= request.getParameter("bktitle");
		
		int bkNo = 0;
		try {
			bkNo = Integer.parseInt(bkNoStr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo");
		if(vo == null) { //로그인이 되지 않은 상황 -> 로그인 해야만 함->로그인으로 이동
			response.sendRedirect("login");
			return; 
		} else {
			String usId = vo.getUsId();
			BuyListVo bVo = new BuyListVo();
			bVo.setUsId(usId);
			bVo.setBkNo(bkNo);
			bVo.setBkTitle(bktitle);
			System.out.println(bVo);
			
			int result = new MyPageService().insertOrder(bVo);
			System.out.println(result);
			
			response.sendRedirect("mypagemain");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
