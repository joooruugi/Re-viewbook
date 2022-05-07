package kh.semi.reviewBook.series.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.reviewBook.series.model.service.SeriesService;
import kh.semi.reviewBook.series.model.vo.SeriesVo;


@WebServlet("/seriesupdate.do")
public class SeriesUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SeriesUpdateDoServlet() {
        super();
        
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

    //	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post : /seriesupdate.do");
		
		//파일업로드 처리
		//db에 저장하러 가는 코드 
		request.setCharacterEncoding("euc-kr");
	 	String encType = "euc-kr";
		String fileSavePath = "FileUpload";
		//metadata의 realpath get하기
		String contextPath = request.getContextPath();  
		System.out.println("contextPath : "+contextPath);
		String uploadPath = getServletContext().getRealPath("FileUpload");
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
		String wbCategory = multi.getParameter("wbCategory");
		String wbTitle = multi.getParameter("wbTitle");
		String wbContent = multi.getParameter("wbContent");
		wbContent = wbContent.replace("\r\n","<br>");
		String wbContentFile= multi.getFilesystemName("wbContentFile");
		
		//값 확인
		System.out.println(wbCategory);
		System.out.println(wbTitle);
		System.out.println(wbContent);
		System.out.println(wbContentFile);

		if(wbContentFile != null) {
			wbContent += "<br> <br> <img src = '"+fileSavePath+"/"+wbContentFile+"'>";
		}
		
		SeriesVo svo = new SeriesVo();
		svo.setWbNo(wbNo);
		svo.setWbTitle(wbTitle);
		svo.setWbContent(wbContent);
		svo.setWbCategory(wbCategory);
	
		 int result = new SeriesService().updateSeriesBoard(svo);
		 
		 if(result<1) {//게시글 수정에 실패한 경우에도 메인으로 보냄
			 PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>");
				out.print("alert('게시물 수정에 실패하였습니다.'); location.href='" + request.getContextPath() + "/seriesmain'");
				out.print("</script>");
				out.flush();
				return;
		 }else {//성공해도 메인
			 PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>");
				out.print("alert('게시물 수정에 성공하였습니다.'); location.href='" + request.getContextPath() + "/seriesmain'");
				out.print("</script>");
				out.flush();
			 }
		 }
		
		
	}

