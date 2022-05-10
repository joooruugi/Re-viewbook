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


@WebServlet("/booklistself")
public class BookListSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookListSelf() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get /booklistself");

		ArrayList<BookVo> blist = new BookService().bookListSelf();
		System.out.println(blist);
		request.setAttribute("blist",blist);
		request.getRequestDispatcher("WEB-INF/view/user/book/booklist_self.jsp").forward(request, response);
		
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
