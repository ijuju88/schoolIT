package controllerAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardReplyVo;

public class BoardReplylistAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="board/boardReplyList.jsp";
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardDao Bdao=BoardDao.getInstance();
		List<BoardReplyVo> replyList= Bdao.selectReply(num);
		
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
