package kh.semi.reviewBook.series.controller;

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


@WebServlet("/seriesinsert.do")
public class SeriesInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SeriesInsertDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("do post : /seriesinsert.do");
		
		//여기서부터 파일 업로드 실패하면 걍 없앨것
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
		 			
		 			

		
		
		
		//게시글 등록 
		String wbTitle = multi.getParameter("wbTitle");
		String wbContent = multi.getParameter("wbContent");
		wbContent = wbContent.replace("\r\n","<br>");
		String wbCategory = multi.getParameter("wbCategory");
		String wbContentFile= multi.getFilesystemName("wbContentFile");
		System.out.println(wbTitle);
		System.out.println(wbContent);
		System.out.println(wbCategory);
		System.out.println(wbContentFile);
		
		//로그인 구현되면 세션에서 값 얻어오는거로 변경해야함 
		String usId = "";
		String wbWriter = ""; 
		
		if(wbContentFile != null) {
			wbContent += "<br> <br> <img src = '"+fileSavePath+"/"+wbContentFile+"'>";
		}
		
		SeriesVo svo = new SeriesVo();
		
		svo.setWbTitle(wbTitle);
		svo.setWbContent(wbContent);
		svo.setUsId(usId);
		svo.setWbWriter(wbWriter);
		svo.setWbCategory(wbCategory);
	
		 int result = new SeriesService().insertSeriesBoard(svo);
		 if(result<1) {//게시글 작성에 실패한 경우에도 메인으로 보냄
			 response.sendRedirect("seriesmain");
		 }else {//성공해도 메인으로 보냄
			 request.getSession().setAttribute("msg", "게시물 등록이 완료되었습니다.");
			 response.sendRedirect("seriesmain");
			 }
		 }
	}

