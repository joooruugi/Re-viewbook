package kh.semi.reviewBook.admin.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;


@WebServlet("/adseriescommentdelete")
public class AdminSeriesCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminSeriesCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get /adseriescommentdelete");
		//글번호
		String wbnostr = request.getParameter("wbNo");
		//댓글번호
		String wbcnostr = request.getParameter("wbcNo");
		
		System.out.println("wbNo : "+wbcnostr);
		int wbNo = 0;
		int wbcNo = 0;
		try {
			wbNo = Integer.parseInt(wbnostr);
			wbcNo = Integer.parseInt(wbcnostr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(wbcNo < 1 && wbNo <1) { 
			//읽어올 게시글 번호가 이상할 경우 메인으로 보냄
			response.sendRedirect("adseriesmain");
			//콘솔에서 확인
			System.out.println("wbNo < 1");
			System.out.println("wbcNo < 1");
		}

		
		//값 확인
		System.out.println(wbNo);
		System.out.println(wbcNo);

		
		SeriesReCommentVo srvo = new SeriesReCommentVo();
		srvo.setWbcNo(wbcNo);

		
		int result = new SeriesService().adminDeleteSeriesBoardComment(srvo);
		if(result<1) {//댓글 삭제에 실패한 경우 원래 읽던 글 화면으로
			 response.sendRedirect("adseriesread?wbNo="+wbNo);
		 }else { //성공해도 기존 게시글로 
			 response.sendRedirect("adseriesread?wbNo="+wbNo);
		 }
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
