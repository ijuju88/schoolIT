package controllerAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BoardDao;
import dto.BoardVo;;
/**
 * Servlet implementation class BoardListAction
 */
@WebServlet("/BoardListAction")
public class BoardListAction extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;
       
  
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum=1;
		PageMaker pageM=null;
		String strPage=request.getParameter("pageNum");
		
		if(strPage!=null){
			pageNum=Integer.parseInt(strPage);
		}
		
		
		String url="/board/boardList.jsp";
		
		BoardDao bDao=BoardDao.getInstance();
		int totalCount=bDao.getBoardCount();
		
		pageM=new PageMaker(pageNum, totalCount);
	
		List<BoardVo> boardList=bDao.selectAllBaords(pageM.getStart(),pageM.getPageSize());
		System.out.println("totcount=>"+pageM.getStart());
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageM", pageM);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	

}
