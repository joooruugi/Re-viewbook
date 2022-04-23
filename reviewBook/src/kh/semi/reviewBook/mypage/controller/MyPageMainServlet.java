package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.BuyListVo;
import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.user.model.service.UserService;
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
		
		//강제 로그인(로그인됐다는 가정하에 마이페이지 들어가기위한 코드)
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) {
//			response.sendRedirect(request.getContextPath());
//			return;
//			TODO
			vo = new UserVo();
			vo.setUsId("us111");
		}
		SubscribeVo sVo = new MyPageService().selectSubscribe(vo.getUsId());
		System.out.println("servlet: "+sVo);
		BuyListVo bLVo = new MyPageService().selectBuyList(vo.getUsId());
//		ArrayList<OrderVo> myOrderlist = new OrderService().listOrder();
		
		request.setAttribute("sVo", sVo);
		request.setAttribute("bLVo", bLVo);
		
//		request.setAttribute("myOrderlist", myOrderlist);
		
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
