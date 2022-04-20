package kh.semi.reviewBook.series.controller;

import java.io.IOException;
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
			response.sendRedirect("seriesmain");
		}
		else{
			request.getRequestDispatcher("WEB-INF/view/user/series/seriessearch.jsp").forward(request, response);
		}
		
		 
		
		
	}

}

