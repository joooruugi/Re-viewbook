package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet("/insertreview")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bkNoStr= request.getParameter("bkNo");
		String rvTitle= request.getParameter("rvTitle");
		String rvContent= request.getParameter("rvContent");
		String rvRatingStr= request.getParameter("rvRating");
		int rvRating = 0;
		int bkNo = 0;
		try {
			rvRating = Integer.parseInt(rvRatingStr);
			bkNo = Integer.parseInt(bkNoStr);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		UserVo vo = (UserVo)request.getSession().getAttribute("ssUserVo");
		if(vo == null) { //로그인이 되지 않은 상황 -> 로그인 해야만 리뷰 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return; 
		} else {
			String usId = vo.getUsId();
			ReviewVo rVo = new ReviewVo();
			rVo.setUsId(usId);
			rVo.setBkNo(bkNo);
			rVo.setRvTitle(rvTitle);
			rVo.setRvContent(rvContent);
			rVo.setRvRating(rvRating);
			
			int result = new MyPageService().insertReview(rVo);
			if(result < 1 ) {	//리뷰작성 실패한 경우 메인으로 보냄
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=utf-8");
				out.print("<script language='javascript'>");
				out.print("alert('리뷰 작성에 실패하였습니다.'); history.back();");
				out.print("</script>");
				out.flush();	
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=utf-8");
				out.print("<script language='javascript'>");
				out.print("alert('리뷰 작성이 완료되었습니다.'); location.href='" + request.getContextPath() + "/mypagemain'");
				out.print("</script>");
				out.flush();
			}
		}
	}

}
