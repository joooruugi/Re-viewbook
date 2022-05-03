package kh.semi.reviewBook.admin.series.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/adseriesupdate.do")
public class AdminSeriesUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminSeriesUpdateDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO : 관리자 session
		
		System.out.println("do post : /adseriesupdate.do");
		
		//파일업로드 처리
		//db에 저장하러 가는 코드 
		request.setCharacterEncoding("euc-kr");
	 	String encType = "euc-kr";
		String fileSavePath = "test";
		//metadata의 realpath get하기
		String contextPath = request.getContextPath();  
		System.out.println("contextPath : "+contextPath);
		String uploadPath = getServletContext().getRealPath("test");
		System.out.println("uploadPath : " + uploadPath);
		//업로드할 폴더 여부 확인 후 없다면 생성하도록 함
		File path = new File(uploadPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		//제한크기
		
		int maxFileSize = 10*1024*1024;
		//파일저장까지 한번에 실행하는 객체 
		//MultipartRequest multi = new MultipartRequest(request, "C:\\z_workspace\\image","UTF-8");
		MultipartRequest multi = new MultipartRequest(request, uploadPath , maxFileSize , "UTF-8"
				,new DefaultFileRenamePolicy());
		
		
		//parameter로 값 가져오기 
		//1.글번호
		String wbnostr = multi.getParameter("wbNo");
		System.out.println("wbNo : "+wbnostr);
		int wbNo = 0;
		try {
			wbNo = Integer.parseInt(wbnostr);
			System.out.println(wbNo);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(wbNo < 1) { 
			//읽어올 게시글 번호가 이상할 경우 그냥 메인으로 보냄
			response.sendRedirect("seriesmain");
			//콘솔에서 확인
			System.out.println("wbNo < 1");
		}
		//2. 카테고리
		String wbCategory = multi.getParameter("wbCategory");
		
		//3.펀딩여부
		String fdOXstr = multi.getParameter("fdOX");
		System.out.println("fdOX : "+fdOXstr);
		int fdOX = Integer.parseInt(fdOXstr);
			System.out.println(fdOX);
			
		//4.1인당 제한금액
		String fdLimitstr = multi.getParameter("fdLimit");
		System.out.println("fdLimit : "+fdLimitstr);
		int fdLimit = Integer.parseInt(fdLimitstr);
			System.out.println(fdLimit);
			
		//5.마감일
		String fdDeadline = multi.getParameter("fdDeadline");
		
		//6.목표금액
		String fdAccumulatestr = multi.getParameter("fdAccumulate");
		System.out.println("fdAccumulate : "+fdAccumulatestr);
		int fdAccumulate = 0;
		try {		
		fdAccumulate = Integer.parseInt(fdAccumulatestr);
			System.out.println(fdAccumulate);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		//값 확인
		System.out.println(wbNo);
		System.out.println(wbCategory);
		System.out.println(fdOX);
		System.out.println(fdLimit);
		System.out.println(fdDeadline);
		System.out.println(fdAccumulate);


	
		
		SeriesVo svo = new SeriesVo();
		svo.setWbNo(wbNo);
		svo.setWbCategory(wbCategory);
		svo.setFdOX(fdOX);
		svo.setFdLimit(fdLimit);
		svo.setFdDeadline(fdDeadline);
		svo.setFdAccumulate(fdAccumulate);
	
		 int result = new SeriesService().adminUpdateSeriesBoard(svo);
		 
		 if(result<1) {//게시글 작성에 실패한 경우에도 메인으로 보냄
			 response.sendRedirect("adseriesmain");
			 return;
		 }else {//성공하면 글 읽기
			 	request.getSession().setAttribute("msg", "게시물 수정이 완료되었습니다.");
				response.sendRedirect("adseriesread?wbNo="+wbNo);
				
			 }
		 }
	}

