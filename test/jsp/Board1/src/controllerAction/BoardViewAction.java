package controllerAction;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardReplyVo;
import dto.BoardVo;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/board/boardView.jsp";
		
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDao bDao=BoardDao.getInstance();
		bDao.updateReadCount(num);
		
		BoardVo bVo=bDao.selectOneBoardByNum(num);
		int reCount=bDao.getBoardRelpyCount(num);
		List<BoardReplyVo> replyList=bDao.selectReply(num);
		
		request.setAttribute("board", bVo);
		request.setAttribute("replyList", replyList);
		request.setAttribute("reCount", reCount);
		request.setAttribute("pageNum", pageNum);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
