package controllerAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardVo;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;

		int num=Integer.parseInt(request.getParameter("num"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		String pass=request.getParameter("pass");

		BoardDao bDao=BoardDao.getInstance();
		BoardVo bVo=bDao.selectOneBoardByNum(num);
	
		if(bVo.getPass().equals(pass)){
			request.setAttribute("pageNum", pageNum);
			url="/board/checkSuccess.jsp?pageNum="+pageNum;
		}else{
			url="/board/boardCheckPass.jsp?pageNum="+pageNum;
			request.setAttribute("message", "비번틀림 >_<");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
