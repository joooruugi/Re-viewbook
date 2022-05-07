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
		request.getRequestDispatcher("WEB-INF/view/user/subscribe/subscribeqna.jsp").forward(request, response);
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
