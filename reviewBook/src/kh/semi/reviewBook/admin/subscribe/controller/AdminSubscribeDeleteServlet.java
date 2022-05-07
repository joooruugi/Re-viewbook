package kh.semi.reviewBook.admin.subscribe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.subscribe.model.service.SubscribeService;
import kh.semi.reviewBook.user.model.vo.UserVo;


@WebServlet("/adsubscribedelete")
public class AdminSubscribeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminSubscribeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get /adsubscribedelete");
		
		String usId = request.getParameter("usId");
		// 삭제 메소드
		int result = new SubscribeService().deleteSubscribe(usId);

		if (result < 1) { // 삭제에 실패한경우 다시 그 화면
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>");
			out.print("alert('삭제에 실패하였습니다.'); history.back();");
			out.print("</script>");
			out.flush();
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>");
			out.print("alert('구독 철회 회원 삭제가 완료되었습니다.'); location.href='" + request.getContextPath() + "/adsubscribedel'");
			out.print("</script>");
			out.flush();
		}
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
