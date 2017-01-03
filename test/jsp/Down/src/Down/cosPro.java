package Down;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class cosPro
 */
@WebServlet("/cosPro.do")
public class cosPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cosPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//String realPath = request.getServletContext().getRealPath("files");
		String realPath = "files";
		int maxSize = 1024 * 1024 * 5;
		int file_size = 0;
		String encType="UTF-8";
		
		File f = new File(realPath);
		System.out.println("f.getPath():"+f.getPath());
		if (!f.exists()) {
			f.mkdirs();
		}
		
		ServletContext context=getServletContext();
		String uploadFilePath=context.getRealPath(realPath);
		System.out.println("서버상 실제 디렉토리");
		System.out.println(uploadFilePath);
		
		try{
			MultipartRequest mul = new MultipartRequest(request, realPath,
					maxSize, "UTF-8",new DefaultFileRenamePolicy());
			String filename=mul.getFilesystemName("cosselect");
			if(filename==null){
				System.out.println("업로드 안됨");
			}else{
				out.println("<br> 글쓴이 : "+mul.getParameter("name"));
				out.println("<br> 제&nbsp;&nbsp;&nbsp;목 : "+mul.getParameter("title"));
				out.println("<br> 파&nbsp;&nbsp;&nbsp;일 : "+filename);
			}
		
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
