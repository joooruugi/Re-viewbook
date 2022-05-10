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


@WebServlet("/booklistro")
public class BookListRo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookListRo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get /booklistro");

		ArrayList<BookVo> blist = new BookService().bookListRo();
		System.out.println(blist);
		request.setAttribute("blist",blist);
		request.getRequestDispatcher("WEB-INF/view/user/book/booklist_ro.jsp").forward(request, response);
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
