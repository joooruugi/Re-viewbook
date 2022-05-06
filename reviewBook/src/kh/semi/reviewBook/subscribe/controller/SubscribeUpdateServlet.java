package kh.semi.reviewBook.subscribe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.service.SubscribeService;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class SubscribeUpdateServlet
 */
@WebServlet("/updatesubreview")
public class SubscribeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SubscribeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get : /updatesubreview");
		String usId ="";
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo"); 
		if(vo == null) { //로그인이 되지 않은 상황 -> 로그인 해야만 글 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return; 
		} else {
		usId = vo.getUsId();
		SubscribeVo ssvo = new SubscribeService().readSubscribe(usId);
		System.out.println("ssvo : "+ssvo);
		request.setAttribute("ssvo", ssvo);
		if(ssvo==null || ssvo.getSubYN().charAt(0)=='n') {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			out.print("<script language='javascript'>");
			out.print("alert('현재 구독중인 회원이 아닙니다.'); history.back();");
			out.print("</script>");
			out.flush();
			return;
		}else {
			request.getRequestDispatcher("WEB-INF/view/user/subscribe/updatesubreview.jsp").forward(request, response);
		}
		}
		
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
