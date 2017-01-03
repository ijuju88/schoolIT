package controllerAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardVo;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo bVo = new BoardVo();

		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));

		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDao bDao = BoardDao.getInstance();
		bDao.updateBoard(bVo);
		request.setAttribute("pageNum", pageNum);
		new BoardListAction().execute(request, response);

	}

}
