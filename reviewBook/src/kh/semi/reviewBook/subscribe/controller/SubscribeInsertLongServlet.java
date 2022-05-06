package kh.semi.reviewBook.subscribe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.service.SubscribeService;
import kh.semi.reviewBook.user.model.vo.UserVo;


@WebServlet("/subscribelong")
public class SubscribeInsertLongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubscribeInsertLongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get : /subscribelong");
		request.getRequestDispatcher("WEB-INF/view/user/subscribe/subscribelong.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post : /subscribelong");
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
		
		int result = new SubscribeService().insertSubscribeLong(usId);
		if(result<1) {//실패
			response.sendRedirect("subscribemain");
			System.out.println("실패");
		}else {//성공
			response.sendRedirect("subscribemain");
			System.out.println("성공");
		}
	}

}
