package kh.semi.reviewBook.series.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;

/**
 * Servlet implementation class SeriesSearchServlet
 */
@WebServlet("/seriessearch")
public class SeriesSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeriesSearchServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("doPost : /seriessearch");
		
		String searchText = request.getParameter("searchText");
		ArrayList<SeriesVo> slist = new SeriesService().searchlistBoard(searchText);
		System.out.println(slist);
		
		
		request.setAttribute("slist",slist);
		
		
		if(slist.size()==0) {
			//공백, 없는 검색어 입력한경우 메인으로 보냄
			 PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>");
				out.print("alert('해당 검색 조건에 일치하는 게시물이 없습니다.'); location.href='" + request.getContextPath() + "/seriesmain'");
				out.print("</script>");
				out.flush();
				return;
			//콘솔에서 확인
		}
		else{
			request.getRequestDispatcher("WEB-INF/view/user/series/seriessearch.jsp").forward(request, response);
		}
		
		 
		
		
	}

}

