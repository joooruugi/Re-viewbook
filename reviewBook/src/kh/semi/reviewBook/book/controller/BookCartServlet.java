package kh.semi.reviewBook.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.book.model.service.BookService;
import kh.semi.reviewBook.mypage.model.vo.CartVo;
import kh.semi.reviewBook.user.model.vo.UserVo;

/**
 * Servlet implementation class BookCartServlet
 */
@WebServlet("/bookaddcart")
public class BookCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BookCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post : /bookaddcart");
		String bkNostr = request.getParameter("bkNo");
		System.out.println("bkNo : " + bkNostr);
		int bkNo = Integer.parseInt(bkNostr);
		try {
			bkNo = Integer.parseInt(bkNostr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (bkNo < 1) {
			// 읽어올 책번호가 이상할 경우 그냥 도서메인으로 보냄
			response.sendRedirect("bookcontent?bkNo=" + bkNo);
			// 콘솔에서 확인
			System.out.println("bkNo < 1");
		}
		String caCountstr = request.getParameter("caCount");
		System.out.println("caCountstr : " + caCountstr);
		int caCount = 0;
		try {
			caCount = Integer.parseInt(caCountstr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}


		// 로그인 정보 읽어오기
		String usId = "";
		UserVo vo = (UserVo) request.getSession().getAttribute("ssUserVo");
		if (vo == null) { // 로그인이 되지 않은 상황 -> 로그인 해야만 글 작성 가능 ->로그인으로 이동
			response.sendRedirect("login");
			return;
		} else {
			usId = vo.getUsId();
			System.out.println(usId);
		}

		CartVo cvo = new CartVo();
		cvo.setBkNo(bkNo);
		cvo.setCaCount(caCount);
		cvo.setUsId(usId);

		int result = new BookService().insertCart(cvo);
		if (result < 1) {// 장바구니 넣기 실패
			System.out.println("실패");
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>");
			out.print("alert('이미 장바구니에 존재하는 상품입니다. 수량 변경은 장바구니에서 가능합니다.'); location.href='" + request.getContextPath() + "/cartlist'");
			out.print("</script>");
			out.flush();
		} else {
			response.sendRedirect("cartlist");
			System.out.println("성공");
		}
	}

}
