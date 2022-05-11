package kh.semi.reviewBook.admin.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesReCommentVo;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

/**
 * Servlet implementation class AdminSeriesReadServlet
 */
@WebServlet("/adseriesread")
public class AdminSeriesReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminSeriesReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getParameter로 값 받아줌 -> string 형태에서 number 형태로 파싱 (NumberFormatException 주의)
		// TODO : 관리자 로그인 정보 session에서 얻어와야함 
		String wbnostr = request.getParameter("wbNo");
		System.out.println("wbNo : " + wbnostr);
		int wbNo = 0;
		try {
			wbNo = Integer.parseInt(wbnostr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (wbNo < 1) {
			// 읽어올 게시글 번호가 이상할 경우 그냥 메인으로 보냄
			response.sendRedirect("seriesmain");
			// 콘솔에서 확인
			System.out.println("wbNo < 1");
		}

		// service - dao 순으로 db에서 읽어오기
		SeriesVo svo = new SeriesService().readBoardAndReComment(wbNo);
		SeriesReCommentVo srvo = new SeriesReCommentVo();
		// db갔다온 데이터는 반드시 sysout으로 콘솔으로 확인 그 다음 request에 담아줌
		//System.out.println(svo);
		//System.out.println(srvo);

		if (svo == null) {
			// query문 실행 중 오류 발생한 경우 메인으로 보냄
			response.sendRedirect("seriesmain");
			return;
		}
		// 게시글 조회수 업데이트 메소드
		int updateCount = new SeriesService().readUpdateCount(svo);
		if (updateCount < 1) {
			response.sendRedirect("seriesmain");
			System.out.println("조회수 증가 실패");
			return;
		} else {

			request.setAttribute("svo", svo); 
			request.getRequestDispatcher("WEB-INF/view/admin/series/adseriesread.jsp").forward(request, response);
		}
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
