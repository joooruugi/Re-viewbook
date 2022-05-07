package kh.semi.reviewBook.admin.subscribe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.service.SubscribeService;


@WebServlet("/adsubscribedel")
public class AdminSubscribeDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminSubscribeDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doGet : /adsubscribemain");
		

		ArrayList<SubscribeVo> sslist = new SubscribeService().checkSubscribeDel();
		System.out.println(sslist);
		

		request.setAttribute("sslist",sslist);
		

		request.getRequestDispatcher("WEB-INF/view/admin/subscribe/adsubscribedel.jsp").forward(request, response);
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
