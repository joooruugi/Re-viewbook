package kh.semi.reviewBook.series.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/seriesdelete")
public class SeriesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SeriesDeleteServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get /seriesdelete");
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
			response.sendRedirect("seriesmain");
			//콘솔에서 확인
			System.out.println("wbNo < 1");
		}
		
		SeriesVo svo = new SeriesService().readUpdateBoard(wbNo); //수정 삭제 동일 메소드 활용! 
		
		if(svo==null) {
			//query문 실행 중 오류 발생한 경우 메인으로 보냄 
			response.sendRedirect("seriesmain");
			return ;
		}
		
		//게시글 삭제 메소드
		int result =  new SeriesService().deleteSeriesBoard(svo); 
		
		 if(result<1) {//게시글 삭제에 실패한 경우 기존 게시글로 
			 response.sendRedirect("seriesread?wbNo="+wbNo);
			 return;
		 }else {//게시글 삭제 성공하면 목록으로
			 PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>");
				out.print("alert('게시물 삭제에 성공하였습니다.'); location.href='" + request.getContextPath() + "/seriesmain'");
				out.print("</script>");
				out.flush();

				
			 }
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
