package controllerAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardReplyVo;

public class BoardReplywriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String content=request.getParameter("content");
		
		BoardReplyVo BRvo=new BoardReplyVo();
		
		BRvo.setName(name);
		BRvo.setPass(pass);
		BRvo.setContent(content);
		BRvo.setGroup_num(num);
		
		BoardDao Bdao=BoardDao.getInstance();
		Bdao.insertReply(BRvo);
		
		request.setAttribute("pageNum", pageNum);
		new BoardViewAction().execute(request, response);
	}

}
