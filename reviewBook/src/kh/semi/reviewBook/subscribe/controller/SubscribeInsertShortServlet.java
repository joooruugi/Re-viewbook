package kh.semi.reviewBook.subscribe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.service.SubscribeService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class SubscribeInsertShortServlet
 */
@WebServlet("/subscribeshort")
public class SubscribeInsertShortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SubscribeInsertShortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get : /subscribeshort");
		request.getRequestDispatcher("WEB-INF/view/user/subscribe/subscribeshort.jsp").forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post : /subscribeshort");
		String usId = "";
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo"); 
		if(vo == null) { 
			response.sendRedirect("login");
			return; 
		} else {
			usId = vo.getUsId();
			System.out.println(usId);
		}
		
		SubscribeVo ssvo = new SubscribeVo();
		ssvo.setUsId(usId);
		
		int result = new SubscribeService().insertSubscribeShort(usId);
		if(result<1) {//실패
			response.sendRedirect("subscribemain");
			System.out.println("실패");
		}else {//성공
			response.sendRedirect("subscribemain");
			System.out.println("성공");
		}
	}

}
