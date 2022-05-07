package kh.semi.reviewBook.admin.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

/**
 * Servlet implementation class AdminSeriesUpdate
 */
@WebServlet("/adseriesupdate")
public class AdminSeriesUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminSeriesUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO : 관리자 로그인 세션 정보 받아옴
		
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
		
		//service - dao 순으로 db에서 읽어오기
		SeriesVo svo = new SeriesService().adminReadUpdateBoard(wbNo);
		//db갔다온 데이터는 반드시 sysout으로 콘솔으로 확인  그 다음 request에 담아줌
		System.out.println(svo);
		
		if(svo==null) {
			//query문 실행 중 오류 발생한 경우 메인으로 보냄 
			response.sendRedirect("adseriesmain");
			return ;
		}
		
		request.setAttribute("svo", svo); 
		request.getRequestDispatcher("WEB-INF/view/admin/series/adseriesupdate.jsp").forward(request, response);
		
		}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

}
