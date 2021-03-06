package kh.semi.reviewBook.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;
import kh.semi.reviewBook.user.model.vo.UserVo;



/**
 * Servlet implementation class SeriesCommentServlet
 */
@WebServlet("/seriescomment")
public class SeriesCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SeriesCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do Post : /seriescomment");
		String wbnostr = request.getParameter("wbNo");
		System.out.println("wbNo : "+wbnostr);
		int wbNo = 0;
		try {
			wbNo = Integer.parseInt(wbnostr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(wbNo < 1) { 
			//읽어올 게시글 번호가 이상할 경우 그냥 메인으로 보냄
			response.sendRedirect("seriesmain");
			//콘솔에서 확인
			System.out.println("wbNo < 1");
		}
		String wbcContent = request.getParameter("wbcContent");
		String wbcRatingstr = request.getParameter("wbcRating");
		System.out.println("wbcRating : "+ wbcRatingstr);
		int wbcRating = 0;
		try {
			wbcRating = Integer.parseInt(wbcRatingstr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		//로그인 구현되면 세션에서 값 얻어오는거로 변경해야함 
		String usId = "";
		String wbcWriter = ""; 
				
		//로그인 구현 완료 로그인 정보 읽어오기
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo"); 
		if(vo == null) { //로그인이 되지 않은 상황 -> 로그인 해야만 글 작성 가능 ->로그인으로 이동
		response.sendRedirect("login");
		return; 
		} else {
		usId = vo.getUsId();
		wbcWriter = vo.getUsNickname();
		System.out.println(usId);
		System.out.println(wbcWriter);
		}
		
		SeriesReCommentVo srvo = new SeriesReCommentVo();
		srvo.setWbNo(wbNo);
		srvo.setWbcContent(wbcContent);
		srvo.setWbcRating(wbcRating);
		srvo.setUsId(usId);
		srvo.setWbcWriter(wbcWriter);
		 int result = new SeriesService().insertSeriesComment(srvo);
		 if(result<1) {//댓글 입력에 실패한 경우에도 메인으로 보냄
			 response.sendRedirect("seriesmain");
		 }else {
			 response.sendRedirect("seriesread?wbNo="+wbNo);
		 }
		
	}

}
