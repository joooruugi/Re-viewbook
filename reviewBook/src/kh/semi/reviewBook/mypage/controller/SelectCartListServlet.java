package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class SelectCartListServlet
 */
@WebServlet("/cartlist")
public class SelectCartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCartListServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		ArrayList<CartVo> cVo = new MyPageService().selectCartList(vo.getUsId());
		
		request.setAttribute("cVo", cVo);
		
		request.getRequestDispatcher("WEB-INF/view/user/mypage/cart_main.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
