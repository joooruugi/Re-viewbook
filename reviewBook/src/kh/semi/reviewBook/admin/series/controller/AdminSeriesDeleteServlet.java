package kh.semi.reviewBook.admin.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/adseriesdelete")
public class AdminSeriesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminSeriesDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO : 관리자 로그인 정보 받아와야함
		System.out.println("do get /adseriesdelete");
		// string 형태에서 number 형태로 파싱 (NumberFormatException 주의)
		String wbnostr = request.getParameter("wbNo");
		System.out.println("wbNo : "+wbnostr);
		int wbNo = 0;
		try {
			wbNo = Integer.parseInt(wbnostr);
			System.out.println(wbNo);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(wbNo < 1) { 
			//읽어올 게시글 번호가 이상할 경우 그냥 메인으로 보냄
			response.sendRedirect("adseriesmain");
			//콘솔에서 확인
			System.out.println("wbNo < 1");
		}
		
		SeriesVo svo = new SeriesService().adminReadUpdateBoard(wbNo); //수정 삭제 동일 메소드 활용! 
		
		if(svo==null) {
			//query문 실행 중 오류 발생한 경우 메인으로 보냄 
			response.sendRedirect("adseriesmain");
			return ;
		}
		
		//게시글 삭제 메소드
		int result =  new SeriesService().adminDeleteSeriesBoard(svo); 
		
		 if(result<1) {//게시글 삭제에 실패한 경우 기존 게시글로 
			 response.sendRedirect("adseriesread?wbNo="+wbNo);
			 return;
		 }else {//게시글 삭제 성공하면 목록으로
			 	System.out.println("게시물 삭제에 성공하였습니다.");
			 	request.getSession().setAttribute("msg", "게시물 삭제에 성공하였습니다.");
				response.sendRedirect("adseriesmain");
				
			 }
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//	}

}
