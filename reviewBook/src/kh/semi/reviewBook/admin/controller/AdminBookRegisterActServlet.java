package kh.semi.reviewBook.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.admin.service.AdminService;
import kh.semi.reviewBook.book.model.vo.BookVo;

/**
 * Servlet implementation class AdminBookRegisterActServlet
 */
@WebServlet("/book_register.lo")
public class AdminBookRegisterActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookRegisterActServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//    pstmt.setInt(1, bvo.getBkNo());
//	pstmt.setString(2, bvo.getBkTitle());
//	pstmt.setString(3, bvo.getBkContent());
//	pstmt.setString(4, bvo.getBkImg());
//	pstmt.setInt(5, bvo.getBkPrice());
//	pstmt.setString(6, bvo.getBkWriter());
//	pstmt.setInt(7, bvo.getGnNo());
//	pstmt.setString(8, bvo.getBkIndex());
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String bkTitle = request.getParameter("bkTitle");
	String bkImg = request.getParameter("bkImg");
	int bkPrice = Integer.parseInt(request.getParameter("bkPrice"));
	String bkPublishdate = request.getParameter("bkPublishdate");
	String bkWriter = request.getParameter("bkWriter");
	int gnNo = Integer.parseInt(request.getParameter("gnNo"));
	String bkIndex = request.getParameter("bkIndex");
	String bkContent = request.getParameter("bkContent");
	
	BookVo bvo = new BookVo();
	bvo.setBkTitle(bkTitle);
	bvo.setBkImg(bkImg);
	bvo.setBkPrice(bkPrice);
	bvo.setBkPublishdate(bkPublishdate);
	bvo.setBkWriter(bkWriter);
	bvo.setGnNo(gnNo);
	bvo.setBkIndex(bkIndex);
	bvo.setBkContent(bkContent);
	
	int result = new AdminService().BookRegister(bvo);
	if(result <1) {
		System.out.println("책 등록 실패");
		response.sendRedirect("book_register");
	}else {
		System.out.println("책 등록 성공");
		response.sendRedirect("booklist");
	}
	
	
	}

}
