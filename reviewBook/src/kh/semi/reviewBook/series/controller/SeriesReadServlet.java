package kh.semi.reviewBook.series.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class SeriesReadServlet
 */
@WebServlet("/seriesread")
public class SeriesReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SeriesReadServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do Get /seriesread");

		// getParameter로 값 받아줌 -> string 형태에서 number 형태로 파싱 (NumberFormatException 주의)
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
		// db갔다온 데이터는 반드시 sysout으로 콘솔으로 확인 그 다음 request에 담아줌
		//System.out.println(svo);

		if (svo == null) {
			// query문 실행 중 오류 발생한 경우 메인으로 보냄
			response.sendRedirect("seriesmain");
			return;
		}
		// 게시글 조회수 업데이트 메소드
		int updateCount = new SeriesService().readUpdateCount(svo);
		if (updateCount < 1) {// 조회수 +1 실패시 목록으로
			response.sendRedirect("seriesmain");
			System.out.println("조회수 증가 실패");
			return;
		} else {// 조회수 +1 성공 시 (로그인된 상태여야함)

			request.setAttribute("svo", svo); // 이동할 jsp파일의 getAttribute와 같은 이름인지 확인
			UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo"); 
			if(vo == null) { //로그인이 되지 않은 상황 -> 로그인 해야만 글 읽기 가능
				response.sendRedirect("login");
				return; 
			} else {
				request.getRequestDispatcher("WEB-INF/view/user/series/seriesread.jsp").forward(request, response);
			}
			

		}

	}
}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
