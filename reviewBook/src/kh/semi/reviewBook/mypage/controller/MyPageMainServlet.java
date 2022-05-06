package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;
import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class MyPageMainServlet
 */
@WebServlet("/mypagemain")
public class MyPageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageMainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("들어가나?");
		
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo");
		if(vo == null) { //로그인이 되지 않은 상황 -> 로그인 해야만 리뷰 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return; 
		} else {
			String usId = vo.getUsId();
			vo.setUsId(usId);
		}
		SubscribeVo sVo = new MyPageService().selectSubscribe(vo.getUsId());
		System.out.println("servlet: "+sVo);
		ArrayList<BuyListVo> bLVo = new MyPageService().selectBuyList(vo.getUsId());
		
		request.setAttribute("sVo", sVo);
		request.setAttribute("bLVo", bLVo);
		
		
		request.getRequestDispatcher("WEB-INF/view/user/mypage/mypage_main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
