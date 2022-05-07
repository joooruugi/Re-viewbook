package kh.semi.reviewBook.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.book.model.service.BookService;
import kh.semi.reviewBook.book.model.vo.BookVo;

/**
 * Servlet implementation class BookContentServlet
 */
@WebServlet("/bookcontent")
public class BookContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bkNostr = request.getParameter("bkNo");
		System.out.println("bkno : "+bkNostr);
		int bkNo = Integer.parseInt(bkNostr);
		BookVo bvo = new BookService().BookContent(bkNo);
		System.out.println("bvo : "+bvo);
		request.setAttribute("bvo", bvo);
		request.getRequestDispatcher("WEB-INF/view/user/book/bookcontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
