package kh.semi.reviewBook.subscribe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.user.model.vo.UserVo;


@WebServlet("/subscribeqna")
public class SubscribeQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SubscribeQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get : /subscribeqna");
		String usId = "";
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) { // 로그인이 되지 않은 상황 -> 로그인 해야만 글 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return;
		} else {
			usId = vo.getUsId();
		}
		
		request.getRequestDispatcher("WEB-INF/view/user/subscribe/subscribeqna.jsp").forward(request, response);
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
