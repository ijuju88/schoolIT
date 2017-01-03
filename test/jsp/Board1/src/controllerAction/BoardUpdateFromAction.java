package controllerAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardVo;

public class BoardUpdateFromAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardUpdate.jsp";

		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));

		BoardDao bDao = BoardDao.getInstance();
		bDao.updateReadCount(num);

		BoardVo bVo = bDao.selectOneBoardByNum(num);

		request.setAttribute("board", bVo);
		request.setAttribute("pageNum", pageNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
