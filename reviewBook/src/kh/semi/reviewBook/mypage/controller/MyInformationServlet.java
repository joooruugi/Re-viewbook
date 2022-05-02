package kh.semi.reviewBook.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.reviewBook.mypage.model.service.MyPageService;
import kh.semi.reviewBook.mypage.model.vo.MyInformationVo;

/**
 * Servlet implementation class MyInformationServlet
 */
@WebServlet({"/myinformation", "/myinfoupdate.lo"})
public class MyInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("/myinformation doGet");
		
		String usId = "us111";//TODO 로그인한 session
		MyInformationVo myinfovo = new MyPageService().selectMyInformation(usId);
		System.out.println("myinfovo: "+myinfovo);
		request.setAttribute("myinfovo", myinfovo);
		request.getRequestDispatcher("/WEB-INF/view/user/mypage/myInfoUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usEmail = request.getParameter("usEmail");
		String usPhone = request.getParameter("usPhone");
		String usNickname = request.getParameter("usNickname");
		String usAddress = request.getParameter("usAddress");
		String usName = request.getParameter("usName");
	
		String usId = "us111";  // TODO 로그인
		//vo -> service method -> dao메소드 호출 ->update(int형) -> return int형 -> result(int형)
		//0이면 업데이트 실패, -> myinformation
		//1이면 성공 -> 메인페이지(sendredirect.main)
		MyInformationVo iVo = new MyInformationVo();
		iVo.setUsAddress(usAddress);
		iVo.setUsEmail(usEmail);
		iVo.setUsName(usName);
		iVo.setUsNickname(usNickname);
		iVo.setUsPhone(usPhone);
		iVo.setUsId(usId);
		System.out.println("/myinfoupdate.lo"+iVo);
		int result = new MyPageService().updateMyInformation(iVo);
		System.out.println("result:" + result);
		if(result == 1 ) {
			response.sendRedirect(request.getContextPath());	
		} else {
			request.getSession().setAttribute("msg", "정보 수정에 실패하였습니다.");
			// TODO :페이지 이동 멫 메시지 경고 창 띄우
//			response.sendRedirect(request.getContextPath()+"/myinformation");
		}
				
	}
	

}
