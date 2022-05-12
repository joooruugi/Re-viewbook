package kh.semi.reviewBook.admin.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.book.model.service.BookService;
import kh.semi.reviewBook.mypage.model.vo.ReviewVo;


@WebServlet("/adbookdelete")
public class AdminBookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminBookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("do get /adbookdelete");
	 String bkNostr = request.getParameter("bkNo");
     System.out.println("bkNo : "+bkNostr);
     int bkNo = 0;
     try {
        bkNo = Integer.parseInt(bkNostr);
     }catch(NumberFormatException e) {
        e.printStackTrace();
     }
     if(bkNo < 1) { 
        //읽어올 게시글 번호가 이상할 경우 그냥 메인으로 보냄
        response.sendRedirect("bookcontent?wbNo="+bkNo);
        //콘솔에서 확인
        System.out.println("bkNo < 1");
     }
	
     int result = new BookService().bookDelete(bkNo);
     
     if(result<1) {//게시글 삭제에 실패한 경우 기존 게시글로               
    	 PrintWriter out = response.getWriter();                
		 out.print("<script language='javascript'>");                 
		 out.print("alert('도서 삭제에 실패하였습니다.'); location.href='" + request.getContextPath() + "/booklist'");                
		 out.print("</script>");                 
		 out.flush(); 
    	 }else {//게시글 삭제 성공하면 목록으로              
    		 PrintWriter out = response.getWriter();                
    		 out.print("<script language='javascript'>");                 
    		 out.print("alert('도서 삭제에 성공하였습니다.'); location.href='" + request.getContextPath() + "/booklist'");                
    		 out.print("</script>");                 
    		 out.flush();                          
    		 }
     }
     
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

