package kh.semi.reviewBook.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.book.model.service.BookService;
import kh.semi.reviewBook.book.model.vo.BookVo;
import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/bookmain")
public class BookMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BookMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /bookmain");
		
		System.out.println("servlet확인");
		ArrayList<BookVo> blistOrderBest = new BookService().bookListOrder();
		ArrayList<BookVo> blistRating = new BookService().bookListRating();
		ArrayList<BookVo> blistReview = new BookService().bookListReview();
		System.out.println(blistOrderBest);
		System.out.println(blistRating);
		System.out.println(blistReview);
		
		request.setAttribute("blistOrderBest",blistOrderBest);
		request.setAttribute("blistRating",blistRating);
		request.setAttribute("blistReview",blistReview);
		
		request.getRequestDispatcher("WEB-INF/view/user/book/bookmain.jsp").forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
