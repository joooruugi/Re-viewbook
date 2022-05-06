package kh.semi.reviewBook.subscribe.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.vo.SubscribeVo;
import kh.semi.reviewBook.subscribe.model.service.SubscribeService;




@WebServlet("/subscribemain")
public class SubscribeMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SubscribeMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /subscribemain");
		

		ArrayList<SubscribeVo> sslist = new SubscribeService().listSubscribe();
		System.out.println(sslist);
		

		request.setAttribute("sslist",sslist);
		

		request.getRequestDispatcher("WEB-INF/view/user/subscribe/subscribemain.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
